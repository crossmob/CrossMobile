/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils.func;

import org.crossmobile.bridge.system.BaseUtils;
import org.crossmobile.utils.UnsafeConsumer;

import java.util.Objects;
import java.util.function.Consumer;

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

    public Opt<T> filter(UnsafePredicate<T> predicate) {
        Objects.requireNonNull(predicate);
        try {
            return exists() && predicate.test(value) ? this : nullable();
        } catch (Throwable throwable) {
            return nullable();
        }
    }

    public <S> Opt<S> map(UnsafeFunction<T, S> mapper) {
        Objects.requireNonNull(mapper);
        try {
            return exists() ? Opt.of(mapper.apply(value)) : nullable();
        } catch (Throwable throwable) {
            return nullable();
        }
    }

    public Opt<T> mapMissing(UnsafeSupplier<T> supplier) {
        Objects.requireNonNull(supplier);
        try {
            return !exists() ? Opt.of(supplier.get()) : this;
        } catch (Throwable throwable) {
            return this;
        }
    }
}
