/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package crossmobile.ios.uikit;

import crossmobile.ios.coregraphics.CGRect;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;

class cmCells {

    static class AbstractCell extends UITableViewCell {

        UILabel label;
        List<Object> list;
        private final float width;
        private final float height;

        public AbstractCell(float width, float height, List<Object> list) {
            super(UITableViewCellStyle.Default, null);
            this.list = list;
            this.width = width;
            this.height = height;
            setSelectionStyle(UITableViewCellSelectionStyle.None);
            if (list.get(0) instanceof String) {
                label = new UILabel(new CGRect(0, 0, width, height));
                label.setTextAlignment(UITextAlignment.Center);
                addSubview(label);
            }
        }

        public void update(int idx) {
            if (list.get(idx) instanceof String)
                label.setText((String) list.get(idx));
            else
                addSubview((UIView) list.get(idx));
        }

        String getValue() {
            return label.text();
        }
    }

    abstract static class AbstractCalendarCell extends UITableViewCell {

        UILabel label;
        Calendar calendar;
        CGRect rect;

        AbstractCalendarCell(CGRect rect) {
            super(UITableViewCellStyle.Default, null);
            calendar = Calendar.getInstance();
            this.rect = rect;
            setSelectionStyle(UITableViewCellSelectionStyle.None);
            label = new UILabel(new CGRect(0, 0, rect.getSize().getWidth(), 30));
            label.setTextAlignment(UITextAlignment.Center);
            addSubview(label);
        }

        Calendar getCalendar() {
            return calendar;
        }

        abstract public void update(int idx);
    }

    static class MinuteCell extends AbstractCalendarCell {

        int interval;

        MinuteCell(CGRect rect, int interval) {
            super(rect);
            this.interval = interval;
        }

        @Override
        public void update(int idx) {
            idx -= 100000;
            calendar.roll(Calendar.MINUTE, -calendar.get(Calendar.MINUTE) % interval);
            calendar.roll(Calendar.MINUTE, idx * interval);
            label.setText(Integer.toString((calendar.get(Calendar.MINUTE) == 0) ? 60 : calendar.get(Calendar.MINUTE)));
        }
    }

    static class CountDownMinuteCell extends MinuteCell {

        public CountDownMinuteCell(CGRect rect, int interval) {
            super(rect, interval);
        }

        @Override
        public void update(int idx) {
            super.update(idx);
        }
    }

    static class HourCell extends AbstractCalendarCell {

        HourCell(CGRect rect) {
            super(rect);
        }

        @Override
        public void update(int idx) {
            idx -= 100000;
            if ((calendar.get(Calendar.HOUR) == 0 ? 12 : calendar.get(Calendar.HOUR)) + idx > 12)
                calendar.roll(Calendar.AM_PM, (((calendar.get(Calendar.HOUR) == 0 ? 12 : calendar.get(Calendar.HOUR)) + idx) / (calendar.getActualMaximum(Calendar.HOUR) + 1)));
            if ((calendar.get(Calendar.HOUR) == 0 ? 12 : calendar.get(Calendar.HOUR)) + idx < 1)
                calendar.roll(Calendar.AM_PM, -((((calendar.get(Calendar.HOUR) == 0 ? 12 : calendar.get(Calendar.HOUR)) + idx) / (calendar.getActualMaximum(Calendar.HOUR) + 1)) + 1));
            calendar.roll(Calendar.HOUR, idx);
            label.setText(Integer.toString((calendar.get(Calendar.HOUR) == 0) ? 12 : calendar.get(Calendar.HOUR)));
        }
    }

    static class CountDownHourCell extends HourCell {

        CountDownHourCell(CGRect rect) {
            super(rect);
            label.setTextAlignment(UITextAlignment.Left);
        }

        @Override
        public void update(int idx) {
            idx -= calendar.get(Calendar.HOUR_OF_DAY) + 3;
            if (idx < -calendar.get(Calendar.HOUR_OF_DAY) || idx > 23 - calendar.get(Calendar.HOUR_OF_DAY))
                label.setText("");
            else {
                calendar.roll(Calendar.HOUR_OF_DAY, idx);
                label.setText("     " + Integer.toString(calendar.get(Calendar.HOUR_OF_DAY)));
            }
        }
    }

    static class DateCell extends AbstractCalendarCell {

        long first = 0;

        DateCell(CGRect rect) {
            super(rect);
            label.setTextAlignment(UITextAlignment.Right);
        }

        @Override
        public void update(int idx) {
            idx -= 100000;
            if (calendar.get(Calendar.DAY_OF_YEAR) + idx > calendar.getActualMaximum(Calendar.DAY_OF_YEAR))
                calendar.roll(Calendar.YEAR, (idx / calendar.getActualMaximum(Calendar.DAY_OF_YEAR)) + 1);
            if (calendar.get(Calendar.DAY_OF_YEAR) + idx < calendar.getActualMinimum(Calendar.DAY_OF_YEAR))
                calendar.roll(Calendar.YEAR, -(((-idx) / calendar.getActualMaximum(Calendar.DAY_OF_YEAR)) + 1));
            calendar.roll(Calendar.DAY_OF_YEAR, idx);
            if (idx == 0)
                label.setText("Today");
            else
                label.setText(calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault())
                        + " " + calendar.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault())
                        + " " + calendar.get(Calendar.DATE));
        }
    }

    static class DayCell extends AbstractCalendarCell {

        DayCell(CGRect rect) {
            super(rect);
        }

        @Override
        public void update(int idx) {
            idx -= 100000;
            calendar.roll(Calendar.DATE, idx);
            label.setText(Integer.toString(calendar.get(Calendar.DATE)));
        }

    }

    static class MonthCell extends AbstractCalendarCell {

        MonthCell(CGRect rect) {
            super(rect);
            label.setTextAlignment(UITextAlignment.Right);
        }

        @Override
        public void update(int idx) {
            idx -= 100000;
            calendar.roll(Calendar.MONTH, idx);
            label.setText(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault()));
        }

    }

    static class YearCell extends AbstractCalendarCell {

        YearCell(CGRect rect) {
            super(rect);
            label.setTextAlignment(UITextAlignment.Left);
        }

        @Override
        public void update(int idx) {
            idx -= calendar.get(Calendar.YEAR) - 1;
            calendar.roll(Calendar.YEAR, idx);
            label.setText(Integer.toString(calendar.get(Calendar.YEAR)));
        }

    }

    static class AMPMCell extends AbstractCalendarCell {

        AMPMCell(CGRect rect) {
            super(rect);
            label.setTextAlignment(UITextAlignment.Left);
        }

        @Override
        public void update(int idx) {
            if (idx == 1) {
                label.setText("PM");
                calendar.set(Calendar.AM_PM, Calendar.PM);
            } else if (idx == 0) {
                label.setText("AM");
                calendar.set(Calendar.AM_PM, Calendar.AM);
            }
        }

    }
}
