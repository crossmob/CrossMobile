package org.crossmobile.plugin.robovm;

import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.crossmobile.plugin.model.NObject;

import java.io.IOException;

import static org.crossmobile.plugin.bro.JavaTransformer.STRUCT;

public class StructBuilder extends CObjectBuilder {
    protected StructBuilder(NObject obj) throws IOException, CannotCompileException, NotFoundException, ClassNotFoundException {
        super(obj);
        getCclass().setSuperclass(wp.get(STRUCT));
    }
}
