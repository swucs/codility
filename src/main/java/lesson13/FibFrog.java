package lesson13;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 피보나치 수열은 다음 재귀 공식을 사용하여 정의됩니다.
 *
 *     F(0) = 0
 *     F(1) = 1
 *     F(M) = F(M - 1) + F(M - 2) M >= 2인 경우
 * 작은 개구리는 강 건너편으로 가고 싶어합니다. 개구리는 처음에 강의 한쪽 강둑(위치 -1)에 위치하고 다른 강둑(위치 N)으로 이동하려고 합니다.
 * 개구리는 F(K)가 K번째 피보나치 수인 F(K) 거리를 뛰어 넘을 수 있습니다.
 * 운 좋게도 강에는 많은 잎사귀가 있고 개구리는 잎사귀 사이로 점프할 수 있지만 위치 N의 둑 방향으로만 가능합니다.
 *
 * 강의 잎은 N개의 정수로 구성된 배열 A로 표현됩니다. 배열 A의 연속 요소는 강의 0에서 N − 1까지의 연속 위치를 나타냅니다.
 * 배열 A에는 0 및/또는 1만 포함됩니다.
 *
 * 0은 리프가 없는 위치를 나타냅니다.
 * 1은 리프를 포함하는 위치를 나타냅니다.
 * 목표는 개구리가 강의 반대편(위치 -1에서 위치 N까지)에 도달할 수 있는 최소 점프 횟수를 계산하는 것입니다.
 * 개구리는 위치 -1과 N(강둑)과 잎사귀가 있는 모든 위치 사이를 이동할 수 있습니다.
 *
 * 예를 들어, 다음과 같은 배열 A를 고려하십시오.
 *
 *     A[0] = 0
 *     A[1] = 0
 *     A[2] = 0
 *     A[3] = 1
 *     A[4] = 1
 *     A[5] = 0
 *     A[6] = 1
 *     A[7] = 0
 *     A[8] = 0
 *     A[9] = 0
 *     A[10] = 0
 * 개구리는 F(5) = 5, F(3) = 2, F(5) = 5의 길이로 세 번 점프할 수 있습니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 배열 A가 주어지면 개구리가 강의 반대편에 도달할 수 있는 최소 점프 수를 반환합니다.
 * 개구리가 강의 반대편에 도달할 수 없으면 함수는 -1을 반환해야 합니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 *     A[0] = 0
 *     A[1] = 0
 *     A[2] = 0
 *     A[3] = 1
 *     A[4] = 1
 *     A[5] = 0
 *     A[6] = 1
 *     A[7] = 0
 *     A[8] = 0
 *     A[9] = 0
 *     A[10] = 0
 * 함수는 위에서 설명한 대로 3을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 0, 1 값 중 하나를 가질 수 있는 정수입니다.
 */
public class FibFrog {

    public int solution(int[] A) {
        List<Integer> fibos = new ArrayList<>();
        fibos.add(0);
        fibos.add(1);
        for (int i = 0; ; i++) {
            int val = fibos.get(i) + fibos.get(i + 1);
            if (val > A.length) {
                fibos.add(val);
                break;
            }

            fibos.add(val);
        }
        fibos.remove(0);

        int curIndex = -1;
        int jumpCount = search(A, curIndex, fibos);

        if (jumpCount == 0) {
            return -1;
        }

        return jumpCount;

    }

    private int search(int[] A, int curIndex, List<Integer> fibos) {
        int jumpCount = 0;
        while (true) {
            //피보숫자를 큰 숫자부터 시작한다.
            for (int i = fibos.size() - 1; i >=0; i--) {
                int jump = fibos.get(i);

                if (curIndex + jump > A.length) {
                    //끝 보다 Over한 경우 다음 fibo숫자
                    continue;
                }

                if (curIndex + jump == A.length) {
                    //딱 맞게 건너간 경우 끝남.
                    return 1;
                }

                if (A[curIndex + jump] == 1) {
                    //jump했는데 나뭇잎이 있다면 점프성공
                    int result = search(A, curIndex + jump, fibos);

                    if (result == 0) {
                        continue;
                    } else {
                        jumpCount++;
                        jumpCount += result;
                        return jumpCount;
                    }

                }

                if (i == 0) {
                    //끝까지 못찾은 경우 종료
                    return 0;
                }

            }
        }
    }


    public static void main(String[] args) {
        FibFrog test = new FibFrog();
//        System.out.println(test.solution(new int[] {0, 0, 0, 0, 1}));
//        System.out.println(test.solution(new int[] {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0}));
        System.out.println(test.solution(new int[] {1, 1, 0, 0, 0}));

    }
}
