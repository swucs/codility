package lesson12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 프라임 처음 몇 프라임 정수 2, 3, 5, 7, 11, 13 및 1이다 X. : 정확히 두 개의 별개의 약수를 가진 양의 정수 X이다.
 *
 * 소수 D는 D * K = P와 같은 양의 정수 K가 존재하는 경우 양의 정수 P 의 소수 라고 합니다 . 예를 들어 2와 5는 20의 소수입니다.
 *
 * 두 개의 양의 정수 N과 M이 주어집니다. 목표는 정수 N과 M의 소수 제수 집합이 정확히 같은지 확인하는 것입니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 * N = 15 및 M = 75, 소수는 동일합니다. {3, 5};
 * N = 10 및 M = 30, 소수는 동일하지 않습니다. {2, 5}는 ​​{2, 3, 5}와 같지 않습니다.
 * N = 9 및 M = 5, 소수는 동일하지 않습니다. {3}은 {5}와 같지 않습니다.
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A, int[] B); }
 *
 * Z 정수의 비어 있지 않은 두 배열 A와 B가 주어지면 A[K]와 B[K]의 소수가 정확히 같은 위치 K의 수를 반환합니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 *     A[0] = 15 B[0] = 75
 *     A[1] = 10 B[1] = 30
 *     A[2] = 3 B[2] = 5
 * 한 쌍(15, 75)만 동일한 소수 제수 집합을 가지므로 함수는 1을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * Z는 [ 1 .. 6,000 ] 범위 내의 정수입니다 .
 * 배열 A와 B의 각 요소는 [ 1 .. 2,147,483,647 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingDGP7JH-M33/    => 72% (정합성 100%, 성능 : 40%)
 */
public class CommonPrimeDivisors {

    public int solution(int[] A, int[] B) {

        int result = 0;

        for (int i = 0; i < A.length; i++) {
            //소인수분해
            Set<Integer> primesA = getPrimes(A[i]);
            Set<Integer> primesB = getPrimes(B[i]);

//            System.out.println(A[i] + " : " + primesA);
//            System.out.println(B[i] + " : " + primesB);

            if (primesA.equals(primesB)) {
                result++;
            }
        }
        return result;
    }

    /**
     * 소인수분해
     * 2부터 나눠서 1이 될때 까지 계속 나눈다.
     * @param a
     * @return
     */
    private Set<Integer> getPrimes(int a) {
        Set<Integer> primes = new HashSet<>();

        int n = a;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            while(n % i == 0) {
                primes.add(i);
                n = n / i;
            }
        }
        if (n != 1) {
            primes.add(n);
        }
        return primes;
    }

    public static void main(String[] args) {
        CommonPrimeDivisors test = new CommonPrimeDivisors();
        System.out.println(test.solution(new int[] {15, 10, 3, 1, 37}, new int[] {75, 30, 5, 1, 74}));
    }
}
