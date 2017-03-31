package Objects.nestedAnonymousClasses;

import Objects.LinkedList.LinkedList;
import Objects.arrayList.ArrayList;
import Objects.interfaces.List;

import java.util.Iterator;

/*
 * Created by Юлия on 27.03.2017.
 */
public class Utils {

    static Object find(Predicate pred, List list) {
        for (Object o : list) {
            if (pred.apply(o))
                return o;
        }
        return null;
    }

    static List filter(Predicate pred, List list) {
        List newList = new ArrayList();
        for (Object o : list) {
            if (pred.apply(o))
                newList.add(o);
        }
        return newList;
    }

    static List transform(Transformer trans, List list) {
        List newList = new ArrayList();
        for (Object o : list) {
            newList.add(trans.apply(o));
        }
        return newList;
    }

    static List diff(List l1, List l2) {
        List newList = new ArrayList();
        boolean match;
        for(Object o1:l1) {
            match=false;
            for(Object o2:l2) {
                if (o1.equals(o2)) {
                    match=true;
                    break;
                }
            }
            if(!match)
                newList.add(o1);
        }
        return newList;
    }

    static List diff(List l1, List l2, Predicate2 pred) {
        List newList = new ArrayList();
        boolean match;
        for(Object o1:l1) {
            match=false;
            for(Object o2:l2) {
                if (pred.apply(o1,o2)) {
                    match=true;
                    break;
                }
            }
            if(!match)
                newList.add(o1);
        }
        return newList;
    }

    static List intersect(List l1, List l2) {
        List newList = new ArrayList();
        boolean match;
        for(Object o1:l1) {
            match=false;
            for(Object o2:l2) {
                if (o1.equals(o2)) {
                    match=true;
                    break;
                }
            }
            if(match)
                newList.add(o1);
        }
        return newList;
    }

    static List intersect(List l1, List l2, Predicate2 pred) {
        List newList = new ArrayList();
        boolean match;
        for(Object o1:l1) {
            match=false;
            for(Object o2:l2) {
                if (pred.apply(o1,o2)) {
                    match=true;
                    break;
                }
            }
            if(match)
                newList.add(o1);
        }
        return newList;
    }

    static List toList(Object[] arr){
        List newList=new ArrayList();
        for (Object o:arr){
            newList.add(o);
        }
        return newList;
    }
}
