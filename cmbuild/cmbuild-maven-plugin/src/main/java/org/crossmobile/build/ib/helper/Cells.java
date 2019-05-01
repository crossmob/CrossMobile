package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.visual.TableViewCell;

public class Cells extends Subviews {

    @Override
    protected void addSupported() {
        addSupportedChild(Elements.TableViewCell);
    }

    public String constructor() {
        StringBuilder out = new StringBuilder("new UITableViewCell[] {");
        for (TableViewCell tableViewCell : parts(Elements.TableViewCell))
            out.append(NEWLINE).append(I5).append(Objects.GETTER).append(tableViewCell.variable()).append("(),");
        out.deleteCharAt(out.length() - 1);
        out.append(NEWLINE).append(I4).append("}");
        return out.toString();
    }

}
