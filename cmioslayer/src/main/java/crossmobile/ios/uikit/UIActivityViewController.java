package crossmobile.ios.uikit;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.List;

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
