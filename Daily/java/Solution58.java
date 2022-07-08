/**
 * 58.最后一个单词长度
 * easy
 * @author xuhao
 * @date Created at 2022/6/21 11:32
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {

        char[] chars = s.trim().toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            if (chars[length - 1 - i] == ' ') {
                return i;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        System.out.println(solution58.lengthOfLastWord("sdadsa  "));
    }
}
