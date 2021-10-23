package test.coding.sort;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.sort.Sort02;

@DisplayName("Sort")
public class Sort02_Test {

    final private Sort02 test = new Sort02();

    @Test
    void test_01() {
        int[] numbers = {6, 10, 2};
        String answers = "6210";

        String result = test.solution(numbers);

        assertThat(result).isEqualTo(answers);
    }

    @Test
    void test_02() {
        int[] numbers = {100, 10, 10};
        String answers = "1010100";

        String result = test.solution(numbers);

        assertThat(result).isEqualTo(answers);
    }

    @Test
    @DisplayName("모두 0인 경우 테스트")
    void test_03() {
        int[] numbers = {0, 0, 0, 0, 0};
        String answers = "0";

        String result = test.solution(numbers);

        assertThat(result).isEqualTo(answers);
    }


}
