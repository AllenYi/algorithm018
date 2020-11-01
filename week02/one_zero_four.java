package com.arithmeticHomeWork;

public class one_zero_four {

    public  int  maxDepth(TreeNode root){
//        if(null==root){
//            return 0;
//        }
//        int leftsum = maxDepth(root.left); //得到最远的左边子叶节点
//        int rightsum = maxDepth(root.right);//得到最远的右边子叶节点
//        return Math.max(leftsum,rightsum)+1; //判断两者最大的加一则就是此二叉树最大的深度
        return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1; //简化写法
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

}
