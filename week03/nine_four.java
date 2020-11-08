package com.arithmeticHomeWorkThree;

import com.arithmeticHomeWork.one_zero_four;
import com.j256.ormlite.stmt.query.In;

import java.util.ArrayList;
import java.util.List;

public class nine_four {
//94. 二叉树的中序遍历
    public List<Integer> inorderTraversal(one_zero_four.TreeNode root) {
            List<Integer> res =  new ArrayList<Integer>();
            inorder(root,res);
            return res;
    }
//时间复杂度: O(n)，其中 n 为二叉树节点的个数。二叉树的遍历中每个节点会被访问一次且只会被访问一次。
//空间复杂度：O(n)。空间复杂度取决于递归的栈深度，而栈深度在二叉树为一条链的情况下会达到 O(n) 的级别。
    public void  inorder(one_zero_four.TreeNode root,List<Integer> res){
            if (null==root) return ;
            //中序遍历左中右
            inorder(root.left,res);
            res.add(root.val);
            inorder(root.right,res);

    }
}
