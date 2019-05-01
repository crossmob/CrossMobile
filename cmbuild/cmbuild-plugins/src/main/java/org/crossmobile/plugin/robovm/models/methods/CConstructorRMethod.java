package org.crossmobile.plugin.robovm.models.methods;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtNewConstructor;
import javassist.Modifier;
import org.crossmobile.plugin.model.NObject;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.robovm.models.parameters.RParam;

import java.util.List;

public class CConstructorRMethod extends RMethod {
    public CConstructorRMethod(NSelector selector, RParam returnParam, List<RParam> parameters, NObject object, CtClass cclass) {
        super(selector, returnParam, parameters, object, cclass);
    }

    @Override
    public boolean needsReturn() {
        return false;
    }

    @Override
    protected void makeNativeMethod() {
    }

    @Override
    public boolean needsMapping() {
        return true;
    }

    @Override
    protected String mapSignature() {
        return super.mapSignature();
    }

    @Override
    protected String nativeCall() {
        return "";
    }

    @Override
    protected String javaSignature() {
        return getCclass().getSimpleName();
    }

    @Override
    protected String mapReturn() {
        return "";
    }

    public void buildNativeMapping() throws CannotCompileException {
        mapping = CtNewConstructor.make(mapMethod(), getCclass());
        setMappingModifiers();
        annotateParams(mapping, getParameters(), true);
        addMappingAnnotation();
        getCclass().addConstructor((CtConstructor) mapping);
    }

    protected void setMappingModifiers() {
        mapping.setModifiers(Modifier.PUBLIC);
    }
}
