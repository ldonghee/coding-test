package dhlee.coding.exam;

import java.util.HashSet;
import java.util.Set;

// KKO_MB
public class Exam02 {
    public int solution(int[] T, int[] A) {
        // write your code in Java SE 8
        Set<Integer> skill = new HashSet<>();

        for (int target : A) {
            dfs(T, target, skill);
        }
        return skill.size();
    }

    void dfs(int[] T, int target, Set<Integer> skill) {
        skill.add(target);

        int need = T[target];
        if (!skill.contains(need)) {
            dfs(T, need, skill);
        }
    }
}
