package test.coding.dfsbfs;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dhlee.coding.dfsbfs.DfsBfs02;

public class DfsBfs02_Test {
    final private DfsBfs02 test = new DfsBfs02();

    @Test
    void test_01() {
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int n = 3;
        int answer = 2;

        int result = test.solution(n, computers);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_02() {
        int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int n = 3;
        int answer = 1;

        int result = test.solution(n, computers);

        assertThat(result).isEqualTo(answer);
    }
}
