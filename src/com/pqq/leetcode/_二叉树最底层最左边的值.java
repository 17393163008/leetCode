package com.pqq.leetcode;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}

/**
 * @author pqq
 * @create ${year}-09-16 9:03
 */
public class _二叉树最底层最左边的值 {
    int deep;
    int ans;

    public int findBootmLeftValue(TreeNode root) {
        deep = -1;
        dfs(root, 0);
        return ans;
    }

    private void dfs(TreeNode node, int curDeep) {
        if (node == null) {
            return;
        }
        //如果深度发生了变化，说明我们来到了新的一层的最左边的点
        if (curDeep > deep) {
            //到此我们就知道树的深度增加了
            deep = curDeep;
            //不断更新答案
            ans = node.val;
        }
        //前序遍历
        dfs(node.left, curDeep + 1);
        dfs(node.right, curDeep + 1);
    }
}


