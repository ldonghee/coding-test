package test.study;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 46. 순열 (Permutations)
 * https://leetcode.com/problems/permutations/
 */
public class weeks_3th_01 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            // Input: nums = [1,2,3]
            // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

            List<List<Integer>> result = new ArrayList<>();
            permutations(result, nums, 0, nums.length);
            return result;
        }

        void permutations(List<List<Integer>> result, int[] nums, int depth, int n) {
            if (depth == n) {
                System.out.println("-------- ADD : " + nums[0] + nums[1] + nums[2]);
                result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
                return;
            }

            for (int i=depth; i<n; i++) {
                System.out.println("permutations : " + nums[0] + nums[1] + nums[2]);
                swap(nums, i, depth);
                System.out.println("depth: " + depth + ", i : " + i + ", nums : " + nums[0] + nums[1] + nums[2]);
                permutations(result, nums, depth + 1, n);
                swap(nums, i, depth);
            }
        }

        void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    private Solution solution = new Solution();

    public static List<List<Integer>> convertArrayToList(int[][] nums) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums[i].length; j++) {
                list.add(nums[i][j]);
            }
            result.add(list);
        }

        return result;
    }

    @Test
    public void test1() {
        // Input: nums = [1,2,3]
        // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

        // given
        int[] nums = {1, 2, 3};
        int[][] expectArray = {{1,2,3},{1,3,2},{2,1,3},{2,3,1},{3,1,2},{3,2,1}};
        List<List<Integer>> expectList = convertArrayToList(expectArray);

        // when
        List<List<Integer>> actual = solution.permute(nums);

        // then
        assertThat(actual).containsAll(expectList);
        assertThat(actual.size()).isEqualTo(expectList.size());
    }

    @Test
    public void test2() {
        // Input: nums = [0,1]
        // Output: [[0,1],[1,0]]

        // given
        int[] nums = {0,1};
        int[][] expectArray = {{0,1},{1,0}};
        List<List<Integer>> expectList = convertArrayToList(expectArray);

        // when
        List<List<Integer>> actual = solution.permute(nums);

        // then
        assertThat(actual).containsAll(expectList);
        assertThat(actual.size()).isEqualTo(expectList.size());
    }

    @Test
    public void test3() {
        // Input: nums = [1]
        // Output: [[1]]

        // given
        int[] nums = {1};
        int[][] expectArray = {{1}};
        List<List<Integer>> expectList = convertArrayToList(expectArray);

        // when
        List<List<Integer>> actual = solution.permute(nums);

        // then
        assertThat(actual).containsAll(expectList);
        assertThat(actual.size()).isEqualTo(expectList.size());
    }
}


