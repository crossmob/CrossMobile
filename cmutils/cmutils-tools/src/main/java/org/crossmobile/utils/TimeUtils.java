/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

public class TimeUtils {


    public static void time(String description, Procedure r) {
        timeImpl(description, () -> {
            r.run();
            return null;
        });
    }

    public static <R> R time(String description, ProcedureR<R> r) {
        return timeImpl(description, r);
    }

    private static <R> R timeImpl(String description, ProcedureR<R> r) {
        if (description == null || description.trim().isEmpty())
            throw new NullPointerException("Description should not be empty");
        String error = null;

        int howmany = -1;   // ignore current
        String myClassName = TimeUtils.class.getName();
        String myMethod = "timeImpl";
        for (StackTraceElement ste : Thread.currentThread().getStackTrace())
            if (ste.getClassName().equals(myClassName) && ste.getMethodName().equals(myMethod))
                howmany++;
        description = TextUtils.repeatString("  ", howmany) + description.trim();

        Log.info(description);
        long nano = System.nanoTime();
        try {
            R result = r.run();
            nano = System.nanoTime() - nano;
            return result;
        } catch (NestedException ex) {
            nano = System.nanoTime() - nano;
            error = ex.getMessage();
            throw ex;
        } catch (Throwable th) {
            nano = System.nanoTime() - nano;
            error = th.toString();
            throw new NestedException("Error caused in " + description.trim() + ": " + th.toString(), th);
        } finally {
            log(nano, description, error);
        }
    }

    private static void log(long nano, String description, String error) {
        if (error != null)
            Log.error(description + ": " + error);
        Log.debug(description + ": time elapsed " + (nano / 1_000_000_000.d) + "s");
    }

    public interface Procedure {

        void run() throws Throwable;
    }

    public interface ProcedureR<R> {

        R run() throws Throwable;
    }

    private static class NestedException extends RuntimeException {
        public NestedException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
