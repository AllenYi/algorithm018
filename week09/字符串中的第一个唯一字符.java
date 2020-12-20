package com.arithmeticHomeWorkNine;

public class Soultion {
 public int firstUniqChar(String s) {
         HashMap<Character ,Integer> count = new HashMap<>();
            int n =  s.length();
            for (int i =0 ;i<n;i++){ //循环遍历把每个字符拆分存贮到HashMap中
                char c = s.charAt(i);
                count.put(c,count.getOrDefault(c,0)+1);
            }
            //只遍历了两遍字符串，同时散列表中查找操作是常数时间复杂度的。
            for(int i = 0;i<n;i++){
                if (count.get(s.charAt(i))==1){
                    return  i;
                }
            }
            return -1;
    }
}
