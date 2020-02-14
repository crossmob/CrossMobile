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
package org.crossmobile.gui.parameters.impl;

import org.crossmobile.gui.parameters.FilteredFileParameter;
import org.crossmobile.utils.ParamList;

import java.io.File;

import static org.crossmobile.utils.ParamsCommon.MAIN_STORYBOARD;

public class StoryboardParameter extends FilteredFileParameter {

    public StoryboardParameter(ParamList prop, File baseDir) {
        super(prop, MAIN_STORYBOARD.tag(), baseDir, f -> f.toLowerCase().endsWith(".storyboard"));
    }

    @Override
    public String getVisualTag() {
        return "Main Storyboard";
    }
}
