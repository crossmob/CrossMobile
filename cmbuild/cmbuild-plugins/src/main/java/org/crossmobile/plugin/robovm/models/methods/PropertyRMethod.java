package org.crossmobile.plugin.robovm.models.methods;

import javassist.CtClass;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.util.List;

import static org.crossmobile.plugin.bro.JavaTransformer.PROPERTY_ANN;
import static org.crossmobile.utils.JavassistAnnParam.toParam;
import static org.crossmobile.utils.JavassistUtils.addAnnotation;

public class PropertyRMethod extends SelectorRMethod {
    public PropertyRMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        super(selector, returnParam, parameters, object, cclass);
    }

    @Override
    protected void addMethodAnnotation() {
        addAnnotation(method, PROPERTY_ANN, toParam("selector", getSelector().getSignature()));
    }
}
