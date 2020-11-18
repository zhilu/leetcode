package leetcode.editor.cn;

//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order, and each of their nodes contains a si
//ngle digit. Add the two numbers and return the sum as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// 
// Example 1: 
//
// 
//Input: l1 = [2,4,3], l2 = [5,6,4]
//Output: [7,0,8]
//Explanation: 342 + 465 = 807.
// 
//
// Example 2: 
//
// 
//Input: l1 = [0], l2 = [0]
//Output: [0]
// 
//
// Example 3: 
//
// 
//Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//Output: [8,9,9,9,0,0,0,1]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in each linked list is in the range [1, 100]. 
// 0 <= Node.val <= 9 
// It is guaranteed that the list represents a number that does not have leading
// zeros. 
// 
// Related Topics Linked List Math 
// 👍 9745 👎 2447

public class AddTwoNumbers{
	public static void main(String[] args) {
		Solution solution = new AddTwoNumbers().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */



      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }



class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up=0;
        ListNode head = null;
        ListNode tail = null;
        while (null !=l1 && null != l2){
            int sum = l1.val+l2.val +up;
            ListNode current = new ListNode(sum % 10);
            up = sum /10;

            if(null==head){
                head = current;
            }else {
                tail.next =current;
            }
            tail = current;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (null != l1){
            int val = l1.val+up;
            ListNode current = new ListNode(val%10);
            up = val / 10;
            tail.next = current;
            tail = current;
            l1 = l1.next;
        }

        while (null != l2){
            int val = l2.val+up;
            ListNode current = new ListNode(val%10);
            up = val / 10;
            tail.next = current;
            tail = current;
            l2 = l2.next;
        }
        if(0 != up){
            tail.next = new ListNode(up);
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}