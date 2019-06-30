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
package crossmobile.ios.uikit;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * UIKeyboardType specifies the type of keyboard for a view that contains text.
 */
@CMEnum
public final class UIKeyboardType {

    /**
     * The default keyboard.
     */
    public static final int Default = 0;

    /**
     * A keyboard that displays ASCII characters.
     */
    public static final int ASCIICapable = 1;

    /**
     * A keyboard that displays numbers and punctuation.
     */
    public static final int NumbersAndPunctuation = 2;

    /**
     * A keyboard that enhances typing URLs.
     */
    public static final int URL = 3;

    /**
     * A keyboard that enhances entering pins.
     */
    public static final int NumberPad = 4;

    /**
     * A keyboard that enhances entering phone numbers.
     */
    public static final int PhonePad = 5;

    /**
     * A keyboard that enhances for entering names and phone numbers.
     */
    public static final int NamePhonePad = 6;

    /**
     * A keyboard that enhances for entering email addresses.
     */
    public static final int EmailAddress = 7;

    /**
     * A keyboard that enhances alphabetic entries.
     */
    public static final int Alphabet = ASCIICapable;


    /**
     * A keyboard that has numbers and a decimal point
     */
    public static final int DecimalPad = 8;


    /**
     * A keyboard optimized for twitter with easy acces to '@' and '#' characters
     */
    public static final int Twitter = 9;


    /**
     * A keyboard that optimezed for web searches and URL entry
     */
    public static final int WebSearch = 10;


    /**
     * A keyboard that with a Numpad that only outputs ASCII digits
     */
    public static final int ASCIICapableNumberPad = 11;

    private UIKeyboardType() {
    }
}
