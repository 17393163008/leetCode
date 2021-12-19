package com.pqq.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

/**
 * @author pqq
 * @create ${year}-09-16 10:20
 */
public class _向下的路径节点之和 {
    int targetSum;
    int res = 0;
    Map<Integer,Integer> presum_cnt = new HashMap<>();

    public int pathSum(TreeNode root, int targetSum)
    {
        this.targetSum = targetSum;
        res = 0;
        presum_cnt.put(0,1);
        backtrace(root,0);
        return res;
    }

    private void backtrace(TreeNode x, int cur_presum) {
        if(x == null)
            return;

        cur_presum += x.val;
        if(presum_cnt.containsKey(cur_presum-targetSum)==true)
            res+=presum_cnt.get(cur_presum-targetSum);

        presum_cnt.put(cur_presum,presum_cnt.getOrDefault(cur_presum,0)+1);
        backtrace(x.left,cur_presum);
        backtrace(x.right,cur_presum);
        presum_cnt.put(cur_presum,presum_cnt.get(cur_presum)-1);
    }

}
