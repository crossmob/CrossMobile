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

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class UIActivityType {
    public static final String PostToFacebook = "com.apple.UIKit.activity.PostToFacebook";
    public static final String PostToTwitter = "com.apple.UIKit.activity.PostToTwitter";
    public static final String PostToWeibo = "com.apple.UIKit.activity.PostToWeibo";
    public static final String Message = "com.apple.UIKit.activity.Message";
    public static final String Mail = "com.apple.UIKit.activity.Mail";
    public static final String Print = "com.apple.UIKit.activity.Print";
    public static final String CopyToPasteboard = "com.apple.UIKit.activity.CopyToPasteboard";
    public static final String AssignToContact = "com.apple.UIKit.activity.AssignToContact";
    public static final String SaveToCameraRoll = "com.apple.UIKit.activity.SaveToCameraRoll";
    public static final String AddToReadingList = "com.apple.UIKit.activity.AddToReadingList";
    public static final String PostToFlickr = "com.apple.UIKit.activity.PostToFlickr";
    public static final String PostToVimeo = "com.apple.UIKit.activity.PostToVimeo";
    public static final String PostToTencentWeibo = "com.apple.UIKit.activity.TencentWeibo";
    public static final String AirDrop = "com.apple.UIKit.activity.AirDrop";
    public static final String OpenInIBooks = "com.apple.UIKit.activity.OpenInIBooks";

    private UIActivityType() {
    }
}
