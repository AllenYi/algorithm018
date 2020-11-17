package com.arithmeticHomeWorkFour;

//买卖股票的最佳时机
public class one_two_two {
    public int maxMoney(int[] prices){
        //循环判断当天减去前一天是否大于0大于零则有的赚或者说下一天是否比今天卖的贵
        int sum=0;
        for (int i=1;i<prices.length;i++){//这里注意i=0因为第一天不能卖只能买
            int  len=prices[i]-prices[i-1];
            if (len>0){
                sum+=len;
            }
        }
        return sum;
    }
}
