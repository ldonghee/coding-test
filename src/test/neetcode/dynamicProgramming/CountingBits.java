package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 338. Counting Bits
 * https://leetcode.com/problems/counting-bits/description/
 */
public class CountingBits {
	public int[] countBits(int n) {
		int[] answers = new int[n + 1];
		for (int i=0; i<=n; i++) {
			int count = 0;
			String s = Integer.toBinaryString(i);
			for (int j=0; j<s.length(); j++) {
				if ('1' == (s.charAt(j))) {
					count++;
				}
			}
			answers[i] = count;

		}
		return answers;
	}

	/**
	 *
	 * 1. 입력으로 주어진 num에 대해 0부터 num까지의 각 숫자에 대한 1의 개수를 저장할 배열 f를 선언합니다.
	 *    배열의 크기는 num + 1입니다(0부터 num까지 포함해야 하므로).
	 * 2. for 반복문을 사용하여 1부터 num까지 반복합니다.
	 *    0은 이미 1의 개수가 0이므로 초기값 설정이 필요 없습니다.
	 * 3. 각 숫자 i에 대해, i를 오른쪽으로 1비트 시프트한 값 (i >> 1)에 대한 1의 개수를 이미 알고 있으므로 이를 활용합니다.
	 *    i >> 1은 사실상 i를 2로 나눈 것과 같으며, 이는 i의 이진 표현에서 최하위 비트를 제거한 것과 동일합니다.
	 *    따라서, i의 1의 개수는 i >> 1의 1의 개수에 i의 최하위 비트가 1인지 여부를 더한 것과 같습니다.
	 * 4. i & 1 연산은 i의 최하위 비트가 1인지를 확인합니다.
	 *    만약 i의 최하위 비트가 1이면, i & 1의 결과는 1이 되고, 그렇지 않으면 0이 됩니다.
	 *    따라서, f[i] = f[i >> 1] + (i & 1);는 i의 1의 개수를 올바르게 계산합니다.
	 * 5. 마지막으로, 계산된 배열 f를 반환합니다.
	 *
	 * @param num
	 * @return
	 */
	public int[] countBits2(int num) {
		int[] f = new int[num + 1];
		for (int i=1; i<=num; i++) {
			f[i] = f[i >> 1] + (i & 1);
		}
		return f;
	}

	@Test
	void test1() {
		int n = 2;
		int[] expect = {0,1,1};
		int[] actual = countBits2(n);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	void test2() {
		int n = 5;
		int[] expect = {0,1,1,2,1,2};
		int[] actual = countBits2(n);
		assertThat(expect).isEqualTo(actual);
	}
}
