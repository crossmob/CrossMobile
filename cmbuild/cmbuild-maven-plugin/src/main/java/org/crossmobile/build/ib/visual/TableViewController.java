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
 * You should have received attr copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
            out.append("@Override").append(NEWLINE);
            out.append(I3).append("public void loadView() {").append(NEWLINE);
            out.append(I4).append("super.loadView();").append(NEWLINE);
            out.append(I4).append(Objects.LATE_INITTER).append(view).append("();").append(NEWLINE);
            out.append(I3).append("}").append(NEWLINE);
            out.append(I3).append("@Override").append(NEWLINE);
            out.append(I3).append("public UITableView tableView() {").append(NEWLINE);
            out.append(I4).append("return ").append(Objects.GETTER).append(view).append("();").append(NEWLINE);
            out.append(I3).append("}").append(NEWLINE);
        }
    }


}
