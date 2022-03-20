/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGContext;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.foundation.NSIndexPath;
import org.crossmobile.bind.graphics.Theme;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.*;

import java.util.Set;

import static crossmobile.ios.coregraphics.GraphicsDrill.context;
import static crossmobile.ios.uikit.cmCommonFonts.getSmallSystemFont;

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
    private UIColor originalContentBackground;
    private UIView unselectedBV;
    private UIView selectedBV;
    private UILabel textlabel;
    private UILabel detailedtextlabel;
    private UIButton editB;
    private int selectionStyle = UITableViewCellSelectionStyle.Gray;
    private int editingStyle = UITableViewCellEditingStyle.Delete;
    private boolean isEditing = false;
    private UIImageView imageView = null;
    private float rowHeight = -1;

    private int accessoryType = UITableViewCellAccessoryType.None;
    private UIView accessoryView = null;
    private UIView currentAccessoryView = null;

    private UIStoryboardSegue _selectionSegue;
    private UIStoryboardSegue _accessoryActionSegue;
    private final boolean supportsDetailedTextLabel;

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
        super(new CGRect(0, 0, 320, 44), UIColor.whiteColor);
        originalContentBackground = UIColor.whiteColor;
        supportsDetailedTextLabel = UITableViewCellStyle == crossmobile.ios.uikit.UITableViewCellStyle.Subtitle;
        if (UITableViewCellStyle == crossmobile.ios.uikit.UITableViewCellStyle.Value1)
            Native.system().notImplemented("Cell type UITableViewCellStyle.Value1");
        else if (UITableViewCellStyle == crossmobile.ios.uikit.UITableViewCellStyle.Value2)
            Native.system().notImplemented("Cell type UITableViewCellStyle.Value2");
        this.reuseIdentifier = reuseIdentifier;
        addSubview(contentV = new ContentView());
    }

    @Override
    public void didAddSubview(UIView subview) {
        forceLayout();
    }

    @Override
    void didRemoveSubview(UIView subview) {
        forceLayout();
    }

    @Override
    public void layoutSubviews() {
        super.layoutSubviews();
        if (contentV != null) { // Only when the object is fully initialized
            double leftInset = 0;
            double rightInset = 0;
            double width = cframe().getSize().getWidth();
            double height = cframe().getSize().getHeight();

            if (imageView != null && imageView.image() != null) {
                leftInset = Theme.Cell.INSET_LEFT + Theme.Cell.IMAGE_SIZE;
                int topOffset = (int) (Math.max(0, height - Theme.Cell.IMAGE_SIZE) / 2);
                imageView.setFrame(new CGRect(Theme.Cell.INSET_LEFT, topOffset, Theme.Cell.IMAGE_SIZE, height - 2 * topOffset));
            } else if (isEditing)
                leftInset = Theme.Cell.INSET_LEFT + editButtonSize().getWidth();

            if (currentAccessoryView != null) {
                double accSize = accessoryView == null ? currentAccessoryView.frame().getSize().getWidth() : Theme.Cell.ACCESSORY_SIZE;
                rightInset = accSize + Theme.Cell.INSET_RIGHT_EDGE;
                int topOffset = (int) (Math.max(0, height - Theme.Cell.ACCESSORY_SIZE) / 2);
                currentAccessoryView.setFrame(new CGRect(width - rightInset, topOffset, accSize, height - 2 * topOffset));
            }

            int textY = (int) Math.max(0, (height - (22 + (detailedtextlabel != null && detailedtextlabel.text() != null && !detailedtextlabel.text().isEmpty() ? 2 + 16 : 0))) / 2d);
            if (textlabel != null)
                textlabel.setFrame(new CGRect(leftInset + Theme.Cell.INSET_CONTENT, textY, width - rightInset - Theme.Cell.INSET_CONTENT * 2, 22));
            if (detailedtextlabel != null)
                detailedtextlabel.setFrame(new CGRect(leftInset + Theme.Cell.INSET_CONTENT, textY + 24, width - rightInset - Theme.Cell.INSET_CONTENT * 2, 16));

            contentV.setFrame(new CGRect(leftInset, 0, width - leftInset - rightInset, height));
            CGRect otherF = contentV.frame();
            otherF.getOrigin().setX(0);
            if (unselectedBV != null)
                unselectedBV.setFrame(otherF);
            if (selectedBV != null)
                selectedBV.setFrame(otherF);
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
        UIColor background = originalContentBackground;
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
        setBackgroundColorImpl(background, false);
        if (textlabel != null)
            textlabel.setHighlightedTextColor(highlighted);
        if (detailedtextlabel != null)
            detailedtextlabel.setHighlightedTextColor(highlighted);
        setNeedsDisplay();
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
        if (detailedtextlabel != null)
            detailedtextlabel.setHighlighted(highlighted);
        updateSelectionColors();
    }

    private void updateBackgroundViews() {
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
            updateBackgroundViews();
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
            updateBackgroundViews();
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
            textlabel = new UILabel();
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
        if (detailedtextlabel == null && supportsDetailedTextLabel) {
            detailedtextlabel = new UILabel() {
                @Override
                public void setText(String text) {
                    super.setText(text);
                    UITableViewCell.this.layoutSubviews();
                }
            };
            detailedtextlabel.setHighlightedTextColor(selectionStyle == UITableViewCellSelectionStyle.None ? null : UIColor.whiteColor());
            detailedtextlabel.setFont(getSmallSystemFont());
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
        if (this.accessoryType == UITableViewCellAccessoryType)
            return;
        this.accessoryType = UITableViewCellAccessoryType;
        updateAccessoryView();
    }

    /**
     * Returns the current type of accessory control that is used by the cell.
     *
     * @return The type of accessory control that is
     * used by the cell.
     * @see crossmobile.ios.uikit.UITableViewCellAccessoryType
     */
    @CMGetter("@property(nonatomic) UITableViewCellAccessoryType accessoryType;")
    public int accessoryType() {
        return accessoryType;
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
        return accessoryView;
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
        if (this.accessoryView == accessoryView)
            return;
        this.accessoryView = accessoryView;
        updateAccessoryView();
    }

    /**
     * Prepare this cell to be reused. This method is called on recycled cells, just before being returned from the
     * UITableView.dequeueReusableCellWithIdentifier(id) method.
     */
    @CMSelector("- (void)prepareForReuse;")
    public void prepareForReuse() {
    }

    private void updateAccessoryView() {
        if (accessoryView != null) {
            if (currentAccessoryView == accessoryView) // typically when the accessory type has changed
                return;
            if (currentAccessoryView != null)
                currentAccessoryView.removeFromSuperview();
            currentAccessoryView = accessoryView;
        } else {
            if (currentAccessoryView != null)
                currentAccessoryView.removeFromSuperview();
            switch (accessoryType) {
                case UITableViewCellAccessoryType.Checkmark:
                    currentAccessoryView = new UIImageView(new CGRect(0, 0, Theme.Cell.ACCESSORY_SIZE, Theme.Cell.ACCESSORY_SIZE));
                    ((UIImageView) currentAccessoryView).setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "tick").cacheTinted(true, currentAccessoryView));
                    break;
                case UITableViewCellAccessoryType.DetailDisclosureButton:

                    UIButton info = UIButton.buttonWithType(UIButtonType.Custom);
                    info.setFrame(new CGRect(0, 0, Theme.Cell.ACCESSORY_SIZE, Theme.Cell.ACCESSORY_SIZE));
                    info.setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "info").cacheTinted(true, info), UIControlState.Normal);
                    info.addTarget((sender, event) -> {
                        UITableView parent = parent();
                        UITableViewDelegate delegate = parent == null ? null : parent.tableViewDelegate();
                        if (delegate != null)
                            delegate.accessoryButtonTappedForRowWithIndexPath(parent, path);
                    }, UIControlEvents.TouchUpInside);

                    UIImageView arrow = new UIImageView();
                    arrow.setFrame(new CGRect(Theme.Cell.ACCESSORY_SIZE + Theme.Cell.INSET_RIGHT_ACCESSORY_ACCESSORY, 0, Theme.Cell.ACCESSORY_SIZE, Theme.Cell.ACCESSORY_SIZE));
                    arrow.setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "arrow"));

                    currentAccessoryView = new UIView(new CGRect(0, 0, Theme.Cell.ACCESSORY_SIZE * 2 + Theme.Cell.INSET_RIGHT_ACCESSORY_ACCESSORY, Theme.Cell.ACCESSORY_SIZE));
                    currentAccessoryView.addSubview(info);
                    currentAccessoryView.addSubview(arrow);
                    break;
                case UITableViewCellAccessoryType.DisclosureIndicator:
                    currentAccessoryView = new UIImageView();
                    currentAccessoryView.setFrame(new CGRect(0, 0, Theme.Cell.ACCESSORY_SIZE, Theme.Cell.ACCESSORY_SIZE));
                    ((UIImageView) currentAccessoryView).setImage(UIImage.imageWithContentsOfFile(Native.file().getSystemPrefix() + "arrow"));
                    break;
                default:
                    currentAccessoryView = null;
            }
        }
        if (currentAccessoryView != null)
            addSubview(currentAccessoryView);
    }

    @Override
    boolean shouldDrawOnTop() {
        return (superview() instanceof UITableView);
    }

    @Override
    void drawOnTop(CGContext cx, CGRect rect) {
        UITableView tv = (UITableView) superview();
        if (tv != null && tv.separatorStyle == UITableViewCellSeparatorStyle.SingleLine) {
            cx.setStrokeColorWithColor(tv.separatorColor.cgcolor);
            context(cx).drawLine(15, cframe().getSize().getHeight() - 1, cframe().getSize().getWidth() - 16, cframe().getSize().getHeight() - 1);
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
                editB.setFrame(new CGRect(Theme.Cell.INSET_LEFT, size.getHeight(), size.getWidth(), size.getWidth()));
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
        if (metrics.getWidth() > (cframe().getSize().getHeight() - 2))
            metrics.setWidth(cframe().getSize().getHeight() - 2);
        metrics.setHeight((cframe().getSize().getHeight() - metrics.getWidth()) / 2);
        return metrics;
    }

    void addSegue(String trigger, UIStoryboardSegue segue) {
        if (trigger.equals("action"))
            _selectionSegue = segue;
        else if (trigger.equals("accessoryAction"))
            _accessoryActionSegue = segue;
    }

    double getRowHeight() {
        return rowHeight;
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

        @Override
        public void didAddSubview(UIView subview) {
            UITableViewCell.this.forceLayout();
        }

        @Override
        void didRemoveSubview(UIView subview) {
            UITableViewCell.this.forceLayout();
        }

    }

    private UITableView parent() {
        UIView parent = superview();
        return path == null || !(parent instanceof UITableView)
                ? null : (UITableView) parent;
    }

    private void setBackgroundColorImpl(UIColor background, boolean external) {
        super.setBackgroundColor(background);
        if (external)
            originalContentBackground = background;
    }

    @Override
    public void setBackgroundColor(UIColor background) {
        setBackgroundColorImpl(background, true);
    }

    @Override
    public CGSize sizeThatFits(CGSize size) {
        double height = (detailedtextlabel != null && detailedtextlabel.text() != null && !detailedtextlabel.text().isEmpty()
                ? 14 : 0) + 44;
        return new CGSize(size.getWidth(), height);
    }
}
