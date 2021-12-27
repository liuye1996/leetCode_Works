package medium0019removeNthFromEnd;

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
public class Solution {
//    public ListNode removeNthFromEnd(ListNode head, int n) {
////
////        List<Integer> list = new ArrayList<>();
////        ListNode thisNode = head;
////        while(thisNode != null){
////            list.add(thisNode.val);
////            thisNode = thisNode.next;
////        }
////        list.remove(list.size()-n);
////
////
////        ListNode changeListNode = new ListNode(list.get(list.size()-1), null);
////        ListNode lastListNode = new ListNode();
////        for(int i = list.size()-2 ; i>=0 ; i--){
////            lastListNode.next = lastListNode;
////            changeListNode.val = list.get(i);
////        }
////        return lastListNode;
////    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 双指针法
        ListNode prior = head;
        ListNode pre = new ListNode(0,head); //新建一个头节点
        while(n-->0){
            prior = prior.next;
        }
        while(prior!=null){
            prior = prior.next;
            pre = pre.next;
        }

        if(pre.next == head){
            head = head.next;
        }else{
            pre.next = pre.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5) ))));
        ListNode reult = solution.removeNthFromEnd(head, 2);
        System.out.println(reult);
    }

}

class ListNode {

    int val;
    ListNode next;
    ListNode() {
    }
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}