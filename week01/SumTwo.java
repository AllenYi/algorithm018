import java.util.HashMap;
import java.util.Map;

//两数之和
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 
//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

public class SumTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
//	时间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。对于每一个元素 x，我们可以 O(1)O(1) 地寻找 target - x。

//	空间复杂度：O(N)O(N)，其中 NN 是数组中的元素数量。主要为哈希表的开销。

	public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map= new HashMap<>(); //创建一个Hash表
        for(int i = 0;i<nums.length;++i){//遍历数组
        	//这里判断查询哈希表中是否存在 target - nums[i]
            if(map.containsKey(target - nums[i])){ 
            	return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);//将 nums[i] 插入到哈希表中，即可保证不会让 nums[i] 和自己匹配。
        }
       return new int[0];
   }
}
