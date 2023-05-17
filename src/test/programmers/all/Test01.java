package test.programmers.all;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 * 달리기 경주
 */
public class Test01 {
	class Solution {
		public String[] solution(String[] players, String[] callings) {
			Map<String, Integer> rankMap = new HashMap<>();
			for (int i=0; i<players.length; i++) {
				rankMap.put(players[i], i);
			}

			for (String calling : callings) {
				Integer rank = rankMap.get(calling);

				// 앞서 가던 선수
				String faster = players[rank - 1];

				players[rank - 1] = calling;
				players[rank] = faster;

				rankMap.put(calling, rank - 1);
				rankMap.put(faster, rank);
			}

			return players;
		}
	}
	private final Solution solution = new Solution();

	@Test
	public void test() {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};

		String[] expect = {"mumu", "kai", "mine", "soe", "poe"};
		String[] actual = solution.solution(players, callings);

		assertThat(actual).isEqualTo(expect);
	}
}
