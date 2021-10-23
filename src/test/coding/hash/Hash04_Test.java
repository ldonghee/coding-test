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

    @Test
    @DisplayName("장르 내 재생 횟수가 동일한 경우, 고유 번호가 낮은 순으로 출 테스트")
    void test_02() {
        String[] genres = {"classic", "pop", "pop", "classic", "classic"};
        int[] plays = {200, 200, 300, 100, 100};
        int[] answer = {2, 1, 0, 3};

        int[] result = test.solution(genres, plays);

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("장르가 하나인 경우, 하나의 결과만 출력 테스트")
    void test_03() {
        String[] genres = {"classic", "pop", "pop", "classic", "classic", "pop", "hiphop"};
        int[] plays = {100, 200, 300, 400, 500, 600, 700};
        int[] answer = {5, 2, 4, 3, 6};

        int[] result = test.solution(genres, plays);

        assertThat(result).isEqualTo(answer);
    }


    @Test
    @DisplayName("장르가 하나인 경우, 하나의 결과만 출력 테스트")
    void test_04() {
        String[] genres = {"classic", "pop", "classic", "pop", "classic", "pop"};
        int[] plays = {300, 200, 100, 100, 100, 100};
        int[] answer = {0, 2, 1, 3};

        int[] result = test.solution(genres, plays);

        assertThat(result).isEqualTo(answer);
    }
}
