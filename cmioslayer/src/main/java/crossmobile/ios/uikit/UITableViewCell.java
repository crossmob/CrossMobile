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
import crossmobile.ios.foundation.NSIndexPath;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.Set;

import static crossmobile.ios.coregraphics.$coregraphics.context;

/**
 * UITableViewCell class defines objects that represent cell elements used in
 * table views.
 */
@CMClass
public class UITableViewCell extends UIView {

    final String reuseIdentifier;
    private final ContentView contentV;
    NSIndexPath path = null;
    private boolean selected = false;
    private boolean highlighted = false;
    private UIColor definedContentBackground;
    private UIView unselectedBV;
    private UIView selectedBV;
    private UIView accessoryV;
    private UILabel textlabel;
    private UILabel detailedtextlabel;
    private UIButton editB;
    private int selectionStyle = UITableViewCellSelectionStyle.Gray;
    private int editingStyle = UITableViewCellEditingStyle.Delete;
    private int accessorytype = UITableViewCellAccessoryType.None;
    private boolean isEditing = false;
    private UIImageView imageView = null;
    private float rowHeight = -1;


    private UIStoryboardSegue _selectionSegue;
    private UIStoryboardSegue _accessoryActionSegue;

    /**
     * Constructs a cell with the specified style and reuse identifier parameter
     * to use if the cell will be reused for multiple rows.
     *
     * @param UITableViewCellStyle The style of the cell.
     * @param reuseIdentifier      Used if the cell will be reused for multiple
     *                             rows.NULL if it will not be reused.
     * @see crossmobile.ios.uikit.UITableViewCellStyle
     */
    @CMConstructor("- (instancetype)initWithStyle:(UITableViewCellStyle)style \n"
            + "              reuseIdentifier:(NSString *)reuseIdentifier;")
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public UITableViewCell(int UITableViewCellStyle, String reuseIdentifier) {
        contentV = new ContentView();
        addSubview(contentV);
        setBackgroundColor(UIColor.whiteColor);
        this.reuseIdentifier = reuseIdentifier;
        setFrame(new CGRect(0, 0, 320, 44));
        setAutoresizesSubviews(false);
    }

    @Override
    public void layoutSubviews() {
        if (contentV != null) { // Only when the object is fully initialized
            CGRect innerframe = frame(); // create a new instance of CGFrame to play with it
            innerframe.getOrigin().setX(isEditing ? Theme.Cell.EDIT_EDGE * 2 + editButtonSize().getWidth() : 0);

            if (imageView != null && imageView.image() != null) {
                imageView.setFrame(new CGRect(innerframe.getOrigin().getX(), 0, imageView.image().size().getWidth() + 2, this.getHeight()));
                innerframe.getOrigin().setX(imageView.image().size().getWidth());
            }

            innerframe.getOrigin().setY(0);
            contentV.setFrame(innerframe);

            innerframe.getOrigin().setX(0);    // Editing offset has been performed already
            if (unselectedBV != null)
                unselectedBV.setFrame(innerframe);
            if (selectedBV != null)
                selectedBV.setFrame(innerframe);

            if (textlabel != null) {
                innerframe.getOrigin().setX(Theme.Cell.TEXT_INSET_X);
                innerframe.getSize().setWidth(innerframe.getSize().getWidth() - (Theme.Cell.TEXT_INSET_X * 2));
                textlabel.setFrame(innerframe);
            }
        }
    }

    /**
     * Returns the style of the cell.
     *
     * @return The style of the cell.
     * @see crossmobile.ios.uikit.UITableViewCellEditingStyle
     */
    @CMGetter("@property(nonatomic, readonly) UITableViewCellEditingStyle editingStyle;")
    public int editingStyle() {
        return UITableViewCellEditingStyle.None;
    }

    /**
     * Returns a Boolean that shows whether the cell is selected.
     *
     * @return A Boolean that shows whether the cell is selected.
     */
    @CMGetter("@property(nonatomic, getter=isSelected) BOOL selected;")
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets a Boolean that defines whether the cell is selected.
     *
     * @param sel A Boolean that defines whether the cell is selected.
     */
    @CMSetter("@property(nonatomic, getter=isSelected) BOOL selected;")
    public void setSelected(boolean sel) {
        selected = sel;
        setHighlighted(selected);
    }

    private void updateSelectionColors() {
        UIColor background = definedContentBackground;
        UIColor highlighted = null;
        if (this.highlighted && unselectedBV == null && selectedBV == null) {
            switch (selectionStyle) {
                case UITableViewCellSelectionStyle.Default:
                case UITableViewCellSelectionStyle.Gray:
                    background = Theme.Cell.SELECTED_GRAY;
                    highlighted = UIColor.whiteColor;
                    break;
                case UITableViewCellSelectionStyle.Blue:
                    background = Theme.Cell.SELECTED_BLUE;
                    highlighted = UIColor.whiteColor;
                    break;
                default:
                case UITableViewCellSelectionStyle.None:
                    break;
            }
        }
        contentV.setBackgroundColor(background, false);
        if (textlabel != null)
            textlabel.setHighlightedTextColor(highlighted);
        if (detailedtextlabel != null)
            detailedtextlabel.setHighlightedTextColor(highlighted);
        Native.graphics().refreshDisplay();
    }

    /**
     * Returns a Boolean that shows whether the cell is highlighted.
     *
     * @return A Boolean that shows whether the cell is highlighted.
     */
    @CMGetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;")
    public boolean isHighlighted() {
        return highlighted;
    }

    /**
     * Sets a Boolean that defines whether the cell is highlighted.
     *
     * @param highlighted A Boolean that defines whether the cell is
     *                    highlighted.
     */
    @CMSetter("@property(nonatomic, getter=isHighlighted) BOOL highlighted;")
    public void setHighlighted(boolean highlighted) {
        if (this.highlighted == highlighted)
            return;
        this.highlighted = highlighted;
        if (textlabel != null)
            textlabel.setHighlighted(highlighted);
        updateSelectionColors();
    }

    private void updatebackgroundViews() {
        if (selected)
            if (selectedBV == null) {
                if (unselectedBV != null)
                    unselectedBV.setHidden(false);
            } else {
                if (unselectedBV != null)
                    unselectedBV.setHidden(true);
                selectedBV.setHidden(false);
            }
        else {
            if (unselectedBV != null)
                unselectedBV.setHidden(false);
            if (selectedBV != null)
                selectedBV.setHidden(true);
        }
    }

    /**
     * Sets the background view of the cell.
     *
     * @param backgroundView The background view of the cell.
     */
    @CMSetter("@property(nonatomic, strong) UIView *backgroundView;")
    public void setBackgroundView(UIView backgroundView) {
        if (backgroundView == unselectedBV)
            return;

        // Remove old
        if (unselectedBV != null) {
            unselectedBV.removeFromSuperview();
            unselectedBV = null;
        }

        // Add new
        if (backgroundView != null) {
            backgroundView.setContentMode(UIViewContentMode.ScaleToFill);
            unselectedBV = backgroundView;
            insertSubview(unselectedBV, 0);
            CGSize size = frame().getSize();
            unselectedBV.setSize(size.getWidth(), size.getHeight());
            updatebackgroundViews();
        }
        updateSelectionColors();
    }

    /**
     * Returns the background view of the cell.
     *
     * @return The background view of the cell.
     */
    @CMGetter("@property(nonatomic, strong) UIView *backgroundView;")
    public UIView backgroundView() {
        return unselectedBV;
    }

    /**
     * Sets the background of the selected cell.
     *
     * @param selectedBackgroundView The background of the selected cell.
     */
    @CMSetter("@property(nonatomic, strong) UIView *selectedBackgroundView;")
    public void setSelectedBackgroundView(UIView selectedBackgroundView) {
        if (selectedBackgroundView == selectedBV)
            return;

        // Remove old
        if (selectedBV != null) {
            selectedBV.removeFromSuperview();
            selectedBV = null;
        }

        // Add new
        if (selectedBackgroundView != null) {
            selectedBV = selectedBackgroundView;
            insertSubview(selectedBV, 0);
            CGSize size = frame().getSize();
            selectedBV.setSize(size.getWidth(), size.getHeight());
            updatebackgroundViews();
        }
        updateSelectionColors();
    }

    /**
     * Returns the background of the selected cell.
     *
     * @return The background of the selected cell.
     */
    @CMGetter("@property(nonatomic, strong) UIView *selectedBackgroundView;")
    public UIView selectedBackgroundView() {
        return selectedBV;
    }

    /**
     * Returns the content view of the cell.
     *
     * @return The content view of the cell.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIView *contentView;")
    public UIView contentView() {
        return contentV;
    }

    /**
     * Returns the label of table cell.
     *
     * @return The label of table cell.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UILabel *textLabel;")
    public UILabel textLabel() {
        if (textlabel == null) {
            CGSize size = frame().getSize();
            textlabel = new UILabel(new CGRect(0, 0, size.getWidth(), size.getHeight()));
            textlabel.setHighlightedTextColor(selectionStyle == UITableViewCellSelectionStyle.None ? null : UIColor.whiteColor());
            contentV.addSubview(textlabel);
        }
        return textlabel;
    }

    /**
     * Returns the additional label of the table cell, if there is one.
     *
     * @return The additional label of the table cell, if there is one.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UILabel *detailTextLabel;")
    public UILabel detailTextLabel() {
        if (detailedtextlabel == null) {
            CGSize size = frame().getSize();
            detailedtextlabel = new UILabel(new CGRect(0, 30, size.getWidth(), size.getHeight() - 30));
            detailedtextlabel.setHighlightedTextColor(selectionStyle == UITableViewCellSelectionStyle.None ? null : UIColor.whiteColor());
            contentV.addSubview(detailedtextlabel);
        }
        return detailedtextlabel;
    }

    /**
     * Returns the image view of the table cell.
     *
     * @return The image view of the table cell.
     */
    @CMGetter("@property(nonatomic, readonly, strong) UIImageView *imageView;")
    public UIImageView imageView() {
        if (imageView == null) {
            imageView = new UIImageView(frame());
            addSubview(imageView);
        }
        return imageView;
    }

    /**
     * Returns a view displayed on the right side of the UITableViewCell and is
     * used for additional control options.
     *
     * @return A view displayed on the right side of the UITableViewCell and is
     * used for additional control options.
     */
    @CMGetter("@property(nonatomic, strong) UIView *accessoryView;")
    public UIView accessoryView() {
        return accessoryV;
    }

    /**
     * Sets a view displayed on the right side of the UITableViewCell and is
     * used for additional control options.
     *
     * @param accessoryView A view displayed on the right side of the
     *                      UITableViewCell and is used for additional control options.
     */
    @CMSetter("@property(nonatomic, strong) UIView *accessoryView;")
    public void setAccessoryView(UIView accessoryView) {
        this.accessoryV = accessoryView;
    }

    /**
     * Returns a string id for a reusable cell.
     *
     * @return A string id for a reusable cell.
     */
    @CMGetter("@property(nonatomic, readonly, copy) NSString *reuseIdentifier;")
    public String reuseIdentifier() {
        return reuseIdentifier;
    }

    /**
     * Returns the style of the selected cell.
     *
     * @return The style of the selected cell.
     */
    @CMGetter("@property(nonatomic) UITableViewCellSelectionStyle selectionStyle;")
    public int selectionStyle() {
        return selectionStyle;
    }

    /**
     * Sets the style of the selected cell.
     *
     * @param UITableViewCellSelectionStyle The style of the selected cell.
     * @see crossmobile.ios.uikit.UITableViewCellSelectionStyle
     */
    @CMSetter("@property(nonatomic) UITableViewCellSelectionStyle selectionStyle;")
    public void setSelectionStyle(int UITableViewCellSelectionStyle) {
        this.selectionStyle = UITableViewCellSelectionStyle;
    }

    /**
     * Sets the type of accessory control that is used by the cell.
     *
     * @param UITableViewCellAccessoryType The type of accessory control that is
     *                                     used by the cell.
     * @see crossmobile.ios.uikit.UITableViewCellAccessoryType
     */
    @CMSetter("@property(nonatomic) UITableViewCellAccessoryType accessoryType;")
    public void setAccessoryType(int UITableViewCellAccessoryType) {
        this.accessorytype = UITableViewCellAccessoryType;
    }

    @Override
    boolean shouldDrawOnTop() {
        UIView parent = superview();
        return parent != null && (parent instanceof UITableView);
    }

    @Override
    void drawOnTop(CGContext cx, CGRect rect) {
        UITableView tv = (UITableView) superview();
        if (tv != null && tv.separatorStyle == UITableViewCellSeparatorStyle.SingleLine) {
            cx.setStrokeColorWithColor(tv.separatorColor.cgcolor);
            context(cx).drawLine(15, getHeight() - 1, getWidth() - 16, getHeight() - 1);
        }
    }

    void setEditing(boolean editing, int editingStyle) {
        if (isEditing == editing && editingStyle == this.editingStyle)
            return;
        isEditing = editing;
        if (isEditing) {
            if (editB == null) {
                editB = UIButton.buttonWithType(UIButtonType.Custom);
                updateEditingStyleButton(editingStyle);
                CGSize size = editButtonSize();
                editB.setFrame(new CGRect(Theme.Cell.EDIT_EDGE, size.getHeight(), size.getWidth(), size.getWidth()));
                editB.setContentMode(UIViewContentMode.ScaleToFill);
                editB.addTarget((UIControl sender, UIEvent event) -> {
                    UITableView tv = (UITableView) superview();
                    UITableViewDataSource ds = tv.dataSource();
                    if (ds != null)
                        ds.commitEditingStyle(tv, UITableViewCell.this.editingStyle, path);
                }, UIControlEvents.TouchUpInside);
                addSubview(editB);
            } else if (editingStyle != this.editingStyle)
                updateEditingStyleButton(editingStyle);
        } else if (editB != null) {
            editB.removeFromSuperview();
            editB = null;
        }
        this.editingStyle = editingStyle;
        layoutSubviews();
    }

    private void updateEditingStyleButton(int style) {
        String normalT, highlightedT;
        switch (style) {
            case UITableViewCellEditingStyle.Insert:
                normalT = Theme.Images.INSERT_RELEASED;
                highlightedT = Theme.Images.INSERT_PRESSED;
                break;
            case UITableViewCellEditingStyle.None:
                normalT = null;
                highlightedT = null;
                break;
            default:
                normalT = Theme.Images.DELETE_RELEASED;
                highlightedT = Theme.Images.DELETE_PRESSED;
                break;
        }
        editB.setBackgroundImage(normalT == null ? null : UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + normalT), UIControlState.Normal);
        editB.setBackgroundImage(highlightedT == null ? null : UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + highlightedT), UIControlState.Highlighted);
    }

    private CGSize editButtonSize() {
        CGSize metrics = new CGSize(Theme.Cell.EDIT_SIZE, 0);
        if (metrics.getWidth() > (getHeight() - 2))
            metrics.setWidth(getHeight() - 2);
        metrics.setHeight((getHeight() - metrics.getWidth()) / 2);
        return metrics;
    }

    @Override
    public final void drawRect(CGRect rect) {
        super.drawRect(rect);
    }

    void addSegue(String trigger, UIStoryboardSegue segue) {
        if (trigger.equals("action"))
            _selectionSegue = segue;
        else if (trigger.equals("accessoryAction"))
            _accessoryActionSegue = segue;
    }

    double getRowHeight(UITableView tableView) {
        return rowHeight >= 0 ? rowHeight : tableView.rowHeight();
    }

    void setRowHeight(float rowHeight) {
        this.rowHeight = rowHeight;
    }

    private class ContentView extends UIView {
        @Override
        public void touchesBegan(Set<UITouch> touches, UIEvent event) {
            UITableView parent = parent();
            if (parent != null && parent.allowsSelection())
                setHighlighted(true);
        }

        @Override
        public void touchesEnded(Set<UITouch> touches, UIEvent event) {
            UITableView parent = parent();
            if (parent != null) {
                parent.selectRow(path, true);
                if (_selectionSegue != null && _selectionSegue.sourceViewController().shouldPerformSegueWithIdentifier(_selectionSegue.identifier(), this)) {
                    _selectionSegue.sourceViewController().prepareForSegue(_selectionSegue, this);
                    _selectionSegue.perform();
                }
            }
        }

        @Override
        public void touchesCancelled(Set<UITouch> touches, UIEvent event) {
            setHighlighted(false);
        }

        private UITableView parent() {
            UIView parent = UITableViewCell.this.superview();
            return path == null || !(parent instanceof UITableView)
                    ? null : (UITableView) parent;
        }

        private void setBackgroundColor(UIColor background, boolean external) {
            super.setBackgroundColor(background);
            if (external)
                definedContentBackground = background;
        }

        @Override
        public void setBackgroundColor(UIColor background) {
            setBackgroundColor(background, true);
        }
    }
}
