package Objects.Library;

/*
 * Created by Юлия on 21.03.2017.
 */
public class Library {
    public LibRecord[] library = new LibRecord[100];

    public void put(Book b, int q) {

        for (int i = 0; i < library.length; i++) {
            if (library[i] == null) {
                library[i]=new LibRecord(b,q);
                break;
            }
            if (library[i].book.equals(b)) {
                library[i].quantity += q;
                break;
            }
            if(i==library.length-1)
                System.out.println("Больше книг добавить нельзя");
        }

    }

    public int get(Book book, int quantity) {
        for (int i = 0; i < library.length; i++) {
            if (library[i] == null) {
                break;
            }
            if (library[i].book.equals(book)) {
                if (library[i].quantity >= quantity) {
                    library[i].quantity -= quantity;
                    return i;
                } else {
                    System.out.println("Искомой книги всего " + library[i].quantity + " экземпляров");
                    return -1;
                }
            }
        }
        System.out.println("Искомой книги в списке нет");
        return -1;
    }
}
