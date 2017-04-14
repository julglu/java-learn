package Objects.LinkedList;

import Objects.exceptions.getAbsentElementException;
import Objects.exceptions.modifyingWhileIterationException;
import Objects.interfaces.List;
import Objects.interfaces.Stack;

import java.util.Iterator;

/*
 * Created by Юлия on 20.03.2017.
 */
public class LinkedList<T> implements Stack, List<T> {

    public ListItem<T> startItem;

    public void add(T value) {
        ListItem<T> newItem = new ListItem<>(value);
        if (startItem == null) {
            startItem = newItem;
        } else {
            ListItem<T> curItem = startItem, nextItem;
            while (true) {
                nextItem = curItem.link;
                if (nextItem == null) {
                    curItem.link = newItem;
                    newItem.value = value;
                    break;
                }
                curItem = nextItem;
            }
        }
    }

    public T get(int i) {
        int cnt = 0;

        if (startItem == null) {
            throw new getAbsentElementException("Trying to get element from emply list");
        }
        ListItem<T> curItem = startItem;
        while (true) {
            if (cnt == i) {
                return curItem.value;
            }
            if (curItem.link == null) {
                throw new getAbsentElementException("There is no element with index "+i+" in list");
            }
            cnt++;
            curItem = curItem.link;
        }

    }

    public T remove(int i) {
        int cnt = 0;
        if (startItem == null) {
            return null;
        }
        if (i == 0) {
            T val = startItem.value;
            startItem = startItem.link;
            return val;
        }
        ListItem<T> curItem = startItem, prevItem = startItem;
        T val;
        while (true) {
            if (cnt == i) {
                val = curItem.value;
                prevItem.link = curItem.link;
                return val;
            }
            if (curItem.link == null) {
                System.out.println("Элемент с индексом " + i + " не найден");
                return null;
            }

            prevItem = curItem;
            curItem = curItem.link;
            cnt++;
        }
    }

    @Override
    public int hashCode() {
        int rez = 1;
        ListItem<T> next = startItem;
        while (next != null) {
            rez = 31 * rez + next.value.hashCode();
            next = next.link;
        }
        return rez;
    }

    @Override
    public int size() {
        ListItem<T> next = startItem;
        int cnt = 0;
        while (next != null) {
            cnt++;
            next = next.link;
        }
        return cnt;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        List l = (LinkedList) obj;
        Iterator iter1 = this.iterator();
        Iterator iter2 = l.iterator();
        while (iter1.hasNext()) {
            if (iter1.hasNext() != iter2.hasNext())
                return false;
            if (!iter1.next().equals(iter2.next()))
                return false;
        }
        return true;
    }

    @Override
    public void push(Object val) {
        ListItem next = startItem;
        startItem = new ListItem(val);
        startItem.link = next;
    }

    @Override
    public T poll() {
        return remove(0);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    public class LinkedListIterator<T> implements Iterator<T> {
        LinkedList<T> list;
        ListItem<T> next;
        int startHashCode;

        public LinkedListIterator(LinkedList<T> n) {
            list=n;
            next = n.startItem;
            startHashCode=n.hashCode();
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public T next() {
            if (hasNext()) {
                if(startHashCode!=list.hashCode())
                    throw new modifyingWhileIterationException("Unable to modify list while iteration");
                T v = next.value;
                next = next.link;
                return v;
            }
            return null;
        }

        @Override
        public void remove() {

        }
    }

    public static class ListItem<T> {
        public ListItem link;
        public T value;

        public ListItem(T value) {
            this.value = value;
        }
    }

}
