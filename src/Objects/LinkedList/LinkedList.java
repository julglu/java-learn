package Objects.LinkedList;

/*
 * Created by Юлия on 20.03.2017.
 */
public class LinkedList {

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

    public Object getVal(int i) {
        int cnt = 0;

        if (startItem == null) {
            System.out.println("Список пуст");
            return -1;
        } else {
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
    }

    public void remove(int i) {
        int cnt = 0;
        if (startItem == null) {
            System.out.println("Список пуст");

        } else if (i == 0) {
            startItem = startItem.link;
        } else {
            ListItem curItem = startItem, prevItem = startItem;
            while (true) {
                if (cnt == i) {
                    prevItem.link = curItem.link;
                    break;
                }
                if (curItem.link == null) {
                    System.out.println("Элемент с индексом " + i + " не найден");
                    break;
                }

                prevItem = curItem;
                curItem = curItem.link;
                cnt++;
            }
        }
    }
}
