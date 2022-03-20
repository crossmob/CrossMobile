/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.social;

import crossmobile.ios.uikit.UITextView;
import crossmobile.ios.uikit.UITextViewDelegate;
import crossmobile.ios.uikit.UIView;
import crossmobile.ios.uikit.UIViewController;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.List;

@CMClass
public class SLComposeServiceViewController extends UIViewController implements UITextViewDelegate {

    private UIViewController autoCompletionViewController;
    private Number charactersRemaining;
    private String placeholder;
    private String contentText;
    private UITextView textView;

    @CMSelector("- (void)presentationAnimationDidFinish;")
    public void presentationAnimationDidFinish() {
    }

    @CMSelector("- (void)cancel;")
    public void cancel() {

    }

    @CMSelector("- (void)didSelectCancel;")
    public void didSelectCancel() {

    }

    @CMSelector("- (void)didSelectPost;")
    public void didSelectPost() {

    }

    @CMSelector("- (BOOL)isContentValid;")
    public boolean isContentValid() {
        return false;
    }

    @CMSelector("- (void)validateContent;")
    public void validateContent() {

    }

    @CMSelector("- (UIView *)loadPreviewView;")
    public UIView loadPreviewView() {
        return null;
    }

    @CMSelector("- (NSArray *)configurationItems;")
    public List configurationItems() {
        return null;
    }

    @CMSelector("- (void)popConfigurationViewController;")
    public void popConfigurationViewController() {

    }

    @CMSelector("- (void)pushConfigurationViewController:(UIViewController *)viewController;")
    public void pushConfigurationViewController(UIViewController viewController) {

    }

    @CMSelector("- (void)reloadConfigurationItems;")
    public void reloadConfigurationItems() {
    }

    @CMGetter("@property(strong, nonatomic) UIViewController *autoCompletionViewController;")
    public UIViewController autoCompletionViewController() {
        return autoCompletionViewController;
    }

    @CMSetter("@property(strong, nonatomic) UIViewController *autoCompletionViewController;")
    public void setAutoCompletionViewController(UIViewController autoCompletionViewController) {
        this.autoCompletionViewController = autoCompletionViewController;
    }

    @CMGetter("@property(strong, nonatomic) NSNumber *charactersRemaining;")
    public Number charactersRemaining() {
        return charactersRemaining;
    }

    @CMSetter("@property(strong, nonatomic) NSNumber *charactersRemaining;")
    public void setCharactersRemaining(Number charactersRemaining) {
        this.charactersRemaining = charactersRemaining;
    }

    @CMGetter("@property(copy, nonatomic) NSString *placeholder;")
    public String placeholder() {
        return placeholder;
    }

    @CMSetter("@property(copy, nonatomic) NSString *placeholder;")
    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    @CMGetter("@property(readonly, nonatomic) NSString *contentText;")
    public String contentText() {
        return contentText;
    }

    @CMGetter("@property(readonly, nonatomic) UITextView *textView;")
    public UITextView textView() {
        return textView;
    }
}
