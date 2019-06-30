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
package crossmobile.ios.foundation;

import org.crossmobile.bridge.ann.CMEnum;

/**
 * NSCalendarUnit class defines calendar units such as months,days etc.
 */
@CMEnum
public final class NSCalendarUnit {

    /**
     * The era unit.
     */
    public static final int Era = 2;

    /**
     * The year unit.
     */
    public static final int Year = 4;

    /**
     * The month unit.
     */
    public static final int Month = 8;

    /**
     * The day unit.
     */
    public static final int Day = 16;

    /**
     * The hour unit.
     */
    public static final int Hour = 32;

    /**
     * The minute unit.
     */
    public static final int Minute = 64;

    /**
     * The second unit.
     */
    public static final int Second = 128;

    /**
     * The week unit.
     */
    public static final int Week = 256;

    /**
     * The day of the week unit.
     */
    public static final int Weekday = 512;

    /**
     * The unit that represents the order of the day within the week.
     */
    public static final int WeekdayOrdinal = 1024;

    /**
     * The quarter of the calendar.
     */
    public static final int Quarter = 2048;

    /**
     * The unit that represents the order of the week within the month.
     */
    public static final int WeekOfMonth = 4096;

    /**
     * The unit that represents the week of the year.
     */
    public static final int WeekOfYear = 8192;

    /**
     * The year in case of a week-based calendar.
     */
    public static final int YearForWeekOfYear = 16384;

    /**
     * The NSCalendar of the date.
     */
    public static final int Calendar = 1 << 20;

    /**
     * The NSTimeZone of the date.
     */
    public static final int TimeZone = 1 << 21;

    private NSCalendarUnit() {
    }
}
