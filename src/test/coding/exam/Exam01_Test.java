package test.coding.exam;

import dhlee.coding.exam.Exam01;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exam01_Test {
    final private Exam01 test = new Exam01();

    @Test
    void test_01() {
        String S = "John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        String answer = "John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane Watson-Parker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>";

        String result = test.solution(S, C);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    void test_02() {
        String S = "John Doe, Peter Parker, Mary Jane WatsonP-arker, James Doe, John Elvis Doe, Jane Doe, Penny Parker";
        String C = "Example";
        String answer = "John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane WatsonP-arker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>";

        String result = test.solution(S, C);

        assertThat(result).isEqualTo(answer);
    }
}
