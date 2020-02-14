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
package crossmobile.ios.quicklook;

import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;

/**
 * QLPreviewItem interface defines properties of items that can be previewed in
 * a QuickLook preview.
 */
@CMClass
public interface QLPreviewItem {

    /**
     * Returns the URL of the QLPreviewItem.
     *
     * @return The URL of the QLPreviewItem.
     */
    @CMGetter("@property(readonly, nonatomic) NSURL *previewItemURL;")
    public abstract NSURL previewItemURL();

    /**
     * Returns the title of the QLPreviewItem.
     *
     * @return The title of the QLPreviewItem.
     */
    @CMGetter("@property(readonly, nonatomic) NSString *previewItemTitle;")
    public abstract String previewItemTitle();
}
