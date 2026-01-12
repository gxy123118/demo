package com.example;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    //    给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
//    示例 1:
//    输入: s = "cbaebabacd", p = "abc"
//    输出: [0,6]
//    解释:
//    起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//    起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
//    示例 2:
//    输入: s = "abab", p = "ab"
//    输出: [0,1,2]
//    解释:
//    起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//    起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//    起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
    public static void main(String[] args) {
        System.out.println(new FindAnagrams().findAnagrams("cbaebabacd", "abc"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] pNums = new int[26];
        int[] sNums = new int[26];
        for (int i = 0; i < p.length(); i++) {
            pNums[p.charAt(i) - 'a']++;
            sNums[s.charAt(i) - 'a']++;
        }
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()){
            return res;
        }

        if (isMatch(sNums, pNums)) {
            res.add(0);
        }
        for (int r = p.length(); r < s.length(); r++){
            sNums[s.charAt(r) - 'a']++;
            sNums[s.charAt(r - p.length()) - 'a']--;

            if (isMatch(sNums, pNums)){
                res.add(r - p.length() + 1);
            }


        }
        return res;
    }
    public Boolean isMatch(int[] sNums, int[] pNums) {
        for (int i = 0; i < 26; i++) {
            if (sNums[i] != pNums[i]) {
                return false;
            }
        }
        return true;
    }
}
