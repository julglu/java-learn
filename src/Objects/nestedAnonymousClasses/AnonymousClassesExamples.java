package Objects.nestedAnonymousClasses;

import Objects.arrayList.ArrayList;
import Objects.interfaces.List;

/*
 * Created by Юлия on 27.03.2017.
 */
public class AnonymousClassesExamples {
    public static void main(String[] args) {
        List l=new ArrayList();
        l.add(7);
        l.add(5);
        l.add(18);
        l.add(1);
        l.add(3);
        l.add(62);
        System.out.println(l.toString());
        Object firstMatch= Utils.find(new Predicate() {
            @Override
            public boolean apply(Object o) {
                return (int)o>60;
            }
        }, l);
        System.out.println(firstMatch);
        System.out.println();

        List l2=Utils.filter(new Predicate() {
            @Override
            public boolean apply(Object o) {
                return o.toString().length()==1;
            }
        },l);

        System.out.println(l2.toString());
        System.out.println();
        List l3=Utils.transform(new Transformer() {
            @Override
            public Object apply(Object o) {
                return o.toString()+o.toString();
            }
        },l);

        System.out.println(l3.toString());



    }
}
