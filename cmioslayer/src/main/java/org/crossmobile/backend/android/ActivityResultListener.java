// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.backend.android;

import android.content.Intent;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.ANDROID_PLUGIN)
public interface ActivityResultListener {

    void result(int resultCode, Intent data);
}
