package Lesson3;
import java.util.*;

public class Number3 {
    public static void main(String[] args) {
        String[] words = {"one", "two", "three", "four", "five", "one", "five", "six", "seven", "nine"};

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println("");

        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println("");

        Phonebook pb = new Phonebook();

        pb.add("Ivanov", "78-15-12");
        pb.add("Petrov", "12-15-75");
        pb.add("Ivanova", "28-13-12");

        System.out.println(pb.get("Petrov"));
    }

        static class Phonebook {
            private Map<String, ArrayList<String>> phonebook = new HashMap<>();

            public void add(String surname, String number) {
                if (!phonebook.containsKey(surname)) {
                    phonebook.put(surname, new ArrayList<>());
                }
                phonebook.get(surname).add(number);
            }
            public ArrayList<String> get(String surname) {
                return phonebook.get(surname);

            }}}
