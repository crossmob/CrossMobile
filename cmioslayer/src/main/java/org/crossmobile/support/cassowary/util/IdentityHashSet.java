package org.crossmobile.support.cassowary.util;

import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class IdentityHashSet<E> implements Set<E> {

    private IdentityHashMap<E, Object> map = new IdentityHashMap<E, Object>();

    @Override
    public boolean add(E element) {
        if (map.containsKey(element)) {
            return false;
        } else {
            map.put(element, null);
            return true;
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> elements) {
        boolean anyChanges = false;
        for (E element : elements) {
            if (!map.containsKey(element)) {
                anyChanges = true;
                map.put(element, null);
            }
        }
        return anyChanges;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean contains(Object element) {
        return map.containsKey(element);
    }

    @Override
    public boolean containsAll(Collection<?> elements) {
        for (Object element : elements) {
            if (!map.containsKey(element))
                return false;
        }
        return true;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean remove(Object element) {
        if (map.containsKey(element)) {
            map.remove(element);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> elements) {
        for (Object element : elements)
            map.remove(element);
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean retainAll(Collection<?> elements) {
        IdentityHashMap<E, Object> newMap = new IdentityHashMap<E, Object>();

        for (Object element : elements) {
            if (map.containsKey(element))
                newMap.put((E) element, null);
        }

        boolean anyChanges = newMap.size() != map.size();

        map = newMap;
        return anyChanges;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Unsupported operation on IdentityHashSet.");
    }

    @Override
    public <T> T[] toArray(T[] dummy) {
        throw new UnsupportedOperationException("Unsupported operation on IdentityHashSet.");
    }

    @Override
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("{");

        Iterator<Entry<E, Object>> i = map.entrySet().iterator();
        boolean hasNext = i.hasNext();
        while (hasNext) {
            Entry<E, Object> e = i.next();
            E key = e.getKey();
            buf.append(key);
            hasNext = i.hasNext();
            if (hasNext)
                buf.append(", ");
        }

        buf.append("}");
        return buf.toString();
    }

}