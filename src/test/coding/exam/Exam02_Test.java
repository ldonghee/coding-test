package test.coding.exam;

import dhlee.coding.exam.Exam02;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exam02_Test {
    final private Exam02 test = new Exam02();

    @Test
    void test_01() {
        int[] T = {0, 3, 0, 0, 5, 0, 5};
        int[] A = {4, 2, 6, 1, 0};
        int answer = 7;

        int result = test.solution(T, A);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_02() {
        int[] T = {0, 0, 1, 1};
        int[] A = {2};
        int answer = 3;

        int result = test.solution(T, A);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_03() {
        int[] T = {0, 0, 0, 0, 2, 3, 3};
        int[] A = {2, 5, 6};
        int answer = 5;

        int result = test.solution(T, A);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_04() {
        int[] T = {0, 0, 1, 2};
        int[] A = {1, 2};
        int answer = 3;

        int result = test.solution(T, A);

        assertThat(result).isEqualTo(answer);
    }
}
