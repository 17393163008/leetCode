package com.pqq.leetcode;

import com.sun.javafx.image.BytePixelSetter;
import org.omg.CORBA.INTERNAL;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author pqq
 * @create ${year}-09-15 18:55
 */
public class _举行中最大的矩形 {
    public int maximalRectangle(String[] matrix)
    {
        int Row = matrix.length;
        if(Row == 0)
        {
            return 0;
        }
        int Col = matrix[0].length();

        int res = 0;
        int[] height = new int[Col];

        for(int r = 0; r < Row; r++)
        {
            for(int c = 0; c < Col; c++)
            {
                if(matrix[r].charAt(c)=='1')
                    height[c]++;
                else
                    height[c] = 0;
            }
            res = Math.max(res,get_max_rectangle_area(height));

        }
        return res;
    }

    private int get_max_rectangle_area(int[] heights) {
        int n = heights.length;

        int[] left_less = new int[n];
        Deque<Integer> stk = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int x = heights[i];
            while(!stk.isEmpty() && heights[stk.peekLast()]>= x)
            {
                stk.pollLast();

            }
            left_less[i] = !stk.isEmpty() ? stk.peekLast() : -1;
            stk.addLast(i);

        }
        int [] right_less = new int[n];
        while(!stk.isEmpty())
            stk.pollLast();
        for(int i = n-1; i > -1; i--)
        {
            int x  = heights[i];
            while (!stk.isEmpty() && heights[stk.peekLast()]>=x)
            {
                stk.pollLast();
            }
            right_less[i] = !stk.isEmpty() ? stk.peekLast() : n;
            stk.addLast(i);
        }

        int res = 0;
        for(int i = 0; i < n; i++)
        {
            int cur = (right_less[i] - left_less[i]-1) * heights[i];
            res = Math.max(res,cur);
        }
        return res;
    }

}
