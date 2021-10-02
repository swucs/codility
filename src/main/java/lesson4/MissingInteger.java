package lesson4;

import java.util.Arrays;

/**
 * 이것은 데모 작업입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N 정수의 배열 A가 주어지면 A에서 발생하지 않는 가장 작은 양의 정수(0보다 큼)를 반환합니다.
 *
 * 예를 들어, A = [1, 3, 6, 4, 1, 2]가 주어지면 함수는 5를 반환해야 합니다.
 *
 * A = [1, 2, 3]이 주어지면 함수는 4를 반환해야 합니다.
 *
 * A = [−1, −3]이 주어지면 함수는 1을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ −1,000,000 .. 1,000,000 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingN9SUQE-CEK/        => 88% , [1] 일때 2반환이여야 하는데, 1을 반환시켜버림.
 * https://app.codility.com/demo/results/trainingDHN58R-M65/        => 100%
 */
public class MissingInteger {

    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Arrays.sort(A);

        int prevNum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 1) {
                continue;
            }

            if (prevNum != A[i] && prevNum + 1 != A[i]) {
                return prevNum + 1;
            }

            prevNum = A[i];
        }

        return prevNum + 1;

    }
}
