package medium0061rotateRight;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2020/10/31 11:10
 */
public class Solution {

    public ListNode rotateRight(ListNode head, int k) {
        List<Integer> numList = new ArrayList<>();
        ListNode thisNode = head;
        while(thisNode!=null){
            numList.add(thisNode.val);
            thisNode = thisNode.next;
        }
        int length = numList.size();
        if (k > length){
            k = k % length;
        }
        ListNode newListNode = new ListNode(0);

        for (int i = length - k;i < length;i++){
            newListNode.val = numList.get(i);
            newListNode.next = newListNode;
            if ( i == length - k - 1){
                break;
            }
            if (i == length - 1){
                i = 0;
            }
        }
        return newListNode;
    }


//      Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        ListNode result = solution.rotateRight(listNode, 2);
        System.out.println("build success!");
    }
}
