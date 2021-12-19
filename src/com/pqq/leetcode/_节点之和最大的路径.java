package com.pqq.leetcode;

/**
 * @author pqq
 * @create ${year}-09-16 15:02
 */
public class _节点之和最大的路径 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root)
    {
        dfs_NLR(root);
        return res;
    }

    public int dfs_NLR(TreeNode x)
    {
        if(x==null)
            return 0;
        int l = dfs_NLR(x.left);   //向左遍历
        int r = dfs_NLR(x.right);  //向右遍历

        int cur_sum = x.val + Math.max(0,l)+Math.max(0,r);
        res = Math.max(res,cur_sum);

        return x.val+Math.max(Math.max(0,l),Math.max(0,r));
    }

}
