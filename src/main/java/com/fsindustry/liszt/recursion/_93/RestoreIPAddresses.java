package com.fsindustry.liszt.recursion._93;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        test1();
    }

    static void test1() {
        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("25525511135").toString());
    }
}

class Solution {

    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (null == s || "".equals(s) || s.length() < 4 || s.length() > 12) {
            return Collections.emptyList();
        }
        List<Integer> path = new ArrayList<>();
        path.add(s.charAt(0) - '0');
        dfs(s, 1, path);
        return res;
    }

    private void dfs(String s, int idx, List<Integer> path) {
        if (s.length() == idx) {
            if (path.size() == 4) {
                res.add(toIP(path));
            }
            return;
        }

        int cur = path.get(path.size() - 1);
        int next = cur * 10 + (s.charAt(idx) - '0');
        if (next <= 255 && cur != 0) {
            path.set(path.size() - 1, next);
            dfs(s, idx + 1, path);
            path.set(path.size() - 1, cur);
        }

        if (path.size() < 4) {
            path.add(s.charAt(idx) - '0');
            dfs(s, idx + 1, path);
            path.remove(path.size() - 1);
        }
    }

    private String toIP(List<Integer> path) {
        StringBuilder ip = new StringBuilder();
        ip.append(path.get(0));
        for (int i = 1; i < path.size(); i++) {
            ip.append(".").append(path.get(i));
        }
        return ip.toString();
    }
}