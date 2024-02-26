package test.exam.kakao.mobility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Exam02 {
	public boolean solution(int N, int[] A, int[] B) {
		// Implement your solution here
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		// 각 정점에 연결된 모든 정점을 저장
		for (int i = 0; i < A.length; i++) {
			graph.get(A[i]).add(B[i]);
			graph.get(B[i]).add(A[i]);
		}

		// 각 정점이 이전 정점과 연결되어 있는지 확인
		for (int i = 2; i <= N; i++) {
			if (!graph.get(i).contains(i-1)) {
				return false;
			}
		}

		return true;
	}


	@Test
	public void test1() {
		int N = 4;
		int[] A = {1,2,4,4,3};
		int[] B = {2,3,1,3,1};

		boolean expect = true;
		boolean actual = solution(N, A, B);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test2() {
		int N = 4;
		int[] A = {1,2,1,3};
		int[] B = {2,4,3,4};

		boolean expect = false;
		boolean actual = solution(N, A, B);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test3() {
		int N = 6;
		int[] A = {2,4,5,3};
		int[] B = {3,5,6,4};

		boolean expect = false;
		boolean actual = solution(N, A, B);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test4() {
		int N = 3;
		int[] A = {1,3};
		int[] B = {2,2};

		boolean expect = true;
		boolean actual = solution(N, A, B);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test5() {
		int N = 2;
		int[] A = {1};
		int[] B = {2};

		boolean expect = true;
		boolean actual = solution(N, A, B);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test6() {
		int N = 100000;
		int[] A = new int[99999];
		int[] B = new int[99999];
		for(int i = 0; i < 99999; i++) {
			A[i] = i + 1;
			B[i] = i + 2;
		}
		boolean expect = true;
		boolean actual = solution(N, A, B);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test7() {
		int N = 3;
		int[] A = {1, 2};
		int[] B = {2, 2};
		boolean expect = false;
		boolean actual = solution(N, A, B);

		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test8() {
		int N = 4;
		int[] A = {1, 3, 2};
		int[] B = {2, 4, 3};
		boolean expect = false;
		boolean actual = solution(N, A, B);

		assertThat(actual).isEqualTo(expect);
	}
}
