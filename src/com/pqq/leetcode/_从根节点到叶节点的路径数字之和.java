package com.pqq.leetcode;

import java.util.List;
import java.util.logging.Level;

/**
 * @author pqq
 * @create ${year}-09-16 10:06
 */
public class _从根节点到叶节点的路径数字之和 {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    private int dfs(TreeNode node, int last) {
        if(node == null)
        {
            return last;
        }
        //没到一个节点，他的前置数字都是已知的，只要简单地乘以10以上的值即可
        int cSum = last*10+node.val;
        //如果左右节点为空，那么说明已经找到了一条路径
        if(node.left==null && node.right==null)
        {
            return cSum;
        }

        //否则向左右两边继续寻找合法路径
        int lSum = 0;
        if(node.left!=null) lSum = dfs(node.left,cSum);
        int rSum = 0;
        if(node.right!=null) rSum = dfs(node.right,cSum);
        //左右两边的值加起来就是以当前节点为跟的子树的路径和
        return lSum+rSum;
    }
}
