package test.exam.woo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class exam04 {
	/**
	 * Path variable 방식의 url 을 사용하다가 query parameter 방식으로 변경하였다.
	 * 관련된 코드는 수정했지만 요청 로그는 로그의 저장 형식이 달라서 파싱할 때 어려움을 겪고 있다.
	 *
	 * 기존에 path variable 방식의 로그를 query parameter 방식의 로그로 변경해야 한다.
	 *
	 * /payment/{paymentId}/{paymentMethod} 형식의 문자열을
	 * /payment/{paymentMethod}?paymentId={paymentId} 형식으로 변경하여 반환해야 한다.
	 *
	 * 제한사항
	 * paymentId는 1글자 이상 9글자 이하의 숫자로만 이루어져 있다.
	 * paymentMethod는 1글자 이상 10글자 이하의 알파벳으로 이루어져있다.
	 * 전달받은 URL이 형식에 맞지않으면 문자열 "error"를 반환한다.
	 *
	 * 정규식을 최대한 활용하여 코드를 작성
	 *
	 * 예제1)
	 * 입력 : /payment/1234/cancel
	 * 결과 : /payment/cancel?paymentId=1234
	 *
	 * 예제2)
	 * 입력 : /payment/1234
	 * 결과 : error
	 *
	 *
	 */
	class Solution {
		public String solution(String pathVariableUrl) {
			String regex = "/payment/([0-9]{1,9})/([a-zA-Z]{1,10})";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(pathVariableUrl);

			if (matcher.matches()) {
				String paymentId = matcher.group(1);
				String paymentMethod = matcher.group(2);
				return "/payment/" + paymentMethod + "?paymentId=" + paymentId;
			}

			return "error";
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test() {
		String pathVariableUrl = "/payment/1234/cancel";

		String expect = "/payment/cancel?paymentId=1234";
		String actual = solution.solution(pathVariableUrl);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		String pathVariableUrl = "/payment/1234";

		String expect = "error";
		String actual = solution.solution(pathVariableUrl);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		String pathVariableUrl = "/payment/a1234/cancel";

		String expect = "error";
		String actual = solution.solution(pathVariableUrl);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test4() {
		String pathVariableUrl = "/payment/1234567890/cancel";

		String expect = "error";
		String actual = solution.solution(pathVariableUrl);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test5() {
		String pathVariableUrl = "/payment/1234/5678";

		String expect = "error";
		String actual = solution.solution(pathVariableUrl);

		assertThat(actual).isEqualTo(expect);
	}
}
