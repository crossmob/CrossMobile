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
package org.crossmobile.gui.actives;

import com.panayotis.hrgui.HiResTextPane;
import org.crossmobile.gui.elements.Theme;
import org.crossmobile.gui.utils.StreamListener;
import org.crossmobile.gui.utils.StreamManager;
import org.crossmobile.gui.utils.StreamQuality;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.util.EnumMap;
import java.util.Map;

import static org.crossmobile.gui.actives.ActiveTextField.updateTheme;

public class ActiveTextPane extends HiResTextPane implements StreamListener, ThemeChanged {

    private static final SimpleAttributeSet INFOATTR = new SimpleAttributeSet();
    private static final SimpleAttributeSet ERRORATTR = new SimpleAttributeSet();
    private static final SimpleAttributeSet WARNATTR = new SimpleAttributeSet();
    private static final SimpleAttributeSet DEBUGATTR = new SimpleAttributeSet();

    private static final Map<StreamQuality, AttributeSet> ATTRS = new EnumMap<>(StreamQuality.class);

    static {
        ATTRS.put(StreamQuality.INFO, INFOATTR);
        ATTRS.put(StreamQuality.ERROR, ERRORATTR);
        ATTRS.put(StreamQuality.WARNING, WARNATTR);
        ATTRS.put(StreamQuality.DEBUG, DEBUGATTR);
        updateAttributes();
    }

    private static void updateAttributes() {
        StyleConstants.setForeground(INFOATTR, Theme.current().textInfo);
        StyleConstants.setForeground(ERRORATTR, Theme.current().textError);
        StyleConstants.setForeground(WARNATTR, Theme.current().textWarning);
        StyleConstants.setForeground(DEBUGATTR, Theme.current().textWarning);
    }

    private StreamManager sman;
    private final TooltipManager ttm = new TooltipManager(this);

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public ActiveTextPane() {
        setOpaque(true);
        ThemeNotifier.register(this);
        themeChanged(Theme.current() == Theme.dark());
    }

    @Override
    public void setToolTipText(String text) {
        ttm.setToolTipText(text);
    }

    public void setToolTip(JToolTip toolTip) {
        ttm.setToolTip(toolTip);
    }

    public StreamManager getStreamManager() {
        if (sman == null) {
            sman = new StreamManager();
            sman.addListener(this);
        }
        return sman;
    }

    public void setText(CharSequence text, StreamQuality quality) {
        setText("");
        appendText(text, ATTRS.get(quality));
    }

    @Override
    public void addLine(CharSequence line, StreamQuality quality) {
        appendText(line + "\n", ATTRS.get(quality));
    }

    public void addChar(Character c, StreamQuality quality) {
        if (c != null)
            appendText(c.toString(), ATTRS.get(quality));
    }

    @Override
    public void themeChanged(boolean dark) {
        updateAttributes();
        updateTheme(this, dark);
        getStyledDocument().setCharacterAttributes(0, getDocument().getLength(), INFOATTR, true);
    }
}
