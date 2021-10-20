package test.coding.hash;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.hash.Hash02;

@DisplayName("Hash")
public class Hash02_Test {
    final Hash02 test = new Hash02();

    @Test
    void test_01() {
        String[] phone_book = {"119", "97674223", "1195524421"};
        Boolean answer = false;

        Boolean result = test.solution(phone_book);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_02() {
        String[] phone_book = {"123","456","789"};
        Boolean answer = true;

        Boolean result = test.solution(phone_book);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_03() {
        String[] phone_book = {"12","123","1235","567","88"};
        Boolean answer = false;

        Boolean result = test.solution(phone_book);

        assertThat(result).isEqualTo(answer);
    }
}
