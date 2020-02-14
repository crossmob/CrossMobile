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
package org.crossmobile.build.ib;

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.build.ib.helper.Date;
import org.crossmobile.build.ib.helper.Objects;
import org.crossmobile.build.ib.helper.TimeZone;
import org.crossmobile.build.ib.helper.*;
import org.crossmobile.build.ib.visual.*;
import org.crossmobile.utils.Log;

import java.lang.reflect.Field;
import java.util.*;

public final class Elements {

    private static final Map<String, Element> elementModels = new HashMap<>();
    private static final Map<Class<? extends Element>, String> elementNames = new HashMap<>();

    public static final Action Action = dec("Action", new Action());
    public static final ActivityIndicatorView ActivityIndicatorView = dec("ActivityIndicatorView", new ActivityIndicatorView());
    public static final AdBannerView AdBannerView = dec("AdBannerView", new AdBannerView());
    public static final AutoresizingMask AutoresizingMask = dec("AutoresizingMask", new AutoresizingMask());
    public static final BarButtonItem BarButtonItem = dec("BarButtonItem", new BarButtonItem());
    public static final Button Button = dec("Button", new Button());
    public static final Cells Cells = dec("Cells", new Cells());
    public static final Color Color = dec("Color", new Color());
    public static final CollectionViewController CollectionViewController = dec("CollectionViewController", new CollectionViewController());
    public static final Connections Connections = dec("Connections", new Connections());
    public static final Constraints Constraints = dec("Constraints", new Constraints());
    public static final Constraint Constraint = dec("Constraint", new Constraint());
    public static final Control Control = dec("Control", new Control());
    public static final CustomObject CustomObject = dec("CustomObject", new CustomObject());
    public static final DataDetectorType DataDetectorType = dec("DataDetectorType", new DataDetectorType());
    public static final Date Date = dec("Date", new Date());
    public static final DatePicker DatePicker = dec("DatePicker", new DatePicker());
    public static final FontDescription FontDescription = dec("FontDescription", new FontDescription());
    public static final GestureRecognizer GestureRecognizer = dec("GestureRecognizer", new GestureRecognizer());
    public static final GlkViewController GlkViewController = dec("GlkViewController", new GlkViewController());
    public static final ImageView ImageView = dec("ImageView", new ImageView());
    public static final Inset Inset = dec("Inset", new Inset());
    public static final Items Items = dec("Items", new Items());
    public static final Label Label = dec("Label", new Label());
    public static final LayoutGuide ViewLayoutGuide = dec("ViewLayoutGuide", new LayoutGuide());
    public static final LayoutGuides LayoutGuides = dec("LayoutGuides", new LayoutGuides());
    public static final MapView MapView = dec("MapView", new MapView());
    public static final NavigationBar NavigationBar = dec("NavigationBar", new NavigationBar());
    public static final NavigationController NavigationController = dec("NavigationController", new NavigationController());
    public static final NavigationItem NavigationItem = dec("NavigationItem", new NavigationItem());
    public static final Nil Nil = dec("Nil", new Nil());
    public static final Objects Objects = dec("Objects", new Objects());
    public static final OffsetWrapper OffsetWrapper = dec("OffsetWrapper", new OffsetWrapper());
    public static final Outlet Outlet = dec("Outlet", new Outlet());
    public static final PageControl PageControl = dec("PageControl", new PageControl());
    public static final PageViewController PageViewController = dec("PageViewController", new PageViewController());
    public static final PanGestureRecognizer PanGestureRecognizer = dec("PanGestureRecognizer", new PanGestureRecognizer());
    public static final PickerView PickerView = dec("PickerView", new PickerView());
    public static final PinchGestureRecognizer PinchGestureRecognizer = dec("PinchGestureRecognizer", new PinchGestureRecognizer());
    public static final Placeholder Placeholder = dec("Placeholder", new Placeholder());
    public static final PongPressGestureRecognizer PongPressGestureRecognizer = dec("PongPressGestureRecognizer", new PongPressGestureRecognizer());
    public static final ProgressView ProgressView = dec("ProgressView", new ProgressView());
    public static final Prototypes Prototypes = dec("Prototypes", new Prototypes());
    public static final Rect Rect = dec("Rect", new Rect());
    public static final RotationGestureRecognizer RotationGestureRecognizer = dec("RotationGestureRecognizer", new RotationGestureRecognizer());
    public static final ScrollView ScrollView = dec("ScrollView", new ScrollView());
    public static final SearchBar SearchBar = dec("SearchBar", new SearchBar());
    public static final Sections Sections = dec("Sections", new Sections());
    public static final Segment Segment = dec("Segment", new Segment());
    public static final SegmentedControl SegmentedControl = dec("SegmentedControl", new SegmentedControl());
    public static final Segments Segments = dec("Segments", new Segments());
    public static final Segue Segue = dec("Segue", new Segue());
    public static final SwipeGestureRecognizer SwipeGestureRecognizer = dec("SwipeGestureRecognizer", new SwipeGestureRecognizer());
    public static final Size Size = dec("Size", new Size());
    public static final Slider Slider = dec("Slider", new Slider());
    public static final StackView StackView = dec("StackView", new StackView());
    public static final State State = dec("State", new State());
    public static final Stepper Stepper = dec("Stepper", new Stepper());
    public static final Subviews Subviews = dec("Subviews", new Subviews());
    public static final Switch Switch = dec("Switch", new Switch());
    public static final TabBar TabBar = dec("TabBar", new TabBar());
    public static final TabBarController TabBarController = dec("TabBarController", new TabBarController());
    public static final TabBarItem TabBarItem = dec("TabBarItem", new TabBarItem());
    public static final TableView TableView = dec("TableView", new TableView());
    public static final TableViewCell TableViewCell = dec("TableViewCell", new TableViewCell());
    public static final TableViewCellContentView TableViewCellContentView = dec("TableViewCellContentView", new TableViewCellContentView());
    public static final TableViewController TableViewController = dec("TableViewController", new TableViewController());
    public static final TableViewSection TableViewSection = dec("TableViewSection", new TableViewSection());
    public static final TapGestureRecognizer TapGestureRecognizer = dec("TapGestureRecognizer", new TapGestureRecognizer());
    public static final TextAttributes TextAttributes = dec("TextAttributes", new TextAttributes());
    public static final TextField TextField = dec("TextField", new TextField());
    public static final TextInputTraits TextInputTraits = dec("TextInputTraits", new TextInputTraits());
    public static final TextView TextView = dec("TextView", new TextView());
    public static final TimeZone TimeZone = dec("TimeZone", new TimeZone());
    public static final Toolbar Toolbar = dec("Toolbar", new Toolbar());
    public static final View View = dec("View", new View());
    public static final ViewController ViewController = dec("ViewController", new ViewController());
    public static final ViewControllerLayoutGuide ViewControllerLayoutGuide = dec("ViewControllerLayoutGuide", new ViewControllerLayoutGuide());
    public static final WebView WebView = dec("WebView", new WebView());
    public static final Window Window = dec("Window", new Window());
    public static final XibClassEnd XibClassEnd = dec("XibClassEnd", new XibClassEnd());
    public static final XibClassStart XibClassStart = dec("XibClassStart", new XibClassStart());
    public static final XIBList XIBList = dec("XIBList", new XIBList(null));

    private static final Set<String> ignoreList = new HashSet<>(Arrays.asList("point", "resources", "dependencies", "simulatedStatusBarMetrics", "simulatedNavigationBarMetrics", "simulatedToolbarMetrics", "simulatedOrientationMetrics", "simulatedScreenMetrics", "device"));

    static {
        Class elementClass = Element.class;
        for (Field f : Elements.class.getDeclaredFields())
            if (elementClass.isAssignableFrom(f.getType()))
                try {
                    Element e = (Element) f.get(null);
                    e.addSupported();
                } catch (IllegalArgumentException | IllegalAccessException ex) {
                    BaseUtils.throwException(ex);
                }
    }

    private static <T extends Element> T dec(String name, T model) {
        elementModels.put(name.toLowerCase(), model);
        elementNames.put(model.getClass(), name);
        return model;
    }

    public static String getName(Element element) {
        return elementNames.get(element.getClass());
    }

    public static Element getModel(String name) {
        return getModel(null, name);
    }

    public static Element getModel(String context, String name) {
        if (ignoreList.contains(name))
            return null;
        Element req = elementModels.get(name.toLowerCase());
        if (req == null && context != null)
            Log.warning(context + ": Missing " + name + " element");
        return req;
    }
}
