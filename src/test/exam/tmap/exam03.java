package test.exam.tmap;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

public class exam03 {
	/**
	 * A domino is a rectangular tile divided into two square parts.
	 * There are between 1 and 6 dots on each of the parts.
	 *
	 * There is an array A of length 2*N, representing N dominoes.
	 * Dominoes are arranged in a line in the order in which they appear in array A.
	 * The number of dots on the left and the right parts of the K-th domino are A[2*K] and A[2*K+1], respectively.
	 * For example, an array A = [2,4,1,3,4,6,2,4,1,6] represents a sequences of fie domino tiles: (2,4), (1,3), (4,6), (2,4), and (1,6).
	 *
	 * In a correct domino sequence, each pair of neighboring tiles should have the same number of dots on their adjacent parts.
	 * For example, tiles (2,4) and (4,6) form a correct domino sequence and tiles (2,4) and (1,3) do not.
	 *
	 * What is the minimum number of domino tiles that must be removed from the sequence so that the remaining tiles from a correct domino sequence?
	 * It is not allowed to reorder or rotate the dominoes.
	 *
	 * That, given an array A representing a sequence of N domino tiles, returns the minimum number of tiles that must be removed so that the remaining tiles from a correct domino sequence.
	 *
	 * Examples:
	 * 1. Given A = [2,4,1,3,4,6,2,4,1,6], the function should return 3.
	 * The second and the last two dominoes should be removed. After this, the remaining dominoes are (2,4), and (4,6).
	 *
	 * 2. Given A = [5,1,2,6,6,1,3,1,4,3,4,3,4,6,1,2,4,1,6,2], the function should return 7.
	 * Then domino tiles that should remain are (2,6), (6,1), (1,2).
	 *
	 * 3. Given A = [1,5,3,3,1,3], the function should return 2.
	 * No pair dominoes are be connected without rotating or reordering them.
	 *
	 * 4. Given A = [3,4], the function should return 0.
	 *
	 * Write an efficient algorithm for the following assumpthions.
	 * N is an integer within the range [1..50,000];
	 * the length of array A is equal to 2*N;
	 * each element of array A is an integer within the range [1..6];
	 *
	 *
	 *
	 * 이 코드는 주어진 도미노 배열에서 올바른 도미노 시퀀스를 만들기 위해 제거해야 하는 도미노의 최소 개수를 찾는 알고리즘입니다.
	 *
	 * 먼저, 코드는 주어진 배열 A의 길이를 n 변수에 저장합니다. 그리고 길이가 6인 새로운 정수 배열 arr를 생성합니다. 이 배열은 각 도미노의 점수(1부터 6까지)를 저장하는 데 사용됩니다.
	 * 그 다음, for문을 사용하여 배열 A를 한 쌍씩(즉, 한 도미노씩) 검사합니다. 각 반복에서, 코드는 먼저 현재 도미노의 오른쪽 부분에 있는 점의 개수에 해당하는 arr 배열의 항목을 currentMax에 저장합니다. 그런 다음 현재 도미노의 왼쪽 부분에 있는 점의 개수에 해당하는 arr 배열의 항목에 1을 더한 값을 previousMax에 저장합니다.
	 * if문에서는 currentMax가 previousMax보다 작은지 확인합니다. 만약 그렇다면, arr 배열의 해당 항목을 previousMax로 업데이트합니다. 이렇게 하면, 가능한 경우에는 현재 도미노를 이전 도미노에 연결할 수 있음을 나타냅니다.
	 * 마지막으로, 코드는 arr 배열에서 가장 큰 값을 찾아 maxVal에 저장합니다. 이 값은 올바른 도미노 시퀀스를 만들기 위해 남겨둘 수 있는 도미노의 최대 개수를 나타냅니다.
	 * 코드의 반환 값은 전체 도미노의 개수(n / 2)에서 maxVal을 뺀 값입니다. 이 값은 올바른 도미노 시퀀스를 만들기 위해 제거해야 하는 도미노의 최소 개수를 나타냅니다.
	 * 이 알고리즘은 시간 복잡도가 O(n)이므로, 주어진 범위 내에서 효율적으로 동작합니다.
	 *
	 *
	 *
	 * https://leetcode.com/discuss/interview-question/4014581/HELP-PLEASE
	 */
	class Solution {
		public int solution(int[] A) {
			int n = A.length;
			int[] arr = new int[6];

			for (int i = 0; i < n; i += 2) {
				int currentMax = arr[A[i + 1] - 1];
				int previousMax = arr[A[i] - 1] + 1;

				if (currentMax < previousMax) {
					arr[A[i + 1] - 1] = previousMax;
				}
			}

			int maxVal = Arrays.stream(arr).max().getAsInt();
			return n / 2 - maxVal;
//			int n = A.length;
//			int[] arr = new int[6];
//
//			for (int i = 0; i < n; i += 2) {
//				int[] temp = arr.clone();
//
//				for (int j = 0; j < 6; ++j) {
//					int currentMax = temp[A[i + 1] - 1];
//					int previousMax = arr[A[i] - 1] + 1;
//					temp[A[i + 1] - 1] = Math.max(currentMax, previousMax);
//				}
//
//				arr = temp;  // Update dp array with the values from the temporary array
//			}
//
//			int maxVal = Arrays.stream(arr).max().getAsInt();
//
//			return n / 2 - maxVal;
		}
	}

	private final Solution solution = new Solution();


	@Test
	public void test1() {
		int[] A = {2, 4, 1, 3, 4, 6, 2, 4, 1, 6};

		int expect = 3;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}


	@Test
	public void test2() {
		int[] A = {5, 1, 2, 6, 6, 1, 3, 1, 4, 3, 4, 3, 4, 6, 1, 2, 4, 1, 6, 2};

		int expect = 7;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int[] A = {1, 5, 3, 3, 1, 3};

		int expect = 2;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test4() {
		int[] A = {3, 4};

		int expect = 0;
		int actual = solution.solution(A);

		assertThat(actual).isEqualTo(expect);
	}
}