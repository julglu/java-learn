package Objects.collections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

/*
 * Created by Юлия on 07.04.2017.
 */
public class CollectionExamples {
    public static void main(String[] args) throws IOException {
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
        /*File f = new File("D:\\lorem.txt");
        Set<String> rez = new HashSet<>();
        List<String> words = getWordsFromFile(f);

        rez.addAll(words);
        System.out.println(rez.size());*/

        //--------------------
        //Занятие 12
        //War and Peace
        //--------------------

        File wp = new File("D:\\wp.txt");
        //100 most popular words in War and Peace
        popularWords(wp, 100);
        System.out.println();
        popularWords(wp, 10);
        System.out.println();

        //Words in groups by their's length
        wordsInGroupsByLength(wp);
        System.out.println();

        //Top 10 the most popular word pairs
        wordsPairs(wp, 10);

        //Occurence frequency of each letter in %
        lettersPercent(wp);

    }

    private static Comparator<Map.Entry<String, Integer>> valuesCompare = new Comparator<Map.Entry<String, Integer>>() {
        @Override
        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o1.getValue() - o2.getValue();
        }
    };

    private static List<String> getWordsFromFile(File text) throws IOException {
        List<String> words = new ArrayList<>();
        List<String> linesWP = Files.readAllLines(text.toPath());

        for (String s : linesWP) {
            if (s.length() > 0) {
                s = s.toLowerCase().replaceAll("[^a-z^ ']", " ");
                s = s.replaceAll("\\ba\\b|\\ban\\b|\\bthe\\b| '|' |^'", " ");
                s = s.replaceAll(" +", " ").trim();
                words.addAll(Arrays.asList(s.split(" ")));
            }
        }
        return words;
    }

    private static void popularWords(File text, int topCnt) throws IOException {
        List<String> words = getWordsFromFile(text);
        Map<String, Integer> wordsCnt = new HashMap<>();
        List<Map.Entry<String, Integer>> rez = new ArrayList<>();

        for (String word : words) {
            if (wordsCnt.containsKey(word))
                wordsCnt.put(word, wordsCnt.get(word) + 1);
            else wordsCnt.put(word, 1);
        }

        rez.addAll(wordsCnt.entrySet());
        rez.sort(valuesCompare.reversed());

        for (int i = 0; i < topCnt; i++) {
            System.out.println(rez.get(i));
        }

    }

    private static void wordsInGroupsByLength(File text) throws IOException {
        List<String> words = getWordsFromFile(text);
        Map<Integer, Set<String>> lengthGroups = new HashMap<>();

        for (String word : words) {
            if (!lengthGroups.containsKey(word.length()))
                lengthGroups.put(word.length(), new HashSet<>());
            lengthGroups.get(word.length()).add(word);

        }
        System.out.println(lengthGroups);
    }

    private static void wordsPairs(File text, int topCnt) throws IOException {
        List<String> words = getWordsFromFile(text);
        Map<String, Integer> pairsCnt = new HashMap<>();
        List<Map.Entry<String, Integer>> sortedPairs = new ArrayList<>();

        for (int i = 0; i < words.size() - 1; i++) {
            String curPair = words.get(i) + " " + words.get(i + 1);
            if (!pairsCnt.containsKey(curPair))
                pairsCnt.put(curPair, 1);
            else pairsCnt.put(curPair, pairsCnt.get(curPair) + 1);
        }

        sortedPairs.addAll(pairsCnt.entrySet());
        sortedPairs.sort(valuesCompare.reversed());
        for (int i = 0; i < topCnt; i++) {
            System.out.println(sortedPairs.get(i));
        }
    }

    private static void lettersPercent(File text) throws IOException {
        Map<Character, Double> lettersCnt = new TreeMap<>();
        List<String> lines = Files.readAllLines(text.toPath());
        int totalCnt = 0;
        for (String line : lines) {
            line = line.toLowerCase().replaceAll("[^a-z]", "");
            totalCnt += line.length();
            char[] letters = line.toCharArray();
            for (char c : letters) {
                if (!lettersCnt.containsKey(c))
                    lettersCnt.put(c, 1.0);
                else lettersCnt.put(c, lettersCnt.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Double> m : lettersCnt.entrySet()) {
            lettersCnt.put(m.getKey(), 100 * m.getValue() / totalCnt);
        }
        System.out.println(lettersCnt);
    }

    private static <T> void shuffle(List<T> list) {
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

    private static <T> Set<T> Difference(Set<T> s1, Set<T> s2) {
        Set<T> newSet = new HashSet<>();
        newSet.addAll(s1);
        newSet.removeAll(s2);
        return newSet;
    }

    private static <T> Set<T> Intersect(Set<T> s1, Set<T> s2) {
        Set<T> newSet = new HashSet<>();
        newSet.addAll(s1);
        newSet.retainAll(s2);
        return newSet;
    }
}
