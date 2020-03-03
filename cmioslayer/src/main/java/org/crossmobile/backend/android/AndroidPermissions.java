// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.backend.android;

import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.system.BaseUtils;
import org.robovm.objc.block.VoidBlock1;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class AndroidPermissions {
    private final Collection<String> alreadyAskedForPermission = new HashSet<>();

    public static AndroidPermissions current() {
        return ((AndroidSystemBridge) Native.system()).getPermissions();
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
