package com.arithmeticHomeWorkNine;

public class Solution {
 public boolean isAnagram(String s, String t) {
    if (s.length()!=t.length())return false;
         int counter[] = new int[26];//新建26位长度计数器
        //s.charAt(index)是取出字符串s中的第index+1个字符 这里的-'a'代表的是减去ASCll码表里面的数值
        // a的ascll码是97 字符的计算是首先转换成对应的ascll码在计算 最后转换成 char类型 可以用(int)'a'强转查看ascll码值
         for (int i=0;i<s.length();i++){
          counter[s.charAt(i)- 'a']++;//正在递增由s.charAt(i) - 'A'索引的数组中的值， 此循环的作用是計算s中每個字母的出现的次数。
          counter[t.charAt(i)- 'a']--;//相应的上面++ 这里如果出现了同样的字符counter就要--
         }
         for (int num : counter){
             if (num>0){
                 return false;
             }
         }
         return true;
    }

}
