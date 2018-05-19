package by.it.shumilov.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListB<T> implements List<T> {

    private  T[] array= (T[])new Object[]{};

    private  int size = 0;

    @Override
    public int indexOf(Object o) {
        if(o == null){
            for (int i = 0; i < size; i++) {
                if (array[i] == null)
                    return i;
            }

        }
        else{
            for (int i = 0; i < size; i++) {
                if (o.equals(array[i]))
                    return i;
            }

        }


        return -1;
    }



    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] inCol = (T[]) c.toArray();
        int colLen = inCol.length;
        if (colLen == 0)
            return false;
        if (array.length <= colLen + size)
            array = Arrays.copyOf(array,array.length+colLen+1);
        System.arraycopy(inCol,0,array,size,colLen);
        size+=colLen;
        return true;
    }


    @Override
    public void add(int index, T element) {
        if(index < size){
            if (size == array.length)
                array = Arrays.copyOf(array,array.length*3/2+1);
            System.arraycopy(array, index,array,index+1,size-(index));
            size++;
            array[index] = element;
        }
        else if(index==size)
            this.add(element);



    }


    @Override
    public T set(int index, T element) {
        T oldVal = array[index];
        array[index] = element;
        return oldVal;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T remove(int index) {
        T delete = array[index];
        System.arraycopy(array, index+1,array,index,size-(index+1));
        size--;
        return delete;
    }

    @Override
    public boolean add(T t) {
        if (size == array.length)
            array = Arrays.copyOf(array,array.length*3/2+1);
        array[size++] = t;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            T t = array[i];
            sb.append(delimeter).append(t);
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
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)>-1;
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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public void clear() {

    }






    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
