package com.arithmeticHomeWork;

import java.lang.reflect.Array;
import java.util.Arrays;

//242. 有效的字母异位词 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
public class two_four_two {

    //排序的方法
    public boolean isAnagram(String s,String t){
        //通过将 ss 的字母重新排列成 tt 来生成变位词。因此，如果 TT 是 SS 的变位词，
        // 对两个字符串进行排序将产生两个相同的字符串。
        if(s.length()!=t.length()){return false;}//两个长度不相等直接返回false
        //把两个字符串 charArray分解成数组
        char[] str1 =  s.toCharArray();
        char[] str2 = t.toCharArray();
        //两个字符串分辨sort 升序排序
        Arrays.sort(str1);
        Arrays.sort(str2);
        //最后直接两两判断返回结果值
        return Arrays.equals(str1,str2);
     //排序方法的时间复杂度:时间复杂度：O(n \log n)O(nlogn)，假设 nn 是 ss 的长度，排序成本 O(n\log n)O(nlogn) 和比较两个字符串的成本 O(n)O(n)。排序时间占主导地位，总体时间复杂度为 O(n \log n)O(nlogn)。
        //空间复杂度：O(1)O(1)，空间取决于排序实现，如果使用 heapsort，通常需要 O(1)O(1) 辅助空间。注意，在 Java 中，toCharArray() 制作了一个字符串的拷贝，所以它花费 O(n)O(n) 额外的空间，但是我们忽略了这一复杂性分析，因为：
        //这依赖于语言的细节,这取决于函数的设计方式。例如，可以将函数参数类型更改为 char[]。
    }

    //哈希表的方法
    //方法二：哈希表
    //算法：
    //为了检查 tt 是否是 ss 的重新排列，我们可以计算两个字符串中每个字母的出现次数并进行比较。因为 SS 和 TT 都只包含 A-ZA−Z 的字母，所以一个简单的 26 位计数器表就足够了。
    //我们需要两个计数器数表进行比较吗？实际上不是，因为我们可以用一个计数器表计算 ss 字母的频率，用 tt 减少计数器表中的每个字母的计数器，然后检查计数器是否回到零。
    public boolean isAnagramHash(String s,String t){
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
