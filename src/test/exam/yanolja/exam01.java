package test.exam.yanolja;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class exam01 {

	public List<Integer> frequency(String s) {
		List<Integer> result = new ArrayList<>(Collections.nCopies(26, 0));
		int i = 0, n = s.length();

		while (i < n) {
			int count = 1; // 기본 빈도수는 1로 설정
			int index; // 알파벳 인덱스

			// '#'이 포함된 경우
			if (i + 2 < n && s.charAt(i + 2) == '#') {
				index = Integer.parseInt(s.substring(i, i + 2)) - 1;
				i += 3; // 기본적으로 3 문자를 건너뛰게 설정
			} else { // '#'이 포함되지 않은 경우
				index = Integer.parseInt(s.substring(i, i + 1)) - 1;
				i += 1; // 기본적으로 1 문자를 건너뛰게 설정
			}

			// 괄호가 있는 경우 빈도수 업데이트
			if (i < n && s.charAt(i) == '(') {
				int closingBracketIndex = s.indexOf(')', i);
				count = Integer.parseInt(s.substring(i + 1, closingBracketIndex));
				i = closingBracketIndex + 1; // 닫는 괄호 다음으로 이동
			}

			// 결과 리스트 업데이트
			result.set(index, result.get(index) + count);
		}

		return result;
	}

	@Test
	public void test1() {
		String s = "1226#24#";

		List<Integer> expect = Arrays.asList(1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1);

		List<Integer> actual = frequency(s);

		for (int i=0; i<26; i++) {
			assertThat(expect.get(i).equals(actual.get(i))).isTrue();
		}
	}

	@Test
	public void test2() {
		String s = "1(2)23(3)";

		List<Integer> expect = Arrays.asList(2,1,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

		List<Integer> actual = frequency(s);

		for (int i=0; i<26; i++) {
			assertThat(expect.get(i).equals(actual.get(i))).isTrue();
		}
	}

	@Test
	public void test3() {
		String s = "2110#(2)";

		List<Integer> expect = Arrays.asList(1,1,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);

		List<Integer> actual = frequency(s);

		for (int i=0; i<26; i++) {
			assertThat(expect.get(i).equals(actual.get(i))).isTrue();
		}
	}

	@Test
	public void test4() {
		String s = "23#(2)24#25#26#23#(3)";

		List<Integer> expect = Arrays.asList(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,1,1,1);

		List<Integer> actual = frequency(s);

		for (int i=0; i<26; i++) {
			assertThat(expect.get(i).equals(actual.get(i))).isTrue();
		}
	}
}