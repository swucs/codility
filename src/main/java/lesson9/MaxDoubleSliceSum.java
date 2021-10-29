package lesson9;

/**
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
 *
 * 0 ≤ X < Y < Z < N과 같은 삼중항(X, Y, Z)을 이중 슬라이스 라고 합니다 .
 *
 * 합 + A [Y + 1] + A [- 이중 슬라이스 (X, Y, Z)의이 A [X + 1] + A [X + 2] + ... + A [1 Y]의 합계이며 Y + 2] + ... + A[Z − 1].
 *
 * 예를 들어, 다음과 같은 배열 A:
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * 다음 예제 이중 슬라이스가 포함되어 있습니다.
 *
 * 이중 슬라이스(0, 3, 6), 합계는 2 + 6 + 4 + 5 = 17,
 * 이중 슬라이스(0, 3, 7), 합은 2 + 6 + 4 + 5 − 1 = 16,
 * 이중 슬라이스(3, 4, 5), 합계는 0입니다.
 * 목표는 이중 슬라이스의 최대 합을 찾는 것입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 이중 슬라이스의 최대 합을 반환합니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 *     A[0] = 3
 *     A[1] = 2
 *     A[2] = 6
 *     A[3] = -1
 *     A[4] = 4
 *     A[5] = 5
 *     A[6] = -1
 *     A[7] = 2
 * 배열 A의 이중 슬라이스에는 합이 17보다 크므로 함수는 17을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 3 .. 100,000 ] 범위의 정수입니다 .
 * 배열 A의 각 요소는 [ −10,000 .. 10,000 ] 범위의 정수 입니다.
 */

/**
 * https://pkiop.tistory.com/218 => 참고
 * https://app.codility.com/demo/results/trainingCB7C3M-PMG/    => 100%
 * Math.max(0, value)처럼 0과 비교해 주는 이유는, X,Y가 인접한 경우와 Y,Z가 인접한 경우 값이 0이므로 값으로 넣을 수 있는 가장 작은 값이다.
 */
public class MaxDoubleSliceSum {
    public int solution(int[] A) {
        // write your code in Java SE 8


        int[] leftSumArray = new int[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            leftSumArray[i] = Math.max(leftSumArray[i - 1] + A[i], 0);
        }

        int[] rightSumArray = new int[A.length];
        for (int i = A.length - 2; i > 0; i--) {
            rightSumArray[i] = Math.max(rightSumArray[i + 1] + A[i], 0);
        }

        int max = 0;
        //(0, 1, 5)처럼 앞에 x, y가 인접할 수도 있으므로. i = 0부터 시작한다.
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(leftSumArray[i] + rightSumArray[i + 2], max);
        }

        return max;
    }
}
