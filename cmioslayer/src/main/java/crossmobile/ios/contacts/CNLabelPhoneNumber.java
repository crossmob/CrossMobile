/*
 * (c) 2020 by Panayotis Katsaloulis
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
