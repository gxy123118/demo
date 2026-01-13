package com.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MinWindow {
    //    给定两个字符串 s 和 t，长度分别是 m 和 n，返回 s 中的 最短窗口 子串，使得该子串包含 t 中的每一个字符（包括重复字符）。如果没有这样的子串，返回空字符串 ""。
//    测试用例保证答案唯一。
//    示例 1：
//    输入：s = "ADOBECODEBANC", t = "ABC"
//    输出："BANC"
//    解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
//    示例 2：
//    输入：s = "a", t = "a"
//    输出："a"
//    解释：整个字符串 s 是最小覆盖子串。
//    示例 3:
//
//    输入: s = "a", t = "aa"
//    输出: ""
//    解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//    因此没有符合条件的子字符串，返回空字符串。
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        MinWindow minWindow = new MinWindow();
        System.out.println(minWindow.minWindow(s, t));


    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] tNum = new int[128];
        char[] charArray = t.toCharArray();
        int needType = 0;
        for (char c : charArray) {
            if (tNum[c] == 0) {
                needType++;
            }
            tNum[c]++;
        }
        int l = 0;
        int v = 0;
        int minL = Integer.MAX_VALUE;
        int start = 0;
        boolean b = true;
        int[] window = new int[128];
        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);
            //是t所需要的
            if (tNum[ch] > 0) {
                window[ch]++;
                if (tNum[ch] == window[ch]) {
                    v++;
                }
            }
            //收缩窗口
            while (v == needType) {
                int len = r - l + 1;
                if (len < minL) {
                    minL = len;
                    start = l;
                }
                char lch = s.charAt(l);

                if (tNum[lch] > 0) {
                    window[lch]--;
                    if (window[lch] < tNum[lch]) {
                        v--;
                    }
                }
                l++;

            }

        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(start, start + minL);
    }
}
