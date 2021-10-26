package dhlee.coding.exam;

// KKO_MB
public class Exam03 {
    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length <= 2) {
            return A.length;
        }

        int answer = 2;
        int temp = 2;
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i-2]) {
                temp = temp + 1;
            } else {
                temp = 2;
            }
            answer = temp > answer ? temp : answer;
        }
        return answer;
    }
}
