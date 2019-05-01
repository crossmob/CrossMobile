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
