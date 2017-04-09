package Objects.collections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/*
 * Created by Юлия on 07.04.2017.
 */
public class CollectionExamples {
    public static void main(String[] args) throws IOException{
        //Задание 1 Shuffle
        List<Integer> l1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            l1.add(i);
        }
        System.out.println(Arrays.toString(l1.toArray()));
        shuffle(l1);
        System.out.println(Arrays.toString(l1.toArray()));

        //Задание 2 Set Intersect & Difference
        Set<Integer> s1 = new HashSet<>();
        s1.add(5);
        s1.add(2);
        s1.add(7);
        s1.add(1);
        s1.add(8);
        s1.add(3);

        Set<Integer> s2 = new HashSet<>();
        s2.add(9);
        s2.add(2);
        s2.add(7);
        s2.add(3);

        Set<Integer> s3 = Difference(s1, s2);
        System.out.println(Arrays.toString(s3.toArray()));
        Set<Integer> s4 = Intersect(s1, s2);
        System.out.println(Arrays.toString(s4.toArray()));

        //Задание 3 Количество уникальных слов в файле
        File f=new File("D:\\lorem.txt");
        List<String> lines= Files.readAllLines(f.toPath());
        List<String> rezult=new ArrayList<>();
        List<String> words=new ArrayList<>();
        for (String s:lines){
            s=s.toLowerCase().replaceAll("[^a-z^A-z^ ]"," ").trim();
            s=s.replaceAll("  "," ");
            words.addAll(Arrays.asList(s.split(" ")));

        }
        for(String word:words){
            if(!rezult.contains(word))
                rezult.add(word);
        }
        System.out.println(rezult.size());

    }

    static <T> void shuffle(List<T> list) {
        T tmp;
        int shuffleCnt = 0;
        boolean[] indexes = new boolean[list.size()];

        Random rnd = new Random();
        while (true) {
            int i1 = rnd.nextInt(list.size()), i2;
            while (true) {
                i2 = rnd.nextInt(list.size());
                if (i1 != i2)
                    break;
            }
            if (!indexes[i1] && !indexes[i2]) {
                tmp = list.get(i1);
                list.set(i1, list.get(i2));
                list.set(i2, tmp);
                indexes[i1] = indexes[i2] = true;
                shuffleCnt++;
            }

            if (shuffleCnt >= list.size() / 2) {
                break;
            }
        }

    }

    static <T> Set<T> Difference(Set<T> s1, Set<T> s2) {
        Set<T> newSet = new HashSet<>();
        newSet.addAll(s1);
        newSet.removeAll(s2);
        return newSet;
    }

    static <T> Set<T> Intersect(Set<T> s1, Set<T> s2) {
        Set<T> newSet = new HashSet<>();
        newSet.addAll(s1);
        newSet.retainAll(s2);
        return newSet;
    }
}
