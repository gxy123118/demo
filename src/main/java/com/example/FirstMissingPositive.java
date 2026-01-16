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
//
//    输入：nums = [7,8,9,11,12]
//    输出：1
//    解释：最小的正数 1 没有出现。
    public static void main(String[] args) {
        FirstMissingPositive f = new FirstMissingPositive();
        int num[] = {1, 2, 0};
        int i = f.firstMissingPositive(num);
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        boolean b = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0 && b) {
                a = nums[i];
                b = false;
            } else {
                a++;
            }
            if (nums[i] - 1 > 0 && a != nums[i]) {
                return nums[i] - 1;
            }
            if (i == nums.length - 1) {
                if (nums[i] > 0) {
                    return nums[i] + 1;
                } else {
                    return 1;
                }
            }
        }

        return 0;
    }
}
