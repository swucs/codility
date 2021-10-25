package lesson3;

/**
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다. 어레이 A는 테이프의 숫자를 나타냅니다.
 *
 * 0 < P < N과 같은 정수 P는 이 테이프를 비어 있지 않은 두 부분으로 나눕니다.
 * A[0], A[1], ..., A[P − 1] 및 A[P], A[ P + 1], ..., A[N − 1].
 *
 * 두 부분 의 차이 는 다음 값입니다.
 * |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + .. . + A[N − 1])|
 *
 * 즉, 첫 번째 부분의 합과 두 번째 부분의 합 사이의 절대 차이입니다.
 *
 * 예를 들어, 다음과 같은 배열 A를 고려하십시오.
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * 이 테이프를 네 곳으로 나눌 수 있습니다.
 *
 * P = 1, 차이 = |3 − 10| = 7
 * P = 2, 차이 = |4 − 9| = 5
 * P = 3, 차이 = |6 − 7| = 1
 * P = 4, 차이 = |10 − 3| = 7
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N 정수의 비어 있지 않은 배열 A가 주어지면 달성할 수 있는 최소 차이를 반환합니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 *   A[0] = 3
 *   A[1] = 1
 *   A[2] = 2
 *   A[3] = 4
 *   A[4] = 3
 * 함수는 위에서 설명한 대로 1을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 2 .. 100,000 ] 범위의 정수입니다 .
 * 배열 A의 각 요소는 [ −1,000 .. 1,000 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingW9Y326-SA6/    => 53%
 * https://app.codility.com/demo/results/training6AQ99S-5JW/    => 100%
 */
public class TapeEquilibrium {

    public int solution(int[] A) {

        //전체 합을 구함
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        int min = -1;
        int prevSum = 0;
        int nextSum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            prevSum += A[i];
            nextSum = sum - prevSum;

            int absResult = Math.abs(prevSum - nextSum);
            if (min == -1 || absResult < min) {
                min = absResult;
            }
        }

        return min;

    }

    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        System.out.println(tapeEquilibrium.solution(new int[]{3,1,2,4,3}));
    }
}
