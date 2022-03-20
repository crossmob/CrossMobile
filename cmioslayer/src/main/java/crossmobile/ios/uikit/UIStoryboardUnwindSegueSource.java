/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMLib;

import java.lang.reflect.Method;

import static org.crossmobile.bridge.ann.CMLibTarget.API_NOUWP;

@CMLib(name = "cmioslayer", target = API_NOUWP)
@CMClass
public class UIStoryboardUnwindSegueSource extends NSObject {

    private final UIViewController sourceViewController;
    private final Method unwindAction;
    private final Object sender;

    UIStoryboardUnwindSegueSource(UIViewController sourceViewController, Method unwindAction, Object sender) {
        this.sourceViewController = sourceViewController;
        this.unwindAction = unwindAction;
        this.sender = sender;
    }

    @CMGetter("@property(readonly) UIViewController *sourceViewController;")
    public UIViewController sourceViewController() {
        return sourceViewController;
    }

    @CMGetter("@property(readonly) SEL unwindAction;")
    public Method unwindAction() {
        return unwindAction;
    }

    @CMGetter("@property(readonly) id sender;")
    public Object sender() {
        return sender;
    }
}
