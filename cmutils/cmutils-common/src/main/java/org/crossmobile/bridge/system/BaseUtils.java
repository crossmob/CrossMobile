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
package org.crossmobile.bridge.system;

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
}
