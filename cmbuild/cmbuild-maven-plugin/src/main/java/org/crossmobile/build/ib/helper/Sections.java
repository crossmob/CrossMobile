package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Elements;

public class Sections extends Subviews {
    @Override
    protected void addSupported() {
        addSupportedChild(Elements.TableViewSection);
    }


    public String addSection() {
        StringBuilder out = new StringBuilder();
        for (TableViewSection tableViewSection : parts(Elements.TableViewSection))
            out.append(I4).append("org.crossmobile.build.StoryBoardBinder.addSectionToTableViewController(").append(Objects.SCENE_VC).append(".this, ").append(tableViewSection.addSection()).append(");").append(NEWLINE);
        return out.toString();
    }
}
