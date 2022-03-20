/*
 * (c) 2022 by Panayotis Katsaloulis
 *
 * SPDX-License-Identifier: LGPL-3.0-only
 */

package org.crossmobile.utils;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.crossmobile.utils.CollectionUtils.IteratorHandler.EMPTY;
import static org.crossmobile.utils.CollectionUtils.IteratorHandler.IterationCode.*;

public class CollectionUtils {

    @SafeVarargs
    public static <T> List<T> asList(T... items) {
        return items == null || items.length < 1 ? Collections.EMPTY_LIST : Arrays.asList(items);
    }

    public static <T> List<T> asList(Collection<T> collection) {
        return collection instanceof List
                ? (List<T>) collection
                : new ArrayList<>(collection);
    }

    public static <S, T> List<T> asList(Iterable<S> input, Function<S, T> converter, Predicate<T> acceptance) {
        if (input == null)
            return null;
        List<T> result = new ArrayList<>();
        for (S item : input) {
            T out = converter == null ? (T) item : converter.apply(item);
            if (acceptance == null || acceptance.test(out))
                result.add(out);
        }
        return result;
    }

    public static <S, T> List<T> asList(Iterable<S> input, Function<S, T> converter) {
        return asList(input, converter, null);
    }

    public static <T> List<T> asList(Iterable<T> input) {
        return asList(input, null, null);
    }

    public static <S, T> Iterable<T> asIterable(Function<S, T> converter, Iterable<S> input) {
        return input == null || converter == null
                ? null
                : () -> joinIterator(converter, input.iterator());
    }

    @SafeVarargs
    public static <T> Collection<T> asCollection(Iterable<T>... iterables) {
        return iterables == null ? null
                : iterables.length == 1 && iterables[0] != null && iterables[0] instanceof Collection
                ? (Collection<T>) iterables[0]
                : asCollection(Arrays.asList(iterables));
    }

    public static <T> Collection<T> asCollection(Iterable<? extends Iterable<T>> iterables) {
        return asCollection(ArrayList.class, iterables);
    }

    @SafeVarargs
    public static <T> Collection<T> asCollection(Class<? extends Collection> classtype, Iterable<T>... iterables) {
        return asCollection(Arrays.asList(iterables));
    }

    public static <T> Collection<T> asCollection(Class<? extends Collection> classtype, Iterable<? extends Iterable<T>> iterables) {
        if (classtype == null)
            return asCollection(iterables);
        try {
            Collection<T> c = classtype.newInstance();
            if (iterables != null)
                for (Iterable<T> iterable : iterables)
                    if (iterable != null)
                        for (T item : iterable)
                            c.add(item);
            return c;
        } catch (InstantiationException | IllegalAccessException ex) {
            return null;
        }
    }

    @SafeVarargs
    public static <T> Collection<T> asCollection(Collection<T>... parts) {
        return asCollection(Arrays.asList(parts));
    }

    public static <T> Collection<T> asCollection(Collection<? extends Collection<T>> parts) {
        AtomicInteger totalsize = new AtomicInteger();
        if (parts != null)
            for (Collection<T> part : parts)
                if (part != null)
                    totalsize.addAndGet(part.size());
        if (totalsize.get() == 0)
            return Collections.EMPTY_LIST;

        return new AbstractCollection<T>() {
            @Override
            public Iterator<T> iterator() {
                Collection<Iterator<? extends T>> iterators = new ArrayList<>();
                for (Collection<T> c : parts)
                    if (c != null)
                        iterators.add(c.iterator());
                return joinIterator(iterators);
            }

            @Override
            public int size() {
                return totalsize.get();
            }
        };
    }

    @SafeVarargs
    public static <T> Collection<T> asCollection(Class<? extends Collection> classtype, Collection<T>... parts) {
        return asCollection(classtype, Arrays.asList(parts));
    }

    public static <T> Collection<T> asCollection(Class<? extends Collection> classtype, Collection<? extends Collection<T>> parts) {
        if (classtype == null)
            return asCollection(parts);
        try {
            Collection<T> c = classtype.newInstance();
            if (parts != null)
                for (Collection<T> part : parts)
                    if (part != null)
                        c.addAll(part);
            return c;
        } catch (InstantiationException | IllegalAccessException ex) {
            return null;
        }
    }

    public static <T> boolean containsAny(Collection<T> a, Collection<T> b) {
        for (T item : b)
            if (a.contains(item))
                return true;
        return false;
    }

    public static <T> T getWithCondition(Collection<T> a, Predicate<T> p) {
        for (T t : a) {
            if (p.test(t))
                return t;
        }
        return null;
    }

    public static String minimumText(Set<String> input) {
        if (input == null)
            return null;
        if (input.isEmpty())
            return "";
        Iterator<String> iterator = input.iterator();
        String current = iterator.next();
        while (iterator.hasNext())
            current = TextUtils.commonText(current, iterator.next());
        return current;
    }

    public static <K, V> K keyFromValue(Map<K, V> map, V value) {
        for (K key : map.keySet())
            if (Objects.equals(map.get(key), value))
                return key;
        return null;
    }

    public static <T> T head(Iterable<T> collection) {
        Iterator<T> it = collection == null ? null : collection.iterator();
        return it != null && it.hasNext() ? it.next() : null;
    }

    public static <T> List<T> tail(Iterable<T> collection) {
        if (collection == null)
            return Collections.emptyList();
        List<T> result = (collection instanceof List<?>) ? (List) collection : asList(asCollection(collection));
        if (result.size() < 2)
            return Collections.emptyList();
        return result.subList(1, result.size());
    }

    public static <T> List<T> front(Iterable<T> collection) {
        if (collection == null)
            return Collections.emptyList();
        List<T> result = (collection instanceof List<?>) ? (List) collection : asList(asCollection(collection));
        if (result.size() < 2)
            return Collections.emptyList();
        return result.subList(0, result.size() - 1);
    }

    public static <T> T last(Iterable<T> collection) {
        if (collection == null)
            return null;
        if (collection instanceof List<?>) {
            List<T> list = (List<T>) collection;
            return list.size() > 0 ? list.get(list.size() - 1) : null;
        }
        // generic method
        T last = null;
        for (T t : collection) last = t;
        return last;
    }

    public static <T> IteratorHandler<T> forEach(Collection<T> collection) {
        return collection != null && !collection.isEmpty()
                ? new IteratorHandler<>(collection)
                : EMPTY;
    }

    public static <T> IteratorHandler<T> forEach(T[] collection) {
        return collection != null && collection.length > 0
                ? new IteratorHandler<>(Arrays.asList(collection))
                : EMPTY;
    }

    @SafeVarargs
    public static <T> Iterator<T> joinIterator(Iterator<? extends T>... iterators) {
        return joinIterator((T t) -> t, iterators);
    }

    @SafeVarargs
    public static <S, T> Iterator<T> joinIterator(Function<S, T> converter, Iterator<? extends S>... iterators) {
        return joinIterator(converter, Arrays.asList(iterators));
    }

    public static <T> Iterator<T> joinIterator(Collection<Iterator<? extends T>> iterators) {
        return joinIterator(t -> t, iterators);
    }

    public static <S, T> Iterator<T> joinIterator(Function<S, T> converter, Collection<Iterator<? extends S>> iterators) {
        if (converter == null || iterators == null)
            return null;
        return new Iterator<T>() {
            ArrayList<Iterator<? extends S>> list = new ArrayList<>();

            {
                for (Iterator<? extends S> it : iterators)
                    if (it != null && it.hasNext())
                        list.add(it);
            }

            @Override
            public boolean hasNext() {
                return list.size() > 0 && list.get(0).hasNext();
            }

            @Override
            public T next() {
                S next = list.get(0).next();
                if (!list.get(0).hasNext())
                    list.remove(0);
                return converter.apply(next);
            }
        };
    }

    public static <T> Iterable<T> allValues(Map<?, Collection<T>> map) {
        Collection<Iterator<? extends T>> iterators = new ArrayList<>();
        for (Collection<T> collection : map.values())
            iterators.add(collection.iterator());
        return () -> joinIterator(iterators);
    }

    public static <T> Iterable<T> filter(Iterable<T> source, Predicate<T> filter) {
        return () -> filter(source.iterator(), filter);
    }

    public static <T> Iterator<T> filter(Iterator<T> source, Predicate<T> filter) {
        if (filter == null)
            return source;
        return new Iterator<T>() {
            private T last;

            @Override
            public boolean hasNext() {
                while (source.hasNext()) {
                    last = source.next();
                    if (filter.test(last))
                        return true;
                }
                return false;
            }

            @Override
            public T next() {
                return last;
            }
        };
    }

    public static <T> void addAll(Collection<T> injectedClasses, Iterable<T> generatedBlocks) {
        for (T item : generatedBlocks)
            injectedClasses.add(item);
    }

    @SafeVarargs
    public static <K, V> Map<K, V> mapOf(KeyValue<K, V>... items) {
        HashMap<K, V> map = new HashMap<>();
        for (KeyValue<K, V> item : items)
            map.put(item.key, item.value);
        return map;
    }

    public static final class IteratorHandler<T> {

        static final IteratorHandler EMPTY = new IteratorHandler(Collections.emptyList());

        public interface ConsumerEx<T> {

            void accept(T t) throws Throwable;
        }

        static final class IterationCode<T> {

            static final int ANY = 0;
            static final int HEAD = 1;
            static final int TAIL = 2;
            static final int FRONT = 3;
            static final int LAST = 4;
            static final int INNER = 5;

            private final int where;
            private final ConsumerEx<T> code;

            public IterationCode(int life, ConsumerEx<T> code) {
                this.where = life;
                this.code = code;
            }

        }

        private final Collection<T> collection;
        private final Collection<IterationCode<T>> code = new ArrayList<>();
        private Predicate<T> predicate;

        public IteratorHandler(Collection<T> collection) {
            this.collection = collection;
        }

        public IteratorHandler<T> setFilter(Predicate<T> predicate) {
            this.predicate = predicate;
            return this;
        }

        public IteratorHandler<T> onAny(ConsumerEx<T> exec) {
            if (exec != null)
                code.add(new IterationCode<>(ANY, exec));
            return this;
        }

        public IteratorHandler<T> onHead(ConsumerEx<T> exec) {
            if (exec != null)
                code.add(new IterationCode<>(HEAD, exec));
            return this;
        }

        public IteratorHandler<T> onTail(ConsumerEx<T> exec) {
            if (exec != null)
                code.add(new IterationCode<>(TAIL, exec));
            return this;
        }

        public IteratorHandler<T> onFront(ConsumerEx<T> exec) {
            if (exec != null)
                code.add(new IterationCode<>(FRONT, exec));
            return this;
        }

        public IteratorHandler<T> onInner(ConsumerEx<T> exec) {
            if (exec != null)
                code.add(new IterationCode<>(INNER, exec));
            return this;
        }

        public IteratorHandler<T> onLast(ConsumerEx<T> exec) {
            if (exec != null)
                code.add(new IterationCode<>(LAST, exec));
            return this;
        }

        public <E extends Throwable> void go() throws E {
            try {
                int count = 0;
                boolean first = true;
                for (T item : collection)
                    if (predicate == null || predicate.test(item)) {
                        count++;
                        boolean last = count == collection.size();
                        for (IterationCode<T> it : code)
                            if (it.where == ANY || (first && it.where == HEAD) || (!first && it.where == TAIL) || (last && it.where == LAST) || (!last && it.where == FRONT) || (!first && !last && it.where == INNER))
                                it.code.accept(item);
                        first = false;
                    }
            } catch (Throwable ex) {
                throw (E) ex;
            }
        }
    }

    public static List<Integer> intList(int from, int to) {
        return intList(from, to, false);
    }

    public static List<Integer> intList(int from, int to, boolean inclusive) {
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int index) {
                if (index >= size() || index < 0)
                    throw new ArrayIndexOutOfBoundsException("Unable to locate item at position " + index);
                return from + index;
            }

            @Override
            public int size() {
                return to - from + (inclusive ? 1 : 0);
            }
        };
    }

    public static class KeyValue<K, V> {
        private final K key;
        private final V value;

        private KeyValue(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public static <K, V> KeyValue<K, V> map(K key, V value) {
            return new KeyValue<>(key, value);
        }
    }
}
