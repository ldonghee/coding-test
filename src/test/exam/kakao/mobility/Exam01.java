package test.exam.kakao.mobility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Exam01 {
    public void solution(int N) {
        int enable_print = 0;
        while (N > 0) {
            if (N % 10 != 0 && enable_print == 0)
                enable_print = 1;
            if (enable_print == 1)
                System.out.print(N % 10);
            N = N / 10;
        }
    }


	@Test
	public void test1() {
		int N = 54321;

		int expect = 12345;
		solution(N);
	}

    @Test
    public void test2() {
        int N = 10011;

        int expect = 11001;
        solution(N);
    }

    @Test
    public void test3() {
        int N = 1;

        int expect = 1;
        solution(N);
    }

    @Test
    public void test4() {
        int N = 101010;

        solution(N);
    }

    @Test
    @DisplayName("N의 최댓값일 경우")
    public void test5() {
        int N = 1000000000;

        solution(N);
    }

    @Test
    public void test6() {
        int N = 33333;

        solution(N);
    }
}
