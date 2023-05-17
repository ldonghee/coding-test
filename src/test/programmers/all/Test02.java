package test.programmers.all;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963
 *  추억 점수
 */
public class Test02 {
	class Solution {
		public int[] solution(String[] name, int[] yearning, String[][] photo) {
			Map<String, Integer> rememberPointMap = new HashMap<>();
			List<Integer> rememberPointList = new ArrayList<>();

			for (int i=0; i<name.length; i++) {
				rememberPointMap.put(name[i], yearning[i]);
			}

			for (String[] p : photo) {
				int sum = 0;
				for (String n : p) {
					sum += rememberPointMap.getOrDefault(n, 0);
				}
				rememberPointList.add(sum);
			}

			return rememberPointList.stream().mapToInt(i->i).toArray();
		}
	}
	private final Solution solution = new Solution();

	@Test
	public void test() {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

		int[] expect = {19, 15, 6};
		int[] actual = solution.solution(name, yearning, photo);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		String[] name = {"kali", "mari", "don"};
		int[] yearning = {11, 1, 55};
		String[][] photo = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};

		int[] expect = {67, 0, 55};
		int[] actual = solution.solution(name, yearning, photo);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		String[] name = {"may", "kein", "kain", "radi"};
		int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};

		int[] expect = {5, 15, 0};
		int[] actual = solution.solution(name, yearning, photo);

		assertThat(actual).isEqualTo(expect);
	}

}
