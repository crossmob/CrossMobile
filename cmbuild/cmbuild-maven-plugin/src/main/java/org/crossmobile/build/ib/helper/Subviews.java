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
 * You should have received attr copy of the GNU General Public License
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.visual.View;

public class Subviews extends Element {

    @Override
    protected void addSupported() {
        addSupportedChild(Elements.ActivityIndicatorView);
        addSupportedChild(Elements.AdBannerView);
        addSupportedChild(Elements.Button);
        addSupportedChild(Elements.Control);
        addSupportedChild(Elements.DatePicker);
        addSupportedChild(Elements.ImageView);
        addSupportedChild(Elements.Label);
        addSupportedChild(Elements.MapView);
        addSupportedChild(Elements.NavigationBar);
        addSupportedChild(Elements.PickerView);
        addSupportedChild(Elements.PageControl);
        addSupportedChild(Elements.ProgressView);
        addSupportedChild(Elements.ScrollView);
        addSupportedChild(Elements.SearchBar);
        addSupportedChild(Elements.SegmentedControl);
        addSupportedChild(Elements.Slider);
        addSupportedChild(Elements.StackView);
        addSupportedChild(Elements.Stepper);
        addSupportedChild(Elements.Switch);
        addSupportedChild(Elements.TabBar);
        addSupportedChild(Elements.TabBarItem);
        addSupportedChild(Elements.TableView);
        addSupportedChild(Elements.TableViewCell);
        addSupportedChild(Elements.TextField);
        addSupportedChild(Elements.TextView);
        addSupportedChild(Elements.Toolbar);
        addSupportedChild(Elements.View);
        addSupportedChild(Elements.WebView);
        addSupportedChild(Elements.Window);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        for (View item : parts(Elements.View))
            out.append(item.toCode());
        return out.toString();
    }

}
