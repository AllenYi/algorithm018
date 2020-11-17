package com.arithmeticHomeWorkFour;
//860. 柠檬水找零
//示例 1：
//输入：[5,5,5,10,20]
//输出：true
//解释：
//前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//由于所有客户都得到了正确的找零，所以我们输出 true。
//示例 2：
//输入：[5,5,10]
//输出：true
//示例 3：
//输入：[10,10]
//输出：false

public class eight_six_zero {
    //这一题主要考贪心算法或者暴力求解
    public boolean main(int[] bills){
        int five=0,ten=0;
        for (int bill :bills){
            if (bill==5){
                five++;
            }else if (bill==10){
                if (five<=0)return false;
                five--;
                ten++;
            }else {
                if (five>0 && ten>0){
                    five--;ten--;
                }else if (five>=3){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;
//        for (int bill : bills){
//            switch (bill){
//                case 5:
//                    five++;break;
//                case 10:
//                    five--;ten++;break;
//                case 20:
//                    if (ten>0){
//                        ten--;five--;
//                    }else {
//                        five-=3;
//                    }
//                    break;
//                default: break;
//            }
//            if (five<0){ //当five 小于0则不满足条件了，需要额外的五块来找零
//                return false;
//            }
//        }
//        return true;
    }

}
