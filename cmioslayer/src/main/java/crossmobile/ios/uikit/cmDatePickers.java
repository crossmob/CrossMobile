/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;
import crossmobile.ios.foundation.*;
import org.crossmobile.bridge.Native;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@SuppressWarnings("OverridableMethodCallInConstructor")
class cmDatePickers {

    static abstract class DatePicker extends UIView {

        Calendar calendar = Calendar.getInstance();
        Date maximumDate = null;
        Date minimumDate = null;
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale = Locale.getDefault();
        int interval = 1;
        int UIDatePickerMode = crossmobile.ios.uikit.UIDatePickerMode.DateAndTime;
        double countDownDuration = 0;

        UITableView hourtable;
        UITableView ampmtable;
        UITableView minutetable;
        UITableView monthtable;
        UITableView daytable;
        UITableView yeartable;
        UITableView datetable;
        UIDatePicker parent;

        DatePicker(CGRect frame, UIDatePicker parent) {
            super(new CGRect(0, 0, frame.getSize().getWidth(), frame.getSize().getHeight()));
            this.parent = parent;
            setAutoresizesSubviews(true);
            UIView line = new UIView(new CGRect(0, frame().getSize().getHeight() / 2 - 15, frame().getSize().getWidth(), 1));
            line.setOpaque(true);
            line.setBackgroundColor(UIColor.blackColor());
            addSubview(line);
            UIView line2 = new UIView(new CGRect(0, frame().getSize().getHeight() / 2 + 15, frame().getSize().getWidth(), 1));
            line2.setOpaque(true);
            line2.setBackgroundColor(UIColor.blackColor());
            addSubview(line2);
        }

        UITableView getTable(CGRect rect, final Calendar calendar, final cmPickers.CellType type, final int interval) {
            return new Table(rect, calendar, type, interval);
        }

        void setCalendar(NSCalendar cal) {
            Native.system().notImplemented();
        }

        void setMaximumDate(NSDate maximumDate) {
            if (this.maximumDate == null)
                this.maximumDate = new Date();
            this.maximumDate.setTime((long) (maximumDate.timeIntervalSince1970() * 1000));
        }

        void setMinimumDate(NSDate minimumDate) {
            if (this.minimumDate == null)
                this.minimumDate = new Date();
            this.minimumDate.setTime((long) (minimumDate.timeIntervalSince1970() * 1000));
        }

        void setTimeZone(NSTimeZone timeZone) {
            this.timeZone.setID(timeZone.name());
        }

        void setLocale(NSLocale locale) {
            Native.system().notImplemented();
        }

        void setInterval(int interval) {
            if (interval > 0 && interval <= 30 && interval % 5 == 0)
                this.interval = interval;
            else
                this.interval = 1;
        }

        void setCountDownDuration(int countDownDuration) {
            this.countDownDuration = countDownDuration;
        }

        void checkDate() {
            parent.sendActionsForControlEvents(UIControlEvents.ValueChanged);
        }

        void checkAMPM() {

        }

        abstract NSDate getDate();

        void setDate(NSDate date) {
            setDate(date, false);
        }

        abstract void setDate(NSDate date, boolean animated);
    }

    static class DateAndTime extends DatePicker {

        DateAndTime(CGRect frame, UIDatePicker parent) {
            super(new CGRect(0, 0, frame.getSize().getWidth(), frame.getSize().getHeight()), parent);
            datetable = getTable(new CGRect(0, 0, frame().getSize().getWidth() / 2, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.DateCell, interval);
            hourtable = getTable(new CGRect(frame().getSize().getWidth() / 2, 0, (frame().getSize().getWidth() / 2) / 3, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.HourCell, interval);
            minutetable = getTable(new CGRect(((1 * frame().getSize().getWidth() / 2) / 3) + frame().getSize().getWidth() / 2, 0, (frame().getSize().getWidth() / 2) / 3, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.MinuteCell, interval);
            ampmtable = getTable(new CGRect(((2 * frame().getSize().getWidth() / 2) / 3) + frame().getSize().getWidth() / 2, 0, (frame().getSize().getWidth() / 2) / 3, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.AMPMCell, interval);
            addSubview(datetable);
            addSubview(hourtable);
            addSubview(minutetable);
            addSubview(ampmtable);
        }

        @Override
        NSDate getDate() {
            calendar.set(((Table) datetable).getCalendar().get(Calendar.YEAR),
                    ((Table) datetable).getCalendar().get(Calendar.MONTH),
                    ((Table) datetable).getCalendar().get(Calendar.DATE),
                    ((Table) hourtable).getCalendar().get(Calendar.HOUR),
                    ((Table) minutetable).getCalendar().get(Calendar.MINUTE));
            calendar.set(Calendar.AM_PM, ((Table) ampmtable).getCalendar().get(Calendar.AM_PM));
            return NSDate.dateWithTimeIntervalSince1970(calendar.getTime().getTime() / 1000d);

        }

        @Override
        void checkDate() {
            super.checkDate();
            Calendar cal = Calendar.getInstance();
            cal.set(((Table) datetable).getCalendar().get(Calendar.YEAR),
                    ((Table) datetable).getCalendar().get(Calendar.MONTH),
                    ((Table) datetable).getCalendar().get(Calendar.DATE),
                    ((Table) hourtable).getCalendar().get(Calendar.HOUR),
                    ((Table) minutetable).getCalendar().get(Calendar.MINUTE));
            calendar.set(Calendar.AM_PM, ((Table) ampmtable).getCalendar().get(Calendar.AM_PM));
            if (maximumDate != null && cal.getTime().after(maximumDate))
                setDate(NSDate.dateWithTimeIntervalSince1970(maximumDate.getTime() / 1000d), true);
            if (minimumDate != null && cal.getTime().before(minimumDate))
                setDate(NSDate.dateWithTimeIntervalSince1970(minimumDate.getTime() / 1000d), true);

        }

        @Override
        void checkAMPM() {
            if (((Table) hourtable).getCalendar().get(Calendar.AM_PM) != ((Table) ampmtable).getCalendar().get(Calendar.AM_PM))
                ampmtable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(((Table) hourtable).getCalendar().get(Calendar.AM_PM), 0), UITableViewScrollPosition.Top, true);
        }

        @Override
        void setDate(NSDate date, boolean animated) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date((long) (date.timeIntervalSince1970() * 1000d)));
            datetable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.YEAR) * cal.get(Calendar.DATE) * (cal.get(Calendar.MONTH) + 1) - calendar.get(Calendar.YEAR) * calendar.get(Calendar.DATE) * (cal.get(Calendar.MONTH) + 1) + 100000, 0), UITableViewScrollPosition.Top, true);
            hourtable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.HOUR) - calendar.get(Calendar.HOUR) + 100000, 0), UITableViewScrollPosition.Top, true);
            minutetable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.MINUTE) - calendar.get(Calendar.MINUTE) + 100000, 0), UITableViewScrollPosition.Top, true);
            ampmtable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.AM_PM), 0), UITableViewScrollPosition.Top, true);
        }

    }

    static class Date1 extends DatePicker {

        Date1(CGRect frame, UIDatePicker parent) {
            super(new CGRect(0, 0, frame.getSize().getWidth(), frame.getSize().getHeight()), parent);
            monthtable = getTable(new CGRect(0, 0, frame().getSize().getWidth() / 2, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.MonthCell, interval);
            daytable = getTable(new CGRect(frame().getSize().getWidth() / 2, 0, frame().getSize().getWidth() / 4, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.DayCell, interval);
            yeartable = getTable(new CGRect(frame().getSize().getWidth() / 2 + frame().getSize().getWidth() / 4, 0, frame().getSize().getWidth() / 4, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.YearCell, interval);
            addSubview(monthtable);
            addSubview(daytable);
            addSubview(yeartable);
        }

        @Override
        NSDate getDate() {
            calendar.set(((Table) yeartable).getCalendar().get(Calendar.YEAR),
                    ((Table) monthtable).getCalendar().get(Calendar.MONTH),
                    ((Table) daytable).getCalendar().get(Calendar.DATE));

            return NSDate.dateWithTimeIntervalSince1970(calendar.getTime().getTime() / 1000d);
        }

        @Override
        void checkDate() {
            super.checkDate();
            Calendar cal = Calendar.getInstance();
            cal.set(((Table) yeartable).getCalendar().get(Calendar.YEAR),
                    ((Table) monthtable).getCalendar().get(Calendar.MONTH),
                    ((Table) daytable).getCalendar().get(Calendar.DATE));
            if (maximumDate != null && cal.getTime().after(maximumDate))
                setDate(NSDate.dateWithTimeIntervalSince1970(maximumDate.getTime() / 1000d), true);
            if (minimumDate != null && cal.getTime().before(minimumDate))
                setDate(NSDate.dateWithTimeIntervalSince1970(minimumDate.getTime() / 1000d), true);
        }

        @Override
        void setDate(NSDate date, boolean animated) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date((long) (date.timeIntervalSince1970() * 1000d)));
            yeartable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.YEAR) - 1, 0), UITableViewScrollPosition.Top, true);
            monthtable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.MONTH) - calendar.get(Calendar.MONTH) + 100000, 0), UITableViewScrollPosition.Top, true);
            daytable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.DATE) - calendar.get(Calendar.DATE) + 100000, 0), UITableViewScrollPosition.Top, true);
        }

    }

    static class Time extends DatePicker {

        Time(CGRect frame, UIDatePicker parent) {
            super(new CGRect(0, 0, frame.getSize().getWidth(), frame.getSize().getHeight()), parent);
            hourtable = getTable(new CGRect(0, 0, frame().getSize().getWidth() / 3, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.HourCell, interval);
            minutetable = getTable(new CGRect(frame().getSize().getWidth() / 3, 0, frame().getSize().getWidth() / 3, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.MinuteCell, interval);
            ampmtable = getTable(new CGRect(2 * frame().getSize().getWidth() / 3, 0, frame().getSize().getWidth() / 3, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.AMPMCell, interval);
            addSubview(hourtable);
            addSubview(minutetable);
            addSubview(ampmtable);
        }

        @Override
        NSDate getDate() {
            calendar.set(Calendar.HOUR_OF_DAY, ((Table) hourtable).getCalendar().get(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, ((Table) minutetable).getCalendar().get(Calendar.MINUTE));

            return NSDate.dateWithTimeIntervalSince1970(calendar.getTime().getTime() / 1000d);
        }

        @Override
        void checkDate() {
            super.checkDate();
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.HOUR_OF_DAY, ((Table) hourtable).getCalendar().get(Calendar.HOUR_OF_DAY));
            cal.set(Calendar.MINUTE, ((Table) minutetable).getCalendar().get(Calendar.MINUTE));
            calendar.set(Calendar.AM_PM, ((Table) ampmtable).getCalendar().get(Calendar.AM_PM));
            if (maximumDate != null && cal.getTime().after(maximumDate))
                setDate(NSDate.dateWithTimeIntervalSince1970(maximumDate.getTime() / 1000d), true);
            if (minimumDate != null && cal.getTime().before(minimumDate))
                setDate(NSDate.dateWithTimeIntervalSince1970(minimumDate.getTime() / 1000d), true);

        }

        @Override
        void checkAMPM() {
            if (((Table) hourtable).getCalendar().get(Calendar.AM_PM) != ((Table) ampmtable).getCalendar().get(Calendar.AM_PM))
                ampmtable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(((Table) hourtable).getCalendar().get(Calendar.AM_PM), 0), UITableViewScrollPosition.Top, true);
        }

        @Override
        void setDate(NSDate date, boolean animated) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date((long) (date.timeIntervalSince1970() * 1000d)));
            hourtable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.HOUR) - calendar.get(Calendar.HOUR) + 100000, 0), UITableViewScrollPosition.Top, true);
            minutetable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.MINUTE) - calendar.get(Calendar.MINUTE) + 100000, 0), UITableViewScrollPosition.Top, true);
            ampmtable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.AM_PM), 0), UITableViewScrollPosition.Top, true);
        }

    }

    static class CountDown extends DatePicker {

        CountDown(CGRect frame, UIDatePicker parent) {
            super(new CGRect(0, 0, frame.getSize().getWidth(), frame.getSize().getHeight()), parent);
            UILabel hours = new UILabel(new CGRect(0, 0, frame().getSize().getWidth() / 2, frame().getSize().getHeight()));
            hours.setText("hours");
            hours.setTextAlignment(UITextAlignment.Right);
            UILabel minutes = new UILabel(new CGRect(frame().getSize().getWidth() / 2, 0, frame().getSize().getWidth() / 2, frame().getSize().getHeight()));
            minutes.setText("min");
            minutes.setTextAlignment(UITextAlignment.Right);
            hourtable = getTable(new CGRect(0, 0, frame().getSize().getWidth() / 2, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.CountDownHourCell, interval);
            minutetable = getTable(new CGRect(frame().getSize().getWidth() / 2, 0, frame().getSize().getWidth() / 2, frame().getSize().getHeight()), Calendar.getInstance(), cmPickers.CellType.CountDownMinuteCell, interval);
            addSubview(hours);
            addSubview(minutes);
            addSubview(hourtable);
            addSubview(minutetable);
        }

        @Override
        NSDate getDate() {
            calendar.set(Calendar.HOUR_OF_DAY, ((Table) hourtable).getCalendar().get(Calendar.HOUR_OF_DAY));
            calendar.set(Calendar.MINUTE, ((Table) minutetable).getCalendar().get(Calendar.MINUTE));

            return NSDate.dateWithTimeIntervalSince1970(calendar.getTime().getTime() / 1000d);
        }

        @Override
        void setDate(NSDate date, boolean animated) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date((long) (date.timeIntervalSince1970() * 1000d)));
            hourtable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.HOUR_OF_DAY) - calendar.get(Calendar.HOUR_OF_DAY) + 100000, 0), UITableViewScrollPosition.Top, true);
            minutetable.scrollToRowAtIndexPath(NSIndexPath.indexPathForRow(cal.get(Calendar.MINUTE) - calendar.get(Calendar.MINUTE) + 100000, 0), UITableViewScrollPosition.Top, true);
        }

    }

    static class Table extends cmPickers.PickerTable {

        final int interval;
        Calendar calendar;

        Table(CGRect rect, Calendar calendar, final cmPickers.CellType type, int interval) {
            super(rect);
            this.interval = interval;
            this.calendar = calendar;
            setContentInset(new UIEdgeInsets(rect.getSize().getHeight() / 2 - 15, 0, rect.getSize().getHeight() / 2 - 15, 0));
            setDataSource(new UITableViewDataSource() {

                @Override
                public UITableViewCell cellForRowAtIndexPath(UITableView table, NSIndexPath idx) {
                    cmCells.AbstractCalendarCell cell = getCell(table, type);
                    cell.update(idx.row());
                    return cell;
                }

                @Override
                public int numberOfRowsInSection(UITableView table, int section) {
                    switch (type) {
                        case AMPMCell:
                            return 2;
                        case CountDownHourCell:
                            return 30;
                        default:
                            return Integer.MAX_VALUE;
                    }

                }

            });
            setDelegate(new UITableViewDelegate() {

                            @Override
                            public void didSelectRowAtIndexPath(UITableView tableview, NSIndexPath indexPath) {
                                scrollToRowAtIndexPath(indexPath, UITableViewScrollPosition.Top, true);
                                setCalendar(((cmCells.AbstractCalendarCell) dataSource().cellForRowAtIndexPath(tableview, indexPath)).getCalendar());
                                if (superview() != null) {
                                    ((DatePicker) superview()).checkDate();
                                    if (type == cmPickers.CellType.HourCell)
                                        ((DatePicker) superview()).checkAMPM();
                                }
                            }
                        }
            );
            NSIndexPath index = type.getIndex(calendar);
            scrollToRowAtIndexPath(index, UITableViewScrollPosition.Top, false);
            setShowsVerticalScrollIndicator(false);
            setSeparatorStyle(UITableViewCellSeparatorStyle.None);
        }

        private void setCalendar(Calendar calendar) {
            this.calendar = calendar;
        }

        Calendar getCalendar() {
            return calendar;
        }

        cmCells.AbstractCalendarCell getCell(UITableView table, cmPickers.CellType type) {
            switch (type) {
                case MinuteCell:
                    return new cmCells.MinuteCell(table.frame(), interval);
                case CountDownMinuteCell:
                    return new cmCells.CountDownMinuteCell(table.frame(), interval);
                case HourCell:
                    return new cmCells.HourCell(table.frame());
                case CountDownHourCell:
                    return new cmCells.CountDownHourCell(table.frame());
                case DateCell:
                    return new cmCells.DateCell(table.frame());
                case AMPMCell:
                    return new cmCells.AMPMCell(table.frame());
                case YearCell:
                    return new cmCells.YearCell(table.frame());
                case MonthCell:
                    return new cmCells.MonthCell(table.frame());
                case DayCell:
                    return new cmCells.DayCell(table.frame());
                default:
                    return null;
            }
        }

    }

}
