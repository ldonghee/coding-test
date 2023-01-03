package test.programmers.heap;

import static org.assertj.core.api.Assertions.*;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;

/**
 * 디스크 컨트롤러
 * https://school.programmers.co.kr/learn/courses/30/lessons/42627
 */
public class Heap02 {
    class Solution {
        public int solution(int[][] jobs) {
            List<Job> jobList = new LinkedList<>();
            for (int[] job : jobs) {
                jobList.add(new Job(job[0], job[1]));
            }

            int timer = 0;
            int wTimer = 0;
            while(jobList.size() > 0) {
                int d = timer;
                List<Job> canStartJob = jobList.stream().filter(job -> job.isStart(d)).collect(Collectors.toList());

                if (canStartJob.size() > 0) {
                    Job job = canStartJob.stream().min(Comparator.comparing(x -> x.workingTime))
                        .get();

                    timer += job.workingTime;
                    wTimer += (timer - job.requestTime);
                    jobList.remove(job);
                } else {
                    timer++;
                }
            }

            return wTimer / jobs.length;
        }

        public class Job {
            int requestTime;
            int workingTime;

            public Job(int requestTime, int workingTime) {
                this.requestTime = requestTime;
                this.workingTime = workingTime;
            }

            public boolean isStart(int time) {
                return time >= this.requestTime;
            }
        }


        /*
        class Job {
            private int requestTime;
            private int workingTime;

            public Job(int requestTime, int workingTime) {
                this.requestTime = requestTime;
                this.workingTime = workingTime;
            }
        }

        public int solution(int[][] jobs) {
            int answer = 0;
            LinkedList<Job> waiting = new LinkedList<>();
            PriorityQueue<Job> workingQueue = new PriorityQueue<>((o1, o2) -> o1.workingTime - o2.workingTime);

            for (int[] job : jobs) {
                waiting.add(new Job(job[0], job[1]));
            }

            Collections.sort(waiting, (o1, o2) -> o1.requestTime - o2.requestTime);

            int count = 0;
            int time = waiting.peek().requestTime;

            while(count < jobs.length) {
                while (!waiting.isEmpty() && waiting.peek().requestTime <= time) {
                    workingQueue.add(waiting.poll());
                }

                if (!workingQueue.isEmpty()) {
                    Job job = workingQueue.poll();
                    time += job.workingTime;
                    answer += time - job.requestTime;
                    count++;
                } else {
                    time++;
                }
            }

            return answer / count;
        }
        */
    }

    private final Solution solution = new Solution();

    @Test
    public void test01() {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        int expect = 9;
        int actual = solution.solution(jobs);
        assertThat(actual).isEqualTo(expect);
    }
}
