package test.programmers.heap;

import static org.assertj.core.api.Assertions.*;

import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

/**
 * 이중우선순위큐
 * https://school.programmers.co.kr/learn/courses/30/lessons/42628
 */
public class Heap03 {
    class Solution {
        public int[] solution(String[] operations) {
			PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Integer> minQueue = new PriorityQueue<>();

            for (String operation : operations) {
                String[] oper = operation.split(" ");

                switch(oper[0]) {
                    case "I":
						maxQueue.add(Integer.parseInt(oper[1]));
						minQueue.add(Integer.parseInt(oper[1]));
                        break;
                    case "D":
                        if (oper[1].equals("1")) {
							Integer peek = maxQueue.peek();
							maxQueue.remove(peek);
							minQueue.remove(peek);
                        } else {
							Integer peek = minQueue.peek();
							maxQueue.remove(peek);
							minQueue.remove(peek);
                        }
                        break;
                }
            }

            if (maxQueue.isEmpty()) {
            	return new int[] {0, 0};
			}

            return new int[] {maxQueue.peek(), minQueue.peek()};
        }
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        int[] expect = {0, 0};
        int[] actual = solution.solution(operations);
        assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void test02() {
        String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        int[] expect = {333, -45};
        int[] actual = solution.solution(operations);
        assertThat(actual).isEqualTo(expect);
    }
}
