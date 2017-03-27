package Objects.arrayList;

import Objects.LinkedList.LinkedList;
import Objects.interfaces.List;

import java.util.Iterator;

/*
 * Created by Юлия on 26.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        List list1=new ArrayList();
        List list2=new LinkedList();

        for (int i = 0; i <12 ; i++) {
            list1.add(i);
            list2.add(i);
        }

        System.out.println();
        Object x=list1.remove(7);
        Object y=list2.remove(7);


        x=list1.remove(8);
        y=list2.remove(8);
        list1.add(7);
        list2.add(7);
        Iterator iter1= list1.iterator();
        while (iter1.hasNext()) {
            Object o = iter1.next();
            System.out.println(o.toString());
        }
        System.out.println();
        Iterator iter2= list2.iterator();
        while (iter2.hasNext()) {
            Object o = iter2.next();
            System.out.println(o.toString());
        }
    }



}
