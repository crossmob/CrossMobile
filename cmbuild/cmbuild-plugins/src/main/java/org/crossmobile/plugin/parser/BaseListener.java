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
import org.crossmobile.plugin.parser.antlr.CMAnnotBaseListener;
import org.crossmobile.plugin.parser.antlr.CMAnnotParser;

abstract class BaseListener<T> extends CMAnnotBaseListener {

    public T data;
    private boolean found = false;

    public BaseListener(T data) {
        this.data = data;
    }

    public void found() {
        this.found = true;
    }

    public T foundData() {
        return found ? data : null;
    }

    abstract ParseTree getTree(CMAnnotParser parser);

    abstract void setOriginalCode(String code);

}
