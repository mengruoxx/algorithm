package leetcode;

import java.util.*;

/**
 * Given a string array words, return the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters. If no such two words exist, return 0.
 *
 * Example 1:
 *
 * Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 */
public class L318MaxProduct {
    /**
     * 关键在于要降低 判断两个单词是否有重复字母 的时间复杂度
     * 因为字母只有26个，所以使用26位的字符串表示a-z，一个单词为ac 则相应位置上为1，则ac -> 10100...0
     * 通过两个单词的
     * @param words
     * @return
     */
    public int maxProduct2(String[] words) {
        int maxProduct = 0;
        if (words.length == 0 || words.length == 1) {
            return maxProduct;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (noCommonLetters(words[i], words[j])) {
                    maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
                }
            }
        }

        return maxProduct;
    }

    public int maxProduct(String[] words) {
        int maxProduct = 0;
        if (words.length == 0 || words.length == 1) {
            return maxProduct;
        }
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (noCommonLetters(words[i], words[j])) {
                    maxProduct = Math.max(words[i].length() * words[j].length(), maxProduct);
                }
            }
        }

        return maxProduct;
    }

    /**
     * 判断两个单词是否有重复字母的通常解法，O(n)
     * @param word1
     * @param word2
     * @return
     */
    private boolean noCommonLetters(String word1, String word2) {
        // 运用set O(n)的复杂度判断是否有common letter
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < word1.length(); i++) {
            set.add(word1.charAt(i));
        }
        for (int i = 0; i < word2.length(); i++) {
            if (set.contains(word2.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L318MaxProduct l318MaxProduct = new L318MaxProduct();
        l318MaxProduct.noCommonLetters("abcd", "abfd");
    }
}
