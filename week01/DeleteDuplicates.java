
public class DeleteDuplicates {
//	����һ���������飬����Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
//	��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�

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
