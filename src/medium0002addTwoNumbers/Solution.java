package medium0002addTwoNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: ye_liu
 * @Date: 2023/10/20 16:52
 */
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

    /**
     * 2. 两数相加
     * 中等
     * 相关标签
     * 相关企业
     * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
     *
     * 请你将两个数相加，并以相同形式返回一个表示和的链表。
     *
     * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     *
     *
     * 示例 1：
     *
     *
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * 示例 2：
     *
     * 输入：l1 = [0], l2 = [0]
     * 输出：[0]
     * 示例 3：
     *
     * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
     * 输出：[8,9,9,9,0,0,0,1]
     *
     *
     * 提示：
     *
     * 每个链表中的节点数在范围 [1, 100] 内
     * 0 <= Node.val <= 9
     * 题目数据保证列表表示的数字不含前导零
     * 通过次数
     * 1.9M
     * 提交次数
     * 4.4M
     * 通过率
     * 42.8%
     */

    /**
     * 一开始想用常规解法，先全部转成数字 后发现长度可能达到100位，java无法承载此数字换解法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode tempListNode1 = l1;
        int i = 0;
        int number1 = 0;
        boolean zeroFlag1 = false;
        while (tempListNode1!=null){
            int thisNumber = tempListNode1.val;
            if (tempListNode1.val == 0){

                zeroFlag1 = true;
            }
            number1 += tempListNode1.val * Math.pow(10, i);
            tempListNode1 = tempListNode1.next;
            i++;
        }
        ListNode tempListNode2 = l1;
        int j = 0;
        int number2 = 0;
        while (tempListNode2!=null){
            number2 += tempListNode2.val * Math.pow(10, j);
            tempListNode2 = tempListNode2.next;
            j++;
        }


        return new ListNode();
    }


    /**
     * z
     * > 2023/10/23 11:37:28
     * 解答成功:
     * 	执行耗时:2 ms,击败了5.52% 的Java用户
     * 	内存消耗:42.5 MB,击败了5.21% 的Java用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode thisListNode1 = l1;
        ListNode thisListNode2 = l2;
        // 先全部收集到两个list里
        List<Integer> list1 = new ArrayList<>(110);
        List<Integer> list2 = new ArrayList<>(110);
        while(thisListNode1 != null){
            list1.add(thisListNode1.val);
            thisListNode1 = thisListNode1.next;
        }
        while(thisListNode2 != null){
            list2.add(thisListNode2.val);
            thisListNode2 = thisListNode2.next;
        }
        // 之前以为需要做一个倒序，没想到不需要的，其实可以直接循环两个链表
        //        Collections.reverse(list1);
//        Collections.reverse(list2);
        ListNode result = new ListNode();
        int moreAdd = 0;
        ListNode tempNode = new ListNode();
        for(int i = 0 ;i < list1.size() || i < list2.size() || moreAdd != 0; i++){
            ListNode thisResultNode = new ListNode();
            int number1 = 0;
            int number2 = 0;
            if (i < list1.size()){
                number1 = list1.get(i);
            }
            if (i < list2.size()){
                number2 = list2.get(i);
            }
            int thisNumber = number1 + number2 + moreAdd;
            if (thisNumber >= 10){
                moreAdd = 1;
                thisNumber = thisNumber - 10;
            }else{
                moreAdd = 0;
            }
            if (i == 0){
                result.val = thisNumber;
                tempNode = result;
            }else {
                thisResultNode.val = thisNumber;
                tempNode.next = thisResultNode;
                tempNode = thisResultNode;
            }
        }
        return result;
    }


}

/**
 * Definition for singly-linked list.
 */
class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
