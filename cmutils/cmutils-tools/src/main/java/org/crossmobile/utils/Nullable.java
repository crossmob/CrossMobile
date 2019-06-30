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
package org.crossmobile.utils;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Given a possible nullable object as input, create a product out of this
 * object
 *
 * @param <T>
 */
public class Nullable<T> {

    private final T input;
    private Object product;

    public static <Q> Nullable<Q> of(Q input) {
        return new Nullable<>(input);
    }

    public static <Q> void safeCall(Q input, Consumer<Q> consumer) {
        if (input != null && consumer != null)
            consumer.accept(input);
    }

    public Nullable(T input) {
        this.input = input;
    }

    /**
     * Set the value of the product
     *
     * @param product
     * @return
     */
    public Nullable<T> def(Object product) {
        this.product = product;
        return this;
    }

    /**
     * Set the value of the product from the input object, given the input
     * object is not null
     *
     * @param producer
     * @return
     */
    public Nullable<T> set(Function<T, Object> producer) {
        if (input != null && producer != null)
            product = producer.apply(input);
        return this;
    }

    /**
     * Execute code if the input object is not null
     *
     * @param code
     * @return
     */
    public Nullable<T> onValid(Consumer<T> code) {
        if (input != null && code != null)
            code.accept(input);
        return this;
    }

    /**
     * Execute code if the input object is null
     *
     * @param code
     * @return
     */
    public Nullable<T> onNull(Runnable code) {
        if (input == null && code != null)
            code.run();
        return this;
    }

    /**
     * Get the input object
     *
     * @return
     */
    public T input() {
        return input;
    }

    /**
     * Get the product
     *
     * @param <C>   The type of the product
     * @param clazz The class specifying the type of the product
     * @return
     */
    public <C> C get(Class<C> clazz) {
        return (C) product;
    }

}
