package test.coding.search;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dhlee.coding.search.Search01;
import dhlee.coding.search.Search01_Best;

public class Search01_Test {
    private final Search01 test = new Search01();
    private final Search01_Best bestTest = new Search01_Best();

    @Test
    void test_01() {
        int[] answers = {1, 2, 3, 4, 5};
        int[] answer = {1};

        int[] result = test.solution(answers);
        int[] result2 = bestTest.solution(answers);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    void test_02() {
        int[] answers = {1, 3, 2, 4, 2};
        int[] answer = {1, 2, 3};

        int[] result = test.solution(answers);
        int[] result2 = bestTest.solution(answers);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }
}
