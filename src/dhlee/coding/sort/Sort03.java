package dhlee.coding.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 정렬 - H-Index
 *
 * 문제 설명
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
 * 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
 * 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 *
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고
 * 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index 입니다.
 *
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때,
 * 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한사항
 * 		과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
 * 		논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 *
 * 입출력 예
 * 	citations			return
 * 	[3, 0, 6, 1, 5]		3
 *
 * 입출력 예 설명
 * 이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다.
 * 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
 *
 * K인덱스 구하는 법 - 위키백과
 *      공식적으로 f 가 각 출판물에 대한 인용 횟수에 해당하는 함수이면 다음과 같이 h- 인덱스를 계산합니다 .
 *      먼저 f 의 값을 가장 큰 값에서 가장 낮은 값으로 정렬합니다 .
 *      그런 다음 f 가 위치 보다 크거나 같은 마지막 위치를 찾습니다 ( h를 이 위치라고 함).
 *      예를 들어, 각각 10, 8, 5, 4, 3회 인용된 5개의 출판물 A, B, C, D, E를 가진 연구원이 있는 경우
 *      h-4번째 출판물은 4회 인용되고 5번째 출판물은 3회만 인용되기 때문에 index는 4입니다
 */
public class Sort03 {
    public int solution(int[] citations) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for (int citation : citations) {
            list.add(citation);
        }
        Collections.sort(list, Collections.reverseOrder());

        for (int i=0; i<list.size(); i++) {
            if (i >= list.get(i)) {
                answer = i;
                break;
            }
            if (i == list.size() - 1) {
                answer = i + 1;
            }
        }

        return answer;
    }
}
