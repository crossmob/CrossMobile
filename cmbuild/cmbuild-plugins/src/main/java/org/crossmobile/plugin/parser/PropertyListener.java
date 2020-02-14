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
import org.crossmobile.plugin.model.NProperty;
import org.crossmobile.plugin.parser.antlr.CMAnnotParser;
import org.crossmobile.plugin.utils.Factories;

class PropertyListener extends BaseListener<NProperty> {

    public PropertyListener() {
        super(new NProperty());
    }

    @Override
    ParseTree getTree(CMAnnotParser parser) {
        return parser.property();
    }

    @Override
    public void exitPropertydef(CMAnnotParser.PropertydefContext ctx) {
        if (ctx.strong != null)
            data.setWeak(false);
        if (ctx.weak != null)
            data.setWeak(true);
        if (ctx.copy != null)
            data.setCopy(true);
        if (ctx.readonly != null)
            data.setReadonly(true);
        if (ctx.getter != null)
            data.setGetter(ctx.getter.getText());
    }

    @Override
    public void exitProperty(CMAnnotParser.PropertyContext ctx) {
        data.setType(Factories.getType(ctx.variable().vartype()));
        data.setName(ctx.variable().ID().getText());
        data.setObjcBased(ctx.objc != null);
        found();
    }

    @Override
    public void setOriginalCode(String code) {
        data.setOriginalCode(code);
    }

}
