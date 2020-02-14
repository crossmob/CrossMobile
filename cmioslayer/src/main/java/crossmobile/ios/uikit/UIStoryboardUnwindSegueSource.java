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
