package test.programmers.hash;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;

/**
 * 위장
 * https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Hash04 {
	class Solution {
		public int solution(String[][] clothes) {
			int answer = 1;
			Map<String, Integer> map = new HashMap<>();

			for (String[] s : clothes) {
				map.put(s[1], Optional.ofNullable(map.get(s[1])).orElse(0) + 1);
			}

			Iterator<Integer> it = map.values().iterator();
			while(it.hasNext()) {
				answer *= it.next().intValue() + 1;
			}
			return answer - 1;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

		int expect = 5;
		int actual = solution.solution(clothes);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};

		int expect = 3;
		int actual = solution.solution(clothes);
		assertThat(actual).isEqualTo(expect);
	}
}
