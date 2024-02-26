package test.exam.kakao.mobility;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Exam03 {
	public int solution(int N, String S) {
		boolean[][] reserved = new boolean[N][10];
		if (!S.equals("")) {
			String[] reservedSeats = S.split(" ");
			for (String seat : reservedSeats) {
				int row = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
				int col = seat.charAt(seat.length() - 1) - 'A';
				if (col >= 'I' - 'A') col--;
				reserved[row][col] = true;
			}
		}

		int count = 0;
		for (int i = 0; i < N; i++) {
			if (!reserved[i][1] && !reserved[i][2] && !reserved[i][3] && !reserved[i][4] && !reserved[i][5] && !reserved[i][6] && !reserved[i][7] && !reserved[i][8]) {
				count += 2;
			} else if (!reserved[i][1] && !reserved[i][2] && !reserved[i][3] && !reserved[i][4] && (reserved[i][5] || reserved[i][6] || reserved[i][7] || reserved[i][8])) {
				count++;
			} else if ((reserved[i][1] || reserved[i][2] || reserved[i][3] || reserved[i][4]) && !reserved[i][5] && !reserved[i][6] && !reserved[i][7] && !reserved[i][8]) {
				count++;
			} else if (!reserved[i][1] && !reserved[i][2] && !reserved[i][3] && !reserved[i][4] && !reserved[i][5] && !reserved[i][6] || !reserved[i][5] && !reserved[i][6] && !reserved[i][7] && !reserved[i][8]) {
				count++;
			}
		}

		return count;
	}


	@Test
	public void test1() {
		int N = 2;
		String S = "1A 2F 1C";

		int expect = 2;
		int actual = solution(N, S);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		int N = 1;
		String S = "";

		int expect = 2;
		int actual = solution(N, S);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int N = 22;
		String S = "1A 3C 2B 20G 5A";

		int expect = 41;
		int actual = solution(N, S);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void testEmptySeats() {
		assertEquals(2, solution(1, ""));
		assertEquals(4, solution(2, ""));
		assertEquals(100, solution(50, ""));
	}

	@Test
	public void testAllReservedSeats() {
		assertEquals(0, solution(1, "1A 1B 1C 1D 1E 1F 1G 1H 1J"));
		assertEquals(0, solution(2, "1A 1B 1C 1D 1E 1F 1G 1H 1J 2A 2B 2C 2D 2E 2F 2G 2H 2J"));
	}

	@Test
	public void testSomeReservedSeats() {
		assertEquals(2, solution(2, "1A 2F 1C"));
		assertEquals(41, solution(22, "1A 3C 2B 20G 5A"));
	}

	@Test
	public void testNoFamilySeats() {
		assertEquals(0, solution(1, "1B 1C 1E 1F"));
		assertEquals(1, solution(2, "1B 1C 1E 1F 2A"));
	}
}


