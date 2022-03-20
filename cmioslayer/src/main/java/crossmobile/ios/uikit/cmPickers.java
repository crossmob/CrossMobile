/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGPoint;
import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.*;

import java.util.Calendar;

class cmPickers {

    static enum CellType {

        MinuteCell,
        CountDownMinuteCell,
        HourCell,
        CountDownHourCell,
        DateCell,
        AMPMCell,
        YearCell,
        MonthCell,
        DayCell;

        NSIndexPath getIndex(Calendar calendar) {
            switch (this) {
                case MinuteCell:
                    return NSIndexPath.indexPathForRow(100000, 0);
                case CountDownMinuteCell:
                    return NSIndexPath.indexPathForRow(100000, 0);
                case HourCell:
                    return NSIndexPath.indexPathForRow(100000, 0);
                case CountDownHourCell:
                    return NSIndexPath.indexPathForRow(calendar.get(Calendar.HOUR_OF_DAY) + 3, 0);
                case DateCell:
                    return NSIndexPath.indexPathForRow(100000, 0);
                case YearCell:
                    return NSIndexPath.indexPathForRow(calendar.get(Calendar.YEAR) - 1, 0);
                case MonthCell:
                    return NSIndexPath.indexPathForRow(100000, 0);
                case DayCell:
                    return NSIndexPath.indexPathForRow(100000, 0);
                case AMPMCell:
                    return NSIndexPath.indexPathForRow(Calendar.getInstance().get(Calendar.AM_PM), 0);
                default:
                    return null;

            }
        }

    }

    static final class DatePickerView extends UIView {

        private cmDatePickers.DatePicker dpview;
        UIDatePicker parent;

        @SuppressWarnings("OverridableMethodCallInConstructor")
        DatePickerView(CGRect frame, UIDatePicker parent) {
            super(frame);
            setAutoresizesSubviews(true);
            dpview = new cmDatePickers.DateAndTime(frame, parent);
            addSubview(dpview);
            this.parent = parent;
        }

        void setCalendar(NSCalendar cal) {
            dpview.setCalendar(cal);
        }

        void setMaximumDate(NSDate maximumDate) {
            dpview.setMaximumDate(maximumDate);
        }

        void setMinimumDate(NSDate minimumDate) {
            dpview.setMinimumDate(minimumDate);
        }

        void setTimeZone(NSTimeZone timeZone) {
            dpview.timeZone.setID(timeZone.name());
        }

        void setLocale(NSLocale locale) {
            dpview.setLocale(locale);
        }

        void setInterval(int interval) {
            if (interval > 0 && interval <= 30 && interval % 5 == 0)
                dpview.interval = interval;
            else
                dpview.interval = 1;
        }

        void setUIDatePickerMode(int UIDatePickerMode) {
            dpview.UIDatePickerMode = UIDatePickerMode;
            switch (UIDatePickerMode) {
                case crossmobile.ios.uikit.UIDatePickerMode.DateAndTime:
                    dpview.removeFromSuperview();
                    dpview = new cmDatePickers.DateAndTime(frame(), parent);
                    addSubview(dpview);
                    break;
                case crossmobile.ios.uikit.UIDatePickerMode.Date:
                    dpview.removeFromSuperview();
                    dpview = new cmDatePickers.Date1(frame(), parent);
                    addSubview(dpview);
                    break;
                case crossmobile.ios.uikit.UIDatePickerMode.Time:
                    dpview.removeFromSuperview();
                    dpview = new cmDatePickers.Time(frame(), parent);
                    addSubview(dpview);
                    break;
                case crossmobile.ios.uikit.UIDatePickerMode.CountDownTimer:
                    dpview.removeFromSuperview();
                    dpview = new cmDatePickers.CountDown(frame(), parent);
                    addSubview(dpview);
                    break;
            }
        }

        void setCountDownDuration(double countDownDuration) {
            dpview.countDownDuration = countDownDuration;
        }

        NSDate getDate() {
            return dpview.getDate();
        }

        void setDate(NSDate date) {
            dpview.setDate(date);
        }

        void setDate(NSDate date, boolean animated) {
            dpview.setDate(date, animated);
        }

    }

    static class PickerTable extends UITableView {

        @SuppressWarnings("OverridableMethodCallInConstructor")
        public PickerTable(final CGRect rect) {
            super(rect, UITableViewStyle.Plain);
            setAllowsMultipleSelection(false);
            setBounces(true);
            setDelegate(new UIScrollViewDelegate() {
                @Override
                public void didScroll(UIScrollView scrollView) {
                    layoutSubviews();
                }

                @Override
                public void didEndScrollingAnimation(UIScrollView scrollView) {
                    tableViewDelegate().didSelectRowAtIndexPath(PickerTable.this, indexPathForRowAtPoint(new CGPoint(rect.getSize().getWidth() / 2, contentOffset.getY() + rect.getSize().getHeight() / 2)));
                }
            });
        }
    }
}
