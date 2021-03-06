package org.crossmobile.utils.func;

public interface TriFunction<S, T, U, V> {
    V apply(S one, T two, U three);
}
