package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class SetZeroes {
    //    给定一个 m x n的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。
//    请使用 原地 算法。
//    示例 1：
//
//    输入：matrix =[[1,1,1],[1,0,1],[1,1,1]]
//    输出：[[1,0,1],[0,0,0],[1,0,1]]
//    示例 2：
//
//
//    输入：matrix =[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
//    输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
    public static void main(String[] args) {
        int a[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        SetZeroes s=new SetZeroes();
        s.setZeroes(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(Arrays.toString(a[i]));
        }
    }

    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> rowList = new ArrayList<>();
        ArrayList<Integer> colList = new ArrayList<>();
        int rowL=matrix.length;
        int colL=matrix[0].length;
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                if (matrix[i][j] == 0) {
                    rowList.add(i);
                    colList.add(j);
                }
            }
        }
        for (int i = 0; i < rowL; i++) {
            for (int j = 0; j < colL; j++) {
                if (colList.contains(j) || rowList.contains(i)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
