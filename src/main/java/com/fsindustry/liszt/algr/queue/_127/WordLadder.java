package com.fsindustry.liszt.algr.queue._127;

import java.util.*;

public class WordLadder {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution s = new Solution();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(s.ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }
}


class Solution {

    static class Pair {
        private final String word;
        private final int step;

        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 边界条件
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int step = pair.step;

            for (String ele : wordList) {
                if (matched(word, ele) && !visited.contains(ele)) {
                    if (ele.equals(endWord)) {
                        return step + 1;
                    }

                    queue.offer(new Pair(ele, step + 1));
                    visited.add(ele);
                }
            }
        }

        return 0;
    }

    private boolean matched(String word, String word2) {

        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

class Solution1 {

    static class Pair {
        private final String word;
        private final int step;

        public Pair(String word, int step) {
            this.word = word;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // 边界条件
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        if (wordSet.contains(beginWord)) {
            wordSet.remove(beginWord);
        }
        List<String> visited = new ArrayList<>();

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            int step = pair.step;

            visited.clear();
            for (String ele : wordSet) {
                if (matched(word, ele)) {
                    if (ele.equals(endWord)) {
                        return step + 1;
                    }
                    queue.offer(new Pair(ele, step + 1));
                    visited.add(ele);
                }
            }

            wordSet.removeAll(visited);
        }

        return 0;
    }

    private boolean matched(String word, String word2) {

        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}