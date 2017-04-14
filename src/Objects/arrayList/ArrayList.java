package Objects.arrayList;

import Objects.exceptions.getAbsentElementException;
import Objects.exceptions.modifyingWhileIterationException;
import Objects.interfaces.List;

import java.util.Iterator;

/*
 * Created by Юлия on 26.03.2017.
 */
public class ArrayList<T> implements List<T> {

    private final int DEFAULT_SIZE = 10;
    int nextItemIndex;//Индекс первого пустого элемента в массиве
    Object[] items;

    public ArrayList() {
        items = new Object[DEFAULT_SIZE];
        nextItemIndex = 0;
    }

    public ArrayList(int size) {
        items = new Object[size];
        nextItemIndex = 0;
    }

    @Override
    public int size() {
        return nextItemIndex;
    }

    @Override
    public void add(T o) {
        if (nextItemIndex >= items.length) {
            Object[] newArray = new Object[items.length * 2];
            System.arraycopy(items, 0, newArray, 0, items.length);
            items = newArray;
        }

        items[nextItemIndex] = o;
        nextItemIndex++;

    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < nextItemIndex)
            return (T)items[index];
        else throw new getAbsentElementException("There is no element with index "+index+" in list");
    }

    @Override
    public T remove(int index) {
        if (index >= 0 && index < nextItemIndex) {
            T o = (T)items[index];
            System.arraycopy(items, index + 1, items, index, nextItemIndex - index - 1);
            nextItemIndex--;
            return o;
        } else return null;
    }

    @Override
    public int hashCode() {
        int rez=1;
        for (int i = 0; i < nextItemIndex; i++) {
            if(get(i)!=null)
                rez+=31*rez+get(i).hashCode();
            else rez+=31*rez;
        }
        return rez;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator<>(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{'");
        int length = 2;
        for (int i = 0; i < nextItemIndex; i++) {
            T o = (T)items[i];
            sb.append(o.toString() + "', '");
            length += o.toString().length() + 4;
        }

        sb.delete(length - 3, length);
        sb.append("}");
        return sb.toString();
    }


    public class ArrayListIterator<T> implements Iterator<T> {
        private ArrayList<T> l;
        private int next;
        private int startHashCode;

        public ArrayListIterator(ArrayList<T> list) {
            l = list;
            next = 0;
            startHashCode =l.hashCode();
        }

        @Override
        public boolean hasNext() {
            return next < l.nextItemIndex;
        }

        @Override
        public T next() {
            if (hasNext()) {
                int curHashCode=l.hashCode();
                if(startHashCode !=curHashCode)
                    throw new modifyingWhileIterationException("Unable to modify list while iteration");
                next++;
                return (T)l.items[next - 1];
            }
            return null;
        }
    }
}
