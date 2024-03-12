package test.neetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * 89. Gray Code
 * https://leetcode.com/problems/gray-code/description/
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {

		if (n == 0) {
			List<Integer> baseCase = new ArrayList<>();
			baseCase.add(0);
			return baseCase;
		}

		// (n-1)-bit 그레이 코드를 얻는다.
		List<Integer> previousGrayCode = grayCode(n-1);
		int addValue = 1 << (n-1); // 2^(n-1) 값을 계산한다.
		List<Integer> currentGrayCode = new ArrayList<>(previousGrayCode);

		// 역순으로 (n-1)-bit 그레이 코드를 순회하면서, 각 값에 2^(n-1)을 더해준다.
		for (int i = previousGrayCode.size() - 1; i >= 0; i--) {
			currentGrayCode.add(previousGrayCode.get(i) + addValue);
		}

		return currentGrayCode;

	}

	@Test
	public void test01() {
		int n = 2;

		List<Integer> expect = Arrays.asList(0,1,3,2);
		List<Integer> actual = grayCode(n);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		int n = 1;

		List<Integer> expect = Arrays.asList(0, 1);
		List<Integer> actual = grayCode(n);

		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		int n = 3;

		List<Integer> expect = Arrays.asList(0, 1, 3, 2, 6, 7, 5, 4);
		List<Integer> actual = grayCode(n);

		assertThat(expect).isEqualTo(actual);
	}
}
