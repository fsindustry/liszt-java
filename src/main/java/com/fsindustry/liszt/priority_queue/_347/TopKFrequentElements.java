package com.fsindustry.liszt.priority_queue._347;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Solution1 s = new Solution1();
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(s.topKFrequent(nums, k)));
    }
}

class Solution {

    static class Pair {
        private final int num;
        private final int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int getFreq() {
            return freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 1）统计数组元素出现频率
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer freq = countMap.getOrDefault(num, 0);
            countMap.put(num, freq + 1);
        }

        // 2）构建最小堆
        PriorityQueue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(Pair::getFreq));
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (queue.size() < k) {
                queue.add(new Pair(entry.getKey(), entry.getValue()));
            } else {
                assert queue.peek() != null;
                if (queue.peek().freq < entry.getValue()) {
                    queue.poll();
                    queue.add(new Pair(entry.getKey(), entry.getValue()));
                }
            }
        }

        // 3）输出结果
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(queue.poll()).num;
        }

        return result;
    }
}

class Solution1 {

    static class Pair {
        private final int num;
        private final int freq;

        public Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        public int getFreq() {
            return freq;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // 1）统计数组元素出现频率
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            Integer freq = countMap.getOrDefault(num, 0);
            countMap.put(num, freq + 1);
        }

        // 2）构建最大堆
        List<Integer> result = new ArrayList<>(k);
        int size = countMap.size() - k;
        if (size == 0) {
            return countMap.keySet().stream().mapToInt(i -> i).toArray();
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>(size, Comparator.comparingInt(Pair::getFreq).reversed());
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (queue.size() < size) {
                queue.add(new Pair(entry.getKey(), entry.getValue()));
            } else {
                assert queue.peek() != null;
                if (entry.getValue() < queue.peek().freq) {
                    result.add(queue.poll().num);
                    queue.add(new Pair(entry.getKey(), entry.getValue()));
                } else {
                    result.add(entry.getKey());
                }
            }
        }

        // 3）输出结果集
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
