package lesson9;

import java.util.Arrays;

/**
 * N개의 정수로 구성된 배열 A가 제공됩니다. 여기에는 연속 N일 동안의 주식의 일일 가격이 포함됩니다. 0 ≤ P ≤ Q < N일 때 단일 주식을 P일에 매수하고 Q일에 매도한 경우 해당 거래 의 이익 은 A[Q] − A[P]와 같습니다. 단, A[Q] ≥ 에이[피]. 그렇지 않으면 트랜잭션은 A[P] − A[Q]의 손실 을 가져옵니다 .
 *
 * 예를 들어, 다음과 같은 6개의 요소로 구성된 다음 배열 A를 고려하십시오.
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * 주식을 0일에 사고 2일에 팔면 A[2] − A[0] = 21123 − 23171 = −2048이므로 2048의 손실이 발생합니다. 주식을 4일에 사고 5일에 팔면 A[5] − A[4] = 21367 − 21013 = 354이므로 354의 이익이 발생합니다. 가능한 최대 이익은 356입니다. 1일에 사서 5일에 팔았다.
 *
 * 함수를 작성하고,
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * 연속 N일 동안 주식의 일일 가격을 포함하는 N 정수로 구성된 배열 A가 주어지면 이 기간 동안 한 거래에서 가능한 최대 이익을 반환합니다.
 * 이익을 얻을 수 없는 경우 함수는 0을 반환해야 합니다.
 *
 * 예를 들어, 주어진 배열 A는 다음과 같은 6개의 요소로 구성됩니다.
 *
 *   A[0] = 23171
 *   A[1] = 21011
 *   A[2] = 21123
 *   A[3] = 21366
 *   A[4] = 21013
 *   A[5] = 21367
 * 함수는 위에서 설명한 대로 356을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 0 .. 400,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 0 .. 200,000 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingM9MDT6-N4D/       55% => 반환값을 이익값이므로 0이상의 값을 반환해야 함(마이너스 반환 금지)
 * https://app.codility.com/demo/results/training4Z9N53-2TX/       66% => 정합도 100%
 * https://app.codility.com/demo/results/trainingXBT64J-NUQ/       100%
 *
 * 1.왼쪽에서 오른쪽으로 MIN값을 누적해서 배열을 만든다.
 * 2.오른쪽에서 왼쪽으로 MAX값을 누적해서 배열을 만든다.
 * 3. 만든 배열로 계산을한다. 오른쪽[i + 1] - 왼쪽[i] 중 MAX값을 찾는다.
 * A가 null이거나 1개일 수 있으므로 예외처리 해야 한다.
 * 결과가 마이너스 이면 0을 반환해야 한다.
 */
public class MaxProfit {
    public int solution(int[] A) {
        // write your code in Java SE 8

        if (A.length < 2) {
            return 0;
        }

        int maxProfit =  0;

        int[] leftMinAccum = new int[A.length];
        leftMinAccum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            if (A[i] < leftMinAccum[i - 1]) {
                leftMinAccum[i] = A[i];
            } else {
                leftMinAccum[i] = leftMinAccum[i - 1];
            }

            // System.out.print("leftMinAccum[i] " + leftMinAccum[i]);
        }

        int[] rightMaxAccum = new int[A.length];
        rightMaxAccum[A.length - 1] = A[A.length - 1];
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > rightMaxAccum[i + 1]) {
                rightMaxAccum[i] = A[i];
            } else {
                rightMaxAccum[i] = rightMaxAccum[i + 1];
            }
            // System.out.print("rightMaxAccum[i] " + rightMaxAccum[i]);
        }


        for (int i = 0; i < A.length - 1; i++) {
            int profit = rightMaxAccum[i + 1] - leftMinAccum[i];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        if (maxProfit < 0) {
            maxProfit = 0;
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        MaxProfit test = new MaxProfit();
//        test.solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367});
        System.out.println(test.solution(new int[] {0, 200000}));
    }
}
