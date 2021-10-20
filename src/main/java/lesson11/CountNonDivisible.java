package lesson11;

import java.util.HashMap;
import java.util.Map;

/**
 * N개의 정수로 구성된 배열 A가 주어집니다.
 *
 * 0 ≤ i < N인 각 숫자 A[i]에 대해 A[i]의 제수가 아닌 배열 요소의 수를 계산하려고 합니다. 우리는 이러한 요소가 비약수라고 말합니다.
 *
 * 예를 들어, 다음과 같은 정수 N = 5와 배열 A를 고려하십시오.
 *
 *     A[0] = 3
 *     A[1] = 1
 *     A[2] = 2
 *     A[3] = 3
 *     A[4] = 6
 * 다음 요소의 경우:
 *
 * A[0] = 3, 비약수: 2, 6,
 * A[1] = 1, 비약수: 3, 2, 3, 6,
 * A[2] = 2, 비약수: 3, 3, 6,
 * A[3] = 3, 비약수: 2, 6,
 * A[4] = 6, 비약수가 없습니다.
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int[] 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어지면 비약수의 양을 나타내는 정수 시퀀스를 반환합니다.
 *
 * 결과 배열은 정수 배열로 반환되어야 합니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 *     A[0] = 3
 *     A[1] = 1
 *     A[2] = 2
 *     A[3] = 3
 *     A[4] = 6
 * 함수는 위에서 설명한 대로 [2, 4, 3, 2, 0]을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 50,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 1 .. 2 * N ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingTWSHPS-KEX/    => 100%
 */
public class CountNonDivisible {
    public int[] solution(int[] A) {
        int[] result = new int[A.length];

        //A배열 안에 있는 숫자의 갯수를 저장한 Map
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int count = countMap.getOrDefault(A[i], 0);
            countMap.put(A[i], ++count);
        }

        for (int i = 0; i < A.length; i++) {
            //약수 구하기
            double sqrt = Math.sqrt(A[i]);
            int divisors = 0;
            for (int j = 1; j <= sqrt; j++) {
                if (A[i] % j == 0) {
                    //약수인 경우 countMap에서 갯수를 가져온다.
                    divisors += countMap.getOrDefault(j, 0);

                    //다른 사이즈의 약수의 갯수도 가져온다.
                    //4의 경우 2 * 2 일수도 있으므로 같은지 체크
                    if (A[i] / j != j) {
                        divisors += countMap.getOrDefault(A[i] / j, 0);
                    }
                }
            }
            result[i] = A.length - divisors;
        }
        return result;
    }

    public static void main(String[] args) {
        CountNonDivisible test = new CountNonDivisible();
        System.out.println(test.solution(new int[] {3, 1, 2, 3, 6}));
    }

}
