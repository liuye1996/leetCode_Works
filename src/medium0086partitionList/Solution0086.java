package medium0086partitionList;

/**
 * @Author: ye_liu
 * @Date: 2021/1/4 14:20
 */
public class Solution0086 {


    /**
     * https://leetcode-cn.com/problems/partition-list/
     *
     * 86. 分隔链表
     * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * 示例：
     *
     * 输入：head = 1->4->3->2->5->2, x = 3
     * 输出：1->2->2->4->3->5
     * 通过次数81,169提交次数130,691
     *
     */
    /**
     * 链表题目仍需要多练
     *
     */
    public ListNode partition(ListNode head, int x) {
        ListNode smallList = new ListNode(0);
        ListNode bigList = new ListNode(0);
        ListNode node1 = smallList;
        ListNode node2 = bigList;
        while(head!=null){
            if(head.val < x){
                node1.next = head;
                head = head.next;
                node1 = node1.next;
                node1.next = null;
            }else{
                node2.next = head;
                head = head.next;
                node2 = node2.next;
                node2.next = null;
            }
        }
        node1.next = bigList.next;
        return smallList.next;
    }

    /**
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
