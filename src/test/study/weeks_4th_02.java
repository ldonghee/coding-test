package test.study;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * [1차] 비밀지도
 * https://programmers.co.kr/learn/courses/30/lessons/17681
 */
public class weeks_4th_02 {
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            List<String> secretMap = new ArrayList<>();

            for (int i=0; i<n; i++) {
                secretMap.add(convertBinaryString(n, arr1[i], arr2[i]));
            }

            return decryption(secretMap);
        }

        public String[] decryption(List<String> secretMap) {
            String[] result = new String[secretMap.size()];

            for (int i=0; i<secretMap.size(); i++) {
                result[i] = secretMap.get(i).replace("1", "#").replace("0", " ");
            }

            return result;
        }

        public String convertBinaryString(int size, int a, int b) {
            String formatStr = "%0" + size + "d";
            String aStr = String.format(formatStr, Long.parseLong(Integer.toBinaryString(a)));
            String bStr = String.format(formatStr, Long.parseLong(Integer.toBinaryString(b)));

            StringBuilder convertStr = new StringBuilder();
            for (int i=0; i<size; i++) {
                char c = aStr.charAt(i);
                if (c == '0') {
                    c = bStr.charAt(i);
                }
                convertStr.append(c);
            }
            return convertStr.toString();
        }
    }

    private Solution solution = new Solution();

    @Test
    public void test1() {
        // given
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] actual = {"#####","# # #", "### #", "#  ##", "#####"};

        // when
        String[] expect = this.solution.solution(n, arr1, arr2);

        // then
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test2() {
        // given
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        String[] actual = {"######", "###  #", "##  ##", " #### ", " #####", "### # "};

        // when
        String[] expect = this.solution.solution(n, arr1, arr2);

        // then
        assertThat(actual).isEqualTo(expect);
    }
}
