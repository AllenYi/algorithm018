// �ƶ���
//����һ������ nums����дһ������������ 0 �ƶ��������ĩβ��ͬʱ���ַ���Ԫ�ص����˳�򡣸���һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��
//���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢�������֡�
//����Լ���������� 0 ֮�⣬��������������㿪ͷ��
public class MobileZeroa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
	}

	 public void moveZeroes(int[] nums) {
         if(0==nums.length)return;
         int sss = nums.length;
         if(0==sss)return;
         int j=0;
         for (int i=0;i<sss;i++){ //����
             if(nums[i]!=0){  //����������ֵ��Ϊ��
                 if(i>j){ //˫ָ��������λ��
                 nums[j]= nums[i];//ֵ��ǰŲ
                 nums[i]=0; //ԭ����λ�ø�ֵΪ0
                 }
                 j++;//jָ��++����Ų
             }
         }
   }
	 
	 class Solution {
			public void moveZeroes(int[] nums) {
				if(nums==null) {
					return;
				}
				//��һ�α�����ʱ��jָ���¼��0�ĸ�����ֻҪ�Ƿ�0��ͳͳ������nums[j]
				int j = 0;
				for(int i=0;i<nums.length;++i) {
					if(nums[i]!=0) {
						nums[j++] = nums[i];
					}
				}
				//��0Ԫ��ͳ�����ˣ�ʣ�µĶ���0��
				//���Եڶ��α�����ĩβ��Ԫ�ض���Ϊ0����
				for(int i=j;i<nums.length;++i) {
					nums[i] = 0;
				}
			}
		}	

	 
	
}
