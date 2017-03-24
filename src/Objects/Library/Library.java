package Objects.Library;

import Objects.LinkedList.LinkedList;
import Objects.LinkedList.ListItem;

/*
 * Created by Юлия on 21.03.2017.
 */
public class Library {
    private int l;
    public LinkedList[] library;

    public Library(int l){
        this.l=l;
        library = new LinkedList[l];
    }

    public void put(Book b, int q) {
        int index = Math.abs(b.hashCode()) % l;
        if (library[index] == null) {
            library[index] = new LinkedList();
            library[index].add(new LibRecord(b, q));

        } else {
            ListItem item = library[index].startItem;
            while (true) {
                if (((LibRecord) item.value).book.equals(b)) {
                    ((LibRecord) item.value).quantity += q;

                    break;
                }
                if (item.link == null) { //Если элемент последний, то искомой книги в списке нет, добавим новый элемент списка
                    library[index].add(new LibRecord(b, q));
                    break;
                }
                item = item.link;
            }
        }
    }

    public int get(Book book, int quantity) {
        int index = Math.abs(book.hashCode()) % l;
        if (library[index] == null) {
            System.out.println("Искомой книги в списке нет");
            return -1;
        }
        ListItem item = library[index].startItem;

        while (true) {
            if (((LibRecord) item.value).book.equals(book)) {
                if (((LibRecord) item.value).quantity >= quantity) {
                    ((LibRecord) item.value).quantity -= quantity;
                } else {
                    System.out.println("Искомой книги всего " + ((LibRecord) item.value).quantity + " экземпляров");
                }
                return ((LibRecord) item.value).quantity;
            }
            if (item.link == null) {
                break;
            }
            item = item.link;
        }
        System.out.println("Искомой книги в списке нет");
        return -1;
    }

}
