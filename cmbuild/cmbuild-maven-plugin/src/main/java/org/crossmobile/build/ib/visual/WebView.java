/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.build.ib.visual;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.Value;
import org.crossmobile.build.ib.Values;

public class WebView extends View {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("scalesPageToFit", Values.Boolean);
        addSupportedAttribute("phoneNumber", Values.Boolean);
        addSupportedAttribute("calendarEvent", Values.Boolean);
        addSupportedAttribute("keyboardDisplayRequiresUserAction", Values.Boolean);
        addSupportedAttribute("mediaPlaybackRequiresUserAction", Values.Boolean);
        addSupportedAttribute("mediaPlaybackAllowsAirPlay", Values.Boolean);
        addSupportedAttribute("suppressesIncrementalRendering", Values.Boolean);
        addSupportedAttribute("keyboardDisplayRequiresUserAction", Values.Boolean);
        addSupportedAttribute("paginationMode", new Value.Selections(new String[]{"unpaginated", "leftToRight", "topToBottom", "bottomTo Top", "rightToLeft"}));
        addSupportedAttribute("paginationBreakingMode", new Value.Selections(new String[]{"page", "column"}));
        addSupportedChild("dataDetectorTypes", Elements.DataDetectorType);

    }

    @Override
    public String toCode() {
        @SuppressWarnings("ReplaceStringBufferByString")
        StringBuilder out = new StringBuilder(super.toCode());

        return out.toString();
    }

}
