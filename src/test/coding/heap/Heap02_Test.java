package test.coding.heap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.heap.Heap02;

@DisplayName("힙(Heap)")
public class Heap02_Test {

    final private Heap02 test = new Heap02();

    @Test
    void test_01() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int answer = 9;

        int result = test.solution(jobs);

        assertThat(result).isEqualTo(answer);
    }
}
