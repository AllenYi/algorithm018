
public class MergeOrderedLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//�ϲ�������������
	//��������������ϲ�Ϊһ���µ� ���� �������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ�
	//ʱ�临�Ӷȣ�O(n + m)O(n+m)������ nn �� mm �ֱ�Ϊ��������ĳ��ȡ���Ϊÿ�ε��õݹ鶼��ȥ�� l1 ���� l2 ��ͷ�ڵ㣨ֱ��������һ������Ϊ�գ������� mergeTwoList ����ֻ��ݹ����ÿ���ڵ�һ�Ρ���ˣ�ʱ�临�Ӷ�ȡ���ںϲ���������ȣ��� O(n+m)O(n+m)��
	//�ռ临�Ӷȣ�O(n + m)O(n+m)������ nn �� mm �ֱ�Ϊ��������ĳ��ȡ��ݹ���� mergeTwoLists ����ʱ��Ҫ����ջ�ռ䣬ջ�ռ�Ĵ�Сȡ���ڵݹ���õ���ȡ������ݹ����ʱ mergeTwoLists ���������� n+mn+m �Σ���˿ռ临�Ӷ�Ϊ O(n+m)O(n+m)��
	
	//�ݹ�ⷨ
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 //�������������һ��Ϊ�գ��ݹ����
	        if(l1==null){
	            return l2;
	            }else if(l2==null){
	                return l1;
	            }else if(l1.val>l2.val){//����Ҫ�ж� l1 �� l2 ��һ�������ͷ�ڵ��ֵ��С��Ȼ��ݹ�ؾ�����һ����ӵ������Ľڵ�
	                l2.next = mergeTwoLists(l2.next,l1);
	                return l2;
	            }else{//����Ҫ�ж� l1 �� l2 ��һ�������ͷ�ڵ��ֵ��С��Ȼ��ݹ�ؾ�����һ����ӵ������Ľڵ�
	                l1.next = mergeTwoLists(l1.next,l2);
	                return l1;
	            }
	    }
	
	
	  public class ListNode {
		      int val;
		      ListNode next;
		      ListNode() {}
		      ListNode(int val) { this.val = val; }
		      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	 
}
