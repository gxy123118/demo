package com.example;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    //    给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//    示例 1：
//    输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//    输出：[1,2,3,6,9,8,7,4,5]
//    示例 2：
//
//
//    输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//    输出：[1,2,3,4,8,12,11,10,9,5,6,7]
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {

                result.add(matrix[left][i]);
            }
            top++;
            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            right--;
            if (top > bottom || left > right) {
                break;
            }
            // 步骤3：从右到左遍历最下行
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom--; // 收缩最下行边界

            // 步骤4：从下到上遍历最左列
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++; // 收缩最左列边界
        }
        return result;
    }
}
