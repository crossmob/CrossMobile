package org.crossmobile.plugin.robovm.models.methods;

import javassist.CannotCompileException;
import javassist.CtClass;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.lang.reflect.Modifier;
import java.util.List;

public class InterfaceRMethod extends RMethod {
    public InterfaceRMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        super(selector, returnParam, parameters, object, cclass);
    }

    @Override
    protected void setModifiers() throws CannotCompileException {
        method.setModifiers(Modifier.PUBLIC);
        method.setBody("{" + (needsReturn() ? "return null;" : "") + "}");
    }
}
