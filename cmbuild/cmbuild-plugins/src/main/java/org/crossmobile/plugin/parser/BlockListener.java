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
package org.crossmobile.plugin.parser;

import org.antlr.v4.runtime.tree.ParseTree;
import org.crossmobile.plugin.model.MethodType;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.NType;
import org.crossmobile.plugin.parser.antlr.CMAnnotParser;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import static org.crossmobile.plugin.parser.AnnotationParser.getText;
import static org.crossmobile.plugin.utils.Factories.getParam;
import static org.crossmobile.plugin.utils.Factories.getType;
import static org.crossmobile.utils.CollectionUtils.tail;
import static org.crossmobile.utils.ReflectionUtils.getLambdaMethod;

public class BlockListener extends BaseListener<NSelector> {

    public BlockListener() {
        super(new NSelector());
    }

    @Override
    ParseTree getTree(CMAnnotParser parser) {
        return parser.block();
    }

    @Override
    public void setOriginalCode(String code) {
        data.setOriginalCode(code);
    }

    @Override
    public void exitBlock(CMAnnotParser.BlockContext ctx) {
        parse(data, ctx, null);
        found();
    }

    /**
     * Parse a block argument
     *
     * @param sel the current selector to store the result
     * @param ctx the antlr4 context
     * @param nt  if NType is provided, then this means that it is run on the fly
     *            from an outer source
     */
    public static void parse(NSelector sel, CMAnnotParser.BlockContext ctx, NType nt) {
        sel.setReturnType(getType(ctx.simple_vartype_name(0).simple_vartype()));
        sel.setName(ctx.ID() == null ? "" : ctx.ID().getText());
        sel.setStatic(false);
        sel.setMethodType(MethodType.BLOCK);
        for (CMAnnotParser.Simple_vartype_nameContext param : tail(ctx.simple_vartype_name()))
            sel.addParam(getParam(param));
        if (nt != null) {
            sel.setOriginalCode(getText(ctx));
            Method m = getLambdaMethod(nt.getType());
            sel.setJavaExecutable(m, m.getReturnType());
            Parameter[] params = m.getParameters();
            for (int i = 0; i < params.length; i++)
                sel.getParams().get(i).setJavaParameter(params[i]);
        }
    }
}
