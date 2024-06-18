package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/description/
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		return 0;
	}

	@Test
	public void test01() {
		String version1 = "1.2", version2 = "1.10";
		int expect = -1;
		int actual = compareVersion(version1, version2);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		String version1 = "1.01", version2 = "1.001";
		int expect = 0;
		int actual = compareVersion(version1, version2);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test03() {
		String version1 = "1.0", version2 = "1.0.0.0";
		int expect = 0;
		int actual = compareVersion(version1, version2);
		assertThat(expect).isEqualTo(actual);
	}
}
