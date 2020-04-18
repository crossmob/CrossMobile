// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.bridge.system;

import org.robovm.objc.block.Block0;

import java.io.File;
import java.util.*;

public class BaseUtils {

    public static <R> R throwExceptionAndReturn(Throwable th) {  // should return "something", to make happy methods that need to return "something"
        //noinspection RedundantTypeArguments,unchecked
        return (R) BaseUtils.<RuntimeException>throwExceptionImpl(th);
    }

    public static void throwException(Throwable th) {  // should return "something", to make happy methods that need to return "something"
        //noinspection RedundantTypeArguments,unchecked
        BaseUtils.<RuntimeException>throwExceptionImpl(th);
    }

    private static <T extends Throwable> Object throwExceptionImpl(Throwable th) throws T {
        //noinspection unchecked
        throw (T) th;
    }

    public static <T> Collection<T> removeCommon(Collection<T> base, Collection<T> checkUpon) {
        Collection<T> removed = new ArrayList<>();
        for (T toCheck : checkUpon)
            if (base.remove(toCheck))
                removed.add(toCheck);
        return removed;
    }

    public static boolean isOverriddenDouble(Block0<Double> source) {
        Double result;
        try {
            result = source.invoke();
        } catch (Throwable e) {
            return true;
        }
        return result == null || Double.doubleToRawLongBits(source.invoke()) != Double.doubleToRawLongBits(Double.NaN);
    }

    public static Collection<File> listFiles(File directory) {
        if (directory == null || !directory.isDirectory())
            return Collections.emptyList();
        File[] files = directory.listFiles();
        return files == null || files.length == 0 ? Collections.emptyList() : Arrays.asList(files);
    }
}
