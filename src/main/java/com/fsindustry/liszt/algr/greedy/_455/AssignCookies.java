package com.fsindustry.liszt.algr.greedy._455;

import sun.security.pkcs11.wrapper.Functions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;

public class AssignCookies {
    public static void main(String[] args) {
    }
}

class Solution {
    public int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0, res = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                j++;
                i++;
                res++;
            } else {
                j++;
            }
        }
        return res;
    }
}
