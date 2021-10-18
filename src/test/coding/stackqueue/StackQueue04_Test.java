package test.coding.stackqueue;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.stackqueue.StackQueue04;

@DisplayName("Stack Queue")
public class StackQueue04_Test {

    final StackQueue04 test = new StackQueue04();

    @Test
    void test_01() {
        int[] price = {1, 2, 3, 2, 3};
        int[] answer = {4, 3, 1, 1, 0};

        int[] result = test.solution(price);

        assertThat(result).isEqualTo(answer);
    }
}
