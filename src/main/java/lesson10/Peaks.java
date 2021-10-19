package lesson10;

import java.util.HashMap;
import java.util.Map;

/**
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
 *
 * 피크는 이웃보다 큰 어레이 요소이다. 보다 정확하게는 0 < P < N - 1, A[P - 1] < A[P] 및 A[P] > A[P + 1]이 되는 인덱스 P이다.
 *
 * 예를 들어 다음 배열 A:
 *
 *     A[0] = 1
 *     A[1] = 2
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
 * 정확히 3개의 피크가 있습니다: 3, 5, 10.
 *
 * 우리는 이 배열을 같은 수의 요소를 포함하는 블록으로 나누고 싶습니다. 보다 정확하게는 다음 블록을 생성하는 숫자 K를 선택하려고 합니다.
 *
 * A[0], A[1], ..., A[K-1],
 * A[K], A[K + 1], ..., A[2K − 1],
 * ...
 * A[N − K], A[N − K + 1], ..., A[N − 1].
 * 또한 모든 블록에는 최소 하나의 피크가 포함되어야 합니다. 블록의 극단 요소(예: A[K − 1] 또는 A[K])도 피크가 될 수 있지만 두 이웃(인접 블록에 하나 포함)이 있는 경우에만 가능합니다.
 *
 * 목표는 배열 A를 나눌 수 있는 최대 블록 수를 찾는 것입니다.
 *
 * 배열 A는 다음과 같이 블록으로 나눌 수 있습니다.
 *
 * 한 블록(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2). 이 블록에는 세 개의 피크가 있습니다.
 * 두 블록 (1, 2, 3, 4, 3, 4) 및 (1, 2, 3, 4, 6, 2). 모든 블록에는 피크가 있습니다.
 * 세 블록 (1, 2, 3, 4), (3, 4, 1, 2), (3, 4, 6, 2). 모든 블록에는 피크가 있습니다.
 * 특히 첫 번째 블록(1, 2, 3, 4)은 A[3]에서 피크를 가집니다. A[4]가 인접 블록.
 * 그러나 배열 A는 (1, 2, 3), (4, 3, 4), (1, 2, 3) 및 (4, 6, 2)의 네 블록으로 나눌 수 없습니다.
 * 3) 블록은 피크를 포함하지 않습니다. 특히 (4, 3, 4) 블록에는 A[3] 및 A[5]라는 두 개의 피크가 포함되어 있습니다.
 *
 * 배열 A가 나눌 수 있는 최대 블록 수는 3개입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 A를 나눌 수 있는 최대 블록 수를 반환합니다.
 *
 * A를 몇 개의 블록으로 나눌 수 없는 경우 함수는 0을 반환해야 합니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 *     A[0] = 1
 *     A[1] = 2
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
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 0 .. 1,000,000,000 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingDGP7JH-M33/    => 72% (정합성 100%, 성능 40%)
 * https://app.codility.com/demo/results/training5MJ5HS-W2V/    => 81% (정합성 100%, 성능 60%)
 */
public class Peaks {

    public int solution(int[] A) {

        //배열 사이즈가 3보다 작으면 Peak를 만들 수 없으므로 종료
        if (A.length < 3) {
            return 0;
        }


        //Peak를 구함
        Map<Integer, Integer> peaks = new HashMap();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.put(i, i);
            }
        }

        for (int i = peaks.size(); i > 0 ; i--) {

            //동일한 구간이 나오지 않는 경우 SKIP
            if (A.length % i != 0) {
                continue;
            }

            //블럭의 크기
            int blockSize = A.length / i;

            //모든 블럭에 Peak가 존재하는지 여부
            boolean isBlockPeak = true;
            for (int j = i; j <= i ; j++) {
                if (!existsPeak((j - 1) * blockSize, j * blockSize - 1, peaks)) {
                    isBlockPeak = false;
                    break;
                }
            }
            if (isBlockPeak) {
                return i;
            }

        }

        return 0;
    }

    /**
     * 해당 구간에 peak가 있는지 검사
     * @param from
     * @param to
     * @param peaks
     * @return
     */
    private boolean existsPeak(int from, int to, Map<Integer, Integer> peaks) {
        for (int i = from; i <= to; i++) {
            if (peaks.containsKey(i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Peaks test = new Peaks();
        System.out.println(test.solution(new int[] {1, 2, 3, 2, 5, 6, 5}));
        System.out.println(test.solution(new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));
        System.out.println(test.solution(new int[] {1, 2, 3, 4, 3}));
    }
}
