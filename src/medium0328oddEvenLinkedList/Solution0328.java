package medium0328oddEvenLinkedList;

/**
 * @Author: ye_liu
 * @Date: 2020/11/13 11:03
 */
public class Solution0328 {

    /**
     *
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        // 分别定义奇偶链表的 虚拟头结点 和 尾结点
        ListNode oddHead = new ListNode();
        ListNode oddTail = oddHead;
        ListNode evenHead = new ListNode();
        ListNode evenTail = evenHead;
        // 遍历原链表，根据 isOdd 标识位决定将当前结点插入到奇链表还是偶链表（尾插法）
        boolean isOdd = true;
        while (head != null) {
            if (isOdd) {
                oddTail.next = head;
                oddTail = oddTail.next;
            } else {
                evenTail.next = head;
                evenTail = evenTail.next;
            }
            head = head.next;
            isOdd = !isOdd;
        }
        // 将奇链表后面拼接上偶链表，并将偶链表的next设置为null
        oddTail.next = evenHead.next;
        evenTail.next = null;
        return oddHead.next;
    }

    /**
     * Definition for singly-linked list.
     */
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {
        Solution0328 solution0328 = new Solution0328();
        ListNode head = new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        solution0328.oddEvenList(head);
    }


}
