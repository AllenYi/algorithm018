
public class DeleteDuplicates {
// ɾ�����������е��ظ��	����һ���������飬����Ҫ�� ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
//	��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] lis=new int[]{1,1,2,2,5};


      System.out.printf("reslout="+remove(lis));

	}

	
  public static int remove(int[] nums) {
	  //�ⷨ�� ˫ָ��
	  int i=0;
	  //ʱ�临�Ӷȣ�O(n)O(n)��
	 // �ռ临�Ӷȣ�O(1)O(1)��
      for(int j=0;j<nums.length;j++){ //ѭ��
      	if(nums[j]!=nums[i]){ //�Ƚ� i ��  j λ�õ�Ԫ���Ƿ����
      		i++;
      		nums[i]=nums[j];
      	}
      }
		return i+1; //���� i+ 1����Ϊ�����鳤��
    }
	
}
