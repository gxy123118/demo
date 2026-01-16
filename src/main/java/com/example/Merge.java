package com.example;

import java.util.*;

public class Merge {
    //    以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
//    示例 1：
//    输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//    输出：[[1,6],[8,10],[15,18]]
//    解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//    示例 2：
//    输入：intervals = [[1,4],[4,5]]
//    输出：[[1,5]]
//    解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//    示例 3：
//    输入：intervals = [[4,7],[1,4]]
//    输出：[[1,7]]
//    解释：区间 [1,4] 和 [4,7] 可被视为重叠区间。
    public static void main(String[] args) {
        Merge m = new Merge();
        int a[][] = {{2, 6}, {1, 2}, {8, 10}, {1, 3}, {15, 18}};
        m.merge(a);
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = res.get(res.size() - 1);
            int[] cur = intervals[i];
            if (cur[0] > last[1]) {
                res.add(cur);
            } else {
                last[1] = Math.max(cur[1], last[1]);
            }

        }

        return res.toArray(new int[res.size()][]);
    }
}
