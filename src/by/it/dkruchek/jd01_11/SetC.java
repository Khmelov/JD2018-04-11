package by.it.dkruchek.jd01_11;

import java.util.*;

/**
 * Created by Dmitriy.Kruchek on 5/15/2018.
 */
public class SetC<T> implements Set<T> {

    private HashMap<T, Object> map = new HashMap<>();

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public boolean add(T element) {
        if (! contains(element)) {
            map.put(element, null);
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean remove(Object o) {
        if (this.contains(o)) {
            map.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean modified = false;
        for (T element : c)
            if (add(element))
                modified = true;
        return modified;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean modified = false;
        for (Object element : c)
            if (remove(element))
                modified = true;
        return modified;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {

        Set<T> keys = map.keySet();
        Iterator<T> i = keys.iterator();
        if (! i.hasNext())
            return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T e = i.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (! i.hasNext())
                return sb.append(']').toString();
            sb.append(',').append(' ');
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

// Task C -----------------------------------------
    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
