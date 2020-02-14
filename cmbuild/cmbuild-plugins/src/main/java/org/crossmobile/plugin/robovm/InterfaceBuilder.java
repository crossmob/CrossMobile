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
