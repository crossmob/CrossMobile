/*
 * (c) 2019 by Panayotis Katsaloulis
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
package org.crossmobile.gui.elements;

import javax.swing.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Consumer;

public class DnDFileHandler extends TransferHandler {

    private final Consumer<File> addedFiles;

    public DnDFileHandler(Consumer<File> addedFiles) {
        this.addedFiles = addedFiles;
    }

    @Override
    public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
        if (addedFiles == null)
            return false;
        for (DataFlavor flavour : transferFlavors)
            if (flavour.isFlavorJavaFileListType())
                return true;
        return false;
    }

    @Override
    public boolean importData(JComponent comp, Transferable t) {
        try {
            Object data = t.getTransferData(DataFlavor.javaFileListFlavor);
            if (data != null && data instanceof List)
                for (Object item : (List) data)
                    if (item != null && item instanceof File)
                        addedFiles.accept((File) item);
            return true;
        } catch (UnsupportedFlavorException | IOException ex) {
            return false;
        }
    }
}
