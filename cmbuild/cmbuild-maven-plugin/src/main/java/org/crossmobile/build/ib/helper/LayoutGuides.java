package org.crossmobile.build.ib.helper;

import org.crossmobile.build.ib.Element;
import org.crossmobile.build.ib.Elements;

import java.util.Collection;

public class LayoutGuides extends Element {
    @Override
    protected void addSupported() {
        addSupportedChild(Elements.ViewControllerLayoutGuide);
    }

    @Override
    public String toCode() {
        StringBuilder out = new StringBuilder();
        Collection<ViewControllerLayoutGuide> viewControllerLayoutGuides;
        if (!(viewControllerLayoutGuides = parts(Elements.ViewControllerLayoutGuide)).isEmpty())
            for (ViewControllerLayoutGuide viewControllerLayoutGuide : viewControllerLayoutGuides)
                out.append(viewControllerLayoutGuide.toCode());
        return out.toString();
    }
}
