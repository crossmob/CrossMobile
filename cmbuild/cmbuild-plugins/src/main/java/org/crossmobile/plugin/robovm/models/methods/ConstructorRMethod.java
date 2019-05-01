package org.crossmobile.plugin.robovm.models.methods;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtNewConstructor;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.util.List;

import static org.crossmobile.plugin.bro.JavaTransformer.METHOD_ANN;
import static org.crossmobile.utils.JavassistAnnParam.toParam;
import static org.crossmobile.utils.JavassistUtils.addAnnotation;
import static org.crossmobile.utils.JavassistUtils.makeMethod;

public class ConstructorRMethod extends RMethod {
    public ConstructorRMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        super(selector, returnParam, parameters, object, cclass);
    }

    @Override
    public boolean needsMapping() {
        return true;
    }

    @Override
    public boolean needsReturn() {
        return false;
    }

    @Override
    protected String javaSignature() {
        return getCclass().getSimpleName();
    }

    @Override
    protected String nativeCall() {
        return super.nativeCall() + ")";
    }

    @Override
    protected String nativeSignature() {
        return "initObject(init";
    }

    public void buildNativeMapping() throws CannotCompileException {
        mapping = CtNewConstructor.make(mapMethod(), getCclass());
        setMappingModifiers();
        annotateParams(mapping, getParameters(), true);
        addMappingAnnotation();
        getCclass().addConstructor((CtConstructor) mapping);
    }

    @Override
    protected String mapReturn() {
        return "";
    }

    @Override
    protected void makeNativeMethod() {
        method = makeMethod("init", getReturnParam(), getParameters(), nparam, nreturn, getCclass());
    }

    @Override
    protected void addMappingAnnotation() {
        addAnnotation(mapping, METHOD_ANN, toParam("selector", getSelector().getSignature()));
    }

    @Override
    protected void addMethodAnnotation() {
        addAnnotation(method, METHOD_ANN, toParam("selector", getSelector().getSignature()));
    }


}
