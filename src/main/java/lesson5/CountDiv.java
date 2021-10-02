package lesson5;

/**
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int A, int B, int K); }
 *
 * 세 개의 정수 A, B 및 K가 주어지면 [A..B] 범위 내에서 K로 나눌 수 있는 정수의 수를 반환합니다. 즉:
 *
 * { i : A ≤ i ≤ B, i  mod  K = 0 }
 *
 * 예를 들어 A = 6, B = 11 및 K = 2인 경우 함수는 3을 반환해야 합니다. [6..11] 범위 내에서 2로 나눌 수 있는 세 개의 숫자, 즉 6, 8 및 10이 있기 때문입니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * A 및 B는 [ 0 .. 2,000,000,000 ] 범위 내의 정수입니다 .
 * K는 [ 1 .. 2,000,000,000 ] 범위 내의 정수입니다 .
 * A ≤ B.
 */

/**
 * https://app.codility.com/demo/results/trainingK2FTAE-TY4/ => 성능오류, loop를 돌렸음.
 * 해결 => loop 없이 계산으로
 * https://app.codility.com/demo/results/trainingQ8S7EY-3SD/    => 오류 있음
 * 성능 해결 하다가 버그 생길 가능성이 높음. 아래의 코드는 정합성 오류가 있음..
 * 결론 : 그냥 loop로 합시다.
 */
public class CountDiv {

    public int solution(int A, int B, int K) {

        if (A > B) {
            return 0;
        }

        int temp = A % K;
        int firstDiv = 0;
        if (A < K && K <= B) {
            firstDiv = K;
        } else if (temp > 0) {
            firstDiv = A + (K - temp);
        } else {
            firstDiv = A;
        }

        return ((B - firstDiv) / K) + 1;

    }

    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        System.out.println(countDiv.solution(0, 1, 17));
    }
}
