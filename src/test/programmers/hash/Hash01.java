package test.programmers.hash;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 완주하지 못한 선수
 * https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class Hash01 {
	class Solution {
		public String solution(String[] participant, String[] completion) {
			List<String> answers = new ArrayList<>();
			HashMap<String, Integer> participantMap = new HashMap<>();

			for (String person : participant) {
				int cnt = 1;
				if (participantMap.containsKey(person)) {
					cnt = participantMap.get(person) + 1;
				}
				participantMap.put(person, cnt);
			}

			for (String person : completion) {
				int cnt = participantMap.get(person);
				participantMap.put(person, cnt - 1);
			}

			for (String key : participantMap.keySet()) {
				if (participantMap.get(key) >= 1) {
					answers.add(key);
				}
			}
			return answers.toString().substring(1, answers.toString().length()-1);
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};

		String expect = "leo";
		String actual = solution.solution(participant, completion);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] completion = {"josipa", "filipa", "marina", "nikola"};

		String expect = "vinko";
		String actual = solution.solution(participant, completion);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};

		String expect = "mislav";
		String actual = solution.solution(participant, completion);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test04() {
		String[] participant = {"mislav", "stanko", "mislav", "ana", "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = {"stanko", "ana", "mislav", "josipa", "filipa", "marina", "nikola" };

		String expect = "mislav, vinko";
		String actual = solution.solution(participant, completion);
		assertThat(actual).isEqualTo(expect);
	}
}
