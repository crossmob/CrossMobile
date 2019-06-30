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

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.List;

@CMClass
public class UIActivityViewController extends UIViewController {

    private UIActivityViewControllerCompletionWithItemsHandler completionWithItemsHandler;
    private UIActivityViewControllerCompletionHandler completionHandler;
    private List<String> excludedActivityTypes;
    List activityItems;

    @CMConstructor("- (instancetype)initWithActivityItems:(NSArray *)activityItems\n"
            + "    applicationActivities:(NSArray<__kindof UIActivity *> *)applicationActivities;")
    public UIActivityViewController(List activityItems, List<UIActivity> applicationActivities) {
        this.activityItems = activityItems;
    }

    // TODO
//    @CMGetter("@property(nonatomic, copy) UIActivityViewControllerCompletionWithItemsHandler completionWithItemsHandler;")
//    public UIActivityViewControllerCompletionWithItemsHandler completionWithItemsHandler() {
//        return completionWithItemsHandler;
//    }
//
    @CMSetter("@property(nonatomic, copy) UIActivityViewControllerCompletionWithItemsHandler completionWithItemsHandler;")
    public void setCompletionWithItemsHandler(UIActivityViewControllerCompletionWithItemsHandler completionWithItemsHandler) {
        this.completionWithItemsHandler = completionWithItemsHandler;
    }

    @CMGetter("@property(nonatomic, copy) NSArray<UIActivityType> *excludedActivityTypes;")
    public List<String> excludedActivityTypes() {
        return excludedActivityTypes;
    }

    @CMSetter("@property(nonatomic, copy) NSArray<UIActivityType> *excludedActivityTypes;")
    public void setExcludedActivityTypes(List<String> excludedActivityTypes) {
        this.excludedActivityTypes = excludedActivityTypes;
    }

    // TODO
//    @CMGetter("@property(nonatomic, copy) UIActivityViewControllerCompletionHandler completionHandler;")
//    public UIActivityViewControllerCompletionHandler completionHandler() {
//        return completionHandler;
//    }
//
    @CMSetter("@property(nonatomic, copy) UIActivityViewControllerCompletionHandler completionHandler;")
    public void setCompletionHandler(UIActivityViewControllerCompletionHandler completionHandler) {
        this.completionHandler = completionHandler;
    }

    @Override
    public void viewDidAppear(boolean animated) {
        super.viewDidAppear(animated);

        Native.share().share(activityItems, null, completionWithItemsHandler);
    }
}
