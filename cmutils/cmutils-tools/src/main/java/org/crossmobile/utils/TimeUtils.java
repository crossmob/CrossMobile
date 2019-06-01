/* (c) 2019 by Panayotis Katsaloulis
 *
 * CrossMobile is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, version 2.
 *
 * CrossMobile is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CrossMobile; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package org.crossmobile.utils;

import org.crossmobile.bridge.system.BaseUtils;

public class TimeUtils {

    public static void time(Procedure r) {
        time(r, null);
    }

    public static void time(Procedure r, String description) {
        time(() -> {
            r.run();
            return null;
        }, description);
    }

    public static <R> R time(ProcedureR<R> r) {
        return time(r, null);
    }

    public static <R> R time(ProcedureR<R> r, String description) {
        boolean error = false;
        if (description == null)
            description = "";

        if (!description.isEmpty())
            Log.debug("  ** Launching " + description);
        long nano = System.nanoTime();
        try {
            R result = r.run();
            nano = System.nanoTime() - nano;
            return result;
        } catch (Throwable th) {
            nano = System.nanoTime() - nano;
            error = true;
            BaseUtils.throwException(th);
            return null;
        } finally {
            log(nano, description, error);
        }
    }

    private static void log(long nano, String description, boolean error) {
        String reason = description == null || description.trim().isEmpty() ? "" : " for '" + description.trim() + "'";
        if (error && !description.isEmpty())
            Log.error("  !! Error found" + reason);
        Log.debug("  ** Elapsed time" + reason + ": " + (nano / 1_000_000_000.d) + "s");
    }

    public static interface Procedure {

        public void run() throws Throwable;

    }

    public interface ProcedureR<R> {

        public R run() throws Throwable;

    }

}
