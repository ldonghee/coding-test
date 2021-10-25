package test.coding.dfsbfs;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.dfsbfs.DfsBfs01;

public class DfsBfs01_Test {
    final private DfsBfs01 test = new DfsBfs01();

    @Test
    void test_01() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        int answer = 5;

        int result = test.solution(numbers, target);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("원소가 하나일 경우, 테스트")
    void test_02() {
        int[] numbers = {5};
        int target = 5;
        int answer = 1;

        int result = test.solution(numbers, target);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("target 과 일치하지 않을 경우, 테스트")
    void test_03() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 100;
        int answer = 0;

        int result = test.solution(numbers, target);

        assertThat(result).isEqualTo(answer);
    }
}
