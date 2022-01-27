package laicode.test;

/**
 * description
 *
 * @author ericzhang 2022/01/27 15:46
 */
public class MergeTwoSortedLinkedLists {
   /**
    * class ListNode {
    *   public int value;
    *   public ListNode next;
    *   public ListNode(int value) {
    *     this.value = value;
    *     next = null;
    *   }
    * }
    */
      public ListNode merge(ListNode one, ListNode two) {
         // Write your solution here
         //corner case
         if(one == null && two != null){
            return two;
         }
         if(two == null){
            return one;
         }
         ListNode p1 = one;
         ListNode p2 = two;
         //创建了新的链表或者修改了链表结构要dummy  dummy作为新的返回结果的头结点不能动 返回时要删除
         ListNode dummy = new ListNode(0);
         ListNode cur = dummy;
         while(p1 != null && p2 != null){
            if(p1.value < p2.value){
               cur.next = p1;
               p1 = p1.next;
               cur = cur.next;
            }
            else{
               cur.next = p2;
               p2 = p2.next;
               cur = cur.next;
            }
         }
         //保证了肯定有一个list走完了 直接接上p1 可以接上剩余的所有
         //直接接p1就行 不用管p1.next因为你也不知道p1有没有next
         if(p1 != null){
            cur.next = p1;
         }
         if(p2 != null){
            cur.next = p2;
         }
         return dummy.next;
   }



}
