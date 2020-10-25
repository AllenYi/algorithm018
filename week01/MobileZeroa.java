// 移动零
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
//最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
//你可以假设除了整数 0 之外，这个整数不会以零开头。
public class MobileZeroa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

	 public void moveZeroes(int[] nums) {
         if(0==nums.length)return;
         int sss = nums.length;
         if(0==sss)return;
         int j=0;
         for (int i=0;i<sss;i++){ //遍历
             if(nums[i]!=0){  //当符合条件值不为零
                 if(i>j){ //双指针来交换位置
                 nums[j]= nums[i];//值往前挪
                 nums[i]=0; //原来的位置赋值为0
                 }
                 j++;//j指针++往后挪
             }
         }
   }
	 
	 class Solution {
			public void moveZeroes(int[] nums) {
				if(nums==null) {
					return;
				}
				//第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
				int j = 0;
				for(int i=0;i<nums.length;++i) {
					if(nums[i]!=0) {
						nums[j++] = nums[i];
					}
				}
				//非0元素统计完了，剩下的都是0了
				//所以第二次遍历把末尾的元素都赋为0即可
				for(int i=j;i<nums.length;++i) {
					nums[i] = 0;
				}
			}
		}	

	 
	
}
