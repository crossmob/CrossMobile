/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
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
