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

        for (T t : array) {
            if(o==null){
                if(t==null)return true;
                return false;
            }else{
                if(o!=null&&t==null) return false;
                if(o!=null&&t.equals(o)) return true;

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
            System.arraycopy(array,0,array,1,size);
            array[0] = t;
            size++;

            return true;
        }


        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                index = i;
            }
        }
        if (!(index == -1)) {
            System.arraycopy(array, index + 1, array, index, size - (index + 1));
            size--;
            return true;
        }
        return false;
    }


    @Override
    public boolean addAll(Collection<? extends T> c) {

        T[] arrayNew =(T[]) c.toArray();
        int lengthNew = arrayNew.length;
        int flag = size;
        arrayNew=Arrays.copyOf(array,array.length+lengthNew);
        for (int i = 0; i < array.length; i++) {
            if(!c.contains(array[i])){
                arrayNew[lengthNew++]=array[i];
                size++;
            }

        }
        array=Arrays.copyOf(arrayNew,arrayNew.length);
        if(size>flag) return true;

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
    public boolean containsAll(Collection<?> c) {
        return false;
    }



    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
