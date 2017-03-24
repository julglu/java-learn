package Objects.Library;

/*
 * Created by Юлия on 21.03.2017.
 */
public class Book {
    public String author;
    public String title;
    public int pagesNum;

    public Book(String a, String t, int p) {
        author = a;
        title = t;
        pagesNum = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (pagesNum != book.pagesNum) return false;
        if (!author.equals(book.author)) return false;
        return title.equals(book.title);
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + pagesNum;
        return result;
    }
}
