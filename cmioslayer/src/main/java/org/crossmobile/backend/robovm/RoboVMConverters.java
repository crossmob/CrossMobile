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
