package lesson12;

/**
 * 두 개의 양의 정수 N과 M이 주어집니다. 정수 N은 0에서 N - 1까지 번호가 매겨진 원 안에 배열된 초콜릿의 수를 나타냅니다.
 *
 * 초콜릿을 먹기 시작합니다. 초콜릿을 먹고 나면 포장지만 남습니다.
 *
 * 초콜릿 번호 0부터 먹기 시작합니다. 그런 다음 원에 있는 다음 M − 1 초콜릿이나 포장지를 생략하고 다음 것을 먹습니다.
 *
 * 더 정확하게 말하면, 초콜릿 숫자 X를 먹었다면 다음에는 숫자 (X + M) 모듈로 N(나누기의 나머지)이 있는 초콜릿을 먹을 것입니다.
 *
 * 빈 포장지를 만나면 식사를 중단합니다.
 *
 * 예를 들어, 주어진 정수 N = 10 및 M = 4. 다음 초콜릿을 먹게 될 것입니다: 0, 4, 8, 2, 6.
 *
 * 목표는 위의 규칙에 따라 먹을 초콜릿의 수를 계산하는 것입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int N, int M); }
 *
 * 두 개의 양의 정수 N과 M이 주어지면 먹을 초콜릿의 수를 반환합니다.
 *
 * 예를 들어, 주어진 정수 N = 10 및 M = 4. 위에서 설명한 대로 함수는 5를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N 및 M은 [ 1 .. 1,000,000,000 ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/trainingWEY7QZ-NE2/    => 37% => M이 더 큰 경우를 생각하지 못함
 * https://app.codility.com/demo/results/trainingVMHVT5-2HJ/    => 100% 재귀함수로 최대공약수 구해야 정확함
 */
public class ChocolatesByNumbers {

    public int solution(int N, int M) {
        // write your code in Java SE 8
        //최대공약수를 구해야 한다. (유클리드)
        int gdc = gdc(N, M);

        //최대공약수로 나눈다.
        return N / gdc;
    }

    /**
     * 최대공약수 구하기
     * 나눠서 나머지가 0이 될 때까지 나눈다.
     * @param a
     * @param b
     * @return
     */
    private int gdc(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gdc(b, a % b);
    }

    public static void main(String[] args) {
        ChocolatesByNumbers test = new ChocolatesByNumbers();
        System.out.println(test.solution(12, 21));
//        System.out.println(test.solution(10, 4));
//        System.out.println(test.solution(10, 10));

    }
}
