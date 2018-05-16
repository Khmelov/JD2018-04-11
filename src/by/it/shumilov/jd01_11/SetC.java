package by.it.shumilov.jd01_11;



import java.util.*;

public class SetC<T> implements Set<T> {

    private  T[] array= (T[])new Object[]{};
    private int size = 0;



    private void addT(T t) {
        if (size == array.length)
            array = Arrays.copyOf(array,array.length*3/2+1);
        array[size++] = t;
    }

    private int indexOf(Object o) {
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
        return size == 0;
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
    public boolean add(T t) {
        if(size == 0){
            this.addT(t);
            return  true;
        }

        int element = this.indexOf(t);

        if (element < 0){
            this.addT(t);
            return  true;
        }
        else {
            return  false;
        }
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (indexOf(o) < 0)
            return false;
        else {
            System.arraycopy(array, index+1,array,index,size-(index+1));
            size--;
            return true;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {


        T[] inCol = (T[]) c.toArray();


        boolean ret = false;
        if (inCol.length == 0)
            return false;

        for (T t : inCol) {
            ret = contains(t) || ret;
        }
        return ret;


    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        T[] inCol = (T[]) c.toArray();
        int colLen = inCol.length;

        boolean ret = false;
        if (inCol.length == 0)
            return false;

        for (T t : inCol) {
            ret = add(t) || ret;
        }
        return ret;

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        T[] inCol = (T[]) c.toArray();


        boolean ret = false;
        if (inCol.length == 0)
            return false;

        for (T t : inCol) {
            ret = remove(t) || ret;
        }
        return ret;


    }

    @Override
    public void clear() {
        size= 0;

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }
}
