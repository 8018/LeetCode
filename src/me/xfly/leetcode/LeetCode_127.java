package me.xfly.leetcode;

import java.util.*;

public class LeetCode_127 {

    public static void main(String[] args) {
        String[] dict = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(ladderLength("hit", "cog", dict));

       /* String[] dict = {"a", "b", "c"};

        System.out.println(ladderLength("a", "c", dict));*/
    }

    public static int ladderLength(String beginWord, String endWord, String[] wordList) {
        int distance = 0;

        List<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            distance++;
            List<String> next_level = new LinkedList<>();

            for (String o : queue) {
                if (o.equals(endWord)) {
                    return distance;
                }


                for (String l : wordList) {
                    if (visited.contains(l)) {
                        continue;
                    }
                    if (getWordDistance(o, l) == 1) {
                        next_level.add(l);
                        visited.add(l);
                    }
                }

            }
            if (next_level.size() == 0) return 0;
            queue = next_level;

        }

        return 0;

    }


    private static int getWordDistance(String first, String second) {
        if (first.length() != second.length()) {
            return -1;
        }
        int distance = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
