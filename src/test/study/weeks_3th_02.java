package test.study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * 349. 교차점 (Intersection of Two Arrays)
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class weeks_3th_02 {
    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {
            if (nums1.length > nums2.length) {
                return 	execute(nums2, nums1);
            }
            return 	execute(nums1, nums2);
        }

        private int[] execute(int[] nums1, int[] nums2) {
            Set<Integer> result = new HashSet<>();
            Set<Integer> compareSet = new HashSet<>();
            for (Integer a : nums2) {
                compareSet.add(a);
            }

            for (int i=0; i<nums1.length; i++) {
                if (compareSet.contains(nums1[i])) {
                    result.add(nums1[i]);
                }
            }

            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test1() {
        // Input: nums1 = [1,2,2,1], nums2 = [2,2]
        // Output: [2]

        // given
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] expect = {2};

        // when
        int[] actual = solution.intersection(num1, num2);

        // then
        assertThat(actual).containsExactly(expect);
        assertThat(actual.length).isEqualTo(expect.length);
    }

    @Test
    public void test2() {
        // Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
        // Output: [9,4]

        int[] num1 = {4, 9, 5};
        int[] num2 = {9, 4, 9, 8, 4};
        int[] expect = {9, 4};

        // when
        int[] actual = solution.intersection(num1, num2);

        // then
        assertThat(actual).contains(expect);
        assertThat(actual.length).isEqualTo(expect.length);
    }
}

