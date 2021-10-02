package lesson4;

import java.util.Arrays;

/**
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
 *
 * 순열 번만 회 1에서 N까지 각각의 요소를 포함하는 서열, 및이다.
 *
 * 예를 들어, 다음과 같은 배열 A:
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * 순열이지만 배열 A는 다음과 같습니다.
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * 값 2가 없기 때문에 순열이 아닙니다.
 *
 * 목표는 배열 A가 순열인지 확인하는 것입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * 배열 A가 주어지면 배열 A가 순열이면 1을 반환하고 그렇지 않으면 0을 반환합니다.
 *
 * 예를 들어, 주어진 배열 A는 다음과 같습니다.
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 *     A[3] = 2
 * 함수는 1을 반환해야 합니다.
 *
 * 주어진 배열 A는 다음과 같습니다.
 *
 *     A[0] = 4
 *     A[1] = 1
 *     A[2] = 3
 * 함수는 0을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 1 .. 1,000,000,000 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingRZF4HY-M68/    => [1]은 순열, [2]은 1부터 시작하지 않으므로 순열이 아님.
 * https://app.codility.com/demo/results/trainingPB4NCT-CG5/    => 100%
 */
//순열은 1부터 시작해야 함.
public class PermCheck {

    public int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);

        int prevNum = 1;
        for (int i = 0; i < A.length; i++) {
            if (i == 0) {
                if (A[i] != 1) {
                    return 0;
                }

                prevNum = A[i];
                continue;
            }

            if (prevNum + 1 != A[i]) {
                return 0;
            }

            prevNum = A[i];
        }

        return 1;

    }

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();

        int[] test = new int[199];

        for (int i = 0; i < 199; i++) {
            test[i] = i + 2;
        }

        System.out.println(permCheck.solution(test));
    }
}
