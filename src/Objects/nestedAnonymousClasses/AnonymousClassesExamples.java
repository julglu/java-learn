package Objects.nestedAnonymousClasses;

import Objects.LinkedList.LinkedList;
import Objects.arrayList.ArrayList;
import Objects.interfaces.List;
import Objects.interfaces.Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
        LinkedList s=new LinkedList();
        s.push(7);
        s.push(1);
        s.push(8);
        //s.push(4);
        System.out.println(s.hashCode());
        LinkedList s2=new LinkedList();
        s2.push(7);
        s2.push(1);
        s2.push(8);
        s2.push(4);
        System.out.println(s.equals(s2));
        System.out.println(s2.hashCode());
        List l4=Utils.diff(l,l2);
        System.out.println(l4.toString());
        List l5=Utils.intersect(l,l2);
        System.out.println(l5.toString());
        List l6=Utils.toList(new Object[]{"1","2","5","7","3"});
        System.out.println(l6.toString());

        File dir1=new File("D:/dir1");
        File dir2=new File("D:/dir2");

        List files1=Utils.toList(dir1.listFiles());
        List files2=Utils.toList(dir2.listFiles());

        List duplicated=Utils.intersect(files1, files2, new Predicate2() {
            @Override
            public boolean apply(Object o1, Object o2) {
                if(((File)o1).length()!=((File)o2).length())
                    return false;
                try {
                    FileReader fr1=new FileReader((File)o1);
                    FileReader fr2=new FileReader((File)o2);
                    int c1=fr1.read(), c2;
                    while(c1>0){
                        c2=fr2.read();
                        if(c1!=c2)
                            return false;
                        c1=fr1.read();
                    }
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    return false;
                }
            }
        });
        for(Object o :duplicated){
            File f=(File)o;
            System.out.println(f.getName());
        }
        System.out.println();
        List filtered=Utils.filter(new Predicate() {
            @Override
            public boolean apply(Object o) {
                return ((File)o).length()>1024*1024;
            }
        }, files1);

        for(Object o :filtered){
            File f=(File)o;
            System.out.println(f.getName());
        }
        List filtered2=Utils.filter(new Predicate() {
            @Override
            public boolean apply(Object o) {
                String fileName=((File)o).getName();
                return fileName.substring(fileName.lastIndexOf(".")+1).equals("java");
            }
        }, files1);

        for(Object o :filtered2){
            File f=(File)o;
            System.out.println(f.getName());
        }

    }
}
