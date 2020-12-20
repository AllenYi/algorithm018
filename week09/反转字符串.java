package com.arithmeticHomeWorkNine;

public class Solution {
 public String reverseStr(String s, int k) {
     char[] a= s.toCharArray();
    for (int start = 0; start < a.length; start += 2 * k){
        int i = start; //start是每次需要翻转的下标开始位置
        //指定字符串反转结尾的指针j
        //因为判断结尾有两种情况，第一就是能反转k个，这个的前提是从start开始其后面的字符串长度足够长的时候，第二种情况就是能反转的小于k个了，
        // 也就是说字符串剩下的部分小于k了，就是从start开始只能取到s.length() - 1这么长了
        int j= Math.min(start +k -1,a.length -1 );
        while (i<j){//实现翻转
            char tmp = a[i];
            a[i++] = a[j];
            a[j--] = tmp;
        }
    }
    return new String(a);
    }

}
