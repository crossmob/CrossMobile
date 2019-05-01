package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Elements;
import org.crossmobile.build.ib.visual.View;

import static org.crossmobile.build.ib.helper.Objects.getNewMethod;
import static org.crossmobile.build.ib.helper.Objects.viewConstructorMethod;

public class Prototypes extends Element {
    @Override
    protected void addSupported() {
        addSupportedChild(Elements.TableViewCell);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        for (View view : parts(Elements.View)) {
            StringBuilder defs = new StringBuilder();
            StringBuilder late = new StringBuilder();
            String variable = ((RealElement) view).variable();
            out.append(I2).append("public class ").append(variable).append("_Prototype extends ").append(view.getClassName()).append(" {").append(NEWLINE);
            protoTypeClass(out, defs, late, view, variable);
            for (Subviews subviews : view.getInnerParts(Elements.Subviews))
                for (View v : subviews.parts(Elements.View))
                    viewConstructorMethod(out, defs, late, v);
            for (Connections connections : view.parts(Elements.Connections))
                for (Segue storyboardSegue : connections.parts(Elements.Segue))
                    getNewMethod(out, defs, storyboardSegue);
            out.append(late);
            out.append(defs);
            out.append(I2).append("}").append(NEWLINE);
        }
        return out.toString();
    }

    private void protoTypeClass(StringBuilder out, StringBuilder defs, StringBuilder late, View view, String variable) {
        String prototype = view.prototype();
        if (prototype.isEmpty())
            return;
        out.append(I3).append("public ").append(variable).append("_Prototype() {").append(NEWLINE);
        out.append(prototype);
        out.append(I3).append("}").append(NEWLINE);
    }
}
