/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.wrapper;

public class HistoryItem {
    public final String url;
    public final String originalUrl;
    public final String title;

    public HistoryItem(String url, String originalUrl, String title) {
        this.url = url;
        this.originalUrl = originalUrl;
        this.title = title;
    }
}
