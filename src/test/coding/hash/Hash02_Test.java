package test.coding.hash;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.hash.Hash02;
import dhlee.coding.hash.Hash02_Best;

@DisplayName("Hash")
public class Hash02_Test {
    final Hash02 test = new Hash02();
    final Hash02_Best bestTest = new Hash02_Best();

    @Test
    void test_01() {
        String[] phone_book = {"119", "97674223", "1195524421"};
        Boolean answer = false;

        Boolean result = test.solution(phone_book);
        Boolean result2 = bestTest.solution(phone_book);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    void test_02() {
        String[] phone_book = {"123","456","789"};
        Boolean answer = true;

        Boolean result = test.solution(phone_book);
        Boolean result2 = bestTest.solution(phone_book);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    void test_03() {
        String[] phone_book = {"12","123","1235","567","88"};
        Boolean answer = false;

        Boolean result = test.solution(phone_book);
        Boolean result2 = bestTest.solution(phone_book);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    @DisplayName("전화번호 중간부터 동일한 경우")
    void test_04() {
        String[] phone_book = {"312","453123","1235", "1312"};
        Boolean answer = true;

        Boolean result = test.solution(phone_book);
        Boolean result2 = bestTest.solution(phone_book);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    @DisplayName("전화번호 시작은 동일, 중간부터 동일한 경우")
    void test_05() {
        String[] phone_book = {"312","3012","3102", "1312"};
        Boolean answer = true;

        Boolean result = test.solution(phone_book);
        Boolean result2 = bestTest.solution(phone_book);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }
}
