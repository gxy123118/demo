package com.example;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
    //    给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
//    示例 1:
//    输入: s = "abcabcbb"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
//    示例 2:
//    输入: s = "bbbbb"
//    输出: 1
//    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//    示例 3:
//    输入: s = "pwwkew"
//    输出: 3
//    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//    请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。abba
    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abba"));
    }

    // ... existing code ...
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        // 使用HashMap存储字符及其最新索引位置
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        for (int end = 0; end < charArray.length; end++) {
            char currentChar = charArray[end];
            if (charIndexMap.containsKey(currentChar) && charIndexMap.get(currentChar) >= start) {
                start = charIndexMap.get(currentChar) + 1;
            }
            charIndexMap.put(currentChar, end);
            maxLength = Math.max(maxLength, end - start + 1);

        }
        return maxLength;
    }
// ... existing code ...
}
