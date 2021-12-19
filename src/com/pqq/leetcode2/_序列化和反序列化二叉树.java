package com.pqq.leetcode2;

import com.sun.org.apache.xerces.internal.impl.xs.models.XSCMLeaf;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author pqq
 * @create ${year}-09-16 9:37
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class _序列化和反序列化二叉树 {
    //Encodes a tree to a single string.
    public String serialize(TreeNode root)
    {
        if(root == null)
            return new String();
        String res = "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode x = q.poll();
            if(x!=null)
            {
                res += ("" + x.val + ",");
                q.offer(x.left);
                q.offer(x.right);
            }else
            {
                res += ("null,");
            }
        }
        return res;
    }

    //Decode your encode data to tree
    public TreeNode deserialize(String data)
    {
        if(data.length()==0)
        {
            return null;
        }
        String[] ss = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode x = q.poll();
            if(!ss[idx].equals("null"))
            {
                x.left = new TreeNode(Integer.parseInt(ss[idx]));
                q.offer(x.left);
            }
            idx ++;
            if(!ss[idx].equals("null"))
            {
                x.right = new TreeNode(Integer.parseInt(ss[idx]));
                q.offer(x.right);
            }
            idx++;
        }
        return root;
    }
}

