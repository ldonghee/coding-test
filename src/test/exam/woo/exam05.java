package test.exam.woo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class exam05 {
	/**
	 * 자연수가 적힌 2 x N 장의 카드묵음을 가지고 있다.
	 * 카드묶음에는 같은 숫자가 적힌 카드가 2장씩 포함되어 있는데, 서로 다른 숫자가 적힌 카드 2장을 잃어버렸다.
	 *
	 * 2 x N - 2 길의 카드 배열 card 가 매개변수로 주어질 때, 잃어버린 숫자 2개를 배열 형태로 return 하도록 solution 함수를 완성해 줘.
	 * 반환되는 배열은 오름차순으로 정렬되어 있어야 해.
	 *
	 * 제한 사항
	 * 배열 card 길이는 2 이상 100,000 이하
	 * card 원소는 1이상 1,000,000,000 이하의 자연수
	 */
	class Solution {
		public int[] solution(int[] card) {
			Set<Integer> set = new HashSet<>();
			for (int num : card) {
				if (!set.add(num)) {
					set.remove(num);
				}
			}

			int[] answer = set.stream()
							  .limit(2)
							  .mapToInt(Integer::intValue)
							  .toArray();

			Arrays.sort(answer);
			return answer;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test() {
		int[] card = {1, 3, 2, 5, 3, 1};

		int[] expect = {2, 5};
		int[] actual = solution.solution(card);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		int[] card = {1, 2, 3, 4, 4, 3, 2, 5};

		int[] expect = {1, 5};
		int[] actual = solution.solution(card);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int[] card = {5, 1, 3, 4, 4, 3, 2, 2};

		int[] expect = {1, 5};
		int[] actual = solution.solution(card);

		assertThat(actual).isEqualTo(expect);
	}
}
