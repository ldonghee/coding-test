package test.neetcode.twopointers;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 165. Compare Version Numbers
 * https://leetcode.com/problems/compare-version-numbers/description/
 */
public class CompareVersionNumbers {
	public int compareVersion(String version1, String version2) {
		String[] splitVersion1 = version1.split("\\.");
		String[] splitVersion2 = version2.split("\\.");

		for (int idx = 0; idx < splitVersion1.length || idx < splitVersion2.length; idx++) {
			int int1 = idx < splitVersion1.length ? Integer.parseInt(splitVersion1[idx]) : 0;
			int int2 = idx < splitVersion2.length ? Integer.parseInt(splitVersion2[idx]) : 0;
			if (int1 > int2) {
				return 1;
			} else if (int1 < int2) {
				return -1;
			}
		}
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
