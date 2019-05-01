package org.crossmobile.plugin.robovm;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.NotFoundException;
import org.crossmobile.plugin.model.NObject;

import java.io.IOException;

import static org.crossmobile.plugin.bro.JavaTransformer.RT_BRO;

public class CObjectBuilder extends ObjectBuilder {
    protected CObjectBuilder(NObject obj) throws IOException, CannotCompileException, NotFoundException, ClassNotFoundException {
        super(obj);
        addBroBind(getCclass());
    }

    private void addBroBind(CtClass cclass) throws CannotCompileException {
        CtConstructor classInitializer = cclass.makeClassInitializer();
        classInitializer.setBody(RT_BRO + ".bind(" + cclass.getName() + ".class);");
    }
}
