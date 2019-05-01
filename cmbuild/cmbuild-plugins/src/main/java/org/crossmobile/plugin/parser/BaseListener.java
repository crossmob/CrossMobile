/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
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
