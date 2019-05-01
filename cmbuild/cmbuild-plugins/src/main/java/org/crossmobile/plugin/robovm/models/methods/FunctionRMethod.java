package org.crossmobile.plugin.robovm.models.methods;

import javassist.CtClass;
import javassist.Modifier;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.util.List;

import static org.crossmobile.plugin.bro.JavaTransformer.BRIDGE_ANN;
import static org.crossmobile.utils.JavassistAnnParam.toParam;
import static org.crossmobile.utils.JavassistUtils.addAnnotation;

public class FunctionRMethod extends RMethod {
    public FunctionRMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        super(selector, returnParam, parameters, object, cclass);
    }

    @Override
    protected void setModifiers() {
        method.setModifiers(Modifier.PRIVATE | Modifier.NATIVE | Modifier.STATIC);
    }

    @Override
    protected void setMappingModifiers() {
        mapping.setModifiers(Modifier.PUBLIC);
    }

    @Override
    protected void addMethodAnnotation() {
        addAnnotation(method, BRIDGE_ANN, toParam("symbol", getSelector().getName()), toParam("optional", true));
    }
}
