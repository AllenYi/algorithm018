package com.arithmeticHomeWorkThree;

//剑指 Offer 68 - II. 二叉树的最近公共祖先
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
//例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
//示例 1:
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
//示例 2:
//输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
//说明:
//所有节点的值都是唯一的。
//p、q 为不同节点且均存在于给定的二叉树中。
public class six_eight {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
          if (root==null||root==p||root==q)return root; //当root等空或者等于p q 则证明找到了可以退出遍历
          TreeNode left = lowestCommonAncestor(root.left,p,q);//遍历左子树
          TreeNode right = lowestCommonAncestor(root.right,p,q);//遍历右子树
          if (left==null){return right;}//如果left左子树为空则在root节点的右子树上面我们直接返回右子树的查找结果
          if (right==null){return left;}//如果right右子树为空则在root节点的左子树上面我们直接返回左子树的查找结果

        return  root;//如果左右都不是m没有找到则是两个节点一个在root的左边一个在右边root就是最近的公共祖先
    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
}
