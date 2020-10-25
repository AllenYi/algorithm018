
public class DeleteDuplicates {
// 删除排序数组中的重复项：	给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//	不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] lis=new int[]{1,1,2,2,5};


      System.out.printf("reslout="+remove(lis));

	}

	
  public static int remove(int[] nums) {
	  //解法： 双指针
	  int i=0;
	  //时间复杂度：O(n)O(n)。
	 // 空间复杂度：O(1)O(1)。
      for(int j=0;j<nums.length;j++){ //循环
      	if(nums[j]!=nums[i]){ //比较 i 和  j 位置的元素是否相等
      		i++;
      		nums[i]=nums[j];
      	}
      }
		return i+1; //返回 i+ 1，即为新数组长度
    }
	
}
