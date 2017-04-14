package Objects.exceptions;

import Objects.LinkedList.LinkedList;
import Objects.arrayList.ArrayList;
import Objects.interfaces.List;

/**
 * Created by Юлия on 12.04.2017.
 */
public class listExceptionsTest {
    public static void main(String[] args) {
        List<Integer> testArrayList1=new ArrayList<>();
        List<Integer> testLinkedList1=new LinkedList<>();

        for (int i = 0; i <5 ; i++) {
            testArrayList1.add(i);
            testLinkedList1.add(i);
        }

        //int testGet1=testArrayList1.get(7);
        //System.out.println(testGet1);

        /*for (int e:testArrayList1) {
            System.out.println(e);
            if(e==2)
                testArrayList1.remove(e);
        }*/
        for (int e:testLinkedList1) {
            System.out.println(e);
            if(e==2)
                testLinkedList1.remove(e);
        }

        /*for (int e:testLinkedList1){
            testLinkedList1.add(3);
        }*/

    }



}
