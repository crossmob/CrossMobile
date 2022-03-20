/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMSetter;

import java.util.Map;

/**
 * UIMutableUserNotificationAction class defines an object that is equivalent to
 * UIUserNotificationAction and is editable.
 */
@CMClass
@CMLib(name = "cmnotifications")
public class UIMutableUserNotificationAction extends UIUserNotificationAction {

    /**
     * Sets the name of the action.
     *
     * @param identifier The name of the action.
     */
    @CMSetter("@property(nonatomic, copy) NSString *identifier;")
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    /**
     * Sets the text displayed on the button of the action.
     *
     * @param title The text of the button of the action.
     */
    @CMSetter("@property(nonatomic, copy) NSString *title;")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Sets the mode of the application before action is performed.
     *
     * @param activationMode The mode of the application before action is
     *                       performed.
     */
    @CMSetter("@property(nonatomic, assign) UIUserNotificationActivationMode activationMode;")
    public void setActivationMode(int activationMode) {
        this.activationMode = activationMode;
    }

    /**
     * Sets a Boolean value that defines whether the device must unlocked by the
     * user before the action.
     *
     * @param authenticationRequired TRUE, the user must unlock the device
     *                               before the action.
     */
    @CMSetter("@property(nonatomic, assign, getter=isAuthenticationRequired) BOOL authenticationRequired;")
    public void setAuthenticationRequired(boolean authenticationRequired) {
        this.authenticationRequired = authenticationRequired;
    }

    /**
     * Sets a Boolean value that defines whether the action is destructive or
     * not.
     *
     * @param destructive TRUE,then the specified action is destructive.
     */
    @CMSetter("@property(nonatomic, assign, getter=isDestructive) BOOL destructive;")
    public void setDestructive(boolean destructive) {
        this.destructive = destructive;
    }

    /**
     * Sets the behavior that the action supports.
     *
     * @param behavior The behavior that the action supports.
     * @see crossmobile.ios.uikit.UIUserNotificationActionBehavior
     */
    @CMSetter("@property(nonatomic, assign) UIUserNotificationActionBehavior behavior;")
    public void setBehavior(int behavior) {
        this.behavior = behavior;
    }

    /**
     * A dictionary with additional parameters related to the action.
     *
     * @param parameters Dictionary with additional parameters related to the
     *                   action.
     */
    @CMSetter("@property(nonatomic, copy) NSDictionary *parameters;")
    public void setParameters(Map parameters) {
        this.parameters = parameters == null || parameters.isEmpty() ? null : parameters;
    }

}
