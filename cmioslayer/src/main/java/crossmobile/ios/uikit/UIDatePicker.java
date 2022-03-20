/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.NSCalendar;
import crossmobile.ios.foundation.NSDate;
import crossmobile.ios.foundation.NSLocale;
import crossmobile.ios.foundation.NSTimeZone;
import org.crossmobile.bridge.ann.*;

/**
 * UIDatePicker class defines an object that can be added in an application and
 * allows the user to select specific dates and/or hours or define intervals of
 * dates or hours. The user is able to select by scrolling down options thats
 * represent dates,hours,minutes or seconds.
 */
@CMClass
public class UIDatePicker extends UIControl {

    private NSCalendar calendar;
    private NSDate date;
    private NSLocale locale;
    private NSTimeZone timeZone;
    private int datePickerMode;
    private NSDate maximumDate;
    private NSDate minimumDate;
    private int minuteInterval;
    private double countDownDuration;
    private cmPickers.DatePickerView picker;

    /**
     * Constructs a default UIDatePicker object located at (0,0) with 0 weight
     * and 0 height.
     */
    public UIDatePicker() {
        this(CGRect.zero());
    }

    /**
     * Constructs a UIDatePicker object initialized with the dimensions and
     * position specified in the rect parameter.
     *
     * @param rect CGRect that defines dimension and position of UIDatePicker.
     */
    @CMConstructor("- (instancetype)initWithFrame:(CGRect)frame;")
    public UIDatePicker(CGRect rect) {
        super(rect);
        picker = new cmPickers.DatePickerView(new CGRect(0, 0, cframe().getSize().getWidth(), cframe().getSize().getHeight()), this);
        addSubview(picker);
    }

    /**
     * Returns the NSCalendar used on this date picker.
     *
     * @return The NSCalendar used on this date picker.
     */
    @CMGetter("@property(nonatomic, copy) NSCalendar *calendar;")
    public NSCalendar calendar() {
        return calendar;
    }

    /**
     * Sets the calendar type for this date picker specified by the parameter.
     * If NULL, then it uses the default value.
     *
     * @param calendar The calendar for the date picker.
     */
    @CMSetter("@property(nonatomic, copy) NSCalendar *calendar;")
    public void setCalendar(NSCalendar calendar) {
        picker.setCalendar(calendar);
        this.calendar = calendar;
    }

    /**
     * Returns the seconds from which the timer starts the count down.
     *
     * @return The seconds from which starts the timer the count down.
     */
    @CMGetter("@property(nonatomic) NSTimeInterval countDownDuration;")
    public double countDownDuration() {
        return countDownDuration;
    }

    /**
     * Sets the seconds from which the timer will start the count down.
     *
     * @param countDownDuration The seconds from which the timer will start the
     *                          count down.
     */
    @CMSetter("@property(nonatomic) NSTimeInterval countDownDuration;")
    public void setCountDownDuration(double countDownDuration) {
        picker.setCountDownDuration(countDownDuration);
        this.countDownDuration = countDownDuration;
        setNeedsDisplay();
    }

    /**
     * Returns the date of this date picker.
     *
     * @return The date of this date picker.
     */
    @CMGetter("@property(nonatomic, strong) NSDate *date;")
    public NSDate date() {
        return picker.getDate();
    }

    /**
     * Sets the date for this date picker.
     *
     * @param date The date that will be displayed on this date picker.
     */
    @CMSetter("@property(nonatomic, strong) NSDate *date;")
    public void setDate(NSDate date) {
        picker.setDate(date);
        this.date = date;
        setNeedsDisplay();
    }

    /**
     * Returns a number that defines the type of this date picker.
     *
     * @return The type of this date picker.
     */
    @CMGetter("@property(nonatomic) UIDatePickerMode datePickerMode;")
    public int datePickerMode() {
        return datePickerMode;
    }

    /**
     * Sets the type for this date picker
     *
     * @param UIDatePickerMode The type of date picker.
     */
    @CMSetter("@property(nonatomic) UIDatePickerMode datePickerMode;")
    public void setDatePickerMode(int UIDatePickerMode) {
        picker.setUIDatePickerMode(UIDatePickerMode);
        this.datePickerMode = UIDatePickerMode;
        setNeedsDisplay();
    }

    /**
     * Returns the locale of this date picker.
     *
     * @return The locale of this date picker.
     */
    @CMGetter("@property(nonatomic, strong) NSLocale *locale;")
    public NSLocale locale() {
        return locale;
    }

    /**
     * Sets the local format of date that this date picker will display.
     *
     * @param locale The local format of date that this date picker will
     *               display.
     */
    @CMSetter("@property(nonatomic, strong) NSLocale *locale;")
    public void setLocale(NSLocale locale) {
        picker.setLocale(locale);
        this.locale = locale;
        setNeedsDisplay();
    }

    /**
     * Returns the maximum date of this date picker.
     *
     * @return The maximum date that the date picker displays.
     */
    @CMGetter("@property(nonatomic, strong) NSDate *maximumDate;")
    public NSDate maximumDate() {
        return maximumDate;
    }

    /**
     * Sets the maximum date of this date picker. Used along with setMinimumDate
     * or not when defining delimited dates.
     *
     * @param maximumDate The maximum date that this date picker will display.
     */
    @CMSetter("@property(nonatomic, strong) NSDate *maximumDate;")
    public void setMaximumDate(NSDate maximumDate) {
        picker.setMaximumDate(maximumDate);
        this.maximumDate = maximumDate;
        setNeedsDisplay();
    }

    /**
     * Returns the minimum date of this date picker.
     *
     * @return The minimum date that the date picker displays.
     */
    @CMGetter("@property(nonatomic, strong) NSDate *minimumDate;")
    public NSDate minimumDate() {
        return minimumDate;
    }

    /**
     * Sets the minimum date that this date picker can display. Used along with
     * setMaximumDate or not when defining delimited dates.
     *
     * @param minimumDate The minimum date that this date picker will display.
     */
    @CMSetter("@property(nonatomic, strong) NSDate *minimumDate;")
    public void setMinimumDate(NSDate minimumDate) {
        picker.setMinimumDate(minimumDate);
        this.minimumDate = minimumDate;
        setNeedsDisplay();
    }

    /**
     * The interval at which the date picker should display minutes.
     *
     * @return The interval at which the date picker should display minutes.
     */
    @CMGetter("@property(nonatomic) NSInteger minuteInterval;")
    public int minuteInterval() {
        return minuteInterval;
    }

    /**
     * The interval at which the date picker should display minutes.
     *
     * @param minuteInterval The interval at which the date picker should
     *                       display minutes.
     */
    @CMSetter("@property(nonatomic) NSInteger minuteInterval;")
    public void setMinuteInterval(int minuteInterval) {
        picker.setInterval(minuteInterval);
        this.minuteInterval = minuteInterval;
        setNeedsDisplay();
    }

    /**
     * Returns the time zone of the date picker expressed as NSTimeZone object.
     *
     * @return The time zone of the date picker.
     */
    @CMGetter("@property(nonatomic, strong) NSTimeZone *timeZone;")
    public NSTimeZone timeZone() {
        return timeZone;
    }

    /**
     * Sets the time zone of this date picker.
     *
     * @param timeZone The preferred time zone.
     */
    @CMSetter("@property(nonatomic, strong) NSTimeZone *timeZone;")
    public void setTimeZone(NSTimeZone timeZone) {
        picker.setTimeZone(timeZone);
        this.timeZone = timeZone;
        setNeedsDisplay();
    }

    /**
     * Sets the date of date picker applying animation through the change or
     * not.
     *
     * @param date     The preferred date of the date picker defined as NSDate
     *                 object.
     * @param animated Boolean value that defines whether the change will be
     *                 animated or not.
     */
    @CMSelector("- (void)setDate:(NSDate *)date \n"
            + "       animated:(BOOL)animated;")
    public void setDate(NSDate date, boolean animated) {
        picker.setDate(date, animated);
        setNeedsDisplay();
    }
}
