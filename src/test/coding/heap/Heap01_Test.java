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

    @Test
    @DisplayName("스코빌 지수 K 이상으로 만들수 없는 경우 테스트")
    void test_02() {
        int[] scoville = {1, 1, 1, 1, 1, 1};
        int K = 100;
        int answer = -1;

        int result = test.solution(scoville, K);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("모두 스코빌 지수 K 이상일 경우 테스트")
    void test_03() {
        int[] scoville = {1, 1, 1, 1, 1, 1};
        int K = 1;
        int answer = 0;

        int result = test.solution(scoville, K);

        assertThat(result).isEqualTo(answer);
    }


}
