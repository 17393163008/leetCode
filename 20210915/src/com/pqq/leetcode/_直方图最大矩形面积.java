package com.pqq.leetcode;

import java.time.Period;
import java.util.Stack;

/**
 * @author pqq
 * @create ${year}-09-15 18:46
 */
public class _直方图最大矩形面积 {
    public int largestRectangleArea(int[] heights)
    {
        Stack<Integer> stack = new Stack<>();
        //哨兵元素，在原数组头尾鸽子增加一个元素，代表前后的高度为0
        int[] addDummy = new int[heights.length+2];
        for (int i = 0; i < heights.length; i++) {
            addDummy[i+1] = heights[i];

        }
        heights = addDummy;
        stack.add(0);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while(heights[stack.peek()]>heights[i])
            {
                int height = heights[stack.pop()];
                int width = i - stack.peek()-1;
                maxArea = Math.max(maxArea,height*width);

            }
            stack.push(i);

        }
        return maxArea;
    }

}
