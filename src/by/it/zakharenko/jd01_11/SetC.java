package by.it.zakharenko.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    @SuppressWarnings("all")
    private T[] array = (T[]) new Object[]{};
    private int size = 0;

    //реализация toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(array[i]);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    // метод add(T element)
    @Override
    public boolean add(T element) {
        if (size == array.length)
            array = Arrays.copyOf(array, (size * 3) / 2 + 1);
        if (!contains(element))
            array[size++] = element;
        return false;
    }

    public int indexOf(Object o) {
        if (o == null)
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return i;
            }
        else
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i]))
                    return i;
            }
        return -1;
    }

    ///Task C ---------------------------------------

    //метод remove(Object o)
    @Override
    public boolean remove(Object o) {
        int i = indexOf(o);
        if (i > -1) {
            System.arraycopy(array, i + 1, array, i, size - i - 1);
            size--;
        }
        return (i > -1);
    }

    //метод contains(Object o)
    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    //метод size()
    @Override
    public int size() {
        return size;
    }

    //метод isEmpty()
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    //метод addAll(List <? > c)
    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (c != null && c.size() != 0) {
            for (T element : c) {
                add(element);
            }
            return true;
        }
        return false;
    }

    //метод containsAll(Collection<?> c)
    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<T> iterator = (Iterator<T>) c.iterator();
        while (iterator.hasNext())
            if (!contains(iterator.next()))
                return false;
        return true;
    }

    //метод removeAll(Collection<?> c)
    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator<?> myIterator = c.iterator();
        while (myIterator.hasNext()) {
            remove((T) myIterator.next());
        }
        return true;
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

    @Override
    public void clear() {
        size = 0;
    }

}
