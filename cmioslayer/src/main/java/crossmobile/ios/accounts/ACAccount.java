/*
 * (c) 2019 by Panayotis Katsaloulis
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
package crossmobile.ios.accounts;

import crossmobile.ios.foundation.NSObject;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMConstructor;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSetter;

/**
 * ACAccount class defines an object that represents a user account that is
 * stored in the Accounts database.
 */
@CMClass
public class ACAccount extends NSObject {

    private ACAccountType accountType;
    private String accountDescription;
    private String username;
    private ACAccountCredential credential;


    /**
     * Constructs a new ACAccount of the specified type.
     *
     * @param type The type of the new ACAccount.
     */
    @CMConstructor("- (instancetype)initWithAccountType:(ACAccountType *)type;")
    public ACAccount(ACAccountType type) {
    }

    /**
     * The default constructor of an ACAccount object.
     */
    public ACAccount() {
    }

    /**
     * Returns the unique id of this ACAccount.
     *
     * @return The unique id of this ACAccount.
     */
    @CMGetter("@property(readonly, weak, nonatomic) NSString *identifier;")
    public String identifier() {
        Native.lifecycle().notImplemented();
        return null;
    }

    /**
     * Returns the type of service of this ACAccount.
     *
     * @return The type of service of this ACAccount.
     * @see crossmobile.ios.accounts.ACAccountType
     */
    @CMGetter("@property(strong, nonatomic) ACAccountType *accountType;\n"
            + "")
    public ACAccountType accountType() {
        return accountType;
    }

    /**
     * Sets the type of service for this ACAccount.
     *
     * @param accountType The type of service for this ACAccount.
     * @see crossmobile.ios.accounts.ACAccountType
     */
    @CMSetter("@property(strong, nonatomic) ACAccountType *accountType;\n"
            + "")
    public void setAccountType(ACAccountType accountType) {
        this.accountType = accountType;
    }

    /**
     * Returns the description of this ACAccount.
     *
     * @return The description of this ACAccount.
     */
    @CMGetter("@property(copy, nonatomic) NSString *accountDescription;")
    public String accountDescription() {
        return accountDescription;
    }

    /**
     * Sets the description of this ACAccount.
     *
     * @param accountDescription The description of this ACAccount.
     */
    @CMSetter("@property(copy, nonatomic) NSString *accountDescription;")
    public void setAccountDescription(String accountDescription) {
        this.accountDescription = accountDescription;
    }

    /**
     * Returns the username of this ACAccount.
     *
     * @return The username of this ACAccount.
     */
    @CMGetter("@property(copy, nonatomic) NSString *username;\n"
            + "")
    public String username() {
        return username;
    }

    /**
     * Sets the username of this ACAccount.
     *
     * @param username The username of this ACAccount.
     */
    @CMSetter("@property(copy, nonatomic) NSString *username;\n"
            + "")
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Returns the credential for the validation of this ACAccount.
     *
     * @return The credential for the validation of this ACAccount.
     */
    @CMGetter("@property(strong, nonatomic) ACAccountCredential *credential;")
    public ACAccountCredential credential() {
        return credential;
    }

    /**
     * Sets the credential for the validation of this ACAccount.
     *
     * @param credential The credential for the validation of this ACAccount.
     */
    @CMSetter("@property(strong, nonatomic) ACAccountCredential *credential;")
    public void setCredential(ACAccountCredential credential) {
        this.credential = credential;
    }
}
