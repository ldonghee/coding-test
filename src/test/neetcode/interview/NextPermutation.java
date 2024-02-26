package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class NextPermutation {
	/**
	 * https://jaime-note.tistory.com/292 참고
	 *
	 * 시간 복잡도: O(N)
	 * 이는 입력 크기 N에 비례하여 시간이 증가함을 의미합니다.
	 * 이 함수는 주어진 배열을 두 번 순회합니다.
	 * 첫 번째 순회는 배열의 끝에서 시작하여 감소하는 구간을 찾는 과정입니다.
	 * 이 과정은 배열의 뒷부분에서부터 앞으로 이동하며 감소하는 부분을 탐색합니다.
	 * 두 번째 순회는 배열의 특정 부분을 뒤집는 과정입니다.
	 * 이 과정은 특정 구간을 찾아 그 안의 요소들의 순서를 바꾸는 작업을 합니다.
	 * 두 순회 과정 모두 최악의 경우에도 배열 전체를 한 번씩만 순회하므로, 시간 복잡도는 O(N)이라고 할 수 있습니다.
	 *
	 * 공간 복잡도: O(1)
	 * 입력의 크기에 관계없이 공간 사용량이 일정함을 의미합니다.
	 * 이 함수는 원래의 입력 배열을 직접 조작하며 과정을 수행하고, 추가적인 배열이나 자료구조를 사용하지 않습니다.
	 * 따라서 필요한 메모리 공간이 입력 크기 N과 무관하게 항상 일정하므로, 공간 복잡도는 O(1)이라고 할 수 있습니다.
	 *
	 * 엣지 케이스
	 * 1. 배열의 길이가 1인 경우
	 * 배열에 하나의 요소만 있는 경우, 다음 순열은 자기 자신이 됩니다. 이 경우에 대한 처리가 필요합니다.
	 *
	 * 2. 모든 숫자가 내림차순으로 정렬된 경우
	 * '3, 2, 1'과 같이 모든 숫자가 내림차순으로 정렬된 경우, 다음 순열은 '1, 2, 3'과 같이 오름차순 정렬입니다. 이 경우에 대한 처리가 필요합니다.
	 *
	 * 3. 모든 숫자가 동일한 경우
	 * '1, 1, 1'과 같이 모든 숫자가 동일한 경우, 다음 순열은 자기 자신이 됩니다. 이 경우에 대한 처리가 필요합니다.
	 *
	 * 4. 배열의 길이가 최대 길이인 경우
	 * 배열의 길이가 최대 길이(100)인 경우에 대한 처리가 필요합니다.
	 */
	public int[] nextPermutation(int[] nums) {
		// (1) 뒤에서부터 감소하는 구간을 찾습니다.
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}

		if (i >= 0) {
			int j = nums.length - 1;
			// (2) 감소가 시작된 구간의 수보다 큰 수를 찾아 swap 합니다.
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		// (3) swap 한 숫자 이후 뒷부분을 뒤집어 줍니다.
		reverse(nums, i + 1);
		return nums;
	}

	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	@Test
	public void test01() {
		int[] nums = {1,2,3};
		int[] expect = {1,3,2};
		int[] actual = nextPermutation(nums);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int[] nums = {3,2,1};
		int[] expect = {1,2,3};
		int[] actual = nextPermutation(nums);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int[] nums = {1,1,5};
		int[] expect = {1,5,1};
		int[] actual = nextPermutation(nums);

		assertThat(expect).isEqualTo(actual);
	}
}
