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
	/**
	 * 예를 들어 상의의 수를 A 하의의 수를 B라고 하면
	 * 상의와 하의의 조합하는 경우의 수는 A * B
	 * 상의만 선택하고 하의는 선택하지 않을 수도 있고, 하의만 선택하고 상의를 선택하지 않을 수도 있음
	 * (A + 1) * (B + 1) 의 경우의 수가 나옴
	 * 아무것도 입지 않는 수가 있을 수 있기 때문에 최종적으로 -1을 해주면
	 * (A + 1) * (B + 1) - 1 공식을 얻을 수가 있음
	 */
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
