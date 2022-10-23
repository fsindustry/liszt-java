package com.fsindustry.liszt.dp._91;

import java.util.Arrays;

public class DecodeWays {
}


// dynamic program
class Solution {

    private int[] cache;

    public int numDecodings(String s) {
        cache = new int[s.length() + 1];
        Arrays.fill(cache, -1);
        cache[s.length()] = 1;
        for (int start = s.length() - 1; start >= 0; start--) {
            int count = cache[start + 1];

            if ("0".equals(s.substring(start, start + 1))) {
                cache[start] = 0;
                continue;
            }

            if (start + 2 <= s.length() && "26".compareTo(s.substring(start, start + 2)) >= 0) {
                count += cache[start + 2];
            }
            cache[start] = count;
        }
        return cache[0];
    }
}

// memory search
class Solution1 {

    private int[] cache;

    private int countDecode(String s, int start) {
        if (s.length() == start) {
            return 1;
        }

        if ("0".equals(s.substring(start, start + 1))) {
            return 0;
        }

        if (cache[start] != -1) {
            return cache[start];
        }

        int count = countDecode(s, start + 1);
        if (start + 2 <= s.length() && "26".compareTo(s.substring(start, start + 2)) >= 0) {
            count += countDecode(s, start + 2);
        }
        return cache[start] = count;
    }

    public int numDecodings(String s) {
        cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return countDecode(s, 0);
    }
}

// recursion: timeout
class Solution2 {

    private int countDecode(String s, int start) {
        if (s.length() == start) {
            return 1;
        }

        if ("0".equals(s.substring(start, start + 1))) {
            return 0;
        }

        int count = countDecode(s, start + 1);
        if (start + 2 <= s.length() && "26".compareTo(s.substring(start, start + 2)) >= 0) {
            count += countDecode(s, start + 2);
        }
        return count;
    }

    public int numDecodings(String s) {
        return countDecode(s, 0);
    }
}
