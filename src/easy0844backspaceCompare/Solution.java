package easy0844backspaceCompare;

/**
 * @Author: ye_liu
 * @Date: 2020/10/19 18:24
 */
public class Solution {

    /**
     * 844. 比较含退格的字符串
     * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
     *
     * 注意：如果对空文本输入退格字符，文本继续为空。
     *
     *
     *
     * 示例 1：
     *
     * 输入：S = "ab#c", T = "ad#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “ac”。
     * 示例 2：
     *
     * 输入：S = "ab##", T = "c#d#"
     * 输出：true
     * 解释：S 和 T 都会变成 “”。
     * 示例 3：
     *
     * 输入：S = "a##c", T = "#a#c"
     * 输出：true
     * 解释：S 和 T 都会变成 “c”。
     * 示例 4：
     *
     * 输入：S = "a#c", T = "b"
     * 输出：false
     * 解释：S 会变成 “c”，但 T 仍然是 “b”。
     *
     *
     * 提示：
     *
     * 1 <= S.length <= 200
     * 1 <= T.length <= 200
     * S 和 T 只含有小写字母以及字符 '#'。
     *
     *
     * 进阶：
     *
     * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
     *
     *
     * 通过次数49,173提交次数93,998
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T){
        StringBuffer s = new StringBuffer();
        StringBuffer t = new StringBuffer();
        for (char ss : S.toCharArray()){
            if (ss == '#'){
                int length =  s.length();
                if (length != 0){
                    s.deleteCharAt(length-1);
                }
            }else{
                s.append(ss);
            }
        }
        for (char tt : T.toCharArray()){
            if (tt == '#'){
                int length =  t.length();
                if (length != 0){
                    t.deleteCharAt(length-1);
                }
            }else{
                t.append(tt);
            }
        }
        return s.toString().equals(t.toString());
    }
//    public boolean backspaceCompare(String S, String T){
//        while (S.contains("#")||T.contains("#")){
//            int index1 = S.indexOf('#');
//            if (index1>-1) {
//                S = S.substring(0, (index1 == 0 ? 1 : index1) - 1) + S.substring(index1 + 1);
//            }
//            int index = T.indexOf('#');
//            if (index>-1) {
//                T = T.substring(0, (index == 0 ? 1 : index) - 1) + T.substring(index + 1);
//            }
//        }
//        return S.equals(T);
//    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时：
     * 3 ms
     * , 在所有 Java 提交中击败了
     * 54.08%
     * 的用户
     * 内存消耗：
     * 38.4 MB
     * , 在所有 Java 提交中击败了
     * 5.02%
     * 的用户
     * @param args
     */

//    public boolean backspaceCompare(String S, String T){
//        while (S.contains("#")){
//            int index = S.indexOf('#');
//            S = S.substring(0, (index == 0?1:index)-1) + S.substring(index+1);
//        }
//        while (T.contains("#")){
//            int index = T.indexOf('#');
//            T = T.substring(0, (index == 0?1:index)-1) + T.substring(index+1);
//        }
//        return S.equals(T);
//    }

//    public boolean backspaceCompare(String S, String T) {
//        char sChar[] = S.toCharArray();
//        char tChar[] = T.toCharArray();
//        List<Integer> sSubList = new ArrayList<>();
//        List<Integer> tSubList = new ArrayList<>();
//        for(int i=0;i<sChar.length;i++){
//            if(sChar[i] == '#'){
//                sSubList.add(Integer.valueOf(i));
//            }
//        }
//        for(int i=0;i<tChar.length;i++){
//            if(tChar[i] == '#'){
//                tSubList.add(Integer.valueOf(i));
//            }
//        }
//        for(int i=0;i<sSubList.size();i++){
//            int index = sSubList.get(i);
//            S = S.substring(index-1-i, index-i);
//        }
//        for(int i=0;i<tSubList.size();i++){
//            int index = tSubList.get(i);
//            T = T.substring(index-1-i, index-i);
//        }
//        return S.equals(T);
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare("ab#c","ad#c"));
        System.out.println(solution.backspaceCompare("a##c","#a#c"));

    }

}
