package test.coding.stackqueue;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.stackqueue.StackQueue01;
import dhlee.coding.stackqueue.StackQueue01_Best;

@DisplayName("Stack Queue")
public class StackQueue01_Test {

    final StackQueue01 test = new StackQueue01();
    final StackQueue01_Best bestTest = new StackQueue01_Best();

    @Test
    void test_01() {
        // given
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] answers = {1, 3, 2};

        // when
        int[] result = test.solution(progresses, speeds);
        int[] result2 = bestTest.solution(progresses, speeds);

        // then
        assertThat(answers).containsExactly(result);
        assertThat(answers).containsExactly(result2);
    }

    @Test
    void test_02() {
        // given
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] answers = {2, 1};

        // when
        int[] result = test.solution(progresses, speeds);
        int[] result2 = bestTest.solution(progresses, speeds);

        // then
        assertThat(answers).containsExactly(result);
        assertThat(answers).containsExactly(result2);
    }
}
