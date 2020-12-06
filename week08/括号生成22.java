package com.arithmeticHomeWorkEight;

import java.util.ArrayList;
import java.util.List;

public class two_two {
    public List<String> generateParenthesis(int n) {
          List<String> ans = new ArrayList<>();
          backtrack(ans,new StringBuilder(),0,0,n);
          return  ans;
    }

    private void backtrack(List<String> ans, StringBuilder cur, int left, int right, int n) {
      if (cur.length() == n*2){ //终止条件出循环 当整个cur长度刚好为n*2证明刚好长度条件达到了
          ans.add(cur.toString()); //把stringBuilder toString添加至List返回
          return ;
      }
      //如果左括号数量不大于 n，我们可以放一个左括号。如果右括号数量小于左括号的数量，我们可以放一个右括号
      if (left<n){//当左括号小于n
          cur.append('(');
          backtrack(ans,cur,left+1,right,n);
          cur.deleteCharAt(cur.length()-1); //移除cur中 cur.length()-1的位置的值
      }
      if (right<left){//当右括号小于左括号
          cur.append(')');
          backtrack(ans,cur,left,right+1,n);
          cur.deleteCharAt(cur.length()-1);
      }


    }
}
