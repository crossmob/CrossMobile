/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMGetter;
import org.crossmobile.bridge.ann.CMSelector;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * NSDate class defines an object that represents the date as a instance of
 * time.
 */
@CMClass
public class NSDate extends NSObject implements NSSecureCoding {

    private static final double MILLENIUMDIFF = 978307200;
    private static SimpleDateFormat[] GMT_FORMATS;

    final double secondsSince1970;

    static NSDate fromGMT(String date) {
        initDateFormatters();
        for (int i = 0; i < GMT_FORMATS.length; i++)
            try {
                return new NSDate(GMT_FORMATS[i].parse(date).getTime() / 1000d);
            } catch (ParseException ex) {
            }
        return null;
    }

    /**
     * Constructs and returns a new date object for the current date and time.
     *
     * @return The new date object.
     */
    @CMSelector("+ (instancetype)date;")
    public static NSDate date() {
        return new NSDate(System.currentTimeMillis() / 1000d);
    }

    /**
     * Constructs and returns a date object spaced from 00:00:00 UTC on 1
     * January 1970, interval that corresponds to the given seconds.
     *
     * @param seconds The seconds that specify the new NSDate object.
     * @return The new date object.
     */
    @CMSelector("+ (instancetype)dateWithTimeIntervalSince1970:(NSTimeInterval)secs;")
    public static NSDate dateWithTimeIntervalSince1970(double seconds) {
        return new NSDate(seconds);
    }

    /**
     * Constructs and returns a date object spaced from 00:00:00 UTC on 1
     * January 2001, interval that corresponds to the given seconds.
     *
     * @param seconds The seconds that specify the new NSDate object.
     * @return The new date object.
     */
    @CMSelector("+ (instancetype)dateWithTimeIntervalSinceReferenceDate:(NSTimeInterval)ti;")
    public static NSDate dateWithTimeIntervalSinceReferenceDate(double seconds) {
        return new NSDate(seconds + MILLENIUMDIFF);
    }

    /**
     * Constructs and returns a date object spaced from the current date,
     * interval that corresponds to the given seconds.
     *
     * @param seconds The seconds that specify the new NSDate object.
     * @return The new date object.
     */
    @CMSelector("+ (instancetype)dateWithTimeIntervalSinceNow:(NSTimeInterval)secs;")
    public static NSDate dateWithTimeIntervalSinceNow(double seconds) {
        return new NSDate(System.currentTimeMillis() / 1000d + seconds);
    }

    /**
     * Constructs and returns a date object spaced from the specified date,
     * interval that corresponds to the given seconds.
     *
     * @param seconds       The seconds that specify the new NSDate object.
     * @param referenceDate The reference date.
     * @return The new date object.
     */
    @CMSelector("+ (instancetype)dateWithTimeInterval:(NSTimeInterval)secsToBeAdded sinceDate:(NSDate *)date;")
    public static NSDate dateWithTimeInterval(double seconds, NSDate referenceDate) {
        return new NSDate(seconds + referenceDate.secondsSince1970);
    }

    /**
     * Constructs an date object for the specified seconds.
     *
     * @param seconds The seconds that specify the new date object.
     */
    private NSDate(double seconds) {
        this.secondsSince1970 = seconds;
    }

    /**
     * Returns the interval between 00:00:00 UTC on 1 January 2001 and this
     * date.
     *
     * @return The interval between 00:00:00 UTC on 1 January 2001 and this
     * date.
     */
    @CMGetter("@property(readonly) NSTimeInterval timeIntervalSinceReferenceDate;")
    public double timeIntervalSinceReferenceDate() {
        return secondsSince1970 - MILLENIUMDIFF;
    }

    /**
     * Returns the interval between 00:00:00 UTC on 1 January 1970 and this
     * date.
     *
     * @return The interval between 00:00:00 UTC on 1 January 1970 and this
     * date.
     */
    @CMGetter("@property(readonly) NSTimeInterval timeIntervalSince1970;")
    public double timeIntervalSince1970() {
        return secondsSince1970;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof NSDate))
            return false;
        return ((NSDate) o).secondsSince1970 == secondsSince1970;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.secondsSince1970) ^ (Double.doubleToLongBits(this.secondsSince1970) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        initDateFormatters();
        return GMT_FORMATS[0].format(new Date((long) (secondsSince1970 * 1000)));
    }

    private static void initDateFormatters() {
        if (GMT_FORMATS == null) {
            String[] formats = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy"};
            GMT_FORMATS = new SimpleDateFormat[formats.length];
            for (int i = 0; i < formats.length; i++) {
                GMT_FORMATS[i] = new SimpleDateFormat(formats[i], Locale.US);
                GMT_FORMATS[i].setTimeZone(TimeZone.getTimeZone("GMT"));
            }
        }
    }
}
