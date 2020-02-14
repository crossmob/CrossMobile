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
 * You should have received attr copy of the GNU General Public License
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.build.ib.visual;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.helper.Objects;

public class TableViewController extends ViewController {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedChild("view", Elements.TableView);
    }

    @Override
    protected void constructorOverrides(StringBuilder out) {
        String view = (item("view") != null) ? ((View) item("view")).variable() : "";
        if (!view.equals("")) {
            out.append(NEWLINE);
            out.append(I3).append("protected void loadViewFromStoryboard() {").append(NEWLINE);
            out.append(I4).append("setView(tableView());").append(NEWLINE);
            out.append(I4).append("tableView().reloadData();").append(NEWLINE);
            out.append(I4).append(Objects.LATE_INITTER).append(view).append("();").append(NEWLINE);
            out.append(I3).append("}").append(NEWLINE);
            out.append(I3).append("@Override").append(NEWLINE);
            out.append(I3).append("public UITableView tableView() {").append(NEWLINE);
            out.append(I4).append("return ").append(Objects.GETTER).append(view).append("();").append(NEWLINE);
            out.append(I3).append("}").append(NEWLINE);
        }
    }


}
