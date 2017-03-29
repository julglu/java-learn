package Objects.LinkedList;

import Objects.interfaces.List;
import Objects.interfaces.Stack;

import java.util.Iterator;

/*
 * Created by Юлия on 20.03.2017.
 */
public class LinkedList implements Stack, List {

    public ListItem startItem;

    public void add(Object value) {
        ListItem newItem = new ListItem(value);
        if (startItem == null) {
            startItem = newItem;
        } else {
            ListItem curItem = startItem, nextItem;
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


    public Object get(int i) {
        int cnt = 0;

        if (startItem == null) {
            System.out.println("Список пуст");
            return -1;
        }
        ListItem curItem = startItem;
        while (true) {
            if (cnt == i) {
                return curItem.value;
            }
            if (curItem.link == null) {
                System.out.println("Искомый элемент не найден");
                return -1;
            }
            cnt++;
            curItem = curItem.link;
        }

    }

    public Object remove(int i) {
        int cnt = 0;
        if (startItem == null) {
            return null;
        }
        if (i == 0) {
            Object val = startItem.value;
            startItem = startItem.link;
            return val;
        }
        ListItem curItem = startItem, prevItem = startItem;
        Object val;
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
    public void push(Object val) {
        ListItem next = startItem;
        startItem = new ListItem(val);
        startItem.link = next;
    }

    @Override
    public Object poll() {
        return remove(0);
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator(startItem);
    }

    public static class LinkedListIterator implements Iterator {
        ListItem next;

        public LinkedListIterator(ListItem n) {
            next = n;
        }

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                Object v = next.value;
                next = next.link;
                return v;
            }
            return null;
        }

        @Override
        public void remove() {

        }
    }

    public static class ListItem {
        public ListItem link;
        public Object value;

        public ListItem(Object value) {
            this.value = value;
        }
    }
}
