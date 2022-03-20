/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGSize;
import crossmobile.ios.uikit.UIFont;
import crossmobile.ios.uikit.UIGraphics;
import crossmobile.rt.StrongReference;
import org.crossmobile.bind.graphics.GraphicsContext;
import org.crossmobile.bind.graphics.TextHelpers;
import org.crossmobile.bind.system.AbstractLifecycleBridge;
import org.crossmobile.bind.system.i18n.I18NBridge;
import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMLib;
import org.crossmobile.bridge.ann.CMLibTarget;
import org.crossmobile.bridge.ann.CMSelector;

import java.io.*;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.*;
import java.util.regex.Pattern;

import static crossmobile.ios.coregraphics.GraphicsDrill.context;
import static crossmobile.ios.coregraphics.GraphicsDrill.font;
import static crossmobile.ios.foundation.NSStringEncoding.convertIntToString;
import static crossmobile.ios.uikit.UserInterfaceDrill.cgfont;
import static org.crossmobile.bind.system.SystemUtilities.closeR;
import static org.crossmobile.bind.system.i18n.I18NTest.I18N_SUPPORT;

/**
 * NSString class defines an object that is the foundation of the textual
 * functionality of the application.
 */
@CMLib(target = CMLibTarget.API_NOUWP)
@CMClass
public class NSString extends NSObject implements NSSecureCoding {
    private static final Map<Pattern, String> FORMAT_PATTERNS = new LinkedHashMap<>();

    static {
        FORMAT_PATTERNS.put(Pattern.compile("%C"), "%c");
        FORMAT_PATTERNS.put(Pattern.compile("%u"), "%d");
        FORMAT_PATTERNS.put(Pattern.compile("%U"), "%d");
        FORMAT_PATTERNS.put(Pattern.compile("%lld"), "%d");
        FORMAT_PATTERNS.put(Pattern.compile("%llo"), "%o");
        FORMAT_PATTERNS.put(Pattern.compile("%llx"), "%x");
        FORMAT_PATTERNS.put(Pattern.compile("%llX"), "%X");
        FORMAT_PATTERNS.put(Pattern.compile("%@"), "%s");

        FORMAT_PATTERNS.put(Pattern.compile("%([0-9]+\\$)C"), "%$1c");
        FORMAT_PATTERNS.put(Pattern.compile("%([0-9]+\\$)u"), "%$1d");
        FORMAT_PATTERNS.put(Pattern.compile("%([0-9]+\\$)U"), "%$1d");
        FORMAT_PATTERNS.put(Pattern.compile("%([0-9]+\\$)lld"), "%$1d");
        FORMAT_PATTERNS.put(Pattern.compile("%([0-9]+\\$)llo"), "%$1o");
        FORMAT_PATTERNS.put(Pattern.compile("%([0-9]+\\$)llx"), "%$1x");
        FORMAT_PATTERNS.put(Pattern.compile("%([0-9]+\\$)llX"), "%$1X");
        FORMAT_PATTERNS.put(Pattern.compile("%([0-9]+\\$)@"), "%$1s");
    }

    private NSString() {
    }

    /**
     * Returns an NSData object that represents the given String encoded using
     * the specified NSStringEncoding.
     *
     * @param string           The initial String that is converted to a NSData object.
     * @param NSStringEncoding The String encoding that is used.
     * @return The final NSData object.
     */
    @CMSelector(value = "- (NSData *)dataUsingEncoding:(NSStringEncoding)encoding", staticMapping = true)
    public static NSData dataUsingEncoding(String string, int NSStringEncoding) {
        try {
            if (string == null)
                return null;
            return new NSData(string.getBytes(convertIntToString(NSStringEncoding)));
        } catch (UnsupportedEncodingException ignored) {
        }
        return null;
    }

    /**
     * Returns a String that is the result of reading data from the specified
     * URL using the given encoding.
     *
     * @param url              The URL from which to read data.
     * @param NSStringEncoding The encoding that is used.
     * @param error            The error that occurs in case of failure.NULL when there the
     *                         error description is useless.
     * @return The final String.
     */
    @Deprecated
    @CMSelector("+ (instancetype)stringWithContentsOfURL:(NSURL *)url\n"
            + "                               encoding:(NSStringEncoding)enc\n"
            + "                                  error:(NSError * _Nullable *)error")
    public static String stringWithContentsOfURL(NSURL url, int NSStringEncoding, StrongReference<NSError> error) {
        if (url == null)
            return null;
        return stringWithContentsOfURL(url.absoluteString(), convertIntToString(NSStringEncoding), error);
    }

    /**
     * Returns a String that is the interpretation of the specified URL.
     *
     * @param url The URL that is interpreted.
     * @return The final String.
     */
    @Deprecated
    @CMSelector("+ (id)stringWithContentsOfURL:(NSURL *)url;")
    public static String stringWithContentsOfURL(NSURL url) {
        if (url == null)
            return null;
        return stringWithContentsOfURL(url.absoluteString(), null, null);
    }

    private static String stringWithContentsOfURL(String url, String encoding, StrongReference<NSError> error) {
        try {
            return stringWithContentsOfInputStream(new URL(url).openStream(), encoding, error);
        } catch (IOException ex) {
            if (error != null)
                ;
            return null;
        }
    }

    /**
     * Returns a String that is the result of reading data from the specified
     * file.
     *
     * @param path The path of the file.
     * @return The final String.
     */
    @Deprecated
    @CMSelector("+ (id)stringWithContentsOfFile:(NSString *)path;")
    public static String stringWithContentsOfFile(String path) {
        return stringWithContentsOfFileImpl(path, null, null);
    }

    /**
     * Returns a String that is the result of reading data from the specified
     * file.
     *
     * @param path             The path of the file.
     * @param NSStringEncoding the file encoding
     * @param error            The error that occurs in case of failure
     * @return The final String.
     */
    @CMSelector("+ (instancetype)stringWithContentsOfFile:(NSString *)path \n"
            + "                                encoding:(NSStringEncoding)enc \n"
            + "                                   error:(NSError * _Nullable *)error;")
    public static String stringWithContentsOfFile(String path, int NSStringEncoding, StrongReference<NSError> error) {
        return stringWithContentsOfFileImpl(path, convertIntToString(NSStringEncoding), error);
    }

    private static String stringWithContentsOfFileImpl(String path, String encoding, StrongReference<NSError> error) {
        if (path != null)
            try {
                return stringWithContentsOfInputStream(Native.file().getFileStream(path), encoding, error);
            } catch (IOException e) {
                if (error != null)
                    error.set(NSError.errorWithDomain(NSError.Domain.NSPOSIX, 0, AbstractLifecycleBridge.errorFromThrowable(e)));
            }
        return null;
    }

    private static String stringWithContentsOfInputStream(InputStream stream, String charset, StrongReference<NSError> error) {
        BufferedReader in = null;
        StringBuilder out = new StringBuilder();
        try {
            char[] buffer = new char[1000];
            int howmany;
            in = new BufferedReader(charset == null ? new InputStreamReader(stream) : new InputStreamReader(stream, charset));
            while ((howmany = in.read(buffer)) > 0)
                out.append(buffer, 0, howmany);
        } catch (IOException e) {
            if (error != null)
                error.set(NSError.errorWithDomain(NSError.Domain.NSPOSIX, 0, AbstractLifecycleBridge.errorFromThrowable(e)));
            return null;
        } finally {
            closeR(in);
        }
        return out.toString();
    }

    /**
     * Check whether a string can be converted to the specified encoding
     *
     * @param self             the String to check if it can be converted
     * @param NSStringEncoding the desired encoding
     * @return true if the self can be converted
     * @see NSStringEncoding
     */
    @CMSelector(value = "- (BOOL)canBeConvertedToEncoding:(NSStringEncoding)encoding;", staticMapping = true)
    public static boolean canBeConvertedToEncoding(String self, int NSStringEncoding) {
        try {
            return Charset.forName(convertIntToString(NSStringEncoding)).newEncoder().canEncode(self);
        } catch (UnsupportedCharsetException e) {
            return false;
        }
    }

    /**
     * Return a new string, where the content inside range is replaced with replacement
     *
     * @param self        The string to act on
     * @param range       The range which will be replaced
     * @param replacement The replacement string
     * @return The result string
     */
    @CMSelector(value = "- (NSString *)stringByReplacingCharactersInRange:(NSRange)range \n" +
            "                                      withString:(NSString *)replacement;\n", staticMapping = true)
    public static String stringByReplacingCharactersInRange(String self, NSRange range, String replacement) {
        return range.getLocation() == 0
                ? replacement + self.substring(range.getLength())
                : self.substring(0, range.getLocation()) + replacement
                + self.substring(range.getLocation() + range.getLength());
    }

    /**
     * Creates and returns a new NSString object from the interpretation of the
     * specified URL replacing all percent escapes with the matching characters
     * using the specified encoding.
     *
     * @param self             The URL that is used.
     * @param NSStringEncoding The encoding used for the returned string.
     * @return The final String.
     */
    @CMSelector(value = "- (NSString *)stringByReplacingPercentEscapesUsingEncoding:(NSStringEncoding)encoding", staticMapping = true)
    public static String stringByReplacingPercentEscapesUsingEncoding(String self, int NSStringEncoding) {
        try {
            return URLDecoder.decode(self, convertIntToString(NSStringEncoding));
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    /**
     * Creates and returns a new NSString object by adding percent escapes in
     * order to convert it to a legal URL.
     *
     * @param self             The URL that is used.
     * @param NSStringEncoding The encoding used for the returned string.
     * @return The final String.
     */
    @CMSelector(value = "- (NSString *)stringByAddingPercentEscapesUsingEncoding:(NSStringEncoding)encoding", staticMapping = true)
    public static String stringByAddingPercentEscapesUsingEncoding(String self, int NSStringEncoding) {
        try {
            return URLEncoder.encode(self, convertIntToString(NSStringEncoding)).replace("+", "%20");
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    /**
     * Compares the given Strings using the specified options.
     *
     * @param self                   The first String to be compared.
     * @param with                   The second String to be compared.
     * @param NSStringCompareOptions The option for searching the Strings.
     * @return The result of comparing the two Strings.
     * @see crossmobile.ios.foundation.NSOrdered
     */
    @CMSelector(value = "- (NSComparisonResult)compare:(NSString *)aString options:(NSStringCompareOptions)mask", staticMapping = true)
    public static int compare(String self, String with, int NSStringCompareOptions) {
        if (with == null && self == null)
            return NSOrdered.Same;
        if (with == null)
            return NSOrdered.Descending;
        if (self == null)
            return NSOrdered.Ascending;
        int order;

        if ((NSStringCompareOptions & crossmobile.ios.foundation.NSStringCompareOptions.NSNumericSearch) != 0) {
            double fromD = stringToRelaxedDouble(self);
            double withD = stringToRelaxedDouble(with);
            order = fromD == withD ? 0 : (fromD < withD ? -1 : 1);
        } else {
            if ((NSStringCompareOptions & crossmobile.ios.foundation.NSStringCompareOptions.NSCaseInsensitiveSearch) != 0) {
                self = self.toLowerCase();
                with = with.toLowerCase();
            }
            if ((NSStringCompareOptions & crossmobile.ios.foundation.NSStringCompareOptions.NSDiacriticInsensitiveSearch) != 0) {
                self = Normalizer.normalize(self, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                with = Normalizer.normalize(with, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
            }
            order = self.compareTo(with);
        }
        return order < 0 ? NSOrdered.Ascending : (order > 0 ? NSOrdered.Descending : NSOrdered.Same);
    }

    private static double stringToRelaxedDouble(String dirtyDouble) {
        try {
            return Double.parseDouble(dirtyDouble);
        } catch (NumberFormatException ignored) {
        }

        StringBuilder out = new StringBuilder();
        dirtyDouble = dirtyDouble.trim();
        boolean hasdot = false;
        for (int i = 0; i < dirtyDouble.length(); i++) {
            char current = dirtyDouble.charAt(i);
            switch (current) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    out.append(current);
                    break;
                case '-':
                    if (out.length() == 0)
                        out.append(current);
                    break;
                case '.':
                    if (!hasdot)
                        out.append(current);
                    hasdot = true;
                    break;
                default:
            }
        }
        return Double.parseDouble(out.toString());
    }

    /**
     * Returns a list that contains the substrings of the specified String
     * divided by the given separator.
     *
     * @param self      The initial String.
     * @param separator The separator String.
     * @return The list that contains the substrings of the specified String
     * divided by the given separator.
     */
    @CMSelector(value = "- (NSArray<NSString *> *)componentsSeparatedByString:(NSString *)separator", staticMapping = true)
    public static List<String> componentsSeparatedByString(String self, String separator) {
        List<String> parts = new ArrayList<>();
        int loc;
        while (true) {
            loc = self.indexOf(separator);
            if (loc < 0) {
                parts.add(self);
                break;
            } else {
                parts.add(self.substring(0, loc));
                self = self.substring(loc + separator.length());
            }
        }
        return parts;
    }

    /**
     * Returns a String  that is encoded representation of the given
     * NSData object of the specified encoding.
     *
     * @param data             The NSData object to be encoded.
     * @param NSStringEncoding The encoding used.
     * @return The new String object.
     */
    @CMSelector(value = "- (instancetype)initWithData:(NSData *)data encoding:(NSStringEncoding)encoding", staticMapping = true)
    public static String initWithData(NSData data, int NSStringEncoding) {
        try {
            return new String(data.bytes(), convertIntToString(NSStringEncoding));
        } catch (UnsupportedEncodingException ex) {
        }
        return null;
    }

    /**
     * Create a String based on the provided format
     *
     * @param format The iOS-type formatting
     * @param args   The possible arguments, up to 20 arguments
     * @return The formatted String
     */
    @CMSelector(value = "- (instancetype)initWithFormat:(NSString *)format, ...;", staticMapping = true)
    public static String initWithFormat(String format, Object... args) {
        return String.format(objcToJavaFormat(format), args);
    }

    /**
     * Get a localized version of a formatted String using current locale
     *
     * @param format The iOS-type formatting
     * @param args   The possible arguments, up to 20 arguments
     * @return A localized version of the formatted String
     */
    @CMSelector("+ (instancetype)localizedStringWithFormat:(NSString *)format, ...;")
    public static String localizedStringWithFormat(String format, Object... args) {
        return initWithFormat(format, NSLocale.currentLocale(), args);
    }

    /**
     * Get a localized version of a formatted String
     *
     * @param format The iOS-type formatting
     * @param args   The possible arguments, up to 20 arguments
     * @param loc    The preferred locale
     * @return A localized version of the formatted String
     */
    @CMSelector(value = "- (instancetype)initWithFormat:(NSString *)format \n" +
            "                        locale:(id)locale, ...;", staticMapping = true)
    public static String initWithFormat(String format, NSLocale loc, Object... args) {
        loc = loc == null ? NSLocale.systemLocale() : loc;
        if (I18N_SUPPORT)
            format = I18NBridge.retrieveFormat(format, loc.few, loc.many, args);
        format = objcToJavaFormat(format);
        try {
            return loc == NSLocale.systemLocale()
                    ? String.format(format, args)
                    : String.format(loc.loc, format, args);
        } catch (Exception e) {
            return format;
        }
    }

    private static String objcToJavaFormat(String format) {
        if (format == null)
            throw new IllegalArgumentException("format should not be null");
        for (Pattern pattern : FORMAT_PATTERNS.keySet())
            format = pattern.matcher(format).replaceAll(FORMAT_PATTERNS.get(pattern));
        return format;
    }

    /**
     * Draws the specified string at the specified point using the specified
     * font.
     *
     * @param self  The string that is drawn.
     * @param point The benchmark of the text drawing.
     * @param font  The font that is used.
     * @return The size of the string.
     */
    @Deprecated
    @CMSelector(value = "- (CGSize)drawAtPoint:(CGPoint)point withFont:(UIFont *)font;", staticMapping = true)
    public static CGSize drawAtPoint(String self, CGPoint point, UIFont font) {
        if (self == null || self.isEmpty())
            return new CGSize(0, 0);
        GraphicsContext<?> gcx = context(UIGraphics.getCurrentContext());
        gcx.setFont(font(cgfont(font)));
        gcx.showTextAtPoint(point.getX(), point.getY(), self);
        return sizeWithFont(self, font);
    }

    /**
     * Returns the size that the specified string would have if it was depicted
     * with the specified font.
     *
     * @param self The String for which the size is requested.
     * @param font The font that the String would have.
     * @return The size of the String.
     */
    @Deprecated
    @CMSelector(value = "- (CGSize)sizeWithFont:(UIFont *)font;", staticMapping = true)
    public static CGSize sizeWithFont(String self, UIFont font) {
        return context(UIGraphics.getCurrentContext()).stringSizeWithFont(self, font(cgfont(font)));
    }

    /**
     * Returns the size that the specified string would have if it was depicted
     * with the specified font and line attributes on a single line.
     *
     * @param self            The String for which the size is requested.
     * @param font            The font that the String would have.
     * @param size            The initial size of the String.
     * @param NSLineBreakMode The line break options in order to compute the new
     *                        size.
     * @return The size that the String would have.
     */
    @Deprecated
    @CMSelector(value = "- (CGSize)sizeWithFont:(UIFont *)font\n"
            + "     constrainedToSize:(CGSize)size\n"
            + "         lineBreakMode:(NSLineBreakMode)lineBreakMode ;", staticMapping = true)
    public static CGSize sizeWithFont(String self, UIFont font, CGSize size, int NSLineBreakMode) {
        return TextHelpers.splitStringWithFontAndSize(self, cgfont(font), size.getWidth(), 0, NSLineBreakMode).size;
    }

    /**
     * Writes the specified content to the specified file using the given
     * encoding.
     *
     * @param self             The content that will be written to the file.
     * @param path             The path of the file to which the content will be written.
     * @param atomically       FALSE if the content was written directly, TRUE if
     *                         there was an auxiliary file.
     * @param NSStringEncoding The string encoding.
     * @param error            The error that occurs in case of failure.NULL when there the
     *                         error description is useless.
     * @return TRUE if the operation was successful.
     */
    @CMSelector(value = "- (BOOL)writeToFile:(NSString *)path\n"
            + "         atomically:(BOOL)useAuxiliaryFile\n"
            + "           encoding:(NSStringEncoding)enc\n"
            + "              error:(NSError * _Nullable *)error", staticMapping = true)
    public static boolean writeToFile(String self, String path, boolean atomically, int NSStringEncoding, StrongReference<NSError> error) {
        Writer out = null;
        String outpath = atomically ? path + Math.random() : path;
        try {
            out = new OutputStreamWriter(new FileOutputStream(outpath), convertIntToString(NSStringEncoding));
            out.write(self);
        } catch (IOException ex) {
            return false;
        } finally {
            closeR(out);
        }
        if (atomically)
            return new File(outpath).renameTo(new File(path));
        return true;
    }
}
