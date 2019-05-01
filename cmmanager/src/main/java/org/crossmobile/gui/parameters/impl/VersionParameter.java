/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.gui.parameters.impl;

import org.crossmobile.gui.elements.VersionDocumentFilter;
import org.crossmobile.gui.parameters.FreeTextParameter;
import org.crossmobile.utils.ParamList;

import static org.crossmobile.utils.ParamsCommon.BUNDLE_VERSION;

public class VersionParameter extends FreeTextParameter {

    public VersionParameter(ParamList list) {
        super(list, BUNDLE_VERSION.tag());
        setValue(getValue());
        setFilter(new VersionDocumentFilter());
        setTooltip(VersionDocumentFilter.TOOLTIP);
    }

    @Override
    public String getVisualTag() {
        return "Application version";
    }

    @Override
    public String getValue() {
        String value = super.getValue();
        String[] parts = value.split("\\.");
        StringBuilder out = new StringBuilder();
        for (int index = 0; index < 4 && index < parts.length; index++) {
            String part = parts[index];
            if (part != null)
                try {
                    part = part.trim();
                    int v = Integer.parseInt(part);
                    if (v < 0)
                        v = -v;
                    if (v > 255)
                        v = 255;
                    if (index == 0)
                        if (v > 127)
                            v = 127;
                        else if (v > 255)
                            v = 255;
                    out.append(".").append(v);
                } catch (NumberFormatException ex) {
                }
        }
        return out.length() < 1 ? "1" : out.substring(1);
    }

}
