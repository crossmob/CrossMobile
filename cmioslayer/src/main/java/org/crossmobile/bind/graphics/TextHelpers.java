/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.bind.graphics;

import crossmobile.ios.coregraphics.CGFont;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIGraphics;

import java.util.ArrayList;
import java.util.List;

import static crossmobile.ios.coregraphics.GraphicsDrill.context;
import static crossmobile.ios.coregraphics.GraphicsDrill.font;

public class TextHelpers {

    public static List<String> splitWords(String text) {
        List<String> words = new ArrayList<>();
        int from = 0;
        int caret = 0;
        int length = text.length();
        while (caret < length) {
            while (caret < length && text.charAt(caret) == ' ')
                caret++;
            while (caret < length && text.charAt(caret) != ' ')
                caret++;
            words.add(text.substring(from, caret));
            from = caret;
        }
        return words;
    }

    public static TextBlock splitStringWithFontAndSize(String text, CGFont cgfont, double maxwidth, int numlines, int lineBreakMode) {
        List<String> words = splitWords(text);
        if (numlines == 0)
            numlines = Integer.MAX_VALUE;
        else if (numlines == 1) {
            TextBlock textBlock = new TextBlock();
            textBlock.add(text, context(UIGraphics.getCurrentContext()).stringSizeWithFont(text, font(cgfont)));
            return textBlock;
        }

        NativeFont font = font(cgfont);
        TextBlock tb = new TextBlock();
        CGSize csize;
        CGSize lastsize = null;
        String ctext;
        String lasttext;
        int idx = 0;
        GraphicsContext<?> cxt = context(UIGraphics.getCurrentContext());
        while (idx < words.size() && numlines > tb.lines.size()) {
            ctext = "";
            csize = null;
            StringBuilder buffer = new StringBuilder();
            do {
                lasttext = ctext;
                lastsize = csize;
                buffer.append(words.get(idx++));
                ctext = tb.lines.isEmpty() ? trimRight(buffer.toString()) : buffer.toString().trim();  // The first line is allowed to have spaces on the left hand side.
                csize = cxt.stringSizeWithFont(ctext, font);
            } while (maxwidth > csize.getWidth() && idx < words.size());

            if (lasttext.isEmpty()) {
                lasttext = ctext;
                lastsize = csize;
            } else if (maxwidth < csize.getWidth())
                idx--;
            else {
                lasttext = ctext;
                lastsize = csize;
            }
            tb.add(lasttext, lastsize);
        }

        double dots;
        dots = text.equals("") ? 0 : cxt.stringSizeWithFont("...", font).getWidth();
        if (idx < words.size() && lastsize != null)
            if ((lastsize.getWidth() + dots) <= maxwidth)
                tb.addDots("...", dots);
        return tb;
    }

    private static String trimRight(String str) {
        for (int i = str.length() - 1; i >= 0; i--)
            if (str.charAt(i) != ' ')
                return str.substring(0, i + 1);
        return "";
    }

    public static class TextBlock {
        public static final TextBlock EMPTY = new TextBlock();

        public List<TextLine> lines = new ArrayList<>();
        public CGSize size = new CGSize(0, 0);

        private TextBlock() {
        }

        public boolean isEmpty() {
            return lines.isEmpty();
        }

        private void add(String text, CGSize size) {
            lines.add(new TextLine(text, size));
            if (size != null) {
                if (this.size.getWidth() < size.getWidth())
                    this.size.setWidth(size.getWidth());
                this.size.setHeight(this.size.getHeight() + size.getHeight());
            }
        }

        private void addDots(String dots, double size) {
            if (lines.isEmpty())
                return;
            TextLine last = lines.get(lines.size() - 1);
            last.text = last.text + dots;
            last.size.setWidth(last.size.getWidth() + size);
        }
    }

    public static class TextLine {

        public String text;
        public CGSize size;

        public TextLine(String text, CGSize size) {
            this.text = text;
            this.size = size;
        }
    }
}
