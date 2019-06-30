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
package org.crossmobile.utils;

public interface ParamDisplay {

    String parameter();

    String display();

    String definition();

    default boolean isDefault() {
        return false;
    }

    class GenericParamDisplay implements ParamDisplay {
        private final String parameter;
        private final String display;
        private final String definition;
        private final boolean isDefault;

        public GenericParamDisplay(String parameter, String display, String definition, boolean isDefault) {
            this.parameter = parameter;
            this.display = display;
            this.definition = definition;
            this.isDefault = isDefault;
        }

        @Override
        public String parameter() {
            return parameter;
        }

        @Override
        public String display() {
            return display;
        }

        @Override
        public String definition() {
            return definition;
        }

        @Override
        public boolean isDefault() {
            return isDefault;
        }
    }
}
