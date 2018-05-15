package by.it.krivenkova.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size > 0)
            return false;
        else
            return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) continue;
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

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
    public boolean add(T element) {
        if (size == elements.length)
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        if (!contains(element))
            elements[size++] = element;
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int pos = 0;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    pos = i;
                    for (int j = pos; j < size; j++) {
                        elements[j] = elements[j + 1];
                    }
                    size--;
                    return true;
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (elements[i] == null) continue;
            if (elements[i].equals(o)) {
                pos = i;
                for (int j = pos; j < size; j++) {
                    elements[j] = elements[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elements[i] == null)
                    return i;
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<T> iterator = (Iterator<T>) c.iterator();
        while (iterator.hasNext())
            if (!contains(iterator.next())) return false;
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] element = (T[]) c.toArray();
        for (T t : element) {
            add(t);
        }
        return false;

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> iter = c.iterator();
        while (iter.hasNext()) {
            remove((T) iter.next());
        }
        return true;
    }

    @Override
    public void clear() {
        size = 0;
    }
}