package test.coding.dfsbfs;

import static org.assertj.core.api.Assertions.*;

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
}
