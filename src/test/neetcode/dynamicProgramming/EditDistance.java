package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
		return 0;
	}

	@Test
	public void test01() {
		String word1 = "horse", word2 = "ros";
		int expect = 3;
		int actual = minDistance(word1, word2);
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	public void test02() {
		String word1 = "intention", word2 = "execution";
		int expect = 5;
		int actual = minDistance(word1, word2);
		assertThat(expect).isEqualTo(actual);
	}
}
