package Objects.arrayList;

import Objects.interfaces.List;

import java.util.Iterator;

/*
 * Created by Юлия on 26.03.2017.
 */
public class ArrayList implements List {

    private final int DEFAULT_SIZE = 10;
    public int nextItemIndex;//Индекс первого пустого элемента в массиве
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
    public void add(Object o) {
        if (nextItemIndex >= items.length) {
            Object[] newArray = new Object[items.length * 2];
            System.arraycopy(items, 0, newArray, 0, items.length);
            items = newArray;
        }

        items[nextItemIndex] = o;
        nextItemIndex++;

    }

    @Override
    public Object get(int index) {
        if (index >= 0 && index < nextItemIndex)
            return items[index];
        else return null;
    }

    @Override
    public Object remove(int index) {
        if (index >= 0 && index < nextItemIndex) {
            Object o = items[index];
            System.arraycopy(items, index + 1, items, index, nextItemIndex - index - 1);
            nextItemIndex--;
            return o;
        } else return null;
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator(this);
    }
}
