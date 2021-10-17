package lesson10;

/**
 * 어떤 직사각형의 면적을 나타내는 정수 N이 주어집니다.
 *
 * 변의 길이가 A이고 B가 A * B이고 둘레 가 2 * (A + B) 인 직사각형 의 면적 .
 *
 * 목표는 면적이 N인 직사각형의 최소 둘레를 찾는 것입니다. 이 직사각형의 변은 정수여야 합니다.
 *
 * 예를 들어, 정수 N = 30이 주어지면 영역 30의 직사각형은 다음과 같습니다.
 *
 * (1, 30), 둘레 62,
 * (2, 15), 둘레 34,
 * (3, 10), 둘레 26,
 * (5, 6), 둘레 22.
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int N); }
 *
 * 정수 N이 주어지면 면적이 N과 정확히 같은 직사각형의 최소 둘레를 반환합니다.
 *
 * 예를 들어 정수 N = 30이 주어지면 위에서 설명한 대로 함수는 22를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 1,000,000,000 ] 범위의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/training8M7SX9-VFD/    => 100%
 */
public class MinPerimeterRectangle {

    /**
     * 제곱근과 근사치를 찾아야 한다.
     * @param N
     * @return
     */
    public int solution(int N) {
        // write your code in Java SE 8

        int base = (int) Math.floor(Math.sqrt(N));  //소수점 버림

        for (int i = base; i > 0; i--) {
            if (N % i == 0) {
                int j = N / i;  //다른 한변의 길이

                return (i + j) * 2;

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(Math.ceil(Math.sqrt(1)));
    }
}
