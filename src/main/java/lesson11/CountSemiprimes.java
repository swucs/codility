package lesson11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 프라임 처음 몇 프라임 정수 2, 3, 5, 7, 11, 13 및 1이다 X. : 정확히 두 개의 별개의 약수를 가진 양의 정수 X이다.
 *
 * semiprime는 이 (반드시 구별하지 않음) 소수의 제품입니다 자연수이다. 처음 몇 개의 반소수는 4, 6, 9, 10, 14, 15, 21, 22, 25, 26입니다.
 *
 * 각각 M개의 정수로 구성된 비어 있지 않은 두 개의 배열 P와 Q가 제공됩니다. 이러한 배열은 지정된 범위 내의 반소수에 대한 쿼리를 나타냅니다.
 *
 * 쿼리 K는 1 ≤ P[K] ≤ Q[K] ≤ N인 범위(P[K], Q[K]) 내에서 반소수의 수를 찾아야 합니다.
 *
 * 예를 들어, 다음과 같은 정수 N = 26과 배열 P, Q를 고려하십시오.
 *
 *     P[0] = 1 Q[0] = 26
 *     P[1] = 4 Q[1] = 10
 *     P[2] = 16 Q[2] = 20
 * 각 범위 내에서 반소수의 수는 다음과 같습니다.
 *
 * (1, 26)은 10이고,
 * (4, 10)은 4이고,
 * (16, 20)은 0입니다.
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int[] 솔루션(int N, int[] P, int[] Q); }
 *
 * 정수 N과 M 정수로 구성된 두 개의 비어 있지 않은 배열 P 및 Q가 주어지면
 * 모든 쿼리에 대한 연속적인 답변을 지정하는 M 요소로 구성된 배열을 반환합니다.
 *
 * 예를 들어, 정수 N = 26과 배열 P, Q가 다음과 같은 경우:
 *
 *     P[0] = 1 Q[0] = 26
 *     P[1] = 4 Q[1] = 10
 *     P[2] = 16 Q[2] = 20
 * 함수는 위에서 설명한 대로 값 [10, 4, 0]을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 50,000 ] 범위 내의 정수입니다 .
 * M은 [ 1 .. 30,000 ] 범위 내의 정수입니다 .
 * 배열 P 및 Q의 각 요소는 [ 1 .. N ] 범위 내의 정수입니다 .
 * P[i] ≤ Q[i].
 */

/**
 * https://app.codility.com/demo/results/trainingKW4DRF-D6D/    ==> 66% (정합성 100%, 성능 40%)
 * https://app.codility.com/demo/results/trainingCQX7CW-DSX/    ==> 100% (accum을 사용해 성능 개선)
 */
public class CountSemiprimes {

    public int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] A = new int[N + 1];
        A[0] = 1;
        A[1] = 1;
        //에라노테스의 체를 이용하여 소수를 구한다.
        for (int i = 2; i <= N; i++) {
            int j = 2;
            while (true) {
                if (i * j > N) {
                    break;
                }
                A[i * j] = 1;
                j++;
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (A[i] == 0) {
                primes.add(i);
            }
        }

        //소수를 이용하여 반소수를 구한다.
        Set<Integer> semiPrimes = new HashSet<>();
        for (int prime1 : primes) {
            for (int prime2 : primes) {
                if (prime1 * prime2 <= N) {
                    semiPrimes.add(prime1 * prime2);
                } else {
                    break;
                }
            }
        }
        // System.out.println("semiPrimes: " + semiPrimes);
        //반소수 합계의 누적 배열
        int[] semiPrimeAcuum = new int[N + 1];
        for (int i = 1; i < semiPrimeAcuum.length; i++) {
            semiPrimeAcuum[i] = semiPrimeAcuum[i - 1];
            if (semiPrimes.contains(i)) {
                semiPrimeAcuum[i]++;
            }
        }

        //accum을 이용해서 반소수의 count를 계산한다.
        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int start = P[i] - 1;
            int end = Q[i];

            result[i] = semiPrimeAcuum[end] - semiPrimeAcuum[start];
            // System.out.println("result[i]: " + result[i]);
        }


        return result;
    }

    public static void main(String[] args) {
        CountSemiprimes test = new CountSemiprimes();
        System.out.println(test.solution(26, new int[] {1, 4, 16}, new int[] {26, 10, 20}));
    }

}
