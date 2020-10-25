
public class DeleteDuplicates {
//	给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//	不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] lis=new int[]{1,1,2,2,5};
    //  int[] retoultList=  remove(list);
	  	System.out.printf("reslout="+remove(lis));

      for(int i =0;i<lis.length;i++){
    	//  	System.out.printf("reslout="+remove[list]);

      }
	}

	
  public static int remove(int[] nums) {
	  int i=0;
      for(int j=0;j<nums.length;j++){
      	if(nums[j]!=nums[i]){
      		i++;
      		nums[i]=nums[j];
      	}
      }
		return i+1;
    }
	
}
