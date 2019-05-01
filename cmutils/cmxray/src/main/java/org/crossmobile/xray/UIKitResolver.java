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
package org.crossmobile.xray;

import com.panayotis.xray.prop.GenericPropertyResolver;
import com.panayotis.xray.prop.commons.*;

import static com.panayotis.xray.prop.commons.EnumerationPropertyManager.EnumEntry.entry;
import static com.panayotis.xray.prop.commons.EnumerationPropertyManager.SEPARATOR;

@SuppressWarnings("unchecked")
class UIKitResolver extends GenericPropertyResolver {

    UIKitResolver(ReflectionClassSupport rcs) {
        /*
         * Type properties
         */
        register(rcs.cgsize, null, (instance, name, accessor)
                -> new NumericPairPropertyManager<>(instance, name, accessor, 0d, Double.MAX_VALUE,
                rcs::constructCGSize, rcs::deconstructCGSize, rcs.constructCGSize(0d, 0d), "Width", "Height"));

        register(rcs.cgpoint, null, (instance, name, accessor)
                -> new NumericPairPropertyManager<>(instance, name, accessor, 0d, Double.MAX_VALUE,
                rcs::constructCGPoint, rcs::deconstructCGPoint, rcs.constructCGPoint(0f, 0f), "X", "Y"));

        register(rcs.cgrect, null, (instance, name, accessor)
                -> new NumericQuadPropertyManager<>(instance, name, accessor,
                -Double.MAX_VALUE, Double.MAX_VALUE, 0d, Double.MAX_VALUE,
                rcs::constructCGRect, rcs::deconstructCGRect, rcs.constructCGRect(0f, 0f, 0f, 0f),
                "X", "Y", "Width", "Height"));

        register(rcs.uiedgeinsets, null, (instance, name, accessor)
                -> new NumericQuadPropertyManager<>(instance, name, accessor,
                -Double.MAX_VALUE, Double.MAX_VALUE, 0d, Double.MAX_VALUE,
                rcs::constructInsets, rcs::deconstructInsets, rcs.constructInsets(0f, 0f, 0f, 0f),
                "Top", "Bottom", "Left", "Right"));

        register(rcs.uicolor, null, (instance, name, accessor)
                -> new ColorPropertyManager<>(instance, name, accessor,
                rcs::constructColor, rcs::deconstructColor, null));

        register(rcs.uifont, null, (instance, name, accessor)
                -> new FontPropertyManager<>(instance, name, accessor,
                rcs::constructFont, rcs::deconstructFont, null));

        /*
         * All properties
         */
        hideProperty("delegate", null);

        /*
         * UIView properties
         */
        hideProperty("bottomanchor", rcs.uiview);
        hideProperty("bounds", rcs.uiview);
        hideProperty("center", rcs.uiview);
        hideProperty("centerxanchor", rcs.uiview);
        hideProperty("centeryanchor", rcs.uiview);
        hideProperty("constraints", rcs.uiview);
        hideProperty("gesturerecognizers", rcs.uiview);
        hideProperty("heightanchor", rcs.uiview);
        hideProperty("layer", rcs.uiview);
        hideProperty("layoutmarginsguide", rcs.uiview);
        hideProperty("leadinganchor", rcs.uiview);
        hideProperty("leftanchor", rcs.uiview);
        hideProperty("rightanchor", rcs.uiview);
        hideProperty("rootviewcontroller", rcs.uiview);
        hideProperty("safearealayoutguide", rcs.uiview);
        hideProperty("subviews", rcs.uiview);
        hideProperty("superview", rcs.uiview);
        hideProperty("topanchor", rcs.uiview);
        hideProperty("trailinganchor", rcs.uiview);
        hideProperty("transform", rcs.uiview);
        hideProperty("viewforfirstbaselinelayout", rcs.uiview);
        hideProperty("viewforlastbaselinelayout", rcs.uiview);
        hideProperty("widthanchor", rcs.uiview);
        hideProperty("window", rcs.uiview);
        register("alpha", rcs.uiview, PercentPropertyManager::new);

        register("contentmode", rcs.uiview, (instance, name, accessor)
                -> new EnumerationPropertyManager(instance, name, accessor,
                entry(0, "Scale To Fill"), entry(1, "Scale Aspect Fit"), entry(2, "Scale Aspect Fill"),
                entry(3, "Redraw"), entry(4, "Center"), entry(5, "Top"),
                entry(6, "Bottom"), entry(7, "Left"), entry(8, "Right"),
                entry(9, "Top Left"), entry(10, "Top Right"), entry(11, "Bottom Left"),
                entry(12, "Bottom Right")));

        register("tintadjustmentmode", rcs.uiview, (instance, name, accessor)
                -> new EnumerationPropertyManager(instance, name, accessor,
                entry(0, "Automatic"), entry(1, "Normal"), entry(2, "Dimmed")));

        register("autoresizingmask", rcs.uiview, AutoResizingPropertyManager::new);

        /*
         * UIControl properties
         */
        hideProperty("state", rcs.uicontrol);
        hideProperty("alltargets", rcs.uicontrol);

        register("contenthorizontalalignment", rcs.uicontrol, (instance, name, accessor)
                -> new EnumerationPropertyManager(instance, name, accessor,
                entry(0, "Center"), entry(1, "Left"), entry(2, "Right"),
                entry(3, "Fill"), entry(4, "Leading"), entry(5, "Tailing")));

        register("contentverticalalignment", rcs.uicontrol, (instance, name, accessor)
                -> new EnumerationPropertyManager(instance, name, accessor,
                entry(0, "Center"), entry(1, "Top"),
                entry(2, "Bottom"), entry(3, "Fill")));

        /*
         * UIButton properties
         */
        hideProperty("alltargets", rcs.uibutton);
        hideProperty("imageview", rcs.uibutton);
        hideProperty("titlelabel", rcs.uibutton);

        register("buttontype", rcs.uibutton, ((instance, name, accessor) -> new EnumerationPropertyManager(instance, name, accessor,
                entry(0, "Custom"), entry(1, "System"), entry(2, "DetailDisclosure"),
                entry(3, "Info Lght"), entry(4, "InfoDark"), entry(5, "Contact Add"))));

        /*
         * UISlider properties
         */
        hideProperty("currentmaximumtrackimage", rcs.uislider);
        hideProperty("currentminimumtrackimage", rcs.uislider);
        hideProperty("currentthumbimage", rcs.uislider);

        /*
         * UILabel properties
         */
        register("linebreakmode", rcs.uilabel, (instance, name, accessor)
                -> new EnumerationPropertyManager(instance, name, accessor,
                entry(2, "Clip"), SEPARATOR,
                entry(1, "Character Wrap"), entry(0, "Word Wrap"), SEPARATOR,
                entry(3, "Truncate Head"), entry(5, "Truncate Middle"), entry(4, "Truncate Tail")));

        register("textalignment", rcs.uilabel, (instance, name, accessor)
                -> new EnumerationPropertyManager(instance, name, accessor,
                entry(0, "Left"), entry(2, "Right"), entry(1, "Center"),
                entry(3, "Justified"), entry(4, "Natural")));

        register("numberoflines", rcs.uilabel, NumericBoxedPropertyManager.PositiveInt::new);

        register("baselineadjustment", rcs.uilabel, (instance, name, accessor)
                -> new EnumerationPropertyManager(instance, name, accessor,
                entry(0, "Align Baselines"), entry(1, "Align Centers"), entry(2, "None")));

        register("preferredmaxlayoutwidth", rcs.uilabel, NumericBoxedPropertyManager.PositiveDouble::new);

        /*
        UITableView properties
         */
        hideProperty("datasource", rcs.uitableview);
        hideProperty("indexpathforselectedrow", rcs.uitableview);
        hideProperty("indexpathsforselectedrows", rcs.uitableview);
        hideProperty("indexpathsforvisiblerows", rcs.uitableview);
        hideProperty("tableviewdelegate", rcs.uitableview);

        register("rowheight", rcs.uitableview, NumericBoxedPropertyManager.PositiveDouble::new);

        register("sectionfooterheight", rcs.uitableview, NumericBoxedPropertyManager.PositiveDouble::new);

        register("sectionheaderheight", rcs.uitableview, NumericBoxedPropertyManager.PositiveDouble::new);

        /*
         * UIScrollView properties
         */
        hideProperty("decelerating", rcs.uiscrollview);
        hideProperty("dragging", rcs.uiscrollview);
        hideProperty("tracking", rcs.uiscrollview);
    }

}
