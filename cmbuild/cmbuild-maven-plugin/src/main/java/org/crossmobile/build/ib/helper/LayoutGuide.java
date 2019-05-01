package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Values;

public class LayoutGuide extends RealElement {

    @Override
    protected void addSupported() {
        super.addSupported();
        addSupportedAttribute("key", Values.String);
    }

    @Override
    public String toCode() {
        return null;
    }


    @Override
    public String variable() {
        return super.variable();
    }

    public String toCode(String viewId) {
        StringBuilder out = new StringBuilder();
        return out.append(I4).append("UILayoutGuide ").append(variable()).append(I1).append("=").append(I1).append(viewId).append(".safeAreaLayoutGuide();").append(NEWLINE).toString();
    }
}
