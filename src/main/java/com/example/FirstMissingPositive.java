package com.example;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class FirstMissingPositive {
    //    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
//    请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//    示例 1：
//    输入：nums = [1,2,0]
//    输出：3
//    解释：范围 [1,2] 中的数字都在数组中。
//    示例 2：
//
//    输入：nums = [3,4,-1,1]
//    输出：2
//    解释：1 在数组中，但 2 没有。
//    示例 3：
//    输入：nums = [7,8,9,11,12]
//    输出：1
//    解释：最小的正数 1 没有出现。
    public static void main(String[] args) {

        FirstMissingPositive f = new FirstMissingPositive();
        int num[] = {7, 8, 9, 11, 12};
        int i = f.firstMissingPositive(num);
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int cur=nums[i];
            while (cur > 0 && cur <= n && cur != nums[cur - 1]) {
                int targetIndex = cur - 1;
                int temp = nums[cur - 1];
                nums[targetIndex] = cur;
                cur = temp;
            }

        }
        for (int i = 0; i < n; i++) {

            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;
    }
}
