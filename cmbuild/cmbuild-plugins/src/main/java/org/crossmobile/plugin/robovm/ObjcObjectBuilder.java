/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the CrossMobile Community License as published
 * by the CrossMobile team.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * CrossMobile Community License for more details.
 *
 * You should have received a copy of the CrossMobile Community
 * License along with CrossMobile; if not, please contact the
 * CrossMobile team at https://crossmobile.tech/contact/
 */
package org.crossmobile.plugin.robovm;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.NotFoundException;
import org.crossmobile.plugin.model.NObject;

import java.io.IOException;

import static org.crossmobile.plugin.bro.JavaTransformer.NSOBJ_OBJ;
import static org.crossmobile.plugin.bro.JavaTransformer.OBJC_RUNTIME;

public class ObjcObjectBuilder extends ObjectBuilder {
    protected ObjcObjectBuilder(NObject obj) throws IOException, CannotCompileException, NotFoundException, ClassNotFoundException {
        super(obj);
        addObjcRuntimeBind(getCclass());
        addNSObjectCostructors(getCclass());
    }


    private void addObjcRuntimeBind(CtClass cclass) throws CannotCompileException {
        CtConstructor classInitializer = cclass.makeClassInitializer();
        classInitializer.setBody(OBJC_RUNTIME + ".bind(" + cclass.getName() + ".class);");
    }


    /**
     * Adds skipinit and Handle constructors
     *
     * @param cclass
     * @throws CannotCompileException
     */
    private void addNSObjectCostructors(CtClass cclass) throws CannotCompileException {
        // SkipInit Cnstructor
        CtConstructor skipInitC = new CtConstructor(skipInitP, cclass);
        skipInitC.setBody("super(("+NSOBJ_OBJ+"$SkipInit)$1);");
        cclass.addConstructor(skipInitC);

        // Handle constructors
        CtConstructor handleC = new CtConstructor(handleP, cclass);
        handleC.setBody("super($$);");
        cclass.addConstructor(handleC);

    }
}
