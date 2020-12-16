package com.arithmeticHomeWorkNine;

public class one_one_two_two {
//1122. 数组的相对排序
//给你两个数组，arr1 和 arr2，
//arr2 中的元素各不相同
//arr2 中的每个元素都出现在 arr1 中
//对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
//示例：
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
    public int[] relativeSortArray(int[] arr1,int[] arr2){
        int[] tmp = new int[1001]; //new 一个新的数组来存放 arr1中每个数字的个数
        for (int num : arr1){
          tmp[num]++; //将arr1中每个数字出现的次数 累加
        }
        int poss=0; // arr1的索引位置，也是arr2中含有出现的数字在arr1中的最大长达
        for(int num : arr2){ //
            while (tmp[num]>0){ //当arr2中的数字也在arr1中出现时
                arr1[poss++]=num; //在arr1上从0开的位置添加arr2中的顺序的值
                tmp[num]--; // num值的总数要减1保证数量的不变
            }
        }
        //第三个for循还添加arr2中没有的值
        for(int i = 0;i<1001;++i){
            while (tmp[i]>0){
                arr1[poss++]=i;
                tmp[i]--;
            }
        }

        return arr1;
    }

}
