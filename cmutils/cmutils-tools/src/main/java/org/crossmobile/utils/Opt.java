/*
 * (c) 2020 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import org.crossmobile.bridge.system.BaseUtils;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Opt<T> {
    private final T value;
    private Consumer<Throwable> errorHandler;

    @SuppressWarnings("rawtypes")
    private static final Opt nullable = new Opt<>(null);

    @SuppressWarnings("unchecked")
    private static <Q> Opt<Q> nullable() {
        return nullable;
    }

    public static <Q> Opt<Q> of(Q value) {
        return value == null ? nullable() : new Opt<>(value);
    }

    public static <Q> Opt<Q> of(UnsafeSupplier<Q> supplier) {
        try {
            return of(supplier.get());
        } catch (Throwable throwable) {
            return nullable();
        }
    }

    private Opt(T value) {
        this.value = value;
    }

    public Opt<T> onError(Consumer<Throwable> errorHandler) {
        this.errorHandler = errorHandler;
        return this;
    }

    public Opt<T> ifExists(UnsafeConsumer<T> consumer) {
        if (exists())
            always(consumer);
        return this;
    }

    public Opt<T> ifMissing(UnsafeRunnable runnable) {
        if (!exists())
            always(q -> runnable.run());
        return this;
    }

    public Opt<T> always(UnsafeConsumer<T> runnable) {
        try {
            runnable.accept(value);
        } catch (Throwable e) {
            if (errorHandler != null)
                errorHandler.accept(e);
            else
                BaseUtils.throwException(e);
        }
        return this;
    }

    public T get() {
        return value;
    }

    public boolean exists() {
        return value != null;
    }

    public T getOrElse(T otherValue) {
        return exists() ? get() : otherValue;
    }

    public Opt<T> filter(Predicate<T> predicate) {
        Objects.requireNonNull(predicate);
        return exists() && predicate.test(value) ? this : nullable();
    }

    public <S> Opt<S> map(Function<T, S> mapper) {
        Objects.requireNonNull(mapper);
        return exists() ? Opt.of(mapper.apply(value)) : nullable();
    }
}
