package com.pqq.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.logging.Level;

/**
 * @author pqq
 * @create ${year}-09-15 19:40
 */
public class _二叉树每层的最大值 {
    public List<Integer> largestValues(TreeNode root)
    {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            int mx = Integer.MIN_VALUE,cnt = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node == null)
                {
                    continue;
                }
                cnt++;
                mx = Math.max(mx,node.val);
                q.offer(node.left);
                q.offer(node.right);


            }
            if(cnt > 0)
                ans.add(mx);
        }
        return ans;
    }

}
