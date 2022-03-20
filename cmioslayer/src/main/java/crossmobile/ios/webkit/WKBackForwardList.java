/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.webkit;

import crossmobile.ios.foundation.NSObject;
import crossmobile.ios.foundation.NSURL;
import org.crossmobile.bind.wrapper.HistoryItem;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CMClass
public class WKBackForwardList extends NSObject {
    private final List<WKBackForwardListItem> history;
    private final int current;

    WKBackForwardList(Iterable<HistoryItem> listProducer, int current) {
        history = new ArrayList<>();
        for (HistoryItem item : listProducer)
            if (!item.url.startsWith("data:"))
                history.add(new WKBackForwardListItem(NSURL.URLWithString(item.url), NSURL.URLWithString(item.originalUrl), item.title));
        this.current = current;
    }

    @CMGetter("@property(nullable, nonatomic, readonly, strong) WKBackForwardListItem *backItem;")
    public WKBackForwardListItem backItem() {
        return itemAtIndex(-1);
    }

    @CMGetter("@property(nullable, nonatomic, readonly, strong) WKBackForwardListItem *currentItem;")
    public WKBackForwardListItem currentItem() {
        return itemAtIndex(0);
    }

    @CMGetter("@property(nullable, nonatomic, readonly, strong) WKBackForwardListItem *forwardItem;")
    public WKBackForwardListItem forwardItem() {
        return itemAtIndex(1);
    }

    @CMSelector("- (WKBackForwardListItem *)itemAtIndex:(NSInteger)index;")
    public WKBackForwardListItem itemAtIndex(int index) {
        index += current;
        return index >= 0 && index < history.size() ? history.get(index) : null;
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSArray<WKBackForwardListItem *> *backList;")
    public List<WKBackForwardListItem> backList() {
        return new ArrayList<>(history.subList(0, current));
    }

    @CMGetter("@property(nonatomic, readonly, copy) NSArray<WKBackForwardListItem *> *forwardList;")
    public List<WKBackForwardListItem> forwardList() {
        return current + 1 >= history.size() ? Collections.emptyList() : new ArrayList<>(history.subList(current + 1, history.size()));
    }
}
