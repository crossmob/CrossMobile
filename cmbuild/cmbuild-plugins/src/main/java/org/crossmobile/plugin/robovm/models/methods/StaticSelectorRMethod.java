package org.crossmobile.plugin.robovm.models.methods;

import javassist.CtClass;
import javassist.Modifier;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.util.List;

public class StaticSelectorRMethod extends SelectorRMethod {
    public StaticSelectorRMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        super(selector, returnParam, parameters, object, cclass);
    }

    @Override
    protected void setModifiers() {
        method.setModifiers(Modifier.PUBLIC | Modifier.NATIVE | Modifier.STATIC);
    }
}
