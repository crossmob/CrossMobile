/*
 * (c) 2020 by Panayotis Katsaloulis
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
package org.crossmobile.build.ib;

import java.util.HashMap;
import java.util.Map;

public abstract class Value {

    public abstract java.lang.String getPlainValue();

    public java.lang.String getValue() {
        return getPlainValue();
    }

    public abstract Value newInstance(java.lang.String value);

    public static final class Boolean extends Value {

        private final boolean value;

        public Boolean() {
            this(false);
        }

        private Boolean(boolean value) {
            this.value = value;
        }

        @Override
        public Value newInstance(java.lang.String value) {
            return new Boolean(value != null && value.toUpperCase().equals("YES"));
        }

        @Override
        public java.lang.String getPlainValue() {
            return java.lang.Boolean.toString(value);
        }

    }

    public static final class Float extends Value {

        private final float value;

        public Float() {
            this(0);
        }

        private Float(float value) {
            this.value = value;
        }

        @Override
        public Value newInstance(java.lang.String value) {
            return new Float(value == null ? 0 : java.lang.Float.parseFloat(value));
        }

        @Override
        public java.lang.String getPlainValue() {
            return java.lang.Float.toString(value);
        }

        @Override
        public java.lang.String getValue() {
            return getPlainValue() + "f";
        }

    }

    public static final class Double extends Value {

        private final double value;

        public Double() {
            this(0);
        }

        private Double(double value) {
            this.value = value;
        }

        @Override
        public Value newInstance(java.lang.String value) {
            return new Double(value == null ? 0 : java.lang.Double.parseDouble(value));
        }

        @Override
        public java.lang.String getPlainValue() {
            return java.lang.Double.toString(value);
        }

    }

    public static final class Integer extends Value {

        private final int value;

        public Integer() {
            this.value = 0;
        }

        private Integer(int value) {
            this.value = value;
        }

        @Override
        public Value newInstance(java.lang.String value) {
            return new Integer(value == null ? 0 : java.lang.Integer.parseInt(value));
        }

        @Override
        public java.lang.String getPlainValue() {
            return java.lang.Integer.toString(value);
        }

    }

    public static class String extends Value {

        private final java.lang.String value;

        public String() {
            this.value = null;
        }

        protected String(java.lang.String value) {
            this.value = value;
        }

        @Override
        public Value newInstance(java.lang.String value) {
            return new String(value);
        }

        @Override
        public java.lang.String getPlainValue() {
            return value;
        }

        @Override
        public java.lang.String getValue() {
            return '"' + getPlainValue() + '"';
        }
    }

    public static final class LocalizedString extends Value.String {

        private java.lang.String key;
        private java.lang.String table;

        public LocalizedString() {
        }

        protected LocalizedString(java.lang.String value) {
            super(value);
        }

        @Override
        public Value newInstance(java.lang.String value) {
            return new LocalizedString(value);
        }

        public void updateLocalized(java.lang.String key, java.lang.String table) {
            this.key = key;
            this.table = table;
        }

        @Override
        public java.lang.String getValue() {
            return table == null
                    ? super.getValue()
                    : "NSBundle.mainBundle().localizedStringForKey(\"" + key + "\", \"" + getPlainValue() + "\", \"" + table + "\")";
        }
    }

    public static final class Method extends Value {

        private final java.lang.String value;

        public Method() {
            this.value = null;
        }

        private Method(java.lang.String value) {
            this.value = value;
        }

        @Override
        public Value newInstance(java.lang.String value) {
            return new Method(value);
        }

        @Override
        public java.lang.String getPlainValue() {
            return value;
        }

        @Override
        public java.lang.String getValue() {
            return getPlainValue() + "()";
        }
    }

    public static final class Selections extends Value {

        private final Map<java.lang.String, java.lang.Integer> values;
        private final int value;

        public Selections(java.lang.String[] keys, int[] values) {
            this(arraysToKeys(keys, values));
        }

        public Selections(java.lang.String[] keys) {
            this(arraysToKeys(keys, null));
        }

        public Selections(Map<java.lang.String, java.lang.Integer> values) {
            this.values = values;
            value = 0;
        }

        private Selections(int value) {
            this.values = null;
            this.value = value;
        }

        @Override
        public Value newInstance(java.lang.String value) {
            java.lang.Integer v = values.get(value.toLowerCase());
            return new Selections(v == null ? 0 : v);
        }

        @Override
        public java.lang.String getPlainValue() {
            return java.lang.Integer.toString(value);
        }

        private static Map<java.lang.String, java.lang.Integer> arraysToKeys(java.lang.String[] keys, int[] values) {
            int size = Math.min(keys.length, values == null ? keys.length : values.length);
            Map<java.lang.String, java.lang.Integer> result = new HashMap<>();
            for (int i = 0; i < size; i++)
                result.put(keys[i].toLowerCase(), values == null ? i : values[i]);
            return result;
        }
    }

    public static class Enum extends Value {
        private final java.lang.String value;

        public Enum() {
            this.value = null;
        }

        private Enum(java.lang.String value) {
            this.value = value;
        }

        @Override
        public Value newInstance(java.lang.String value) {
            return new Enum(value);
        }

        @Override
        public java.lang.String getPlainValue() {
            return value;
        }

        @Override
        public java.lang.String getValue() {
            return capitalize(getPlainValue());
        }

        protected java.lang.String capitalize(java.lang.String item) {
            return item == null ? null : (item.length() > 0 ? item.substring(0, 1).toUpperCase() + item.substring(1) : "");
        }
    }
}
