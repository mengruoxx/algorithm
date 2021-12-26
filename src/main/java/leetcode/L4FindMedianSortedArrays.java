package leetcode;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * hard
 *  1,5,7,10
 *  4,8,13,14
 * @author Mengruo
 */
public class L4FindMedianSortedArrays {

    /**
     * 找第k小的数（k从1开始）：进阶二分查找
     * 如果两个数组的长度分别为m, n
     * 找中位数其实是找第k小的数，其中k=(m+n)/2 + 1，如果m+n为偶数，则中位数为 第k 和 第k+1 的平均数。如果m+n为奇数，则中位数就是第k个数
     * 想要找到第k小的数：
     *          为了能有log复杂度，如果每次排除一个数，那么复杂度为On；
     *          但是如果我们每次都能排除多个数，比如每次排除k的一半个数，那么复杂度就是log了
     *          首先我们需要找到一个范围，这个范围里面就包括k个数，然后每次排除掉其中的一半（排除A部分或者B部分），于是就需要有一个划分的界限，
     *          于是就各取k/2个数，于是想到用A[k/2-1] 和 B[k/2-1]这两个数作为划分，刚好A[0]-A[k/2-1]为k/2个数
     *  如果我们取A[k/2-1] 和 B[k/2-1]，那么在这两个数组成的分界线的左边（包括这两个数），刚好就有k个数（或者k-1个（当m+n为奇数））了，
     *  在这k个数当中，如果A[k/2-1] <= B[k/2-1]，
     *  通过比较A[k/2-1] 和 B[k/2-1]，我们可以排除A或者B中的那一半数：如果A[k/2]比B[k/2]小，那么包括A[k/2]以及之前的数（一共k/2+1个）都可以排除，
     *  这是因为。
     *  排除了k/2个数之后，我们需要「前进」，假如k=4，排除了A中那一半数（k/2个数），那么可以想象A数组向左移2位，在分界线右边的数组继续寻找第k - k/2
     *  初始：
     *        | 1  5  7  10
     *        | 4  8  13 14
     *  第一轮：
     *  1  5  | 7  10
     *        | 4  8  13  14
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

        return 0;
    }

    /**
     * 将数组合并
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int target1 = 0;
        int target2 = 0;
        int length = (nums1.length + nums2.length) / 2;
        int[] merged = new int[length + 1];
        while (target1 < nums1.length && target2 < nums2.length) {
            if (nums1[target1] >= nums2[target2]) {
                merged[target1 + target2] = nums2[target2];
                target2++;
            } else {
                merged[target1 + target2] = nums1[target1];
                target1++;
            }
            if (target1 + target2 == length + 1) {
                break;
            }
        }
        // 如果此时合并数组还没有达到目标长度，接着合并没有合并完的数组
        if (target1 + target2 < length + 1) {
            if (target1 < nums1.length) {
                while (target1 < nums1.length) {
                    merged[target1 + target2] = nums1[target1];
                    target1++;
                    if (target1 + target2 == length + 1) {
                        break;
                    }
                }
            } else {
                while (target2 < nums2.length) {
                    merged[target1 + target2] = nums2[target2];
                    target2++;
                    if (target1 + target2 == length + 1) {
                        break;
                    }
                }
            }
        }
        for (int i : merged) {
            System.out.println("合并后的数组元素：" + i);
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            if (merged.length >= 2) {
                return (merged[merged.length - 1] + merged[merged.length - 2]) / 2.0;
            } else if (merged.length == 1){
                return merged[0];
            } else {
                return 0;
            }
        } else {
            return merged[merged.length - 1];
        }
    }

    public static void main(String[] args) {
        String text = "aabcdsdsa";
        Map<Character, Long> map = text.chars()
                .mapToObj(e -> (char) e)
                .collect(Collectors.groupingBy(Character::charValue, Collectors.counting()));
        StringBuilder builder = new StringBuilder(text.length());
        map.forEach((k, v) -> builder.append(k).append(v));
        System.out.println(builder);
    }

}
