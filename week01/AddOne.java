//加一
//给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//你可以假设除了整数 0 之外，这个整数不会以零开头。
public class AddOne {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){ //遍历数组
            digits[i]++;//除 9 之外的数字加一,  数字 9；
            //加一得十进一位个位数为 0 加法运算如不出现进位就运算结束了且进位只会是一。
            //如此循环直到判断没有再进位就退出循环返回结果。
            //。只要+1求余数，余数不等于0，说明没有进位，直接返回。如果余数等于0，说明有进位，遍历前一个数字，
            //加1再求余数，以此循环。如果for循环都遍历完了，说明最高位也有进位，则重新建立一个数组，初始化为0，将第一位设置为1就可以了，因为，99、999之类的数字加一为100、1000
            digits[i] = digits[i]%10;
            if(digits[i]!=0){
                return digits;
            }
        }
        digits =  new int[digits.length+1];
        digits[0]=1;//补位
        return digits;
    }
	
}
