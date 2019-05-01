package org.crossmobile.backend.android;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.robovm.objc.block.VoidBlock1;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID, name = "cmioslayer", depends = @CMLibDepends(groupId = "com.android.support",
        pluginName = "support-core-utils",
        version = "26.1.0", isCMPlugin = false))
public class AndroidPermissions {

    public static void requestPermissions(VoidBlock1<Collection<String>> notGrantedPermissions, String... permissions) {
        Collection<String> reqPermissions = new LinkedHashSet<>();
        if (permissions != null && permissions.length > 0) {
            for (String permission : permissions)
                if (permission != null) {
                    permission = permission.trim();
                    if (!permission.isEmpty()) {
                        if (ContextCompat.checkSelfPermission(MainActivity.current(), permission) != PackageManager.PERMISSION_GRANTED)
                            reqPermissions.add(permission);
                    } else
                        Native.system().error("Requesting an empty Android permission", null);
                } else
                    Native.system().error("Requesting a null Android permission", null);
        } else
            Native.system().error("Requested Android permissions are empty", null);
        if (reqPermissions.isEmpty()) {
            if (notGrantedPermissions != null)
                notGrantedPermissions.invoke(Collections.emptyList());
        } else {
            int reqCode = MainActivity.current.getStateListener().register(new ActivityPermissionListener() {
                @Override
                public void result(String[] permissions, int[] grantResults) {
                    MainActivity.current.getStateListener().unregister(this);
                    if (permissions == null || grantResults == null || notGrantedPermissions == null)
                        return;
                    for (int i = 0; i < permissions.length && i < grantResults.length; i++)
                        if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                            reqPermissions.remove(permissions[i]);
                    notGrantedPermissions.invoke(reqPermissions);
                }
            });
            ActivityCompat.requestPermissions(MainActivity.current(), reqPermissions.toArray(new String[0]), reqCode);
        }
    }

    public static String getAuthority() {
        return System.getProperty("cm.group.id") + "." + System.getProperty("cm.artifact.id") + ".provider";
    }
}
