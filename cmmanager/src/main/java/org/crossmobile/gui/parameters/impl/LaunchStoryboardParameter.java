/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.gui.parameters.impl;

import org.crossmobile.gui.parameters.FilteredFileParameter;
import org.crossmobile.utils.ParamList;

import java.io.File;

import static org.crossmobile.utils.ParamsCommon.LAUNCH_STORYBOARD;

public class LaunchStoryboardParameter extends FilteredFileParameter {

    public LaunchStoryboardParameter(ParamList prop, File baseDir) {
        super(prop, LAUNCH_STORYBOARD.tag(), baseDir, f -> f.toLowerCase().endsWith(".storyboard"));
    }

    @Override
    public String getVisualTag() {
        return "Launch Storyboard";
    }
}
