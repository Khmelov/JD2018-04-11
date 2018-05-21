package by.it.shekh.jd01_11;

import java.util.*;


public class SetC<T> implements Set<T> {
    @SuppressWarnings("all")
    private T[] array = (T[]) new Object[]{};
    private int size = 0;

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


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return true;
            }
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == null) continue;
            if (array[i].equals(o)) return true;
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
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean add(T t) {
        int flag = 0;
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return false;
            }
            if (size == array.length)
                array = Arrays.copyOf(array, (size * 3 / 2 + 1));
            array[size++] = t;
            return true;
        }
        for (int i = 0; i < size; i++) {
            if (array[i] == null) continue;
            if (array[i].equals(t)) flag++;
            if (flag > 0) return false;
        }
        if (flag == 0) {
            if (size == array.length)
                array = Arrays.copyOf(array, (size * 3 / 2 + 1));
            array[size++] = t;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int position = 0;
        
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    position = i;
                    for (int j = position; j < size; j++) {
                        array[j] = array[j + 1];
                    }
                    size--;
                    return true;
                }
            }
        }

        for (int i = 0; i < size; i++) {
            if (array[i] == null) continue;
            if (array[i].equals(o)) {
                position = i;
                for (int j = position; j < size; j++) {
                    array[j] = array[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            if (!contains(iterator.next()))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            add((T) iterator.next());
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        int count = 0;
        for (Object element : collection) {
            if (remove(element))
                count++;
        }
        return count > 0;
    }

    @Override
    public void clear() {
        size = 0;
    }


}
