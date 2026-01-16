package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProductExceptSelf {
//    给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除了 nums[i] 之外其余各元素的乘积 。
//
//    题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
//
//    请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

    //    示例 1:
//
//    输入: nums = [1,2,3,4]
//    输出: [24,12,8,6]
//    示例 2:
//
//    输入: nums = [-1,1,0,-3,3]
//    输出: [0,0,9,0,0]
    public static void main(String[] args) {
        ProductExceptSelf p = new ProductExceptSelf();
        int[] ints = p.productExceptSelf(new int[]{1,2,3,4});
        System.out.println(Arrays.toString(ints));
    }

    public int[] productExceptSelf(int[] nums) {
        int []p=new int[nums.length];
        int[] lNums = new int[nums.length];
        int a = 1;
        for (int i = 0; i < nums.length; i++) {
            lNums[i] = a;
            a = a * nums[i];
        }

        a = 1;

        for (int i = nums.length-1; i>=0; i--) {
            p[i]=a*lNums[i];
            a=a*nums[i];
        }


        return p;

    }
}
