package lesson10;

import java.util.ArrayList;
import java.util.List;

/**
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
 *
 * 피크는 이웃보다 큰 어레이 요소이다. 보다 정확하게는 0 < P < N - 1 및 A[P - 1] < A[P] > A[P + 1]이 되는 인덱스 P이다.
 *
 * 예를 들어 다음 배열 A:
 *
 *     A[0] = 1
 *     A[1] = 5
 *     A[2] = 3
 *     A[3] = 4
 *     A[4] = 3
 *     A[5] = 4
 *     A[6] = 1
 *     A[7] = 2
 *     A[8] = 3
 *     A[9] = 4
 *     A[10] = 6
 *     A[11] = 2
 * 요소 1, 3, 5 및 10의 정확히 4개의 피크가 있습니다.
 *
 * 아래 그림과 같이 상대 높이가 배열 A로 표시되는 산 범위로 여행을 가고 있습니다. 얼마나 많은 깃발을 가지고 갈 것인지 선택해야 합니다.
 * 목표는 특정 규칙에 따라 봉우리에 최대 플래그 수를 설정하는 것입니다.
 *
 *
 *
 * 플래그는 피크에만 설정할 수 있습니다. 또한 K 플래그를 사용하는 경우 두 플래그 사이의 거리는 K보다 크거나 같아야 합니다.
 * 인덱스 P와 Q 사이의 거리는 절대값 |P − Q|입니다.
 *
 * 예를 들어, 위의 배열 A로 표시된 산맥이 주어지고 N = 12인 경우 다음을 수행합니다.
 *
 * 두 개의 플래그, 피크 1과 5에 설정할 수 있습니다.
 * 세 개의 플래그, 피크 1, 5 및 10에 설정할 수 있습니다.
 * 네 개의 플래그, 피크 1, 5 및 10에서 세 개의 플래그만 설정할 수 있습니다.
 * 따라서 이 경우 최대 3개의 플래그를 설정할 수 있습니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N 정수의 비어 있지 않은 배열 A가 주어지면 배열의 피크에 설정할 수 있는 최대 플래그 수를 반환합니다.
 *
 * 예를 들어 다음 배열 A:
 *
 *     A[0] = 1
 *     A[1] = 5
 *     A[2] = 3
 *     A[3] = 4
 *     A[4] = 3
 *     A[5] = 4
 *     A[6] = 1
 *     A[7] = 2
 *     A[8] = 3
 *     A[9] = 4
 *     A[10] = 6
 *     A[11] = 2
 * 함수는 위에서 설명한 대로 3을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 400,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 0 .. 1,000,000,000 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingDQKWSS-EPW/    => 100%
 */
public class Flags {
    public int solution(int[] A) {
        // write your code in Java SE 8
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {

            if (A[i] > A[i -1] && A[i] > A[i + 1]) {
                peaks.add(i);   //Peak의 index위치를 저장
            }
        }

        //꽂을 수 있는 최대 플래그 수(최대 가능한 깃발 수는 맨 뒤에있는 peak과 맨 앞에 있는 peak의 거리차의 제곱근 + 1을 정수로 표현한 값이다.)
        int maxFlag = (int) Math.floor(Math.sqrt(peaks.get(peaks.size() - 1) - peaks.get(0))) + 1;
        for (int count = maxFlag; count > 0; count--) {

            int curCount = 0;
            int prevPeak = peaks.get(0);
            for (int j = 1; j < peaks.size(); j++) {

                if (peaks.get(j) - prevPeak >= count) {
                    curCount++;
                    prevPeak = peaks.get(j);
                }
            }

            if (curCount + 1 >= count) {
                return count;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Flags test = new Flags();
//        System.out.println(test.solution(new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        System.out.println(test.solution(new int[] {0, 3, 1, 2, 1, 4, 5,3}));
    }

}
