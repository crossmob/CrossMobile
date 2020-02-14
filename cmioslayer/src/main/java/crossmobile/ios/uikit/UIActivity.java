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
import org.crossmobile.bridge.ann.CMSelector;

import java.util.List;

@CMClass
public abstract class UIActivity extends NSObject {
    private String activityType;
    private String activityTitle;
    private UIImage activityImage;
    private UIViewController activityViewController;

    @CMGetter("@property(nonatomic, readonly) UIActivityType activityType;")
    public abstract String activityType();

    @CMGetter("@property(nonatomic, readonly) NSString *activityTitle;")
    public abstract String activityTitle();

    @CMGetter("@property(nonatomic, readonly) UIImage *activityImage;")
    public abstract UIImage activityImage();

    @CMGetter("@property(nonatomic, readonly) UIViewController *activityViewController;")
    public UIViewController activityViewController() {
        return null;
    }

    @CMSelector("+ (UIActivityCategory)activityCategory")
    public static long activityCategory() {
        return UIActivityCategory.Action;
    }

    @CMSelector("- (BOOL)canPerformWithActivityItems:(NSArray *)activityItems;")
    public abstract boolean canPerformWithActivityItems(List activityItems);

    @CMSelector("- (void)prepareWithActivityItems:(NSArray *)activityItems;")
    public abstract void prepareWithActivityItems(List activityItems);


    @CMSelector("- (void)performActivity;")
    public void performActivity() {

    }

    @CMSelector("- (void)activityDidFinish:(BOOL)completed;")
    public void activityDidFinish(boolean completed) {

    }
}
