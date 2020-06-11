/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.bridge.system.BaseUtils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Opt<T> {
    private final T value;
    private Consumer<Throwable> errorHandler;

    public static <Q> Opt<Q> of(Q value) {
        return new Opt<>(value);
    }

    public Opt(T value) {
        this.value = value;
    }

    public Opt<T> onError(Consumer<Throwable> errorHandler) {
        this.errorHandler = errorHandler;
        return this;
    }

    public Opt<T> ifExists(UnsafeConsumer<T> consumer) {
        if (value != null) {
            try {
                consumer.accept(value);
            } catch (Throwable e) {
                if (errorHandler != null)
                    errorHandler.accept(e);
                else
                    BaseUtils.throwException(e);
            }
        }
        return this;
    }

    public Opt<T> ifMissing(UnsafeRunnable runnable) {
        if (value == null) {
            try {
                runnable.run();
            } catch (Throwable e) {
                if (errorHandler != null)
                    errorHandler.accept(e);
                else
                    BaseUtils.throwException(e);
            }
        }
        return this;
    }

    public T get() {
        return value;
    }

    public T getOrElse(T otherValue) {
        return value == null ? otherValue : value;
    }

    public Opt<T> filter(Predicate<T> predicate) {
        if (value != null && predicate.test(value))
            return this;
        else return new Opt<>(null);
    }

    public <S> Opt<S> map(Function<T, S> mapper) {
        if (value != null)
            return new Opt<>(mapper.apply(value));
        else return new Opt<>(null);
    }
}
