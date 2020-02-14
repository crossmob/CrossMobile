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

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.crossmobile.plugin.model.NParam;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.model.VarargType;
import org.crossmobile.plugin.parser.antlr.CMAnnotParser;
import org.crossmobile.plugin.utils.Factories;

class SelectorListener extends BaseListener<NSelector> {

    public SelectorListener() {
        super(new NSelector());
    }

    @Override
    ParseTree getTree(CMAnnotParser parser) throws RecognitionException {
        return parser.selector();
    }

    @Override
    public void exitReturntype(CMAnnotParser.ReturntypeContext ctx) {
        data.setStatic("+".equals(ctx.isstatic.getText()));
        data.setReturnType(Factories.getType(ctx.vartype()));
    }

    @Override
    public void exitSelector(CMAnnotParser.SelectorContext ctx) {
        data.setName(ctx.retain == null ? ctx.name.getText() : ctx.retain.getText());
        CMAnnotParser.SelectorParamContext sp = ctx.selectorParam();
        boolean varargs = ctx.varargs != null;
        int namedParams = ctx.selectorNamedParam().size();
        if (sp != null)
            data.addParam(Factories.getParam(sp, varargs && namedParams == 0 ? VarargType.OBJC : null, false));
        for (int i = 0; i < namedParams; i++) {
            CMAnnotParser.SelectorNamedParamContext npc = ctx.selectorNamedParam(i);
            NParam param = Factories.getParam(npc.selectorparam, varargs && i == (namedParams - 1) ? VarargType.OBJC : null, false);
            if (npc.paramname != null)
                param.setName(npc.paramname.getText());
            data.addParam(param);
        }
        found();
    }

    @Override
    public void setOriginalCode(String code) {
        data.setOriginalCode(code);
    }

}
