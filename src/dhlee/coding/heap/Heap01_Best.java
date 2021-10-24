package dhlee.coding.heap;

import java.util.PriorityQueue;

public class Heap01_Best {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pqScov = new PriorityQueue<>();
        for (int s: scoville) {
            pqScov.add(s);
        }

        int cnt = 0;
        while (pqScov.size() > 1 && pqScov.peek() < K) {
            pqScov.add(pqScov.remove() + pqScov.remove() * 2);
            cnt++;
        }

        return pqScov.peek() >= K ? cnt : -1;
    }
}
