package easy0206reverseListNotFinish;

/**
 * @Author: ye_liu
 * @Date: 2020/11/3 16:59
 */
public class Solution {

    /**
     * 206. 反转链表
     * 反转一个单链表。
     *
     * 示例:
     *
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     *
     *
     */

    public ListNode reverseList(ListNode head) {
        return null;
    }

    /**
     * 错误解答
     * @param args
     */
//    public ListNode reverseList(ListNode head) {
//        List<Integer> numList = new ArrayList<>();
//        ListNode thisHead = head;
//        while(thisHead != null){
//            numList.add(thisHead.val);
//            thisHead = thisHead.next;
//        }
//        int length = numList.size();
//        thisHead = new ListNode(numList.get(0));
//        thisHead.next = null;
//        for (int i = 1;i < length;i++){
//            thisHead.val = numList.get(i);
//            thisHead.next = thisHead;
//        }
//        return thisHead;
//    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        Solution solution = new Solution();
        solution.reverseList(listNode);

    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x, ListNode y) {
            val = x;
            next = y;
        }
    }



}
