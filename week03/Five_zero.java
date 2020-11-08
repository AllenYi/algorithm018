package com.arithmeticHomeWorkThree;

//50. Pow(x, n)实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//示例 1:
//输入: 2.00000, 10
//输出: 1024.00000
//示例 2:
//输入: 2.10000, 3
//输出: 9.26100
//示例 3:
//输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
public class Five_zero {
    public double myPow(double x, int n) {
//        //暴力求解直接循环遍历 时间复杂度为 O(n)
//       long N= n;
//      if (n<0)
//      {
//          x=1/x;
//          n=-n;
//      }
//      double ans = 1;
//      for (long i=0;i<n;i++){
//          ans = ans * x;
//      }
//      return ans;


//   2.分治法 时间复杂度为0(logn)空间复杂度为 O(logn) 比如计算2的10次方
//   分解开来就是2的5次方乘以2的5次方 而2的五次方又可以分治 这里要区分n为奇数还是偶数

        if (n<0)return 1.0/myPow(x,-n);
        double ans =1.0;
        for (int i=n;i!=0;i/=2){ //二分法 每次循环除以2
            if (i%2!=0){ //当n为奇数的时候需要多乘一次本身
                ans *=x;
            }
            x *= x;
        }
        return n<0?1/ans:ans;










    }
}
