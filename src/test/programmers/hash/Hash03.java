package test.programmers.hash;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

/**
 * 전화번호 목록
 * https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class Hash03 {
	class Solution {

//		public boolean solution(String[] phone_book) {
//			for (int i=0; i<phone_book.length; i++) {
//				String phone = phone_book[i];
//
//				for (int j=0; j<phone_book.length; j++) {
//					if (i == j) {
//						continue;
//					}
//					if (phone_book[j].startsWith(phone))
//						return false;
//				}
//			}
//			return true;
//		}

		public boolean solution(String[] phone_book) {
			Arrays.sort(phone_book);

			for (int i=0; i<phone_book.length-1; i++) {
				if (phone_book[i+1].startsWith(phone_book[i])) {
					return false;
				}
			}

			return true;
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		String[] phone_book = {"119", "97674223", "1195524421"};

		boolean expect = false;
		boolean actual = solution.solution(phone_book);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		String[] phone_book = {"123","456","789"};

		boolean expect = true;
		boolean actual = solution.solution(phone_book);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		String[] phone_book = {"12","123","1235","567","88"};

		boolean expect = false;
		boolean actual = solution.solution(phone_book);
		assertThat(actual).isEqualTo(expect);
	}
}
