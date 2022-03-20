/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
    @SuppressWarnings({"FieldCanBeLocal", "deprecation"})
    private UIActivityViewControllerCompletionHandler completionHandler;
    private List<String> excludedActivityTypes;
    @SuppressWarnings("rawtypes")
    List activityItems;

    @SuppressWarnings("rawtypes")
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
    @SuppressWarnings("deprecation")
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
