package leetcode;

/**
 * @author Mengruo
 * @date 2021/12/13
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 */
public class L26RemoveDuplicates {
    /**
     * 非重子序列cur | 重复子序列i
     * 遍历数组，左边是非重部分，右边为重复部分，cur指向非重数组最后一个元素，遍历指针i不断从右边重复部分添加元素到非重部分。
     * 如果i元素 != cur元素，就将i元素搬到非重数组的末尾（cur先前进一位，将i元素赋值到这里），两个指针前进；
     * 如果i元素=cur元素，说明i元素是重复的，不能添加到非重数组当中，cur不动，i前进，继续遍历下一个元素。
     * cur和i之间的元素，为重复的元素。
     * 正因为数组有序，所以只需要判断i元素 是否等于 cur元素，并且将i元素移到cur+1位置后，非重数组也始终是有序的。
     * 1  1  2  3  3  8
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[cur] != nums[i]) {
                // 将i元素搬到cur的下一个元素位置
                cur ++;
                nums[cur] = nums[i];
            }
        }
        return cur + 1;
    }
}
