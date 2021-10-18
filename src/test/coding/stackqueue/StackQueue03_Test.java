package test.coding.stackqueue;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.stackqueue.StackQueue03;
import dhlee.coding.stackqueue.StackQueue03_Best;

@DisplayName("Stack Queue")
public class StackQueue03_Test {

    final StackQueue03 test = new StackQueue03();
    final StackQueue03_Best bestTest = new StackQueue03_Best();

    @Test
    void test_01() {
        int[] truck_weights = {7, 4, 5, 6};
        int bridge_length = 2;
        int weight = 10;
        int answer = 8;

        int result = test.solution(bridge_length, weight, truck_weights);
        int result2 = bestTest.solution(bridge_length, weight, truck_weights);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    void test_02() {
        int[] truck_weights = {10};
        int bridge_length = 100;
        int weight = 100;
        int answer = 101;

        int result = test.solution(bridge_length, weight, truck_weights);
        int result2 = bestTest.solution(bridge_length, weight, truck_weights);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    void test_03() {
        int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
        int bridge_length = 100;
        int weight = 100;
        int answer = 110;

        int result = test.solution(bridge_length, weight, truck_weights);
        int result2 = bestTest.solution(bridge_length, weight, truck_weights);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }
}
