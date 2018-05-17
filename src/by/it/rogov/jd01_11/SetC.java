package by.it.rogov.jd01_11;

import java.util.*;


public class SetC<T> implements Set<T> {
    private T[] array = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimetr = "";
        for (int i = 0; i < size; i++) {

            sb.append(delimetr).append(array[i]);
            delimetr = ", ";
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
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {


        for (int i = 0; i < size; i++) {

            if (o == null) {

                if (array[i] == null) {

                    return true;

                }


            } else {

                if (array[i] != null && array[i].equals(o))

                    return true;

            }

        }

        return false;
    }

    @Override
    public boolean add(T t) {
        if (!contains(t)) {
            if (size == array.length) {
                array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
            }
            array[size++] = t;


            return true;
        }


        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;

        for (int i = 0; i < size; i++) {

            if (o == null) {

                if (array[i] == null) {

                    index = i;
                    break;

                }

            } else {

                if (array[i] != null && array[i].equals(o)) {

                    index = i;
                    break;

                }

            }

        }

        if (index >= 0) {

            if (index + 1 < size)

                System.arraycopy(array, index + 1, array, index, size - index - 1);

            size--;

            return true;

        }

        return false;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {

        for (T t : c) {
            add(t);
        }

        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {

            if (!contains(o))

                return false;

        }

        return true;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Iterator myIt = c.iterator();

        for (int i = 0; i < c.size(); i++) {

            remove(myIt.next());

        }

        return true;
    }

    @Override
    public void clear() {
        System.arraycopy(array, 0, array, 0, 0);

        size = 0;

    }
}
