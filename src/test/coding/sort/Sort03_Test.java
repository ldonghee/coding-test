package test.coding.sort;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.sort.Sort03;
import dhlee.coding.sort.Sort03_Best;

@DisplayName("Sort")
public class Sort03_Test {

    final private Sort03 test = new Sort03();
    final private Sort03_Best bestTest = new Sort03_Best();

    @Test
    void test_01() {
        int[] citations = {3, 0, 6, 1, 5};
        int answers = 3;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_02() {
        int[] citations = {0, 0, 0, 0, 0};
        int answers = 0;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_03() {
        int[] citations = {0, 0, 0, 0, 1};
        int answers = 1;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_04() {
        int[] citations = {9, 9, 9, 12};
        int answers = 4;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_05() {
        int[] citations = {9, 7, 6, 2, 1};
        int answers = 3;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_06() {
        int[] citations = {10, 8, 5, 4, 3};
        int answers = 4;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_07() {
        int[] citations = {25, 8, 5, 3, 3};
        int answers = 3;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_08() {
        int[] citations = {1, 1, 5, 7, 6};
        int answers = 3;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_09() {
        int[] citations = {0};
        int answers = 0;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }

    @Test
    void test_10() {
        int[] citations = {0, 0};
        int answers = 0;

        int result = test.solution(citations);
        int result2 = bestTest.solution(citations);

        assertThat(result).isEqualTo(answers);
        assertThat(result2).isEqualTo(answers);
    }
}
