package test.coding.exam;

import dhlee.coding.exam.Exam03;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exam03_Test {
    final private Exam03 test = new Exam03();

    @Test
    void test_01() {
        int[] A = {3, 2, 3, 2, 3};
        int answer = 5;

        int result = test.solution(A);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_02() {
        int[] A = {7, 4, -2, 4, -2, -9};
        int answer = 4;

        int result = test.solution(A);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_03() {
        int[] A = {7, -5, -5, -5, 7, -1, 7};
        int answer = 3;

        int result = test.solution(A);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_04() {
        int[] A = {4};
        int answer = 1;

        int result = test.solution(A);

        assertThat(result).isEqualTo(answer);
    }
}
