/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Intent;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;

@CMLib(target = CMLibTarget.ANDROID)
public interface ActivityResultListener {

    /**
     * @param resultCode The result code of the returned Intent
     * @param data       The data of the Intent
     */
    void result(int resultCode, Intent data);
}
