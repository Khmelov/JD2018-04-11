package by.it.kurmaz.jd01_11;

import java.util.*;

public class SetC<T> implements Set {
    private int size= 0;
    private T[] elements = (T[]) new Object[]{};

    @Override
    public boolean add(Object o) {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, size+1);
        if (!this.contains(o)) {
            elements[size++] = (T) o;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            T element = (T) iter.next();
            if(!this.contains(element)) {
                elements = Arrays.copyOf(elements, size+1);
                elements[size++] = element;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            T element = (T) iter.next();
            if (!this.contains(element))
                return false;
        }
        return true;
    }

    @Override
    public void clear() {
        elements = Arrays.copyOf(elements, 0);
        size = 0;
    }

    @Override
    public boolean remove(Object o) {
        if(this.contains(o)) {
            int index = 0;
            if (o == null) {
                for (int i = 0; i < size; i++) {
                    if (elements[i] == null)
                        index = i;
                }
            } else {
                for (int i = 0; i < size; i++) {
                    if (o.equals(elements[i]))
                        index = i;
                }
            }
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
            elements = Arrays.copyOf(elements, size - 1);
            size--;
        }
        else
            return false;
        return true;
    }

    @Override
    public boolean removeAll(Collection c) {
        if (size == 0)
            return false;
        Iterator iter = c.iterator();
        while (iter.hasNext()) {
            T element = (T) iter.next();
            if(this.contains(element)) {
                int index = 0;
                if (element == null) {
                    for (int i = 0; i < size; i++) {
                        if (elements[i] == null)
                            index = i;
                    }
                }
                else {
                    for (int i = 0; i < size; i++) {
                        if (element.equals(elements[i]))
                            index = i;
                    }
                }
                System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
                elements = Arrays.copyOf(elements, size-1);
                size--;
            }
        }
        return true;

    }

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
        return (size == 0);
    }

    @Override
    public boolean contains(Object o) {
        for (T element: elements) {
            if (o == null) {
                if (element == null)
                    return true;
            }
            else if (o.equals(element))
                return true;
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
