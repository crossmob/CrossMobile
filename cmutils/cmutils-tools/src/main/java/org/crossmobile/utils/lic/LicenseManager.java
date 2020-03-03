// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.utils.lic;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import crossmobile.rt.StrongReference;
import org.crossmobile.prefs.Prefs;
import org.crossmobile.utils.*;
import org.crossmobile.utils.WebStreamUtils.SyncWebResult;
import org.crossmobile.utils.WebStreamUtils.WebRequest;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collection;
import java.util.TreeSet;
import java.util.prefs.Preferences;

public class LicenseManager {

    public static final Preferences BASE = Preferences.userRoot().node("tech").node("crossmobile").node("prefs");
    private static final String URL = "https://mvn.crossmobile.org/content/license";
    private static final String CHECKURL = URL + "/check";
    private static final String METHOD = "GET";
    private static final String CHECKMETHOD = "POST";

    @SuppressWarnings("UseSpecificCatch")
    private static String performQuery(UserPass userPass, String macaddress, String method, String url, String post) throws Exception {
        SyncWebResult result = WebStreamUtils.download(new WebRequest(url)
                .setMethod(method)
                .setRequestProperty("Authorization", "Basic " + new String(Base64.getEncoder().encode((userPass.username + ":" + userPass.password).getBytes())))
                .setRequestProperty("License-request", macaddress)
                .setRequestProperty("Content-Type", "application/json")
                .setPostStream(new ByteArrayInputStream(post.getBytes())));
        if (result.error != null)
            throw new IOException(result.error);
        switch (result.code) {
            case 200:
                break;
            case 400:
                throw new Exception("Incorrect server communication");
            case 401:
                throw new Exception("Wrong username/password");
            case 501:
                throw new Exception("Remote and local license mismatch");
            case 503:
                throw new Exception("Unable to gather license");
            default:
                throw new Exception("Communication error (" + result.code + ")");
        }
        return new String(result.data, StandardCharsets.UTF_8);
    }

    @SuppressWarnings("UseSpecificCatch")
    public static String getLicense(UserPass userPass, boolean shouldAlsoValidateAndUpdatePassword) {
        String key = "000000000000";
        String response;
        try {
            JsonObject pjson = Json.object();
            pjson.add("username", userPass.username);
            pjson.add("password", userPass.password);
            response = performQuery(userPass, key, METHOD, URL, null);
        } catch (Throwable ex) {
            return ex.getMessage();
        }
        try {
            if (!save(response, userPass.username, shouldAlsoValidateAndUpdatePassword))
                return "Unable to persist license";
        } catch (Exception ignore) {
        }
        if (shouldAlsoValidateAndUpdatePassword)
            try {
                JsonObject json = Json.object();
                json.add("key", PreferencesUtils.getPref(BASE, "key"));
                json.add("license", PreferencesUtils.getPref(BASE, "license"));
                performQuery(userPass, key, CHECKMETHOD, CHECKURL, json.toString());
            } catch (Throwable ex) {
                return "Verification error: " + ex.getMessage();
            }
        return null;
    }

    @SuppressWarnings("UseSpecificCatch")
    private static boolean save(String result, String username, boolean alsoUpdatePassword) {
        if (result == null || result.isEmpty())
            return false;
        JsonValue root = null;
        try {
            root = Json.parse(result);
        } catch (Exception ignored) {
        }
        if (root == null || !root.isObject())
            return false;
        if (alsoUpdatePassword)
            if (!saveUsernamePassword(new UserPass(username, root.asObject().getString("hash", "")))) {
                //TODO prompt
            }
        return PreferencesUtils.addPref(BASE, "key", root.asObject().getString("key", null))
                && PreferencesUtils.addPref(BASE, "license", root.asObject().getString("license", null));
    }

    public static boolean isAllowed(String appId, String artifactId) {
        if (!Prefs.CHECK_LICENSE)
            return true;
        if (artifactId == null || artifactId.trim().isEmpty() || appId == null || appId.trim().isEmpty())
            return false;
        try {
            for (JsonValue idv : Json.parse(new String(Base64.getDecoder().decode(PreferencesUtils.getPref(BASE, "license")))).asObject().get("ids").asArray()) {
                String allowedId = idv.asObject().getString("id", null);
                if ("*".equals(allowedId) || appId.equals(allowedId))
                    for (JsonValue arv : idv.asObject().get("artifacts").asArray()) {
                        JsonObject ar = arv.asObject();
                        if (artifactId.equals(ar.getString("name", null)))
                            return true;
                    }
            }
        } catch (Exception e) {
        }
        return false;
    }


    private static File getSettingsFile() {
        File settings = new File(System.getProperty("user.home"), ".m2" + File.separator + "settings.xml");
        if (settings.isDirectory())
            return null;
        if (!settings.exists()) {
            settings.getParentFile().mkdirs();
            try {
                FileUtils.copyResource("templates/settings.xml", settings.getAbsolutePath());
            } catch (ProjectException e) {
                return null;
            }
        }
        return settings;
    }

    public static UserPass getUsernamePassword() {
        File settingsFile = getSettingsFile();
        XMLWalker walker = XMLWalker.load(settingsFile);
        if (walker == null)
            return null;
        StrongReference<UserPass> result = new StrongReference<>();
        walker.nodes("settings", n1 -> n1.nodes("servers", n2 -> n2.nodes("server", w -> {
            if (result.get() != null ||
                    !w.nodeExists("id") ||
                    !w.nodeExists("username") ||
                    !w.nodeExists("password") ||
                    !"crossmobile".equals(w.node("id").text()))
                return;
            w.parent();
            String username = w.parent().node("username").text();
            String password = w.parent().node("password").text();
            result.set(new UserPass(username, password));
        })));
        return null;
    }


    public static boolean saveUsernamePassword(UserPass userPass) {
        File settings = getSettingsFile();
        StrongReference<Boolean> found = new StrongReference<>(false);
        XMLWalker walker = XMLWalker.load(settings);
        if (walker != null) {
            walker.execIf(n -> !n.nodeExists("settings"), n -> n.add("settings")).node("settings")
                    .execIf(n -> !n.nodeExists("servers"), n -> n.add("servers")).node("servers").tag("servers")
                    .nodes("server",
                            n -> n.execIf(a -> a.nodeWithTextExists("id", "crossmobile"),
                                    r -> {
                                        found.set(true);
                                        r.execIf(a -> !a.nodeExists("username"), a -> a.add("username")).node("username").setText(userPass.username)
                                                .parent().execIf(a -> !a.nodeExists("password"), a -> a.add("password")).node("password").setText(userPass.password);
                                    }))
                    .execIf(n -> !found.get(), n -> n.toTag("servers").add("server").add("id").setText("crossmobile").parent()
                            .add("username").setText(userPass.username).parent().add("password").setText(userPass.password))
                    .store(settings, true);
            return true;
        } else
            return false;
    }

    public static Collection<LicensedApplication> getRegistered() {
        Collection<LicensedApplication> collection = new TreeSet<>();
        try {
            for (JsonValue idv_j : Json.parse(new String(Base64.getDecoder().decode(PreferencesUtils.getPref(BASE, "license")))).asObject().get("ids").asArray().values()) {
                JsonObject id_j = idv_j.asObject();
                LicensedApplication id = new LicensedApplication(id_j.getString("id", ""));
                collection.add(id);
                for (JsonValue artifactv_j : id_j.get("artifacts").asArray().values()) {
                    JsonObject artifact_j = artifactv_j.asObject();
                    id.addArtifact(new LicensedArtifact(
                            artifact_j.getString("name", ""),
                            artifact_j.getBoolean("ios", false),
                            artifact_j.getBoolean("android", false),
                            artifact_j.getBoolean("desktop", false)));
                }
            }
        } catch (Exception ignore) {
        }
        return collection;
    }

    public static class UserPass {
        public final String username;
        public final String password;

        public UserPass(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }
}
