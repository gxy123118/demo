package com.example;

import java.util.HashMap;
import java.util.HashSet;

public class SubarraySum {
//    给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
//    子数组是数组中元素的连续非空序列。
//    示例 1：
//    输入：nums = [1,1,1], k = 2
//    输出：2
//    示例 2：
//    输入：nums = [1,2,3], k = 3
//    输出：2
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - k)) {
                count += map.get(preSum - k);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);

        }
        return count;
    }
}
