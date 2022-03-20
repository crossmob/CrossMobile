/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import javassist.bytecode.ConstPool;
import javassist.bytecode.annotation.*;

public abstract class JavassistAnnParam {
    private final String name;

    public String getName() {
        return name;
    }

    public abstract MemberValue getValue(ConstPool cp);

    private JavassistAnnParam(String name) {
        this.name = name;
    }

    public static JavassistAnnParam toParam(String name, byte value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new ByteMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, short value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new ShortMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, int value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new IntegerMemberValue(cp, value);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, long value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new LongMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, float value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new FloatMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, double value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new DoubleMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, boolean value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new BooleanMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, char value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new CharMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, String value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new StringMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, Class value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new ClassMemberValue(value.getName(), cp);
            }
        };
    }

    public static JavassistAnnParam toParam(String name, Annotation value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                return new AnnotationMemberValue(value, cp);
            }
        };
    }

    public static JavassistAnnParam toArrParam(String name, JavassistAnnParam... value) {
        return new JavassistAnnParam(name) {

            @Override
            public MemberValue getValue(ConstPool cp) {
                ArrayMemberValue arrayMemberValue = new ArrayMemberValue(cp);
                MemberValue[] memberValues = new MemberValue[value.length];
                for (int i = 0, valueLength = value.length; i < valueLength; i++) memberValues[i] = value[i].getValue(cp);
                arrayMemberValue.setValue(memberValues);
                return arrayMemberValue;
            }
        };
    }
}
