// (c) 2020 by Panayotis Katsaloulis
// SPDX-License-Identifier: LGPL-3.0-only

package org.crossmobile.bridge.system;

import org.robovm.objc.block.Block0;

import java.util.ArrayList;
import java.util.Collection;

public class BaseUtils {

    public static <R> R throwException(Throwable th) {
        return (R) BaseUtils.<RuntimeException>throwExceptionImpl(th);
    }

    private static <T extends Throwable> Object throwExceptionImpl(Throwable th) throws T {
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
}
