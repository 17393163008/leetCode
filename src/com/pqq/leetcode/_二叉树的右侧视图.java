package com.pqq.leetcode;

import com.sun.org.apache.regexp.internal.RE;
import jdk.nashorn.internal.ir.ReturnNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pqq
 * @create ${year}-09-16 9:21
 */
public class _二叉树的右侧视图 {
    public List<Integer> rightSideView(TreeNode root)
    {
        List<Integer> list = new ArrayList<>();
        dfs(list,root,1);
        return list;
    }

    private void dfs(List<Integer> list, TreeNode root, int deep) {
        if(root == null)   //没有节点了
        {
            return;
        }
        if(deep > list.size())
        {
            list.add(root.val);
        }
        dfs(list,root.right,deep+1);
        dfs(list,root.left,deep+1);
    }


}
