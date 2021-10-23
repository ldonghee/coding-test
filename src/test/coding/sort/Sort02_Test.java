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
}
