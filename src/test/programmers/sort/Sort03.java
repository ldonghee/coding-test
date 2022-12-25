package test.programmers.sort;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * H-Index
 * https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class Sort03 {
	class Solution {
		public int solution(int[] citations) {
			int answer = 0;

			List<Integer> list = new ArrayList<>();
			for (int citation : citations) {
				list.add(citation);
			}
			Collections.sort(list, Collections.reverseOrder());

			for (int i=0; i<list.size(); i++) {
				if (i >= list.get(i)) {
					answer = i;
					break;
				}
				if (i == list.size() - 1) {
					answer = i + 1;
				}
			}

			return answer;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] citations = {3, 0, 6, 1, 5};

		int expect = 3;
		int actual = solution.solution(citations);
		assertThat(actual).isEqualTo(expect);
	}
}
