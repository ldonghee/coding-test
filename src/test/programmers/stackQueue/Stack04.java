package test.programmers.stackQueue;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * 프린터
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Stack04 {

	/*
	public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue_index = new LinkedList<>();

        int i = 0;
        for (int priority : priorities) {
            queue.add(priority);
            queue_index.add(i);
            i++;
        }

        Integer cur = queue.poll();
        Integer curIndex = queue_index.poll();

        boolean flag = true;
        while(flag) {
            Integer finalCur = cur;
            Optional<Integer> optional = queue.stream().filter(item -> item > finalCur).findFirst();
            if (optional.isPresent()) {
                queue.add(cur);
                queue_index.add(curIndex);
            } else {
                answer++;
                if (location == curIndex) {
                    break;
                }
            }
            cur = queue.poll();
            curIndex = queue_index.poll();
        }

        return answer;
    }
	 */

	public class Solution {
		public int solution(int[] priorities, int location) {
			Queue<Document> queue = new LinkedList<>();
			queue.addAll(IntStream.range(0, priorities.length)
								  .mapToObj(index -> new Document(priorities[index], index == location))
								  .collect(Collectors.toList()));

			Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
			priorityQueue.addAll(Arrays.stream(priorities).boxed().collect(Collectors.toList()));

			int index = 1;
			while(true) {
				Document doc = queue.poll();
				if (doc.isPriorityEquals(priorityQueue.peek())) {
					if (doc.mine) {
						break;
					}
					priorityQueue.poll();
					index++;
					continue;
				}
				queue.add(doc);
			}

			return index;
		}

		private class Document {
			private int priority;
			private boolean mine;

			public Document(int priority, boolean mine) {
				this.priority = priority;
				this.mine = mine;
			}

			public boolean isPriorityEquals(Integer value) {
				return this.priority == value.intValue();
			}
		}
	}

	private final Solution solution = new Solution();

	@Test
	public void test01() {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;

		int expect = 1;
		int actual = solution.solution(priorities, location);
		assertThat(actual).isEqualTo(expect);
	}

	@Test
	public void test02() {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;

		int expect = 5;
		int actual = solution.solution(priorities, location);
		assertThat(actual).isEqualTo(expect);
	}
}
