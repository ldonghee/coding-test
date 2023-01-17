package test.programmers.binarySearch;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

/**
 * 입국심사
 * https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */
public class BinarySearch01 {
    class Solution {
        public long solution(int n, int[] times) {
            long answer = 0;

			Map<Integer, Integer> timeMap = new HashMap<>();
			for (int t : times) {
				timeMap.put(t, 0);
			}

			int timer = 0;
			while(n > 0) {
				for (Integer time : timeMap.keySet()) {
					int t = timeMap.get(time);
					if (t * time <= timer) {
						t++;
						timeMap.put(time, t);
					}


				}

				timer++;
			}

            return answer;
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int n = 6;
        int[] times = {7,10};

        long expect = 3;
        long actual = solution.solution(n, times);
        assertThat(actual).isEqualTo(expect);
    }
}
