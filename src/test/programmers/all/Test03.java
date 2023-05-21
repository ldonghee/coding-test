package test.programmers.all;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/172928
 * 공원 산책
 */
public class Test03 {
	class Solution {
		public int[] solution(String[] park, String[] routes) {
			int[] answer = {};



			for (int i=0; i<park.length; i++) {
				for (int j=0; j<park[i].length(); j++) {
					char c = park[i].charAt(j);
				}
			}

			return answer;
		}
	}
	private final Solution solution = new Solution();

	@Test
	public void test() {
		String[] park = {"SOO","OOO","OOO"};
		String[] routes = {"E 2","S 2","W 1"};

		int[] expect = {2, 1};
		int[] actual = solution.solution(park, routes);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		String[] park = {"SOO","OXX","OOO"};
		String[] routes = {"E 2","S 2","W 1"};

		int[] expect = {0, 1};
		int[] actual = solution.solution(park, routes);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		String[] park = {"OSO","OOO","OXO","OOO"};
		String[] routes = {"E 2","S 3","W 1"};

		int[] expect = {0, 0};
		int[] actual = solution.solution(park, routes);

		assertThat(actual).isEqualTo(expect);
	}
}
