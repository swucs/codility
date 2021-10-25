package lesson5;

/**
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다. 0 ≤ P < Q < N과 같은 한 쌍의 정수(P, Q) 를 배열 A 의 슬라이스 라고 합니다
 * ( 슬라이스 에 두 개 이상의 요소가 포함됨).
 * 평균 슬라이스 (P, Q)의이 A [P] + A의 합 [P + 1] + ... + A [Q] 슬라이스의 길이로 나눈 값.
 * 정확히 말하면 평균은 (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1)과 같습니다.
 *
 * 예를 들어, 다음과 같은 배열 A:
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * 다음 예제 조각이 포함되어 있습니다.
 *
 * 평균이 (2 + 2) / 2 = 2인 슬라이스 (1, 2);
 * 평균이 (5 + 1) / 2 = 3인 슬라이스 (3, 4);
 * 평균이 (2 + 2 + 5 + 1) / 4 = 2.5인 슬라이스 (1, 4).
 * 목표는 평균이 최소인 슬라이스의 시작 위치를 찾는 것입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 최소 평균으로 슬라이스의 시작 위치를 반환합니다.
 * 최소 평균을 가진 슬라이스가 두 개 이상 있는 경우 해당 슬라이스의 가장 작은 시작 위치를 반환해야 합니다.
 *
 * 예를 들어, 주어진 배열 A는 다음과 같습니다.
 *
 *     A[0] = 4
 *     A[1] = 2
 *     A[2] = 2
 *     A[3] = 5
 *     A[4] = 1
 *     A[5] = 5
 *     A[6] = 8
 * 함수는 위에서 설명한 대로 1을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 2 .. 100,000 ] 범위의 정수입니다 .
 * 배열 A의 각 요소는 [ −10,000 .. 10,000 ] 범위의 정수 입니다.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * https://app.codility.com/demo/results/training46CZSJ-36B/    => 60%
 */
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
        System.out.println(minAvgTwoSlice.solution(new int[] {4, 2, 2, 5, 1, 5, 8}));
        List<Integer> list =  new ArrayList<>();
        list.stream().mapToInt(x -> x).toArray();
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        int minI = 0;
        double minAvg = A[0];

        for (int i = 0; i < A.length; i++) {

            long prevSum = A[i];


            for (int j = i + 1; j < A.length; j++) {

                double avg = (prevSum + A[j]) / (double)(j - i + 1);
                if (minAvg > avg) {
                    minI = i;
                    minAvg = avg;
                }

                prevSum = prevSum + A[j];
            }
        }

        return minI;

    }
}
