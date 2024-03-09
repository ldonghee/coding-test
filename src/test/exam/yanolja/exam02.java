package test.exam.yanolja;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

public class exam02 {

	public List<Integer> minTime(List<Integer> start, List<Integer> end, List<Integer> q_start, List<Integer> q_end, int K) {
		// Write your code here
		List<Integer> result = new ArrayList<>();
		// 모든 입력 리스트에서 최대값을 찾아 배열 크기 결정
		int maxTime = Collections.max(start);
		maxTime = Math.max(maxTime, Collections.max(end));
		maxTime = Math.max(maxTime, Collections.max(q_start));
		maxTime = Math.max(maxTime, Collections.max(q_end));

		// 배열 크기를 최대 시간 + 2로 설정하여 인덱스 초과 문제 방지
		int[] timeline = new int[maxTime + 2];

		// 시간별 학생 수의 변화 기록
		for (int i = 0; i < start.size(); i++) {
			timeline[start.get(i)]++;
			timeline[end.get(i) + 1]--;
		}

		// 누적 합계 계산
		for (int i = 1; i < timeline.length; i++) {
			timeline[i] += timeline[i - 1];
		}

		// K명 이상의 학생이 있었던 시간의 누적 개수 계산
		int[] accumulate = new int[timeline.length];
		accumulate[0] = timeline[0] >= K ? 1 : 0;
		for (int i = 1; i < timeline.length; i++) {
			accumulate[i] = accumulate[i - 1] + (timeline[i] >= K ? 1 : 0);
		}

		// 각 쿼리 처리
		for (int i = 0; i < q_start.size(); i++) {
			int startIdx = q_start.get(i);
			int endIdx = q_end.get(i);
			int time = accumulate[endIdx] - (startIdx > 0 ? accumulate[startIdx - 1] : 0);
			result.add(time);
		}

		return result;
	}


	@Test
	public void test1() {
		List<Integer> start = Arrays.asList(1, 2, 4);
		List<Integer> end = Arrays.asList(3, 4, 5);
		List<Integer> q_start = Arrays.asList(2);
		List<Integer> q_end = Arrays.asList(6);
		int K = 2;

		List<Integer> expect = Arrays.asList(3);
		List<Integer> actual = minTime(start, end, q_start, q_end, K);

		for (int i = 0; i < expect.size(); i++) {
			assertThat(expect.get(i).equals(actual.get(i))).isTrue();
		}
	}

	@Test
	public void test2() {
		List<Integer> start = Arrays.asList(1, 2, 4);
		List<Integer> end = Arrays.asList(4, 5, 5);
		List<Integer> q_start = Arrays.asList(2, 5);
		List<Integer> q_end = Arrays.asList(6, 6);
		int K = 3;

		List<Integer> expect = Arrays.asList(1, 0);
		List<Integer> actual = minTime(start, end, q_start, q_end, K);

		for (int i = 0; i < expect.size(); i++) {
			assertThat(expect.get(i).equals(actual.get(i))).isTrue();
		}
	}
}