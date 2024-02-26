package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class FindFirstAndLastPositionOfElement {
	/**
	 * 제약 사항
	 * 0 <= nums.length <= 10^5
	 * -10^9 <= nums[i] <= 10^9
	 * -10^9 <= target <= 10^9
	 *
	 * You must write an algorithm with O(log n) runtime complexity.
	 *
	 * 정렬된 배열에서 특정 값을 찾는 문제를 처리하는데 있어서, 그 효율성을 극대화하기 위해 이진 검색 알고리즘(Binary Search Algorithm)을 활용하고 있습니다.
	 *
	 * 시간 복잡도 : O(log n)
	 * 이진 검색은 그 이름에서 알 수 있듯이, 배열을 두 부분으로 나누어 찾으려는 값을 검색하는 알고리즘입니다.
	 * 이 알고리즘의 핵심은 배열의 중간 지점을 찾아,
	 * 그 중간값과 타겟값을 비교하는 것입니다. 만약 타겟값이 중간값보다 크다면, 중간 지점의 오른쪽 부분을 대상으로 검색을 계속 진행하고,
	 * 만약 타겟값이 중간값보다 작다면, 중간 지점의 왼쪽 부분을 대상으로 검색을 계속 진행합니다.
	 * 이와 같은 방식으로 반복적으로 검색을 진행하여 최종적으로 원하는 타겟 값을 찾게 됩니다.
	 * 이 때문에 이진 검색 알고리즘의 시간 복잡도는 O(log n)으로 표현됩니다.
	 *
	 * 공간 복잡도 : O(1)
	 * 위 코드에서는 추가적으로 사용하는 메모리가 상수 공간이므로, 공간 복잡도는 O(1)입니다.
	 * 이는 입력 크기 n과 관계없이 일정한 메모리만을 사용한다는 것을 의미합니다.
	 * 즉, 배열의 크기가 커져도, 이 코드는 일정한 메모리만을 필요로 합니다.
	 *
	 * 엣지 케이스
	 * 1. 빈 배열
	 * 입력으로 빈 배열이 들어오는 경우에 대한 처리가 필요합니다. nums 배열의 길이가 0인 경우에 대한 처리가 필요하며, 이 경우에는 [-1, -1]을 반환해야 합니다.
	 *
	 * 2. 배열에 타겟 값이 없는 경우
	 * 배열에 타겟 값이 없는 경우에 대한 처리가 필요합니다. 이 경우에도 [-1, -1]을 반환해야 합니다.
	 *
	 * 3. 배열에 하나의 요소만 있고 그 요소가 타겟 값인 경우
	 * 이 경우 시작 인덱스와 마지막 인덱스는 동일하게 됩니다.
	 *
	 * 4. 배열의 모든 요소가 타겟 값인 경우
	 * 이 경우 시작 인덱스는 0, 마지막 인덱스는 배열의 길이 - 1이 됩니다.
	 *
	 * 5. 타겟 값이 배열의 가장 작은 값이거나 가장 큰 값인 경우
	 * 이 경우에도 알고리즘이 올바르게 작동해야 합니다.
	 *
	 * 6.중복된 값이 많은 배열
	 * 이 경우에도 시작 인덱스와 마지막 인덱스를 올바르게 찾아야 합니다.
	 *
	 *
	 */
	public int[] searchRange(int[] nums, int target) {
		int start = findStartIndex(nums, target, 0, nums.length - 1);
		int end = findLastIndex(nums, target, start, nums.length - 1) - 1;

		if (start >= nums.length || start > end) {
			return new int[] {-1, -1};
		}

		return new int[] {start, end};
	}

	// lowerBound
	public int findStartIndex(int[] nums, int target, int lo, int hi) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (target <= nums[mid]) {
				hi = mid - 1;
			}else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	// upperBound
	public int findLastIndex(int[] nums, int target, int lo, int hi) {
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (target < nums[mid]) {
				hi = mid - 1;
			}
			else {
				lo = mid + 1;
			}
		}

		return lo;
	}

	@Test
	public void test01() {
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		int[] expect = {3,4};
		int[] actual = searchRange(nums, target);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] nums = {5,7,7,8,8,10};
		int target = 6;
		int[] expect = {-1,-1};
		int[] actual = searchRange(nums, target);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		int[] nums = {};
		int target = 0;
		int[] expect = {-1,-1};
		int[] actual = searchRange(nums, target);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test04() {
		int[] nums = {1};
		int target = 0;
		int[] expect = {-1,-1};
		int[] actual = searchRange(nums, target);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test05() {
		int[] nums = {1};
		int target = 1;
		int[] expect = {0, 0};
		int[] actual = searchRange(nums, target);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test06() {
		int[] nums = {1, 1, 1, 1, 1};
		int target = 1;
		int[] expect = {0, 4};
		int[] actual = searchRange(nums, target);

		assertThat(actual).isEqualTo(expect);
	}
}
