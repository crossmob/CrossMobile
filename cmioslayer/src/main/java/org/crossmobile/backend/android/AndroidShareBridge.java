/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.backend.android;

import android.content.Intent;
import android.net.Uri;
import crossmobile.ios.foundation.NSError;
import crossmobile.ios.uikit.UIActivityViewControllerCompletionWithItemsHandler;
import crossmobile.ios.uikit.UIImage;
import org.crossmobile.bridge.ShareBridge;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class AndroidShareBridge implements ShareBridge {

    private String type = "text";
    private String subtype = "plain";

    @Override
    public void share(List items, List<String> excluded, UIActivityViewControllerCompletionWithItemsHandler completion) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        if (items == null) {
            if (completion != null)
                completion.invoke("Android Share", false, null, NSError.errorWithDomain("Null List", -1, null));
            System.out.println("null list");
            return;
        }
        for (Object item : items) {
            addItem(item, intent);
        }
        System.out.println(type + "/" + subtype);
        intent.setType(type + "/" + subtype);
        MainActivity.current.getStateListener().launch(null, Intent.createChooser(intent, "Share" + (type.equals("image") ? "Image" : "...")));
    }

    private void addItem(Object item, Intent intent) {
        if (item instanceof String)
            intent.putExtra(Intent.EXTRA_TEXT, (String) item);
        if (item instanceof UIImage) {
            File tempFile;
            try {
                File outputDir = MainActivity.current().getCacheDir();
                outputDir.mkdirs();
                tempFile = new File(outputDir, item.hashCode() + ".png");
                FileOutputStream fo = new FileOutputStream(tempFile);
                fo.write(((UIImage) item).PNGRepresentation().bytes());
                intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
                if (type.equals("text")) {
                    type = "image";
                    subtype = "png";
                }
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
