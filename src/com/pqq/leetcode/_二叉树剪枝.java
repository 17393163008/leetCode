package com.pqq.leetcode;

import sun.util.resources.cldr.ff.CalendarData_ff_SN;

/**
 * @author pqq
 * @create ${year}-09-16 9:27
 */
public class _二叉树剪枝 {
    public TreeNode pruneTree(TreeNode root) {
        boolean res = dfs(root);
        if(res)
            return null;
        return root;
    }

    private boolean dfs(TreeNode node) {
        if(node == null)
        {
            return true;
        }
        boolean left = dfs(node.left);
        boolean right = dfs(node.right);

        if(left)
        {
            node.left = null;
        }
        if(right)
        {
            node.right = null;
        }

        return node.val == 0 && left && right;
    }
}
