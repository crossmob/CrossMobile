package org.crossmobile.plugin.robovm;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.crossmobile.plugin.bro.JavaTransformer;
import org.crossmobile.plugin.model.NObject;

import java.io.IOException;

import static org.crossmobile.plugin.bro.JavaTransformer.NSOBJ_OBJ_PROT;

public class InterfaceBuilder extends ClassBuilder {
    InterfaceBuilder(NObject obj) throws ClassNotFoundException, CannotCompileException, NotFoundException, IOException {
        super(obj);
        setCclass(wp.classPool().makeInterface(target.getName(), wp.get(NSOBJ_OBJ_PROT)));
    }
}
