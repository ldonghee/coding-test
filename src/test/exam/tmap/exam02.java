package test.exam.tmap;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class exam02 {
	/**
	 * You are processing plane seat reservations.
	 * The plane has N rows of seats, numbered from 1 to N.
	 * There are ten seats in each row(labelled from A to K, with letter I omitted).
	 *
	 * Some of the seats are already reserved.
	 * The list of reserved seats is given as a string S(of length M) containing seat numbers separated by single spaces: for example, "1A 3C 2B 20G 5A".
	 * The reserved seats can be listed inS in any order.
	 *
	 * Your task is to allocate seats for as many four-person families as possible.
	 * A four-person family occupies four seats in one row, that are next to each other - seats across an aisle (such as 2C and 2D) are not considered to be next to each other.
	 * it is permissible for the family to be separated by an aisle, but in this case exactly two people have to sit one each side of the aisle.
	 * Obviously, no seat can be allocated to more than one family.
	 *
	 * that, given the number of rows N and a list of reserved seats as string S, returns the maximum number of four-person families that can be seated in the remaining unreserved seats.
	 *
	 * Examples:
	 * 1. Given N=2 and S="1A 2F 1C", your function should return 2.
	 *
	 * 2. Given N=1 and S=""(empty string), your function should return 2.
	 *
	 * 3. Given N=22 and S="1A 3C 2B 20G 5A", the function should return 41.
	 *
	 * Assume that:
	 * N is an integer within the range [1..50];
	 * M is an integer within the range [0..1,909];
	 * string S consists of valid seat names separated with single spaces;
	 * every seat number appears in string S at most one.
	 *
	 * in your soluntion, focus on correctness.
	 *
	 */
	class Solution {
		public int solution(int N, String S) {
			boolean[][] reserved = new boolean[N][10];
			int count = 0;

			if (!S.equals("")) {
				String[] reservedSeats = S.split(" ");
				for (String seat : reservedSeats) {
					int row = Integer.parseInt(seat.substring(0, seat.length() - 1)) - 1;
					int col = seat.charAt(seat.length() - 1) - 'A';
					reserved[row][col] = true;
				}
			}

			for (int i = 0; i < N; i++) {
				if (!reserved[i][1] && !reserved[i][2] && !reserved[i][3] && !reserved[i][4]) {
					count++;
					reserved[i][1] = true;
					reserved[i][2] = true;
					reserved[i][3] = true;
					reserved[i][4] = true;
				}

				if (!reserved[i][5] && !reserved[i][6] && !reserved[i][7] && !reserved[i][8]) {
					count++;
					reserved[i][5] = true;
					reserved[i][6] = true;
					reserved[i][7] = true;
					reserved[i][8] = true;
				}

				if (!reserved[i][3] && !reserved[i][4] && !reserved[i][5] && !reserved[i][6]) {
					count++;
				}
			}

			return count;
		}
	}

	private final Solution solution = new Solution();


	@Test
	public void test1() {
		int N = 2;
		String S = "1A 2F 1C";

		int expect = 2;
		int actual = solution.solution(N, S);

		assertThat(actual).isEqualTo(expect);
	}


	@Test
	public void test2() {
		int N = 1;
		String S = "";

		int expect = 2;
		int actual = solution.solution(N, S);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int N = 22;
		String S = "1A 3C 2B 20G 5A";

		int expect = 41;
		int actual = solution.solution(N, S);

		assertThat(actual).isEqualTo(expect);
	}
}