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
package org.crossmobile.build.ib.helper;


import org.crossmobile.build.ib.Elements;

public class XibClassStart extends Objects {
    private String filename;
    private String initialViewController;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    protected void addSupported() {
        addSupportedChild(Elements.Objects);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        if (filename != null) {
            out.append(I1 + "public static class ").append(filename).append(" extends UIStoryboard {").append(NEWLINE);
            out.append(I2 + "public ").append(filename).append("() {").append(NEWLINE);
            out.append(I3).append("setStoryBoard(this);").append(NEWLINE);
            out.append(I2).append("}").append(NEWLINE);
            out.append(I2).append("private static ").append(filename).append(" ").append(filename).append("_singleton;").append(NEWLINE);
            out.append(I2).append("private void setStoryBoard(").append(filename).append(" storyboard) {").append(NEWLINE);
            out.append(I3).append(filename).append("_singleton = this;").append(NEWLINE);
            out.append(I2).append("}").append(NEWLINE);
            out.append(I2).append("public static ").append(filename).append(" get_Storyboard() {").append(NEWLINE);
            out.append(I3).append("return ").append(filename).append("_singleton;").append(NEWLINE);
            out.append(I2).append("}").append(NEWLINE);
        } else
            out.append(I1).append("{").append(NEWLINE);
        if (!initialViewController.equals("") || initialViewController == null) {
            out.append(I2).append("@Override").append(NEWLINE);
            out.append(I2).append("public UIViewController instantiateInitialViewController() {").append(NEWLINE);
            out.append(I3).append("return new ").append(RealElement.variableFromID(initialViewController)).append("();").append(NEWLINE);
            out.append(I2).append("}").append(NEWLINE);
        }

        return out.toString();
    }

    public void setInitialViewController(String initialViewController) {
        this.initialViewController = initialViewController;
        addSupported();
    }
}
