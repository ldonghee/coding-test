package test.neetcode.dynamicProgramming;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * 72. Edit Distance
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {

	public int minDistance(String word1, String word2) {
		int n = word1.length();
		int m = word2.length();
		// 다이나믹 프로그래밍을 위한 2차원 DP 테이블 초기화
		int[][] dp = new int[n + 1][m + 1];
		// DP 테이블 초기 설정
		for (int i = 1; i <= n; i++) {
			dp[i][0] = i;
		}
		for (int j = 1; j <= m; j++) {
			dp[0][j] = j;
		}

		// 최소 편집 거리 계산
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// 문자가 같다면, 왼쪽 위에 해당하는 수를 그대로 대입
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				}
				// 문자가 다르다면, 세 가지 경우 중에서 최솟값 찾기
				else { // 삽입(왼쪽), 삭제(위쪽), 교체(왼쪽 위) 중에서 최소 비용을 찾아 대입
					dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
				}
			}
		}

		return dp[n][m];
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
