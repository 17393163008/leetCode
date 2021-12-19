package com.pqq.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author pqq
 * @create ${year}-09-15 13:40
 */
public class _相邻时间最小值 {
    public int findMidDifference(List<String> timePoints)
    {
        if(timePoints.size() > 24*60)
        {

            return 0;
        }
        List<Integer> mins = new ArrayList<>();
        for(String t:timePoints)
        {
            String[] time = t.split(":");
            mins.add(Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]));
        }
        Collections.sort(mins);
        mins.add(mins.get(0) + 24 * 60);
        int res = 24*60;
        for (int i = 0; i < mins.size(); i++) {
            res = Math.min(res,mins.get(i) - mins.get(i-1));
        }
        return res;
    }

}
