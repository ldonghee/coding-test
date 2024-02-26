package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class IntegerToRoman {
	/**
	 * 제약 사항
	 * 1 <= num <= 3999
	 *
	 *
	 * 시간 복잡도 : O(1)
	 * 함수가 codeInt라는 배열을 루프를 통해 순회하기 때문입니다.
	 * codeInt 배열의 크기는 상수값인 13으로, 이는 입력 크기 num에 상관없이 일정한 값을 가집니다.
	 * 이것은 배열을 순회하는 데 필요한 시간이 입력 크기에 영향을 받지 않음을 의미합니다.
	 * 더욱이, 각 루프에서 num값을 감소시키는 과정은 최대 3번만 이루어집니다. 이는 최대 3자리 수를 감소시키는 경우를 의미하며, 이러한 이유로 시간 복잡도는 O(1) 이라고 볼 수 있습니다.
	 *
	 * 공간 복잡도 : O(1)
	 * 이 함수는 StringBuilder 객체인 sb를 사용하여 결과 문자열을 생성합니다.
	 * sb의 크기는 입력 num의 크기에 따라 변동이 있지만, 제약 조건에 따르면 num의 값은 최대 3999를 초과할 수 없습니다.
	 * 이는 sb의 크기가 'MMMCMXCIX'의 길이인 15개 문자를 초과할 수 없음을 의미합니다.
	 *
	 *
	 * 엣지 케이스
	 * 1. 최소 입력값: num의 값이 1인 경우
	 * 이 경우에는 로마 숫자로 'I'를 반환해야 합니다.
	 *
	 * 2. 최대 입력값: num의 값이 3999인 경우
	 * 이 경우에는 로마 숫자로 'MMMCMXCIX'를 반환해야 합니다.
	 *
	 * 3. 특정 패턴
	 * 로마 숫자로 표현할 때 특정 패턴이 반복되는 숫자, 예를 들어 3000('MMM'), 200('CC'), 30('XXX'), 3('III') 등입니다.
	 */
	public String intToRoman(int num) {
		int[] codeInt = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] stringRoman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<codeInt.length; i++) {
			while(num >= codeInt[i]) {
				sb.append(stringRoman[i]);
				num = num-codeInt[i];
			}
		}
		return sb.toString();
	}

	@Test
	public void test01() {
		int nums = 3;
		String expect = "III";
		String actual = intToRoman(nums);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int nums = 58;
		String expect = "LVIII";
		String actual = intToRoman(nums);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int nums = 1994;
		String expect = "MCMXCIV";
		String actual = intToRoman(nums);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test04() {
		int nums = 1;
		String expect = "I";
		String actual = intToRoman(nums);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test05() {
		int nums = 3999;
		String expect = "MMMCMXCIX";
		String actual = intToRoman(nums);

		assertThat(expect).isEqualTo(actual);
	}

}
