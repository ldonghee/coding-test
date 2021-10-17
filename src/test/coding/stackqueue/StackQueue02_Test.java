package test.coding.stackqueue;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.stackqueue.StackQueue02;

@DisplayName("Stack Queue")
public class StackQueue02_Test {

    StackQueue02 test = new StackQueue02();

    @Test
    void test_01() {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;
        int answer = 1;

        int result = test.solution(priorities, location);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_02() {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        int answer = 5;

        int result = test.solution(priorities, location);

        assertThat(result).isEqualTo(answer);
    }
}
