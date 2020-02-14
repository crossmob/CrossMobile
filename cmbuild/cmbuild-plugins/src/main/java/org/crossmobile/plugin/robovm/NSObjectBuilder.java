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
import org.crossmobile.plugin.reg.ObjectRegistry;

import java.io.IOException;

import static org.crossmobile.plugin.bro.JavaTransformer.NSOBJ_OBJ;
import static org.crossmobile.plugin.bro.JavaTransformer.OBJC_RUNTIME;

public class NSObjectBuilder extends ObjectBuilder {
    NSObjectBuilder() throws NotFoundException, CannotCompileException, IOException, ClassNotFoundException {
        super(ObjectRegistry.retrieve(ObjectRegistry.getNSObject()));
        //these should be reenabled when we migrate to our own NSOBject
//        {
//            // Sanitize root objects
//            skipInitP = new CtClass[]{wp.classPool().makeClass("crossmobile.ios.foundation.NSObject$SkipInit")};
//            handleP = new CtClass[]{wp.classPool().makeClass("crossmobile.ios.foundation.NSObject$Handle"), CtClass.longType};
//
//            CtConstructor skipInitC = new CtConstructor(skipInitP, getCclass());
//            skipInitC.setBody(null);
//            getCclass().addConstructor(skipInitC);
//
//            CtConstructor handleC = new CtConstructor(handleP, getCclass());
//            handleC.setBody("super($2);");
//            getCclass().addConstructor(handleC);
//
//        }
        addNSObjectCostructors(getCclass());
        addObjcRuntimeBind();
    }

    private void addObjcRuntimeBind() throws CannotCompileException {
        CtConstructor classInitializer = getCclass().makeClassInitializer();
        classInitializer.setBody(OBJC_RUNTIME + ".bind(" + getCclass().getName() + ".class);");
    }

    @Override
    void createClass() {
        setCclass(wp.classPool().makeClass(target.getName(), wp.get(NSOBJ_OBJ)));
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
