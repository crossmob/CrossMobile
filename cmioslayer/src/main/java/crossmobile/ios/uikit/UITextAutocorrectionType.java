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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UITextAutocorrectionType class defines different types of auto-correction for
 * text objects.
 */
@CMEnum
public final class UITextAutocorrectionType {

    /**
     * Appropriate auto-correction for the current system.
     */
    public static final int Default = 0;

    /**
     * Auto-correction is disabled.
     */
    public static final int No = 1;

    /**
     * Auto-correction is enabled.
     */
    public static final int Yes = 2;

    private UITextAutocorrectionType() {
    }
}
