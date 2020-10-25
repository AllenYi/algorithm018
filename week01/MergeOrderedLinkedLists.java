
public class MergeOrderedLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//合并两个有序链表
	//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
	//时间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。因为每次调用递归都会去掉 l1 或者 l2 的头节点（直到至少有一个链表为空），函数 mergeTwoList 至多只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)O(n+m)。
	//空间复杂度：O(n + m)O(n+m)，其中 nn 和 mm 分别为两个链表的长度。递归调用 mergeTwoLists 函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。结束递归调用时 mergeTwoLists 函数最多调用 n+mn+m 次，因此空间复杂度为 O(n+m)O(n+m)。
	
	//递归解法
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 //如果两个链表有一个为空，递归结束
	        if(l1==null){
	            return l2;
	            }else if(l2==null){
	                return l1;
	            }else if(l1.val>l2.val){//我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点
	                l2.next = mergeTwoLists(l2.next,l1);
	                return l2;
	            }else{//我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点
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
