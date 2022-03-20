/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.foundation;

import org.crossmobile.bridge.Native;
import org.crossmobile.bridge.ann.CMClass;
import org.crossmobile.bridge.ann.CMSelector;

import java.util.Calendar;

import static crossmobile.ios.foundation.NSCalendarUnit.*;
import static java.util.Calendar.*;

/**
 * NSCalendar class defines defines an object that represents the calendar of
 * the application.
 */
@CMClass
public class NSCalendar extends NSObject implements NSSecureCoding {

    /**
     * Returns user's current calendar.
     *
     * @return The current calendar of the user.
     */
    @CMSelector("+ (NSCalendar *)currentCalendar;")
    public static NSCalendar currentCalendar() {
        return new NSCalendar();
    }

    private NSCalendar() {
    }

    /**
     * Returns a NSDateComponents object that is the representation of the
     * specified date using the specified calendar unit.
     *
     * @param NSCalendarUnit The calendar unit used for the transformation of
     *                       the date.
     * @param fromDate       The initial date.
     * @return The NSDateComponents object that represents this date.
     */
    @CMSelector("- (NSDateComponents *)components:(NSCalendarUnit)unitFlags \n" +
            "                        fromDate:(NSDate *)date;")
    public NSDateComponents components(int NSCalendarUnit, NSDate fromDate) {
        Calendar cal = java.util.Calendar.getInstance();
        cal.setTimeInMillis((long) (fromDate.secondsSince1970 * 1000));
        NSDateComponents comp = new NSDateComponents();

        if ((NSCalendarUnit & Era) != 0)
            comp.era = cal.get(ERA);
        if ((NSCalendarUnit & Year) != 0)
            comp.year = cal.get(YEAR);
        if ((NSCalendarUnit & Month) != 0)
            comp.month = cal.get(MONTH) + 1;
        if ((NSCalendarUnit & Day) != 0)
            comp.day = cal.get(DAY_OF_MONTH);
        if ((NSCalendarUnit & Hour) != 0)
            comp.hour = cal.get(HOUR);
        if ((NSCalendarUnit & Minute) != 0)
            comp.minute = cal.get(MINUTE);
        if ((NSCalendarUnit & Second) != 0)
            comp.second = cal.get(SECOND);
        if ((NSCalendarUnit & Week) != 0)
            comp.week = cal.get(WEEK_OF_YEAR);
        if ((NSCalendarUnit & Weekday) != 0)
            comp.weekday = cal.get(DAY_OF_WEEK);
        if ((NSCalendarUnit & WeekdayOrdinal) != 0)
            comp.weekdayOrdinal = cal.get(DAY_OF_WEEK_IN_MONTH);
        if ((NSCalendarUnit & WeekOfMonth) != 0)
            comp.weekOfMonth = cal.get(WEEK_OF_MONTH);
        if ((NSCalendarUnit & WeekOfYear) != 0)
            comp.weekOfYear = cal.get(WEEK_OF_YEAR);
        return comp;
    }

    /**
     * Returns a NSDateComponents object that results from the subtraction of
     * the two date using the specified options..
     *
     * @param NSCalendarUnit   The calendar unit that is used.
     * @param fromDate         The staring date.
     * @param toDate           The ending date.
     * @param NSDateComponents The components used for the calculation.
     * @return A NSDateComponents object that results.
     */
    @CMSelector("- (NSDateComponents *)components:(NSCalendarUnit)unitFlags \n" +
            "                        fromDate:(NSDate *)startingDate \n" +
            "                          toDate:(NSDate *)resultDate \n" +
            "                         options:(NSCalendarOptions)opts;")
    public NSDateComponents components(int NSCalendarUnit, NSDate fromDate, NSDate toDate, int NSDateComponents) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns a date that results from adding the specified components to the
     * specified date.
     *
     * @param comps  The components to add to the specified date.
     * @param toDate The date to which the components are added.
     * @param opts   Options used for the calculation of the new date.
     * @return The date that is calculated.
     */
    @CMSelector("- (NSDate *)dateByAddingComponents:(NSDateComponents *)comps \n" +
            "                            toDate:(NSDate *)date \n" +
            "                           options:(NSCalendarOptions)opts;")
    public NSDate dateByAddingComponents(NSDateComponents comps, NSDate toDate, int opts) {
        Native.system().notImplemented();
        return null;
    }

    /**
     * Returns a NSDate object that corresponds to the specified date
     * components.
     *
     * @param comps The components of this date.
     * @return A new NSDate object that corresponds to the specified date
     * components.
     */
    @CMSelector("- (NSDate *)dateFromComponents:(NSDateComponents *)comps;")
    public NSDate dateFromComponents(NSDateComponents comps) {
        Calendar cal = java.util.Calendar.getInstance();
        cal.set(HOUR, comps.hour);
        cal.set(MINUTE, comps.minute);
        cal.set(SECOND, comps.second);
        if (comps.era != 0)
            cal.set(ERA, comps.era);
        if (comps.year != 0)
            cal.set(YEAR, comps.year);
        if (comps.month != 0)
            cal.set(MONTH, comps.month - 1);
        if (comps.day != 0)
            cal.set(DAY_OF_MONTH, comps.day);
        if (comps.week != 0)
            cal.set(WEEK_OF_YEAR, comps.week);
        if (comps.weekday != 0)
            cal.set(DAY_OF_WEEK, comps.weekday);
        if (comps.weekdayOrdinal != 0)
            cal.set(DAY_OF_WEEK_IN_MONTH, comps.weekdayOrdinal);
        if (comps.weekOfMonth != 0)
            cal.set(WEEK_OF_MONTH, comps.weekOfMonth);
        if (comps.weekOfYear != 0)
            cal.set(WEEK_OF_YEAR, comps.weekOfYear);
        return NSDate.dateWithTimeIntervalSince1970(cal.getTime().getTime() / 1000d);
    }
}
