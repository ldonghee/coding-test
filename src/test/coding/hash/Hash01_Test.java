package test.coding.hash;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.hash.Hash01;
import dhlee.coding.hash.Hash01_Best;

@DisplayName("Hash")
public class Hash01_Test {
    final Hash01 test = new Hash01();
    final Hash01_Best bestTest = new Hash01_Best();

    @Test
    void test_01() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        String answer = "leo";

        String result = test.solution(participant, completion);
        String result2 = bestTest.solution(participant, completion);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    void test_02() {
        String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion = {"josipa", "filipa", "marina", "nikola"};
        String answer = "vinko";

        String result = test.solution(participant, completion);
        String result2 = bestTest.solution(participant, completion);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }

    @Test
    void test_03() {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        String answer = "mislav";

        String result = test.solution(participant, completion);
        String result2 = bestTest.solution(participant, completion);

        assertThat(result).isEqualTo(answer);
        assertThat(result2).isEqualTo(answer);
    }
}
