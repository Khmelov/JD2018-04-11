package by.it.kasiyanov.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        if (!contains(t)){
            elements[size++] = t;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] arr = (T[]) c.toArray();
        int tmpSize = size;
        for (T arrElement : arr) {
            add(arrElement);
        }
        return !(tmpSize == size);
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    System.arraycopy(elements, i + 1, elements, i, size - (i + 1));
                    size--;
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    System.arraycopy(elements, i + 1, elements, i, size - (i + 1));
                    size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] arr = (T[]) c.toArray();
        int tmpSize = size;
        for (T arrElement : arr) {
            if (contains(arrElement)) {
               remove(arrElement);
            }
        }
        return !(tmpSize == size);
    }

    @Override
    public void clear() {
        size = 0;

    }

    @Override
    public boolean containsAll(Collection<?> c) {
        T[] arr = (T[]) c.toArray();
        for (T arrElement : arr) {
                if (!contains(arrElement)) {
                    return false;
                }
        }
        return true;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
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
    public boolean retainAll(Collection<?> c) {
        return false;
    }

}
