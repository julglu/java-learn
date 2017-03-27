package Objects.arrayList;

import java.util.Iterator;

/**
 * Created by Юлия on 26.03.2017.
 */
public class ArrayListIterator implements Iterator {
    private ArrayList l;
    private int next;

    public ArrayListIterator(ArrayList list){
        l=list;
        next=0;

    }
    @Override
    public boolean hasNext() {
        return next<l.nextItemIndex;
    }

    @Override
    public Object next() {
        if(hasNext()) {
            next++;
            return l.items[next-1];
        }
        return null;
    }
}
