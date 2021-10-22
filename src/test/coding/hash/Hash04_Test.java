package test.coding.hash;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import dhlee.coding.hash.Hash04;

@DisplayName("Hash")
public class Hash04_Test {
    final Hash04 test = new Hash04();

    @Test
    void test_01() {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = {4, 1, 3, 0};

        int[] result = test.solution(genres, plays);

        assertThat(result).isEqualTo(answer);
    }
}
