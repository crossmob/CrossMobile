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
package org.crossmobile.backend.robovm;


public class RoboVMConverters {

//    public static class ArrayBundle {
//        public final int size;
//        public final BytePtr.BytePtrPtr pointer;
//
//        public ArrayBundle(int size, BytePtr.BytePtrPtr pointer) {
//            this.size = size;
//            this.pointer = pointer;
//        }
//    }
//    public static ArrayBundle stringArrayToNativeArray(String[] value) {
//        int argc = value == null ? 0 : value.length;
//        BytePtr.BytePtrPtr argv = null;
//        if (argc > 0) {
//            argv = Struct.allocate(BytePtr.BytePtrPtr.class, argc);
//            for (int i = 0; i < argc; i++) {
//                BytePtr arg = BytePtr.toBytePtrZ(value[i], StandardCharsets.UTF_8);
//                argv.next(i).set(arg);
//            }
//        }
//        return new ArrayBundle(argc, argv);
//    }
}
