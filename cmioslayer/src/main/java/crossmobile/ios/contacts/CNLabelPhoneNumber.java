/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.contacts;

import org.crossmobile.bridge.ann.CMEnum;

@CMEnum
public final class CNLabelPhoneNumber {

    public final static String iPhone = "";
    public final static String Mobile = "";
    public final static String Main = "";
    public final static String HomeFax = "";
    public final static String WorkFax = "";
    public final static String OtherFax = "";
    public final static String Pager = "";

    private CNLabelPhoneNumber() {
    }

}
