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
import org.crossmobile.build.ib.Values;
import org.crossmobile.build.ib.visual.BarButtonItem;
import org.crossmobile.build.ib.visual.NavigationItem;
import org.crossmobile.build.ib.visual.View;
import org.crossmobile.build.ib.visual.ViewController;
import org.crossmobile.utils.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Objects extends Subviews {

    public static final String FILEOWNER = "file_owner";
    public static final String GETTER = "get";
    public static final String SETTER = "set";
    public static final String INITTER = "init";
    public static final String LATE_INITTER = "init_late";
    public static final String VARPREFIX = "_";
    public static String SCENE_VC = "";
    final static Map<String, String> VCIDENT = new HashMap<>();

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("filename", Values.String);
        addSupportedAttribute("place", Values.String);

        addSupportedChild(Elements.Placeholder);
        addSupportedChild(Elements.CustomObject);
        addSupportedChild(Elements.SwipeGestureRecognizer);
        addSupportedChild(Elements.RotationGestureRecognizer);
        addSupportedChild(Elements.TapGestureRecognizer);
        addSupportedChild(Elements.PongPressGestureRecognizer);

        addSupportedChild(Elements.ViewController);
        addSupportedChild(Elements.TableViewController);
        addSupportedChild(Elements.CollectionViewController);
        addSupportedChild(Elements.NavigationController);
        addSupportedChild(Elements.TabBarController);
        addSupportedChild(Elements.PageViewController);
        addSupportedChild(Elements.GlkViewController);
    }

    public String filename() {
        String name = attrName("filename");
        if (name == null)
            return null;
        int lastDot = name.lastIndexOf('.');
        return lastDot < 0 ? name : name.substring(0, lastDot).replace(".", "_").replace("-", "_").replace(" ", "_");
    }

    public Boolean filenameIsSet() {
        return !(filename() == null || filename().equals(""));
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        StringBuilder defs = new StringBuilder();
        StringBuilder late = new StringBuilder();
        Placeholder owner = null;
        for (Placeholder ph : parts(Elements.Placeholder))
            if (ph.isOwner()) {
                owner = ph;
                break;
            }
        if (owner == null) {
            Log.warning("Unable to find owner for " + filename());
            return "";
        }
        if (filename() != null && !filename().equals(""))
            out.append(I1).append("public static class ").append(filename()).append(" {").append(NEWLINE);

        initterMethod(out, defs, owner);
        for (View v : parts(Elements.View))
            viewConstructorMethod(out, defs, late, v);
        for (ViewController vc : parts(Elements.ViewController))
            viewControllerConstructorMethod(out, vc);
        for (CustomObject obj : parts(Elements.CustomObject))
            getterMethod(out, defs, obj);

        for (LayoutGuides guide : parts(Elements.LayoutGuides))
            defs.append(guide.toCode());

        out.append(late);
        out.append(defs);
        if (filename() != null && !filename().equals(""))
            out.append(I1).append("}").append(NEWLINE);

        return out.toString();
    }


    static void viewConstructorMethod(StringBuilder out, StringBuilder defs, StringBuilder late, View view) {
        getterMethod(out, defs, view);
        lateInitMethod(late, view);
        for (Connections connections : view.parts(Elements.Connections))
            for (Segue storyboardSegue : connections.parts(Elements.Segue))
                getNewMethod(out, defs, storyboardSegue);
        for (Prototypes p : view.parts(Elements.Prototypes))
            out.append(p.toCode());
        for (Subviews e : view.parts(Elements.Subviews))
            for (View childView : subviews(e))
                viewConstructorMethod(out, defs, late, childView);
    }

    private static Collection<View> subviews(Subviews subviews) {
        Collection<View> views = new ArrayList<>();
        for (Subviews e : subviews.parts(Elements.Subviews))
            views.addAll(subviews(e));
        for (View view : subviews.parts(Elements.View))
            for (Subviews inner : view.getInnerParts(Elements.Subviews))
                views.addAll(inner.parts(Elements.View));

        views.addAll(subviews.parts(Elements.View));
        return views;
    }

    private void viewControllerConstructorMethod(StringBuilder out, ViewController viewController) {
        StringBuilder defs = new StringBuilder();
        StringBuilder late = new StringBuilder();
        classMethod(out, defs, viewController);
        for (View view : viewController.namedParts(Elements.View))
            viewConstructorMethod(out, defs, late, view);
        for (LayoutGuides guides : viewController.parts(Elements.LayoutGuides))
            for (ViewControllerLayoutGuide guide : guides.parts(Elements.ViewControllerLayoutGuide))
                simpleDef(defs, guide);
        for (NavigationItem navigationItem : viewController.namedParts(Elements.NavigationItem)) {
            for (View view : navigationItem.namedParts(Elements.View)) viewConstructorMethod(out, defs, late, view);
            for (BarButtonItem barButtonItem : navigationItem.namedParts(Elements.BarButtonItem)) {
                getterMethod(out, defs, barButtonItem);
                for (Connections connections : barButtonItem.parts(Elements.Connections))
                    for (Segue storyboardSegue : connections.parts(Elements.Segue))
                        getterMethod(out, defs, storyboardSegue);
            }
        }

        out.append(late);
        out.append(defs);
        out.append(I2).append("}").append(NEWLINE);
    }

    private static void lateInitMethod(StringBuilder late, View view) {
        String variable = ((RealElement) view).variable();
        late.append(I2).append("public final void ").append(LATE_INITTER).append(variable).append("() {").append(NEWLINE);
        late.append(view.late());
        late.append(I2).append("}").append(NEWLINE);
    }


    static void classMethod(StringBuilder out, StringBuilder defs, RealElement el) {
        String variable = el.variable();
        String className = el.getClassName();
        out.append(I2).append("public static class ").append(variable).append(" extends ").append(className).append(" {").append(NEWLINE);
        out.append(I3).append(el.publicConstructor()).append(" {").append(NEWLINE);
        out.append(el.toCode()).append(NEWLINE);
        out.append(I3).append("}").append(NEWLINE);
    }

    static void getterMethod(StringBuilder out, StringBuilder defs, RealElement el) {
        String variable = el.variable();
        String className = el.getClassName();
        out.append(I2).append("public final ").append(className).append(" ").append(GETTER).append(variable).append("() {").append(NEWLINE);
        out.append(I3).append("if(").append(variable).append(" == null) {").append(NEWLINE);
        out.append(el.toCode());
        out.append(I3).append("}").append(NEWLINE);
        out.append(I3).append("return ").append(variable).append(";").append(NEWLINE);
        out.append(I2).append("}").append(NEWLINE);
        defs.append(I2).append(className).append(" ").append(variable).append(";").append(NEWLINE);
    }

    static void getNewMethod(StringBuilder out, StringBuilder defs, RealElement el) {
        String variable = el.variable();
        String className = el.getClassName();
        out.append(I2).append("public final ").append(className).append(" ").append(GETTER).append(variable).append("() {").append(NEWLINE);
        out.append(el.toCode());
        out.append(I3).append("return ").append(variable).append(";").append(NEWLINE);
        out.append(I2).append("}").append(NEWLINE);
        defs.append(I2).append(className).append(" ").append(variable).append(";").append(NEWLINE);
    }

    private void initterMethod(StringBuilder out, StringBuilder defs, Placeholder owner) {
        String variable = owner.variable();
        String className = owner.getClassName();
        out.append(I2).append("public final ").append(className).append(" ").append(GETTER).append(variable).append("() {").append(NEWLINE);
        out.append(I3).append("if(").append(variable).append(" == null) {").append(NEWLINE);
        out.append(I4).append(variable).append(" = ").append(owner.constructor()).append(";").append(NEWLINE);
        out.append(I3).append("}").append(NEWLINE);
        out.append(I3).append("return ").append(variable).append(";").append(NEWLINE);
        out.append(I2).append("}").append(NEWLINE);

        out.append(I2).append("public final void ").append(SETTER).append(variable).append("(Object ").append(variable).append(") {").append(NEWLINE);
        out.append(I3).append("this.").append(variable).append(" = (").append(className).append(")").append(variable).append(";").append(NEWLINE);
        out.append(I2).append("}").append(NEWLINE);

        out.append(I2).append("public final void ").append(INITTER).append(variable).append("() {").append(NEWLINE);
        out.append(owner.toCode());
        out.append(I2).append("}").append(NEWLINE);
        defs.append(I2).append(className).append(" ").append(variable).append(";").append(NEWLINE);
    }

    private void simpleDef(StringBuilder defs, RealElement el) {
        defs.append(I2).append(el.getClassName()).append(" ").append(el.variable()).append(";").append(NEWLINE);
    }

    public static void addVC(String identifier, String variable) {
        if (identifier != null && !identifier.isEmpty() && variable != null && !variable.isEmpty())
            VCIDENT.put(identifier, variable);
    }
}
