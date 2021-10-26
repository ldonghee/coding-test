package test.coding.sort;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.sort.Sort03;

@DisplayName("Sort")
public class Sort03_Test {

    final private Sort03 test = new Sort03();

    @Test
    void test_01() {
        int[] citations = {3, 0, 6, 1, 5};
        int answers = 3;

        int result = test.solution(citations);

        assertThat(result).isEqualTo(answers);
    }
}
