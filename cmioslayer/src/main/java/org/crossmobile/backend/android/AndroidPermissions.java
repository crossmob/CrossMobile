/*
 * (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.backend.android;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibDepends;
import org.crossmobile.bridge.system.BaseUtils;
import org.robovm.objc.block.VoidBlock1;

import java.util.*;

import static org.crossmobile.bridge.ann.CMLibTarget.ANDROID;

@CMLib(target = ANDROID, name = "cmioslayer", depends = @CMLibDepends(groupId = "com.android.support",
        pluginName = "support-core-utils",
        version = "26.1.0", isCMPlugin = false))
public class AndroidPermissions {
    private final Collection<String> alreadyAskedForPermission = new HashSet<>();

    public static AndroidPermissions current() {
        return ((AndroidSystemBridge) Native.system()).permissions;
    }

    public void requestPermissions(VoidBlock1<Collection<String>> notGrantedPermissions, String... permissions) {
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
        Collection<String> alreadyAsked = BaseUtils.removeCommon(reqPermissions, alreadyAskedForPermission);
        alreadyAskedForPermission.addAll(reqPermissions);
        if (reqPermissions.isEmpty()) {
            if (notGrantedPermissions != null)
                notGrantedPermissions.invoke(alreadyAsked);
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

    public String getAuthority() {
        return System.getProperty("cm.group.id") + "." + System.getProperty("cm.artifact.id") + ".provider";
    }
}
