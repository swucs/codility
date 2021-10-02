package lesson4;

import java.util.Arrays;

/**
 * 처음에는 0으로 설정된 N 개의 카운터가 제공되며 두 가지 작업이 가능합니다.
 *
 * 증가(X) - 카운터 X가 1만큼 증가하고,
 * 최대 카운터 - 모든 카운터는 모든 카운터의 최대값으로 설정됩니다.
 * M 정수의 비어 있지 않은 배열 A가 제공됩니다. 이 배열은 연속 작업을 나타냅니다.
 *
 * A[K] = X, 1 ≤ X ≤ N인 경우 연산 K는 증가(X),
 * A[K] = N + 1이면 작업 K는 최대 카운터입니다.
 * 예를 들어, 주어진 정수 N = 5와 배열 A는 다음과 같습니다.
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * 각 연속 작업 후 카운터 값은 다음과 같습니다.
 *
 *     (0, 0, 1, 0, 0)
 *     (0, 0, 1, 1, 0)
 *     (0, 0, 1, 2, 0)
 *     (2, 2, 2, 2, 2)
 *     (3, 2, 2, 2, 2)
 *     (3, 2, 2, 3, 2)
 *     (3, 2, 2, 4, 2)
 * 목표는 모든 작업 후에 모든 카운터의 값을 계산하는 것입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int[] 솔루션(int N, int[] A); }
 *
 * 정수 N과 M개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 카운터 값을 나타내는 정수 시퀀스를 반환합니다.
 *
 * 결과 배열은 정수 배열로 반환되어야 합니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 4
 *     A[3] = 6
 *     A[4] = 1
 *     A[5] = 4
 *     A[6] = 4
 * 함수는 위에서 설명한 대로 [3, 2, 2, 4, 2]를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N 및 M은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 1 .. N + 1 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/training4P4JNE-QR3/        => 44% 정합성을 맞으나 퍼포먼스 안됨.  (Max가져오는 부분을 stream().max()를 사용했는데 여기서 성능이 안좋음)
 * https://app.codility.com/demo/results/training22WPGQ-9AG/        => 77%  max값으로 채울때 for loop을 개선해야 할듯.
 */
public class MaxCounters {

    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
        System.out.println(maxCounters.solution(5, new int[] {3, 4, 4, 6, 1, 4, 4}));

    }

    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] <= N) {
                result[A[i] - 1]++;

                if (max < result[A[i] - 1]) {
                    max = result[A[i] - 1];
                }

            } else if (A[i] == N + 1) {

                for (int j = 0; j < result.length; j++) {
                    result[j] = max;
                }
            }
        }

        return result;
    }
}
