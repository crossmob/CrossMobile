package org.crossmobile.support.cassowary.util;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class IdentityHashDoubleMap<K> implements Map<K, Double>, java.io.Serializable, Cloneable {
    /**
     * The initial capacity used by the no-args constructor. MUST be a power of two. The value 32 corresponds to the (specified)
     * expected maximum size of 21, given a load factor of 2/3.
     */
    private static final int DEFAULT_CAPACITY = 32;

    /**
     * The minimum capacity, used if a lower value is implicitly specified by either of the constructors with arguments. The value
     * 4 corresponds to an expected maximum size of 2, given a load factor of 2/3. MUST be a power of two.
     */
    private static final int MINIMUM_CAPACITY = 4;

    /**
     * The maximum capacity, used if a higher value is implicitly specified by either of the constructors with arguments. MUST be
     * a power of two <= 1<<29.
     */
    private static final int MAXIMUM_CAPACITY = 1 << 29;

    /**
     * The table, resized as necessary. Length MUST always be a power of two.
     */
    private transient K[] table;

    private transient double[] rawValues;

    private Class<K> keyType;

    /**
     * The number of key-value mappings contained in this identity hash map.
     *
     * @serial
     */
    private int size;

    /**
     * The number of modifications, to support fast-fail iterators
     */
    private transient volatile int modCount;

    /**
     * The next size value at which to resize (capacity * load factor).
     */
    private transient int threshold;

    // /**
    // * Value representing null keys inside tables.
    // */
    // private static final K NULL_KEY = new Object();

    /**
     * Use NULL_KEY for key if it is null.
     */
    private static <K> K maskNull(K key) {
        // return (key == null ? NULL_KEY : key);
        return key;
    }

    /**
     * Returns internal representation of null key back to caller as null.
     */
    private static <K> K unmaskNull(K key) {
        return key;
        // return (key == NULL_KEY ? null : key);
    }

    /**
     * Constructs a new, empty identity hash map with a default expected maximum size (21).
     */
    public IdentityHashDoubleMap(Class<K> keyType) {
        this.keyType = keyType;
        init(DEFAULT_CAPACITY);
    }

    /**
     * Constructs a new, empty map with the specified expected maximum size. Putting more than the expected number of key-value
     * mappings into the map may cause the internal data structure to grow, which may be somewhat time-consuming.
     *
     * @param expectedMaxSize the expected maximum size of the map
     * @throws IllegalArgumentException if <tt>expectedMaxSize</tt> is negative
     */
    public IdentityHashDoubleMap(Class<K> keyType, int expectedMaxSize) {
        if (expectedMaxSize < 0)
            throw new IllegalArgumentException("expectedMaxSize is negative: " + expectedMaxSize);
        this.keyType = keyType;
        init(capacity(expectedMaxSize));
    }

    /**
     * Returns the appropriate capacity for the specified expected maximum size. Returns the smallest power of two between
     * MINIMUM_CAPACITY and MAXIMUM_CAPACITY, inclusive, that is greater than (3 * expectedMaxSize)/2, if such a number exists.
     * Otherwise returns MAXIMUM_CAPACITY. If (3 * expectedMaxSize)/2 is negative, it is assumed that overflow has occurred, and
     * MAXIMUM_CAPACITY is returned.
     */
    private static int capacity(int expectedMaxSize) {
        // Compute min capacity for expectedMaxSize given a load factor of 2/3
        int minCapacity = (3 * expectedMaxSize) / 2;

        // Compute the appropriate capacity
        int result;
        if (minCapacity > MAXIMUM_CAPACITY || minCapacity < 0) {
            result = MAXIMUM_CAPACITY;
        } else {
            result = MINIMUM_CAPACITY;
            while (result < minCapacity)
                result <<= 1;
        }
        return result;
    }

    /**
     * Initializes object to be an empty map with the specified initial capacity, which is assumed to be a power of two between
     * MINIMUM_CAPACITY and MAXIMUM_CAPACITY inclusive.
     */
    @SuppressWarnings("unchecked")
    private void init(int initCapacity) {
        // assert (initCapacity & -initCapacity) == initCapacity; // power of 2
        // assert initCapacity >= MINIMUM_CAPACITY;
        // assert initCapacity <= MAXIMUM_CAPACITY;

        threshold = (initCapacity * 2) / 3;

        table = (K[]) Array.newInstance(keyType, initCapacity);
        rawValues = new double[initCapacity];
    }

    /**
     * Constructs a new identity hash map containing the keys-value mappings in the specified map.
     *
     * @param m the map whose mappings are to be placed into this map
     * @throws NullPointerException if the specified map is null
     */
    public IdentityHashDoubleMap(Class<K> keyType, Map<? extends K, ? extends Double> m) {
        // Allow for a bit of growth
        this(keyType, (int) ((1 + m.size()) * 1.1));
        putAll(m);
    }

    /**
     * Returns the number of key-value mappings in this identity hash map.
     *
     * @return the number of key-value mappings in this map
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns <tt>true</tt> if this identity hash map contains no key-value mappings.
     *
     * @return <tt>true</tt> if this identity hash map contains no key-value mappings
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns index for Object x.
     */
    private static int hash(Object x, int length) {
        int h = System.identityHashCode(x);
        // Multiply by -127, and left-shift to use least bit as part of hash
        return ((h << 1) - (h << 8)) & (length - 1);
    }

    /**
     * Circularly traverses table of size len.
     */
    private static int nextKeyIndex(int i, int len) {
        return (i + 1 < len ? i + 1 : 0);
    }

    /**
     * Returns the value to which the specified key is mapped, or {@code null} if this map contains no mapping for the key.
     *
     * <p>
     * More formally, if this map contains a mapping from a key {@code k} to a value {@code v} such that {@code (key == k)}, then
     * this method returns {@code v}; otherwise it returns {@code null}. (There can be at most one such mapping.)
     *
     * <p>
     * A return value of {@code null} does not <i>necessarily</i> indicate that the map contains no mapping for the key; it's also
     * possible that the map explicitly maps the key to {@code null}. The {@link #containsKey containsKey} operation may be used
     * to distinguish these two cases.
     *
     */
    @SuppressWarnings("unchecked")
    @Override
    public Double get(Object key) {
        K k = maskNull((K) key);
        K[] tab = table;
        double[] rv = rawValues;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            K item = tab[i];
            if (item == k)
                return rv[i];
            if (item == null)
                return null;
            i = nextKeyIndex(i, len);
        }
    }

    public double getDouble(Object key) {
        Object k = maskNull(key);
        Object[] tab = table;
        double[] rv = rawValues;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            Object item = tab[i];
            if (item == k)
                return rv[i];
            if (item == null)
                return Double.NaN;
            i = nextKeyIndex(i, len);
        }
    }

    /**
     * Tests whether the specified object reference is a key in this identity hash map.
     *
     * @param key possible key
     * @return <code>true</code> if the specified object reference is a key in this map
     * @see #containsValue(Object)
     */
    @Override
    public boolean containsKey(Object key) {
        Object k = maskNull(key);
        Object[] tab = table;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            Object item = tab[i];
            if (item == k)
                return true;
            if (item == null)
                return false;
            i = nextKeyIndex(i, len);
        }
    }

    /**
     * Tests whether the specified object reference is a value in this identity hash map.
     *
     * @param value value whose presence in this map is to be tested
     * @return <tt>true</tt> if this map maps one or more keys to the specified object reference
     * @see #containsKey(Object)
     */
    @SuppressWarnings("UnnecessaryUnboxing")
    @Override
    public boolean containsValue(Object value) {
        if (!(value instanceof Double))
            return false;
        double val = ((Double) value).doubleValue();

        Object[] tab = table;
        double[] rv = rawValues;

        for (int i = 0; i < rv.length; i++) {
            if (rv[i] == val && tab[i] != null)
                return true;
        }

        return false;
    }

    /**
     * Tests if the specified key-value mapping is in the map.
     *
     * @param key   possible key
     * @param value possible value
     * @return <code>true</code> if and only if the specified key-value mapping is in the map
     */
    private boolean containsMapping(Object key, Object value) {
        Object k = maskNull(key);
        Object[] tab = table;
        double[] rv = rawValues;
        int len = tab.length;
        int i = hash(k, len);
        while (true) {
            Object item = tab[i];
            if (item == k)
                return rv[i] == ((Double) value).doubleValue();
            if (item == null)
                return false;
            i = nextKeyIndex(i, len);
        }
    }

    /**
     * Associates the specified value with the specified key in this identity hash map. If the map previously contained a mapping
     * for the key, the old value is replaced.
     *
     * @param key   the key with which the specified value is to be associated
     * @param value the value to be associated with the specified key
     * @return the previous value associated with <tt>key</tt>, or <tt>null</tt> if there was no mapping for <tt>key</tt>. (A
     * <tt>null</tt> return can also indicate that the map previously associated <tt>null</tt> with <tt>key</tt>.)
     * @see Object#equals(Object)
     * @see #get(Object)
     * @see #containsKey(Object)
     */
    @Override
    public Double put(K key, Double value) {
        Object k = maskNull(key);
        Object[] tab = table;
        double[] rv = rawValues;
        int len = tab.length;
        int i = hash(k, len);

        Object item;
        while ((item = tab[i]) != null) {
            if (item == k) {
                double oldValue = rv[i];
                rv[i] = value;
                return oldValue;
            }
            i = nextKeyIndex(i, len);
        }

        modCount++;
        tab[i] = k;
        rv[i] = value;
        if (++size >= threshold)
            resize(len); // len == 2 * current capacity.
        return null;
    }

    public double put(K key, double value) {
        Object k = maskNull(key);
        Object[] tab = table;
        double[] rv = rawValues;
        int len = tab.length;
        int i = hash(k, len);

        Object item;
        while ((item = tab[i]) != null) {
            if (item == k) {
                double oldValue = rv[i];
                rv[i] = value;
                return oldValue;
            }
            i = nextKeyIndex(i, len);
        }

        modCount++;
        tab[i] = k;
        rv[i] = value;
        if (++size >= threshold)
            resize(len); // len == 2 * current capacity.
        return Double.NaN;
    }

    /**
     * Resize the table to hold given capacity.
     *
     * @param newCapacity the new capacity, must be a power of two.
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        // assert (newCapacity & -newCapacity) == newCapacity; // power of 2
        int newLength = newCapacity * 2;

        K[] oldTable = table;
        double[] oldRawValues = rawValues;
        int oldLength = oldTable.length;
        if (oldLength == MAXIMUM_CAPACITY) { // can't expand any further
            if (threshold == MAXIMUM_CAPACITY - 1)
                throw new IllegalStateException("Capacity exhausted.");
            threshold = MAXIMUM_CAPACITY - 1; // Gigantic map!
            return;
        }
        if (oldLength >= newLength)
            return;

        K[] newTable = (K[]) Array.newInstance(keyType, newLength);
        double[] newRawValues = new double[newLength];
        threshold = newLength / 3;

        for (int j = 0; j < oldLength; j++) {
            K key = oldTable[j];
            if (key != null) {
                double value = oldRawValues[j];
                oldTable[j] = null;
                int i = hash(key, newLength);
                while (newTable[i] != null)
                    i = nextKeyIndex(i, newLength);
                newTable[i] = key;
                newRawValues[i] = value;
            }
        }
        table = newTable;
        rawValues = newRawValues;
    }

    /**
     * Copies all of the mappings from the specified map to this map. These mappings will replace any mappings that this map had
     * for any of the keys currently in the specified map.
     *
     * @param m mappings to be stored in this map
     * @throws NullPointerException if the specified map is null
     */
    @Override
    public void putAll(Map<? extends K, ? extends Double> m) {
        int n = m.size();
        if (n == 0)
            return;
        if (n > threshold) // conservatively pre-expand
            resize(capacity(n));

        for (Entry<? extends K, ? extends Double> e : m.entrySet())
            put(e.getKey(), e.getValue());
    }

    /**
     * Removes the mapping for this key from this map if present.
     *
     * @param key key whose mapping is to be removed from the map
     * @return the previous value associated with <tt>key</tt>, or <tt>null</tt> if there was no mapping for <tt>key</tt>. (A
     * <tt>null</tt> return can also indicate that the map previously associated <tt>null</tt> with <tt>key</tt>.)
     */
    @Override
    public Double remove(Object key) {
        Object k = maskNull(key);
        Object[] tab = table;
        double[] rv = rawValues;
        int len = tab.length;
        int i = hash(k, len);

        while (true) {
            Object item = tab[i];
            if (item == k) {
                modCount++;
                size--;
                double oldValue = rv[i];
                tab[i] = null;
                closeDeletion(i);
                return oldValue;
            }
            if (item == null)
                return null;
            i = nextKeyIndex(i, len);
        }

    }

    /**
     * Removes the specified key-value mapping from the map if it is present.
     *
     * @param key   possible key
     * @param value possible value
     * @return <code>true</code> if and only if the specified key-value mapping was in the map
     */
    private boolean removeMapping(Object key, Object value) {
        Object k = maskNull(key);
        Object[] tab = table;
        double[] rv = rawValues;
        int len = tab.length;
        int i = hash(k, len);

        while (true) {
            Object item = tab[i];
            if (item == k) {
                if (rv[i] != ((Double) value).doubleValue())
                    return false;
                modCount++;
                size--;
                tab[i] = null;
                closeDeletion(i);
                return true;
            }
            if (item == null)
                return false;
            i = nextKeyIndex(i, len);
        }
    }

    /**
     * Rehash all possibly-colliding entries following a deletion. This preserves the linear-probe collision properties required
     * by get, put, etc.
     *
     * @param d the index of a newly empty deleted slot
     */
    private void closeDeletion(int d) {
        // Adapted from Knuth Section 6.4 Algorithm R
        Object[] tab = table;
        int len = tab.length;

        // Look for items to swap into newly vacated slot
        // starting at index immediately following deletion,
        // and continuing until a null slot is seen, indicating
        // the end of a run of possibly-colliding keys.
        Object item;
        for (int i = nextKeyIndex(d, len); (item = tab[i]) != null; i = nextKeyIndex(i, len)) {
            // The following test triggers if the item at slot i (which
            // hashes to be at slot r) should take the spot vacated by d.
            // If so, we swap it in, and then continue with d now at the
            // newly vacated i. This process will terminate when we hit
            // the null slot at the end of this run.
            // The test is messy because we are using a circular table.
            int r = hash(item, len);
            if ((i < r && (r <= d || d <= i)) || (r <= d && d <= i)) {
                tab[d] = item;
                tab[i] = null;
                d = i;
            }
        }
    }

    /**
     * Removes all of the mappings from this map. The map will be empty after this call returns.
     */
    @Override
    public void clear() {
        modCount++;
        Object[] tab = table;
        for (int i = 0; i < tab.length; i++)
            tab[i] = null;
        size = 0;
    }

    /**
     * Compares the specified object with this map for equality. Returns <tt>true</tt> if the given object is also a map and the
     * two maps represent identical object-reference mappings. More formally, this map is equal to another map <tt>m</tt> if and
     * only if <tt>this.entrySet().equals(m.entrySet())</tt>.
     *
     * <p>
     * <b>Owing to the reference-equality-based semantics of this map it is possible that the symmetry and transitivity
     * requirements of the <tt>Object.equals</tt> contract may be violated if this map is compared to a normal map. However, the
     * <tt>Object.equals</tt> contract is guaranteed to hold among <tt>IdentityHashMap</tt> instances.</b>
     *
     * @param o object to be compared for equality with this map
     * @return <tt>true</tt> if the specified object is equal to this map
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (o instanceof IdentityHashDoubleMap) {
            IdentityHashDoubleMap<?> m = (IdentityHashDoubleMap<?>) o;
            if (m.size() != size)
                return false;

            Object[] tab = m.table;
            double[] rv = m.rawValues;
            for (int i = 0; i < tab.length; i++) {
                Object k = tab[i];
                if (k != null && !containsMapping(k, rv[i]))
                    return false;
            }
            return true;
        } else if (o instanceof Map) {
            Map<?, ?> m = (Map<?, ?>) o;
            return entrySet().equals(m.entrySet());
        } else {
            return false; // o is not a Map
        }
    }

    /**
     * Returns the hash code value for this map. The hash code of a map is defined to be the sum of the hash codes of each entry
     * in the map's <tt>entrySet()</tt> view. This ensures that <tt>m1.equals(m2)</tt> implies that
     * <tt>m1.hashCode()==m2.hashCode()</tt> for any two <tt>IdentityHashMap</tt> instances <tt>m1</tt> and <tt>m2</tt>, as
     * required by the general contract of {@link Object#hashCode}.
     *
     * <p>
     * <b>Owing to the reference-equality-based semantics of the <tt>Map.Entry</tt> instances in the set returned by this map's
     * <tt>entrySet</tt> method, it is possible that the contractual requirement of <tt>Object.hashCode</tt> mentioned in the
     * previous paragraph will be violated if one of the two objects being compared is an <tt>IdentityHashMap</tt> instance and
     * the other is a normal map.</b>
     *
     * @return the hash code value for this map
     * @see Object#equals(Object)
     * @see #equals(Object)
     */
    @Override
    public int hashCode() {
        int result = 0;
        Object[] tab = table;
        double[] rv = rawValues;
        for (int i = 0; i < tab.length; i++) {
            Object key = tab[i];
            if (key != null) {
                Object k = unmaskNull(key);
                long vbits = Double.doubleToLongBits(rv[i]);
                int vhash = (int) (vbits ^ (vbits >>> 32));
                result += System.identityHashCode(k) ^ vhash;
            }
        }
        return result;
    }

    /**
     * Returns a shallow copy of this identity hash map: the keys and values themselves are not cloned.
     *
     * @return a shallow copy of this map
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object clone() {
        try {
            IdentityHashDoubleMap<K> m = (IdentityHashDoubleMap<K>) super.clone();
            m.entrySet = null;
            m.table = table.clone();
            m.rawValues = rawValues.clone();
            return m;
        } catch (CloneNotSupportedException e) {
            throw new InternalError();
        }
    }

    private abstract class IdentityHashMapIterator<T> implements Iterator<T> {
        int index = (size != 0 ? 0 : table.length); // current slot.
        int expectedModCount = modCount; // to support fast-fail
        int lastReturnedIndex = -1; // to allow remove()
        boolean indexValid; // To avoid unnecessary next computation
        K[] traversalTable = table; // reference to main table or copy
        double[] traversalRawValues = rawValues;

        @Override
        public boolean hasNext() {
            K[] tab = traversalTable;
            for (int i = index; i < tab.length; i++) {
                K key = tab[i];
                if (key != null) {
                    index = i;
                    return indexValid = true;
                }
            }
            index = tab.length;
            return false;
        }

        protected int nextIndex() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if (!indexValid && !hasNext())
                throw new NoSuchElementException();

            indexValid = false;
            lastReturnedIndex = index;
            index++;
            return lastReturnedIndex;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void remove() {
            if (lastReturnedIndex == -1)
                throw new IllegalStateException();
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();

            expectedModCount = ++modCount;
            int deletedSlot = lastReturnedIndex;
            lastReturnedIndex = -1;
            size--;
            // back up index to revisit new contents after deletion
            index = deletedSlot;
            indexValid = false;

            // Removal code proceeds as in closeDeletion except that
            // it must catch the rare case where an element already
            // seen is swapped into a vacant slot that will be later
            // traversed by this iterator. We cannot allow future
            // next() calls to return it again. The likelihood of
            // this occurring under 2/3 load factor is very slim, but
            // when it does happen, we must make a copy of the rest of
            // the table to use for the rest of the traversal. Since
            // this can only happen when we are near the end of the table,
            // even in these rare cases, this is not very expensive in
            // time or space.

            Object[] tab = traversalTable;
            int len = tab.length;

            int d = deletedSlot;
            K key = (K) tab[d];
            tab[d] = null; // vacate the slot

            // If traversing a copy, remove in real table.
            // We can skip gap-closure on copy.
            if (tab != IdentityHashDoubleMap.this.table) {
                IdentityHashDoubleMap.this.remove(key);
                expectedModCount = modCount;
                return;
            }

            Object item;
            for (int i = nextKeyIndex(d, len); (item = tab[i]) != null; i = nextKeyIndex(i, len)) {
                int r = hash(item, len);
                // See closeDeletion for explanation of this conditional
                if ((i < r && (r <= d || d <= i)) || (r <= d && d <= i)) {

                    // If we are about to swap an already-seen element
                    // into a slot that may later be returned by next(),
                    // then clone the rest of table for use in future
                    // next() calls. It is OK that our copy will have
                    // a gap in the "wrong" place, since it will never
                    // be used for searching anyway.

                    if (i < deletedSlot && d >= deletedSlot && traversalTable == IdentityHashDoubleMap.this.table) {
                        int remaining = len - deletedSlot;
                        K[] newTable = (K[]) Array.newInstance(keyType, remaining);
                        System.arraycopy(tab, deletedSlot, newTable, 0, remaining);
                        traversalTable = newTable;
                        index = 0;
                    }

                    tab[d] = item;
                    tab[i] = null;
                    d = i;
                }
            }
        }
    }

    private class KeyIterator extends IdentityHashMapIterator<K> {
        @Override
        public K next() {
            return unmaskNull(traversalTable[nextIndex()]);
        }
    }

    private class ValueIterator extends IdentityHashMapIterator<Double> {
        @Override
        public Double next() {
            return traversalRawValues[nextIndex()];
        }
    }

    /**
     * Since we don't use Entry objects, we use the Iterator itself as an entry.
     */
    private class EntryIterator extends IdentityHashMapIterator<Map.Entry<K, Double>> implements Map.Entry<K, Double> {
        @Override
        public Map.Entry<K, Double> next() {
            nextIndex();
            return this;
        }

        @Override
        public K getKey() {
            // Provide a better exception than out of bounds index
            if (lastReturnedIndex < 0)
                throw new IllegalStateException("Entry was removed");

            return unmaskNull(traversalTable[lastReturnedIndex]);
        }

        @Override
        public Double getValue() {
            // Provide a better exception than out of bounds index
            if (lastReturnedIndex < 0)
                throw new IllegalStateException("Entry was removed");

            return traversalRawValues[lastReturnedIndex];
        }

        @Override
        public Double setValue(Double value) {
            // It would be mean-spirited to proceed here if remove() called
            if (lastReturnedIndex < 0)
                throw new IllegalStateException("Entry was removed");
            double oldValue = traversalRawValues[lastReturnedIndex];
            traversalRawValues[lastReturnedIndex] = value;
            // if shadowing, force into main table
            if (traversalTable != IdentityHashDoubleMap.this.table)
                put(traversalTable[lastReturnedIndex], value);
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (lastReturnedIndex < 0)
                return super.equals(o);

            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
            return e.getKey() == getKey() && e.getValue() == getValue();
        }

        @Override
        public int hashCode() {
            if (lastReturnedIndex < 0)
                return super.hashCode();

            return System.identityHashCode(getKey()) ^ System.identityHashCode(getValue());
        }

        @Override
        public String toString() {
            if (lastReturnedIndex < 0)
                return super.toString();

            return getKey() + "=" + getValue();
        }
    }

    // Views

    /**
     * This field is initialized to contain an instance of the entry set view the first time this view is requested. The view is
     * stateless, so there's no reason to create more than one.
     */
    private transient Set<Map.Entry<K, Double>> entrySet = null;
    transient volatile Set<K> keySet = null;
    transient volatile Collection<Double> values = null;

    /**
     * Returns an identity-based set view of the keys contained in this map. The set is backed by the map, so changes to the map
     * are reflected in the set, and vice-versa. If the map is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined. The set supports element removal, which removes the corresponding mapping from the
     * map, via the <tt>Iterator.remove</tt>, <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt>, and <tt>clear</tt>
     * methods. It does not support the <tt>add</tt> or <tt>addAll</tt> methods.
     *
     * <p>
     * <b>While the object returned by this method implements the <tt>Set</tt> interface, it does <i>not</i> obey <tt>Set's</tt>
     * general contract. Like its backing map, the set returned by this method defines element equality as reference-equality
     * rather than object-equality. This affects the behavior of its <tt>contains</tt>, <tt>remove</tt>, <tt>containsAll</tt>,
     * <tt>equals</tt>, and <tt>hashCode</tt> methods.</b>
     *
     * <p>
     * <b>The <tt>equals</tt> method of the returned set returns <tt>true</tt> only if the specified object is a set containing
     * exactly the same object references as the returned set. The symmetry and transitivity requirements of the
     * <tt>Object.equals</tt> contract may be violated if the set returned by this method is compared to a normal set. However,
     * the <tt>Object.equals</tt> contract is guaranteed to hold among sets returned by this method.</b>
     *
     * <p>
     * The <tt>hashCode</tt> method of the returned set returns the sum of the <i>identity hashcodes</i> of the elements in the
     * set, rather than the sum of their hashcodes. This is mandated by the change in the semantics of the <tt>equals</tt> method,
     * in order to enforce the general contract of the <tt>Object.hashCode</tt> method among sets returned by this method.
     *
     * @return an identity-based set view of the keys contained in this map
     * @see Object#equals(Object)
     * @see System#identityHashCode(Object)
     */
    @Override
    public Set<K> keySet() {
        Set<K> ks = keySet;
        if (ks != null)
            return ks;
        else
            return keySet = new KeySet();
    }

    private class KeySet extends AbstractSet<K> {
        @Override
        public Iterator<K> iterator() {
            return new KeyIterator();
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean contains(Object o) {
            return containsKey(o);
        }

        @Override
        public boolean remove(Object o) {
            int oldSize = size;
            IdentityHashDoubleMap.this.remove(o);
            return size != oldSize;
        }

        /*
         * Must revert from AbstractSet's impl to AbstractCollection's, as the former contains an optimization that results in
         * incorrect behavior when c is a smaller "normal" (non-identity-based) Set.
         */
        @Override
        public boolean removeAll(Collection<?> c) {
            boolean modified = false;
            for (Iterator<K> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public void clear() {
            IdentityHashDoubleMap.this.clear();
        }

        @Override
        public int hashCode() {
            int result = 0;
            for (K key : this)
                result += System.identityHashCode(key);
            return result;
        }
    }

    /**
     * Returns a {@link Collection} view of the values contained in this map. The collection is backed by the map, so changes to
     * the map are reflected in the collection, and vice-versa. If the map is modified while an iteration over the collection is
     * in progress, the results of the iteration are undefined. The collection supports element removal, which removes the
     * corresponding mapping from the map, via the <tt>Iterator.remove</tt>, <tt>Collection.remove</tt>, <tt>removeAll</tt>,
     * <tt>retainAll</tt> and <tt>clear</tt> methods. It does not support the <tt>add</tt> or <tt>addAll</tt> methods.
     *
     * <p>
     * <b>While the object returned by this method implements the <tt>Collection</tt> interface, it does <i>not</i> obey
     * <tt>Collection's</tt> general contract. Like its backing map, the collection returned by this method defines element
     * equality as reference-equality rather than object-equality. This affects the behavior of its <tt>contains</tt>,
     * <tt>remove</tt> and <tt>containsAll</tt> methods.</b>
     */
    @Override
    public Collection<Double> values() {
        Collection<Double> vs = values;
        if (vs != null)
            return vs;
        else
            return values = new Values();
    }

    private class Values extends AbstractCollection<Double> {
        @Override
        public Iterator<Double> iterator() {
            return new ValueIterator();
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean contains(Object o) {
            return containsValue(o);
        }

        @Override
        public boolean remove(Object o) {
            for (Iterator<?> i = iterator(); i.hasNext(); ) {
                if (i.next() == o) {
                    i.remove();
                    return true;
                }
            }
            return false;
        }

        @Override
        public void clear() {
            IdentityHashDoubleMap.this.clear();
        }
    }

    /**
     * Returns a {@link Set} view of the mappings contained in this map. Each element in the returned set is a
     * reference-equality-based <tt>Map.Entry</tt>. The set is backed by the map, so changes to the map are reflected in the set,
     * and vice-versa. If the map is modified while an iteration over the set is in progress, the results of the iteration are
     * undefined. The set supports element removal, which removes the corresponding mapping from the map, via the
     * <tt>Iterator.remove</tt>, <tt>Set.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and <tt>clear</tt> methods. It does
     * not support the <tt>add</tt> or <tt>addAll</tt> methods.
     *
     * <p>
     * Like the backing map, the <tt>Map.Entry</tt> objects in the set returned by this method define key and value equality as
     * reference-equality rather than object-equality. This affects the behavior of the <tt>equals</tt> and <tt>hashCode</tt>
     * methods of these <tt>Map.Entry</tt> objects. A reference-equality based <tt>Map.Entry
     * e</tt> is equal to an object <tt>o</tt> if and only if <tt>o</tt> is a <tt>Map.Entry</tt> and
     * <tt>e.getKey()==o.getKey() &amp;&amp;
     * e.getValue()==o.getValue()</tt>. To accommodate these equals semantics, the <tt>hashCode</tt> method returns
     * <tt>System.identityHashCode(e.getKey()) ^
     * System.identityHashCode(e.getValue())</tt>.
     *
     * <p>
     * <b>Owing to the reference-equality-based semantics of the <tt>Map.Entry</tt> instances in the set returned by this method,
     * it is possible that the symmetry and transitivity requirements of the {@link Object#equals(Object)} contract may be
     * violated if any of the entries in the set is compared to a normal map entry, or if the set returned by this method is
     * compared to a set of normal map entries (such as would be returned by a call to this method on a normal map). However, the
     * <tt>Object.equals</tt> contract is guaranteed to hold among identity-based map entries, and among sets of such entries.
     * </b>
     *
     * @return a set view of the identity-mappings contained in this map
     */
    @Override
    public Set<Map.Entry<K, Double>> entrySet() {
        Set<Map.Entry<K, Double>> es = entrySet;
        if (es != null)
            return es;
        else
            return entrySet = new EntrySet();
    }

    private class EntrySet extends AbstractSet<Map.Entry<K, Double>> {
        @Override
        public Iterator<Map.Entry<K, Double>> iterator() {
            return new EntryIterator();
        }

        @Override
        public boolean contains(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) o;
            return containsMapping(entry.getKey(), entry.getValue());
        }

        @Override
        public boolean remove(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry<?, ?> entry = (Map.Entry<?, ?>) o;
            return removeMapping(entry.getKey(), entry.getValue());
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public void clear() {
            IdentityHashDoubleMap.this.clear();
        }

        /*
         * Must revert from AbstractSet's impl to AbstractCollection's, as the former contains an optimization that results in
         * incorrect behavior when c is a smaller "normal" (non-identity-based) Set.
         */
        @Override
        public boolean removeAll(Collection<?> c) {
            boolean modified = false;
            for (Iterator<?> i = iterator(); i.hasNext(); ) {
                if (c.contains(i.next())) {
                    i.remove();
                    modified = true;
                }
            }
            return modified;
        }

        @Override
        public Object[] toArray() {
            int size = size();
            Object[] result = new Object[size];
            Iterator<Map.Entry<K, Double>> it = iterator();
            for (int i = 0; i < size; i++)
                result[i] = new AbstractMap.SimpleEntry<K, Double>(it.next());
            return result;
        }

        @Override
        @SuppressWarnings("unchecked")
        public <T> T[] toArray(T[] a) {
            int size = size();
            if (a.length < size)
                a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
            Iterator<Map.Entry<K, Double>> it = iterator();
            for (int i = 0; i < size; i++)
                a[i] = (T) new AbstractMap.SimpleEntry<K, Double>(it.next());
            if (a.length > size)
                a[size] = null;
            return a;
        }
    }

    private static final long serialVersionUID = 8188218128353913216L;

    /**
     * Save the state of the <tt>IdentityHashMap</tt> instance to a stream (i.e., serialize it).
     *
     * @serialData The <i>size</i> of the HashMap (the number of key-value mappings) (<tt>int</tt>), followed by the key (Object)
     * and value (Object) for each key-value mapping represented by the IdentityHashMap. The key-value mappings are
     * emitted in no particular order.
     */
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        // Write out and any hidden stuff
        s.defaultWriteObject();

        // Write out size (number of Mappings)
        s.writeInt(size);

        // Write out keys and values (alternating)
        K[] tab = table;
        double[] rv = rawValues;
        for (int i = 0; i < tab.length; i++) {
            Object key = tab[i];
            if (key != null) {
                s.writeObject(unmaskNull(key));
                s.writeDouble(rv[i]);
            }
        }
    }

    /**
     * Reconstitute the <tt>IdentityHashMap</tt> instance from a stream (i.e., deserialize it).
     */
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException, ClassNotFoundException {
        // Read in any hidden stuff
        s.defaultReadObject();

        // Read in size (number of Mappings)
        int size = s.readInt();

        // Allow for 33% growth (i.e., capacity is >= 2* size()).
        init(capacity((size * 4) / 3));

        // Read the keys and values, and put the mappings in the table
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            K key = (K) s.readObject();
            double value = s.readDouble();
            putForCreate(key, value);
        }
    }

    /**
     * The put method for readObject. It does not resize the table, update modCount, etc.
     */
    private void putForCreate(K key, double value) throws IOException {
        K k = maskNull(key);
        K[] tab = table;
        double[] rv = rawValues;
        int len = tab.length;
        int i = hash(k, len);

        Object item;
        while ((item = tab[i]) != null) {
            if (item == k)
                throw new java.io.StreamCorruptedException();
            i = nextKeyIndex(i, len);
        }
        tab[i] = k;
        rv[i] = value;
    }
}
