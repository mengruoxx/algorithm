package leetcode;

import java.util.HashSet;

/**
 * @author mengruo
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class L3LengthOfLongestSubstring {
    /**
     * 最长不重复子串
     * 1. 最原始的方法：遍历。遍历以元素i开头的所有子串。计算出每一趟中的不重复子串最大长度，然后取所有躺中长度最大的那一个
     * 2. 最优解（双指针滑动窗口）：左右两个指针，保证左右指针中间的部分是不重复的。第一趟找到了最大不重复子串的位置，下一次
     * 将左指针向右移动一格，右指针从上一趟末尾+1的位置继续遍历（因为两个指针之间的元素已经不重复，不需要重复遍历），
     * 找到这一趟的最大不重复子串的长度，就这样找到每一趟的不重复子串的最大长度，最后取最长的就可以。
     *
     * 当遍历以元素i开头的所有子串时，此时找到了这一趟中的最大不重复子串的位置，那么下一次我们开始。
     * 遍历以元素i+1开头的所有子串时，其实结尾可以从上一趟的最大不重复子串的末尾位置+1开始遍历，而不需要从i+2开始从头遍历一次
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxLength = 0;
        int lastMaxIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = lastMaxIndex + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                // **这一趟**中的最大不重复子串的末尾位置（这一行不应该在下面的if语句里面
                lastMaxIndex = j;
                if ((j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                }
            }
            // 开始遍历i+1开头的子序列时，将i元素从set中移除
            set.remove(s.charAt(i));
        }
        return maxLength;
    }

    // 原始版
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set ;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                if ((j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        L3LengthOfLongestSubstring substring = new L3LengthOfLongestSubstring();
        substring.lengthOfLongestSubstring2("aabaab!bb");
    }
}
