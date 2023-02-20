package test.neetcode.binarySearch;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/description/
 */
public class BinarySearch {
    class Solution {
        public int search(int[] nums, int target) {
            int index = recursive(0, nums.length-1, target, nums);

            return index;
        }

        int recursive(int start, int end, int target, int[] nums) {
            int medium;

            if(start <= end) {
                medium = (start + end) / 2;

                if(target == nums[medium]) {
                    return medium;
                } else if(target > nums[medium]) {
                    return recursive(medium + 1, end, target, nums);
                } else {
                    return recursive(start, medium - 1, target, nums);
                }
            }

            return -1;
        }

    }


    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;

        int expect = 4;
        int actual = solution.search(nums, target);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;

        int expect = -1;
        int actual = solution.search(nums, target);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test03() {
        int[] nums = {5};
        int target = -5;

        int expect = -1;
        int actual = solution.search(nums, target);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test04() {
        int[] nums = {2, 5};
        int target = 0;

        int expect = -1;
        int actual = solution.search(nums, target);
        assertThat(actual).isEqualTo(expect);
    }
}
