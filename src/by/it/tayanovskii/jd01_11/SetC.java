package by.it.tayanovskii.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private T[] array = (T[]) new Object[]{};
    private int size = 0;

//    add(T e), remove(Object o), contains(Object o), size(), isEmpty(),
//    addAll(List<?> c), containsAll(Collection<?> c), removeAll(Collection<?> c)


    @Override
    public boolean add(T element) {

        if (!contains(element)) {
            if (size == array.length)
                array = Arrays.copyOf(array, array.length * 3 / 2 + 1);

            array[size++] = element;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(contains(o))
        {
            remove(indexOf(o));
            return true;
        }
        return false;
    }


    public T remove(int index) {
        T deleted = array[index];
        System.arraycopy(array, index + 1, array, index, size - (index + 1));
        size--;
        return deleted;
    }


    @Override
    public boolean contains(Object o) {
        return (indexOf(o) > -1);
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

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> otherSet) {
        if (otherSet != null && otherSet.size() != 0) {
            for (T element : otherSet) {
                add(element);
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> otherSet) {
        if (otherSet == null && otherSet.size() == 0)
            return false;
        for (Object element : otherSet) if (!contains(element)) return false;

        return true;

    }


    @Override
    public boolean removeAll(Collection<?> otherSet) {
        if (otherSet == null && otherSet.size() == 0)
            return false;

        int flag=0;
        for (Object element : otherSet) {
            if(remove(element))
                flag++;
        }

        return flag>0;
    }


    @Override
    public void clear() {
        array = (T[]) new Object[]{};
        size=0;

    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            T element = array[i];
            sb.append(delimiter).append(element);
            delimiter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }




//TaskC-----------------------------------------------------------------------------------------------------------------------------------


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
