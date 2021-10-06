package lesson6;

import java.util.Arrays;

/**
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다. 삼중항(P, Q, R) 의 곱은 A[P] * A[Q] * A[R]과 같습니다(0 ≤ P < Q < R < N).
 *
 * 예를 들어, 다음과 같은 배열 A:
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * 다음 예제 삼중항이 포함되어 있습니다.
 *
 * (0, 1, 2), 곱은 −3 * 1 * 2 = −6
 * (1, 2, 4), 제품은 1 * 2 * 5 = 10
 * (2, 4, 5), 제품은 2 * 5 * 6 = 60
 * 당신의 목표는 모든 삼중항의 최대 곱을 찾는 것입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * 비어 있지 않은 배열 A가 주어지면 모든 삼중항의 최대 곱 값을 반환합니다.
 *
 * 예를 들어, 주어진 배열 A는 다음과 같습니다.
 *
 *   A[0] = -3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = -2
 *   A[4] = 5
 *   A[5] = 6
 * 함수는 3중항(2, 4, 5)의 곱이 최대이므로 60을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 3 .. 100,000 ] 범위의 정수입니다 .
 * 배열 A의 각 요소는 [ −1,000 .. 1,000 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingT9N48P-WZN/ => 100%
 */
public class MaxProductOfThree {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        int beginIdx = A.length - 3;

        int max = A[beginIdx] * A[beginIdx + 1] * A[beginIdx + 2];

        if (A[0] < 0 && A[1] < 0) {
            if (max < A[0] * A[1] * A[beginIdx + 2]) {
                return A[0] * A[1] * A[beginIdx + 2];
            }
        }

        return max;
    }
}
