package com.example;

import java.util.*;

public class MaxSlidingWindow {
//    给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
//
//    返回 滑动窗口中的最大值 。
//    示例 1：
//
//    输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//    输出：[3,3,5,5,6,7]
//    解释：
//    滑动窗口的位置                最大值
//---------------               -----
//        [1  3  -1] -3  5  3  6  7       3
//        1 [3  -1  -3] 5  3  6  7       3
//        1  3 [-1  -3  5] 3  6  7       5
//        1  3  -1 [-3  5  3] 6  7       5
//        1  3  -1  -3 [5  3  6] 7       6
//        1  3  -1  -3  5 [3  6  7]      7
//    示例 2：
//
//    输入：nums = [1], k = 1
//    输出：[1]

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(new MaxSlidingWindow().maxSlidingWindow(nums, k)));

    }

    public int[] maxSlidingWindow(int[] nums, int k){
        int []res=new int[nums.length+1-k];
        Deque<Integer>deque=new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty()&&i-deque.peekFirst()==k){
                deque.pollFirst();
            }
            while (!deque.isEmpty()&&nums[i]> deque.peekLast()){
                deque.pollLast();
            }
            deque.addLast(i);

            if (i>=k-1){
                res[i-k+1]=nums[deque.peekFirst()];
            }

        }
        return res;

    }
}
