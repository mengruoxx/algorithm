package leetcode;

import okhttp3.OkHttpClient;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组，里面是0-19的乱序不重复整数。请按照自然排序，限定时间复杂度为O(n)
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 输入: s = "xmy", t = "xmm"
 * 输出: false
 */
public class Sort {
    public int[] sort(int[] a) {
        int[] list = new int[20];
        for (int i = 0; i < a.length; i++) {
            list[a[i]] = a[i];
        }
        return list;
    }

    public boolean s(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.get(s.charAt(i));
            map.put(s.charAt(i), count == null ? 1 : count + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            Integer count = map.get(t.charAt(i));
            if (count == null || count - 1 < 0) {
                return false;
            }
            map.put(t.charAt(i), count - 1);
        }
        return true;

    }
}
