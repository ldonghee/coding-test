package test.coding.heap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.heap.Heap01;

@DisplayName("힙(Heap)")
public class Heap01_Test {
    final Heap01 test = new Heap01();

    @Test
    void test_01() {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        int answer = 2;

        int result = test.solution(scoville, K);

        assertThat(result).isEqualTo(answer);
    }
}
