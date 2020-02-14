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
package org.crossmobile.build;

import crossmobile.ios.uikit.*;
import org.crossmobile.bridge.ann.CMLib;

import java.util.Properties;

import static org.crossmobile.bridge.ann.CMLibTarget.APIJAVA;

@CMLib(name = "cmioslayer", target = APIJAVA)
public class StoryBoardBinder {

    private static Properties outlets;

    public static void bindStoryboardWithViewController(UIViewController controller, UIStoryboard storyboard) {
        $uikit.setStoryboard(controller, storyboard);
    }

    public static void bindSegueWithViewController(UIViewController controller, String id, UIStoryboardSegue segueMap) {
        $uikit.addSegue(controller, id, segueMap);
    }

    public static void bindSegueWithTableviewCell(UITableViewCell cell, String trigger, UIStoryboardSegue segue) {
        $uikit.addSegue(cell, trigger, segue);
    }

    public static void addSectionToTableViewController(UITableViewController tableViewController, String headerTitle, String footerTitle, UITableViewCell[] cells) {
        $uikit.addSection(tableViewController, headerTitle, footerTitle, cells);
    }

    public static void bindRowHeightToTableViewCell(UITableViewCell cell, float rowHeight){
        $uikit.setCellRowHeight(cell, rowHeight);
    }
}
