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
package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSLineBreakMode;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.TextHelpers.TextBlock;
import org.crossmobile.bind.graphics.TextHelpers.TextLine;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bind.system.SystemUtilities;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import static crossmobile.ios.coregraphics.$coregraphics.color;
import static crossmobile.ios.coregraphics.$coregraphics.context;
import static org.crossmobile.bind.graphics.TextHelpers.splitStringWithFontAndSize;

/**
 * UILabel class defines a specialized view that is used to display read-only
 * text.
 */
@CMClass
public class UILabel extends UIView {

    /*
     * Due to a shortcut for various labels, these properties are marked
     * "friendly"
     */
    private UIColor textColor = null;
    private UIColor shadowColor = null;
    /*
     * Regular private properties
     */
    private String text = null;
    private TextBlock blocks = null;
    private UIFont fontOrig = Theme.Label.FONT;
    private UIFont fontDraw = fontOrig;
    private CGSize shadowOffset = null;
    private int textAlignment = UITextAlignment.Left;
    private boolean adjustsFontSizeToFitWidth = false;
    private int lineBreakMode = NSLineBreakMode.ByTruncatingTail;
    private int numberOfLines = 1;
    private boolean highlighted = false;
    private UIColor highlightedTextColor = null;
    private double minimumScaleFactor = 0;
    private double preferredMaxLayoutWidth = 0;
    private int baselineAdjustment = UIBaselineAdjustment.AlignBaselines;
    private double firstbaseline;
    private double lastbaseline;

    private UIView viewForFirstBaselineLayout;
    private UIView viewForLastBaselineLayout;

    /**
     * Constructs a default UILabel object located at (0,0) with 0 weight and 0
     * height.
     */
    public UILabel() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UILabel object using the specified rectangle.
     *
     * @param frame The rectangle in which to draw the text
     */
    @SuppressWarnings("OverridableMethodCallInConstructor")
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UILabel(CGRect frame) {
        super(frame);
        setUserInteractionEnabled(false);
        setContentMode(UIViewContentMode.Left);
        setClipsToBounds(true);
    }

    @Override
    public void setFrame(CGRect frame) {
        if (SystemUtilities.equals(frame, this.frame()))
            return;
        super.setFrame(frame);
        recalculateIntrinsicSize();
    }

    /**
     * Sets the text to be displayed on the label.
     *
     * @param text The text to be displayed on the label.
     */
    @CMSetter("@property(nonatomic, copy) NSString *text;")
    public void setText(String text) {
        if (SystemUtilities.equals(text, this.text))
            return;
        this.text = text;
        recalculateIntrinsicSize();
    }

    /**
     * Returns the text that is displayed on the label.
     *
     * @return The text displayed on the label.
     */
    @CMGetter("@property(nonatomic, copy) NSString *text;")
    public String text() {
        return text;
    }

    /**
     * Sets the font of the label's text.
     *
     * @param font The font of the label's text.
     */
    @CMSetter("@property(nonatomic, strong) UIFont *font;")
    public void setFont(UIFont font) {
        if (SystemUtilities.equals(font, this.fontOrig))
            return;
        this.fontOrig = font == null ? Theme.Label.FONT : font;
        recalculateIntrinsicSize();
    }

    /**
     * Returns the font of the label's text.
     *
     * @return The font of the label's text.
     */
    @CMGetter("@property(nonatomic, strong) UIFont *font;")
    public UIFont font() {
        return fontOrig;
    }

    /**
     * Sets the color of the label's text.
     *
     * @param color The color of the label's text.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *textColor;")
    public void setTextColor(UIColor color) {
        if (color == null)
            textColor = null;
        else if (textColor == null)
            textColor = color;
        else
            textColor = color;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns the color of the label's text.
     *
     * @return The color of the label's text.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *textColor;")
    public UIColor textColor() {
        return textColor;
    }

    /**
     * Sets a Boolean that shows whether this label should be highlighted.
     *
     * @param highlighted A Boolean that shows whether this label should be
     *                    highlighted.
     */
    @CMSetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;")
    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns a Boolean that shows whether this label is highlighted.
     *
     * @return A Boolean that shows whether this label is highlighted.
     */
    @CMGetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;")
    public boolean isHighlighted() {
        return highlighted;
    }

    /**
     * Sets the highlight color of label's text.
     *
     * @param highlightedTextColor The highlight color of label's text.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *highlightedTextColor;")
    public void setHighlightedTextColor(UIColor highlightedTextColor) {
        this.highlightedTextColor = highlightedTextColor;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns the highlight color of label's text.
     *
     * @return The highlight color of label's text.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *highlightedTextColor;")
    public UIColor highlightedTextColor() {
        return highlightedTextColor;
    }

    /**
     * Sets the alignment technique for the text of the label.
     *
     * @param NSTextAlignment The alignment technique for the text of the label.
     * @see crossmobile.ios.uikit.NSTextAlignment
     */
    @CMSetter("@property(nonatomic) NSTextAlignment textAlignment;")
    public void setTextAlignment(int NSTextAlignment) {
        if (this.textAlignment != NSTextAlignment) {
            this.textAlignment = NSTextAlignment;
            Native.graphics().refreshDisplay();
        }
    }

    /**
     * Returns the alignment technique for the text of the label.
     *
     * @return The alignment technique for the text of the label.
     */
    @CMGetter("@property(nonatomic) NSTextAlignment textAlignment;")
    public int textAlignment() {
        return textAlignment;
    }

    /**
     * Sets technique to use in order to wrap and shorten the text of the label.
     *
     * @param NSLineBreakMode The technique to use in order to wrap and shorten
     *                        the text of the label.
     */
    @CMSetter("@property(nonatomic) NSLineBreakMode lineBreakMode;")
    public void setLineBreakMode(int NSLineBreakMode) {
        if (this.lineBreakMode != NSLineBreakMode) {
            this.lineBreakMode = NSLineBreakMode;
            recalculateIntrinsicSize();
        }
    }

    /**
     * Returns the technique that is used to wrap and shorten the text of the
     * label.
     *
     * @return The technique that is used to wrap and shorten the text of the
     * label.
     */
    @CMGetter("@property(nonatomic) NSLineBreakMode lineBreakMode;")
    public int lineBreakMode() {
        return lineBreakMode;
    }

    /**
     * Sets the maximum number of lines for rendering the text.
     *
     * @param numberOfLines The maximum number of lines for rendering the text.
     */
    @CMSetter("@property(nonatomic) NSInteger numberOfLines;")
    public void setNumberOfLines(int numberOfLines) {
        if (this.numberOfLines != numberOfLines) {
            this.numberOfLines = numberOfLines;
            recalculateIntrinsicSize();
        }
    }

    /**
     * Returns the maximum number of lines for rendering the text.
     *
     * @return The maximum number of lines for rendering the text.
     */
    @CMGetter("@property(nonatomic) NSInteger numberOfLines;")
    public int numberOfLines() {
        return numberOfLines;
    }

    /**
     * Sets the shadow offset for the label's text expressed in points.
     *
     * @param shadowOffset The shadow offset for the label's text expressed in
     *                     points.
     */
    @CMSetter("@property(nonatomic) CGSize shadowOffset;")
    public void setShadowOffset(CGSize shadowOffset) {
        this.shadowOffset = shadowOffset;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns the shadow offset of the label's text expressed in points.
     *
     * @return The shadow offset of the label's text expressed in points.
     */
    @CMGetter("@property(nonatomic) CGSize shadowOffset;")
    public CGSize shadowOffset() {
        return shadowOffset;
    }

    /**
     * Sets the shadow color of the text into the label.
     *
     * @param shadowColor The shadow color of the text into the label.
     */
    @CMSetter("@property(nonatomic, strong) UIColor *shadowColor;")
    public void setShadowColor(UIColor shadowColor) {
        this.shadowColor = shadowColor;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns the shadow color of the text into the label.
     *
     * @return The shadow color of the text into the label.
     */
    @CMGetter("@property(nonatomic, strong) UIColor *shadowColor;")
    public UIColor shadowColor() {
        return shadowColor;
    }

    /**
     * Sets the minimum scale factor of label.
     *
     * @param minimumScaleFactor The minimum scale factor of label.
     */
    @CMSetter("@property(nonatomic) CGFloat minimumScaleFactor;")
    public void setMinimumScaleFactor(double minimumScaleFactor) {
        this.minimumScaleFactor = minimumScaleFactor;
    }

    /**
     * Returns the minimum scale factor of label.
     *
     * @return The minimum scale factor of label.
     */
    @CMGetter("@property(nonatomic) CGFloat minimumScaleFactor;")
    public double minimumScaleFactor() {
        return minimumScaleFactor;
    }

    /**
     * Sets the maximum width of a label with multiple lines. Expressed in
     * points.
     *
     * @param preferredMaxLayoutWidth The maximum width of a label with multiple
     *                                lines.
     */
    @CMSetter("@property(nonatomic) CGFloat preferredMaxLayoutWidth;")
    public void setPreferredMaxLayoutWidth(double preferredMaxLayoutWidth) {
        this.preferredMaxLayoutWidth = preferredMaxLayoutWidth;
    }

    /**
     * Returns the maximum width of a label with multiple lines.Expressed in
     * points.
     *
     * @return The maximum width of a label with multiple lines.
     */
    @CMGetter("@property(nonatomic) CGFloat preferredMaxLayoutWidth;")
    public double preferredMaxLayoutWidth() {
        return preferredMaxLayoutWidth;
    }

    /**
     * Sets a value that defines how baselines are adjusted when text size
     * changes
     *
     * @param baselineAdjustment A value that defines how baselines are adjusted
     *                           when text size changes
     */
    @CMSetter("@property(nonatomic) UIBaselineAdjustment baselineAdjustment;")
    public void setBaselineAdjustment(int baselineAdjustment) {
        this.baselineAdjustment = baselineAdjustment;
    }

    /**
     * Returns a number that shows how baselines are adjusted when text size
     * changes to fit the label.
     *
     * @return A number that shows how baselines are adjusted when text size
     * changes to fit the label.
     */
    @CMGetter("@property(nonatomic) UIBaselineAdjustment baselineAdjustment;")
    public int baselineAdjustment() {
        return baselineAdjustment;
    }

    /**
     * Sets a Boolean that defines whether the font size of the title should
     * adjust to label's size.
     *
     * @param adjustsFontSizeToFitWidth A Boolean that defines whether the font
     *                                  size of the title should adjust to label's size.
     */
    @CMSetter("@property(nonatomic) BOOL adjustsFontSizeToFitWidth;")
    public void setAdjustsFontSizeToFitWidth(boolean adjustsFontSizeToFitWidth) {
        this.adjustsFontSizeToFitWidth = adjustsFontSizeToFitWidth;
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns a Boolean that shows whether the font size of the title is
     * adjusted to label's size.
     *
     * @return A Boolean that shows whether the font size of the title is
     * adjusted to label's size.
     */
    @CMGetter("@property(nonatomic) BOOL adjustsFontSizeToFitWidth;")
    public boolean adjustsFontSizeToFitWidth() {
        return adjustsFontSizeToFitWidth;
    }

    @Override
    public final void drawRect(CGRect rect) {
        if (blocks == null)
            return;

        CGContext cx = UIGraphics.getCurrentContext();
        GraphicsContext gcx = context(cx);
        gcx.setFont(crossmobile.ios.coregraphics.$coregraphics.font(fontDraw.cgfont));

        int actualTextAlignment = textAlignment;
        if (textAlignment == NSTextAlignment.Natural)
            actualTextAlignment = Native.system().isRTL() ? NSTextAlignment.Right : NSTextAlignment.Left;

        double y = rect.getOrigin().getY() + (rect.getSize().getHeight() - blocks.size.getHeight()) / 2;
        for (TextLine tl : blocks.lines) {
            double x = rect.getOrigin().getX()
                    + (actualTextAlignment == UITextAlignment.Left ? 0
                    : (actualTextAlignment == UITextAlignment.Center ? (getWidth() - tl.size.getWidth()) / 2
                    : getWidth() - tl.size.getWidth()));

            if (shadowOffset != null && (shadowOffset.getWidth() != 0 || shadowOffset.getHeight() != 0)) {
                gcx.setFillColorWithColor(color(shadowColor == null ? Theme.Color.SHADOW.cgcolor : shadowColor.cgcolor));
                cx.showTextAtPoint(x + shadowOffset.getWidth(), y + shadowOffset.getHeight(), tl.text);
            }
            int c = color((highlighted && highlightedTextColor != null)
                    ? highlightedTextColor.cgcolor
                    : (textColor == null ? Theme.Color.FORE.cgcolor : textColor.cgcolor));
            gcx.setFillColorWithColor(c);
            cx.showTextAtPoint(x, y, tl.text);

            y += tl.size.getHeight();
        }
    }

    private void recalculateIntrinsicSize() {
        UIFont font = fontOrig;
        CGSize size;
        if (text == null || text.isEmpty()) {
            blocks = null;
            size = new CGSize(0, 0);
        } else {
            if (numberOfLines == 1) {
                blocks = splitStringWithFontAndSize(text, fontOrig.cgfont, Double.MAX_VALUE, 1, lineBreakMode);
                if (adjustsFontSizeToFitWidth && blocks.size.getWidth() > getWidth()) {
                    blocks = splitStringWithFontAndSize(text, font.cgfont, Double.MAX_VALUE, 1, lineBreakMode);
                    font = fontOrig.fontWithSize(fontOrig.pointSize() * (getWidth() / intrinsicContentSize.getWidth()));
                }
                size = blocks.size;
            } else {
                blocks = splitStringWithFontAndSize(text, fontDraw.cgfont, getWidth(), numberOfLines, lineBreakMode);
                size = blocks.size;
            }
        }
        setIntrinsicContentSize(size.getWidth(), size.getHeight());
        fontDraw = font;
        Native.graphics().refreshDisplay();
    }
}
