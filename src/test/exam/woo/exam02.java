package test.exam.woo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

public class exam02 {

	/**
	 * 주어지는 두 개의 문자여 배열에 공통으로 존재하는 문자열들을 추출하고, 오름차순으로 정렬 후 ','로 구분된 문자열을 만들어 반환
	 * 1. leftArray, rightArray 매개변수를 통해 String 배열을 입력받음
	 * 2. 양쪽 배열에 모두 존재하는 문자열을 추출 및 오름차순 정렬 후, 생성된 문자열 반환
	 * 중복된 문자열에 대해서는 중복 제거
	 * 양쪽 배열에 모두 존재하는 문자열이 없는 경우 빈 문자열("") 반환
	 *
	 */
	class Solution {
		public String solution(String[] leftArray, String[] rightArray) {
			List<String> leftList = Arrays.asList(leftArray);
			List<String> rightList = Arrays.asList(rightArray);
			Set<String> commonSet = new HashSet<>(leftList);
			commonSet.retainAll(rightList);


			return commonSet.stream()
						   .sorted()
						   .collect(Collectors.joining(","));

//			List<String> commonList = new ArrayList<>(commonSet);
//			Collections.sort(commonList);
//			return String.join(",", commonList);
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test() {
		String[] leftArray = {"a", "b", "c"};
		String[] rightArray = {"b", "c", "d"};

		String expect = "b,c";
		String actual = solution.solution(leftArray, rightArray);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		String[] leftArray = {"a", "b", "b"};
		String[] rightArray = {"b", "c", "d"};

		String expect = "b";
		String actual = solution.solution(leftArray, rightArray);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		String[] leftArray = {"a", "b", "b"};
		String[] rightArray = {"d", "c", "d"};

		String expect = "";
		String actual = solution.solution(leftArray, rightArray);

		assertThat(actual).isEqualTo(expect);
	}
}
