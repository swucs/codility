package lesson2;

/**
 * N개의 정수로 구성된 배열 A가 제공됩니다. 배열의 회전은 각 요소가 한 인덱스만큼 오른쪽으로 이동하고 배열의 마지막 요소가 첫 번째 위치로 이동하는 것을 의미합니다. 예를 들어 배열 A = [3, 8, 9, 7, 6]의 회전은 [6, 3, 8, 9, 7]입니다(요소는 한 인덱스 오른쪽으로 이동하고 6은 첫 번째 위치로 이동합니다).
 *
 * 목표는 어레이를 AK번 회전하는 것입니다. 즉, A의 각 요소는 오른쪽으로 K번 이동합니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int[] 솔루션(int[] A, int K); }
 *
 * N개의 정수와 정수 K로 구성된 배열 A가 주어지면 K번 회전된 배열 A를 반환합니다.
 *
 * 예를 들어, 주어진
 *
 *     A = [3, 8, 9, 7, 6]
 *     K = 3
 * 함수는 [9, 7, 6, 3, 8]을 반환해야 합니다. 세 번의 회전이 이루어졌습니다.
 *
 *     [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 *     [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 *     [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * 다른 예를 들면,
 *
 *     A = [0, 0, 0]
 *     K = 1
 * 함수는 [0, 0, 0]을 반환해야 합니다.
 *
 * 주어진
 *
 *     A = [1, 2, 3, 4]
 *     K = 4
 * 함수는 [1, 2, 3, 4]를 반환해야 합니다.
 *
 * 다음과 같이 가정합니다.
 *
 * N 및 K는 [ 0 .. 100 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ −1,000 .. 1,000 ] 범위 내의 정수 입니다.
 * 솔루션에서 정확성에 중점을 둡니다 . 솔루션의 성능은 평가의 초점이 아닙니다.
 */

/**
 * https://app.codility.com/demo/results/trainingKKTMA5-YRS/
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if (K == 0) {
            return A;
        }

        if (A == null || A.length == 0 ) {
            return A;
        }

        if (A.length == K ) {
            return A;
        }

        //분리할 위치 찾기
        int pos = 0;
        if (A.length > K) {
            pos = A.length - K;
        } else {
            pos = A.length - (K % A.length);
        }

        int index = 0;
        int[] newA = new int[A.length];
        for (int i = pos; i < A.length; i++) {
            newA[index++] = A[i];
        }

        for (int i = 0; i < pos; i++) {
            newA[index++] = A[i];
        }

        return newA;

    }

    public static void main(String[] args) {

    }

}
