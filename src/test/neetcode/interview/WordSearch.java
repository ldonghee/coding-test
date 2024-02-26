package test.neetcode.interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WordSearch {
	/**
	 * 제약 조건
	 * m == board.length
	 * n = board[i].length
	 * 1 <= m, n <= 6
	 * 1 <= word.length <= 15
	 * board and word consists of only lowercase and uppercase English letters.
	 *
	 * 시간 복잡도(Time Complexity): O(MN * 4^L)
	 * 이 알고리즘에서는 보드의 모든 셀에서 시작하여 DFS를 수행합니다.
	 * 각 셀에서 DFS를 수행하는데 필요한 시간 복잡도는 O(4^L)입니다.
	 * 여기서 L은 단어의 길이를 의미합니다. 따라서 전체 시간 복잡도는 O(MN * 4^L)입니다.
	 * 여기서 M과 N은 보드의 행과 열의 수를 의미합니다.
	 *
	 * 공간 복잡도(Space Complexity): O(MN)
	 * 이 알고리즘에서는 방문한 셀을 추적하기 위해 M x N 크기의 추가적인 공간을 사용합니다.
	 * 따라서 공간 복잡도는 O(MN)입니다.
	 *
	 * 엣지 케이스
	 * 1. 단어의 길이가 1인 경우: 이 경우에는 단어가 보드의 어떤 셀에도 존재하지 않을 수 있습니다. 이 경우에는 false를 반환해야 합니다.
	 * 2. 보드의 모든 셀이 동일한 문자로 이루어진 경우: 이 경우에는 단어가 보드에 존재하지 않을 수 있습니다. 이 경우에도 false를 반환해야 합니다.
	 * 3. 단어가 보드의 여러 개의 라인을 걸쳐 있을 경우: 이 경우에는 단어가 여러 라인에 걸쳐 있더라도 찾을 수 있어야 합니다.
	 * 4. 단어가 보드에 여러 번 등장하는 경우: 이 경우에는 단어가 보드에 한 번 이상 등장해도 true를 반환해야 합니다.
	 */

	private boolean[][] visited;

	public boolean exist(char[][] board, String word) {
		visited = new boolean[board.length][board[0].length];

		for (int row=0; row<board.length; row++) {
			for (int col=0; col<board[row].length; col++) {
				boolean answer = dfs(board, word, 0, row, col);
				if(answer) return true;
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, String word, int depth, int row, int col) {
		if (depth == word.length()) {
			return true;
		}
		if (row < 0 || col < 0 || row >= board.length || col >= board[row].length) {
			return false;
		}
		if (visited[row][col]) {
			return false;
		}
		if (board[row][col] != word.charAt(depth)) {
			return false;
		}

		visited[row][col] = true;

		boolean result = dfs(board, word,  depth + 1, row - 1, col)
				 || dfs(board, word,  depth + 1, row, col - 1)
				 || dfs(board, word,  depth + 1, row + 1, col)
				 || dfs(board, word,  depth + 1, row, col + 1);

		if (!result)
			visited[row][col] = false;

		return result;
	}

	@Test
	public void test01() {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";

		boolean expect = true;
		boolean actual = exist(board, word);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";

		boolean expect = true;
		boolean actual = exist(board, word);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test03() {
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCB";

		boolean expect = false;
		boolean actual = exist(board, word);
		assertThat(actual).isEqualTo(expect);
	}
}
