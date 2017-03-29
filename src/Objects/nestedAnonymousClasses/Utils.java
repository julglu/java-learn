package Objects.nestedAnonymousClasses;

import Objects.arrayList.ArrayList;
import Objects.interfaces.List;

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
        List newList=new ArrayList();
        for (Object o : list) {
            if (pred.apply(o))
                newList.add(o);
        }
        return newList;
    }

     static List transform(Transformer trans, List list) {
        List newList=new ArrayList();
        for (Object o : list) {
            newList.add(trans.apply(o));
        }
        return newList;
    }
}
