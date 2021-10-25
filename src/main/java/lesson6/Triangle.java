package lesson6;

import java.util.Arrays;

/**
 * N개의 정수로 구성된 배열 A가 제공됩니다. 삼중항(P, Q, R)은 0 ≤ P < Q < R < N이고 다음과 같은 경우 삼각형입니다 .
 *
 * A[P] + A[Q] > A[R],
 * A[Q] + A[R] > A[P],
 * A[R] + A[P] > A[Q].
 * 예를 들어, 다음과 같은 배열 A를 고려하십시오.
 *
 *   A[0] = 10 A[1] = 2 A[2] = 5
 *   A[3] = 1 A[4] = 8 A[5] = 20
 * 삼중항(0, 2, 4)은 삼각형입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어지면 이 배열에 대한 삼각형 삼중항이 있으면 1을 반환하고 그렇지 않으면 0을 반환합니다.
 *
 * 예를 들어, 주어진 배열 A는 다음과 같습니다.
 *
 *   A[0] = 10 A[1] = 2 A[2] = 5
 *   A[3] = 1 A[4] = 8 A[5] = 20
 * 함수는 위에서 설명한 대로 1을 반환해야 합니다. 주어진 배열 A는 다음과 같습니다.
 *
 *   A[0] = 10 A[1] = 50 A[2] = 5
 *   A[3] = 1
 * 함수는 0을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ −2,147,483,648 .. 2,147,483,647 ] 범위의 정수 입니다.
 */

/**
 * 삼각형의 세 변 a, b, c(a가 가장 긴 변)에서 b + c > a여야 삼각형을 이룰 수 있음
 * => 다른 두 변의 합(b + C)이 가장 긴 변의 길이(a)보다 큰지만 확인하면 됨!
 * (a가 가장 긴 변이기 때문에 a + b > c, a + c > b는 당연히 만족할 수 밖에 없음)
 *
 * 이 문제에는 약간의 함정(?)이 숨어있었다.
 * 삼각형을 만들 수 있는 세 요소가 있는지 확인하는 건데 배열 A의 각 요소는 [-2,147,483,648..2,147,483,647]
 * 범위의 정수이기 때문에 음수도 포함된 상태였다.
 * 당연하게도 삼각형을 만들 때 음수가 있으면 말이 안되기 때문에 비교 연산을 할 때,
 * 음수에 대해서는 비교하지 않도록 if문을 걸어주니 성능 문제도 해결됐다.
 *
 * 그리고 나는 정렬한 배열 arr에서 연이어지지 않은 세 항목이 삼각형이 되는 경우도 있다고 생각을 해서 이중 for문을 사용했는데(CASE 2),
 * 생각해보니 굳이 그럴 필요 없이 for문 하나만 써서 연이어진 세 항목에 대해서만 비교(CASE 3)해주면 될 것 같다.
 * 연이어지지 않은 세 항목도 삼각형이 될 수 있기는 한데, 그 경우에도 제일 긴 변을 기준으로 앞의
 * 두 개 항목과 비교해도 삼각형이 될 수 있는 건 동일하기 때문이다.
 */

/**
 * https://app.codility.com/demo/results/training75GEQ6-S8H/    =>  100%
 */
public class Triangle {

    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        if (A.length < 3) {
            return 0;
        }

        for (int i = 2; i < A.length; i++) {
            if ((long)A[i-2] + (long)A[i-1] > (long)A[i]) {
                return 1;
            }
        }

        return 0;

    }
}
