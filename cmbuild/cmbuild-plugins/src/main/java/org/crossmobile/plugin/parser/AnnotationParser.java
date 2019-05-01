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

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.crossmobile.plugin.model.NProperty;
import org.crossmobile.plugin.model.NSelector;
import org.crossmobile.plugin.parser.antlr.CMAnnotLexer;
import org.crossmobile.plugin.parser.antlr.CMAnnotParser;

import java.io.StringReader;
import java.util.regex.Pattern;

public class AnnotationParser {

    private static final Pattern pattern = Pattern.compile("\\s+");

    AnnotationParser() {
    }

    public static NSelector parseSelector(String signature) {
        return parse(signature, new SelectorListener());
    }

    public static NProperty parseProperty(String signature) {
        return parse(signature, new PropertyListener());
    }

    public static NSelector parseFunction(String signature) {
        return parse(signature, new FunctionListener());
    }

    public static NSelector parseBlock(String signature) {
        return parse(signature, new BlockListener());
    }

    @SuppressWarnings("UseSpecificCatch")
    static <T> T parse(String signature, BaseListener<T> listener) {
        if (!signature.trim().endsWith(";"))
            signature += ";";
        signature = pattern.matcher(signature).replaceAll(" ");
        listener.setOriginalCode(signature);
        try {
            ANTLRInputStream input = new ANTLRInputStream(new StringReader(signature));
            CMAnnotLexer lexer = new CMAnnotLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CMAnnotParser parser = new CMAnnotParser(tokens);
            ParseTree tree = listener.getTree(parser);
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);
        } catch (Exception ex) {
            return null;
        }
        return listener.foundData();
    }

    public static String getText(ParserRuleContext ctx) {
        return ctx.start.getInputStream().getText(new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex()));
    }

}
