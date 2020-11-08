package com.arithmeticHomeWorkThree;

public class zero_five {
//剑指 Offer 05. 替换空格请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//示例 1：

//输入：s = "We are happy."
//输出："We%20are%20happy."

    public String replaceSpace(String s) {
//        return s.replaceAll(" ","%20");
        //  StringBuilder res = new StringBuilder();
        //     for(Character c : s.toCharArray())
        //     {
        //         if(c == ' ') res.append("%20"); //如果为空字符串直接替换成%20
        //         else res.append(c);//添加
        //     }
        //     return res.toString();

        //下面是官方解答
        int length = s.length();
        char[] array=  new char[length*3];//创建一个长度为s.length*3的数组来保持不数组越界
        int size = 0;
        for (int i=0;i<length;i++){
            char c = s.charAt(i);//一次拿出字符
            if (c==' '){ //判断是否为' ' 然后下面依次添加到array数组
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            }else {
                array[size++] = c;
            }
        }
        String newString = new String(array,0,size); //创建新的String 把array数组赋值进去
        return newString;
    }
}
