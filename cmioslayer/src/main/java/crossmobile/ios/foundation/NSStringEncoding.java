/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSStringEncoding class defines different types of NSString's supported
 * encodings.
 */
@CMEnum
public final class NSStringEncoding {

    /**
     * The 7-bit ASCII encoding.
     */
    public static final int ASCII = 1;

    /**
     * The 8-bit ASCII encoding with NEXTSTEP extensions.
     */
    public static final int NEXTSTEP = 2;

    /**
     * The 8-bit EUC encoding used in Japanese text.
     */
    public static final int JapaneseEUC = 3;

    /**
     * The 8-bit representation of Unicode encoding.
     */
    public static final int UTF8 = 4;

    /**
     * The 8-bit ISO encoding known as Latin 1.
     */
    public static final int ISOLatin1 = 5;

    /**
     * The 8-bit Adobe Symbol encoding.
     */
    public static final int Symbol = 6;

    /**
     * The 7-bit verbose ASCII used in order to represent all Unicode
     * characters.
     */
    public static final int NonLossyASCII = 7;

    /**
     * The 8-bit Shift-JIS encoding used in Japanese text.
     */
    public static final int ShiftJIS = 8;

    /**
     * The 8-bit ISO encoding known as Latin 2.
     */
    public static final int ISOLatin2 = 9;

    /**
     * The Unicode encoding.
     */
    public static final int Unicode = 10;

    /**
     * The Microsoft Windows codepage 1251 encoding.
     */
    public static final int WindowsCP1251 = 11;

    /**
     * The Microsoft Windows codepage 1252 encoding.
     */
    public static final int WindowsCP1252 = 12;

    /**
     * The Microsoft Windows codepage 1253 encoding.
     */
    public static final int WindowsCP1253 = 13;

    /**
     * The Microsoft Windows codepage 1254 encoding.
     */
    public static final int WindowsCP1254 = 14;

    /**
     * The Microsoft Windows codepage 1250 encoding.
     */
    public static final int WindowsCP1250 = 15;

    /**
     * The ISO 2022 Japanese encoding.
     */
    public static final int ISO2022JP = 21;

    /**
     * The classic Macintosh Roman encoding.
     */
    public static final int MacOSRoman = 30;

    /**
     * The UTF 16 encoding.
     */
    public static final int UTF16 = Unicode;

    /**
     * The UTF 16 big endian encoding.
     */
    public static final int UTF16BigEndian = 0x90000100;

    /**
     * The UTF 16 little endian encoding.
     */
    public static final int UTF16LittleEndian = 0x94000100;

    /**
     * The UTF 32 encoding.
     */
    public static final int UTF32 = 0x8c000100;

    /**
     * The UTF 32 big endian encoding.
     */
    public static final int UTF32BigEndian = 0x98000100;

    /**
     * The UTF 32 little endian encoding.
     */
    public static final int UTF32LittleEndian = 0x9c000100;

    private NSStringEncoding() {
    }

    static String convertIntToString(int value) {
        switch (value) {
            case ASCII:
            case NonLossyASCII:
                return "US-ASCII";
            case NEXTSTEP:
                return null;
            case JapaneseEUC:
                return "EUC-JP";
            case ISOLatin1:
                return "ISO-8859-1";
            case Symbol:
                return "x-MacSymbol";
            case ShiftJIS:
                return "Shift_JIS";
            case ISOLatin2:
                return "ISO-8859-2";
            case Unicode:
                return "UTF-16";
            case WindowsCP1251:
                return "windows-1251";
            case WindowsCP1252:
                return "windows-1252";
            case WindowsCP1253:
                return "windows-1253";
            case WindowsCP1254:
                return "windows-1254";
            case WindowsCP1250:
                return "windows-1250";
            case ISO2022JP:
                return "ISO-2022-JP";
            case MacOSRoman:
                return "x-MacRoman";
            case UTF16BigEndian:
                return "UTF-16BE";
            case UTF16LittleEndian:
                return "UTF-16LE";
            case UTF32:
                return "UTF-32";
            case UTF32BigEndian:
                return "UTF-32BE";
            case UTF32LittleEndian:
                return "UTF-32LE";
            case UTF8:
            default:
                return "UTF-8";
        }
    }
}
