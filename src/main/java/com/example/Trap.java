package com.example;

public class Trap {
    //    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
//    示例 1：
//    输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//    输出：6
//    解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
//    示例 2：
//
//    输入：height = [4,2,0,3,2,5]
//    输出：9
    public int trap(int[] height) {
//        int area = 0;
//        int leftMax[]=new int[height.length];
//        int rightMax[]=new int[height.length];
//        leftMax[0]=height[0];
//        for (int i = 1; i < height.length; i++){
//            leftMax[i]=Math.max(leftMax[i-1],height[i]);
//        }
//        rightMax[height.length-1]=height[height.length-1];
//        for (int i = height.length - 2; i>=0  ; i--) {
//            rightMax[i]=Math.max(rightMax[i+1],height[i]);
//
//        }
//        for (int i = 0; i < height.length; i++) {
//            area+=Math.min(leftMax[i],rightMax[i])-height[i];
//
//        }
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int area = 0;

        while(left<right){
            if (height[left]<height[right]){
                if (height[left]>=leftMax){
                    leftMax=height[left];
                }else {
                    area+=leftMax-height[left];
                }
            }else {
                if (height[right]>=rightMax){
                    rightMax=height[right];
                }else {
                    area+=rightMax-height[right];
                }
            }
        }




        return area;
    }
}
