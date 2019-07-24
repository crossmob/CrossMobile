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
package org.crossmobile.backend.android.notifications;

import org.crossmobile.bridge.CrossMobilePlugin;
import org.crossmobile.bridge.Native;

public class FirebaseInitializer implements CrossMobilePlugin {
    @Override
    public void earlyInitialize(Object context) {
        if (Native.isAndroid())
            com.google.firebase.FirebaseApp.initializeApp((android.content.Context) context);
    }
}
