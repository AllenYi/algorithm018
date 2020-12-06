package com.arithmeticHomeWorkEight;

public class seven_zero {
    public int climbStairs(int n) {
        //递归，斐波那契数列
        // int a=0,b=0,c=1;
        // for(int i=0;i<n;i++){
        //     a=b;
        //     b=c;
        //     c=a+b;
        // }
        // return c;
        //第二种方法 由于知道是斐波那契 f(n)=f(n-1)+f(n-2) 套用数学公式
        double a= Math.sqrt(5);
        double b = Math.pow((1+a)/2,n+1)-Math.pow((1-a)/2,n+1);
        return  (int)(b/a);

    }
}
