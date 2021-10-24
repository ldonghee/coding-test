package test.coding.heap;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.heap.Heap02;
import dhlee.coding.heap.Heap02_Best;

@DisplayName("힙(Heap)")
public class Heap02_Test {

    final private Heap02 test = new Heap02();
    final private Heap02_Best bestTest = new Heap02_Best();

    @Test
    void test_01() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        int answer = 9;

        int result = test.solution(jobs);
        int result2 = bestTest.solution(jobs);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    @DisplayName("요청 시간과 소요시간이 동일한 경우 테스트 ")
    void test_02() {
        int[][] jobs = {{3, 3}, {3, 3}, {3, 3}};
        int answer = 6;

        int result = test.solution(jobs);
        int result2 = bestTest.solution(jobs);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }
}
