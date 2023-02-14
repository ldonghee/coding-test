package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * https://neetcode.io/roadmap
 */
public class TowSum {
    /**
     * 정렬된 배열
     * 앞에서 부터 시작
     * 뒤에서 부터 시작
     * 크면 뒤에서 -1, 작으면 앞에거 +1
     */
    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int[] answer = new int[2];

            int leftIndex = 0;
            int rightIndex = numbers.length - 1;

            while(true) {
				if (numbers[leftIndex] + numbers[rightIndex] == target) {
					answer[0] = leftIndex + 1;
					answer[1] = rightIndex + 1;
					break;
				}
				if (numbers[leftIndex] + numbers[rightIndex] > target) {
					rightIndex--;
				}

				if (numbers[leftIndex] + numbers[rightIndex] < target) {
					leftIndex++;
				}
			}

            return answer;
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[] numbers = {2,7,11,15};
        int target = 9;

        int[] expect = {1,2};
        int[] actual = solution.twoSum(numbers, target);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        int[] numbers = {2,3,4};
        int target = 6;

        int[] expect = {1,3};
        int[] actual = solution.twoSum(numbers, target);
        assertThat(actual).isEqualTo(expect);
    }


    @Test
    public void test03() {
        int[] numbers = {-1,0};
        int target = -1;

        int[] expect = {1,2};
        int[] actual = solution.twoSum(numbers, target);
        assertThat(actual).isEqualTo(expect);
    }
}
