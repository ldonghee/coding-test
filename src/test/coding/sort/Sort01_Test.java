package test.coding.sort;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.sort.Sort01;

@DisplayName("Sort")
public class Sort01_Test {

    final private Sort01 test = new Sort01();

    @Test
    void test_01() {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answers = {5, 6, 3};

        int[] result = test.solution(array, commands);

        assertThat(result).isEqualTo(answers);
    }
}
