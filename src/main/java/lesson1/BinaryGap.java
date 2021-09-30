package lesson1;

/**
 * 이진 갭 N 양의 정수 내에는 N.의 이진 표현의 양단들에 의해 둘러싸인 연속 된 제로 중 최대 시퀀스 인
 *
 * 예를 들어, 숫자 9는 이진 표현 1001을 갖고 길이가 2인 이진 간격을 포함합니다. 숫자 529는 이진 표현이 1000010001 이고 두 개의 이진 간격(길이 4 중 하나와 길이 3 중 하나)을 포함합니다. 숫자 20은 이진 표현 10100 을 포함하고 다음을 포함합니다. 길이가 1인 하나의 이진 간격. 숫자 15는 이진 표현 1111 을 가지며 이진 간격이 없습니다. 숫자 32는 이진 표현 100000 을 가지며 이진 간격이 없습니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int N); }
 *
 * 양의 정수 N이 주어지면 가장 긴 이진 간격의 길이를 반환합니다. N에 이진 간격이 포함되지 않은 경우 함수는 0을 반환해야 합니다.
 *
 * 예를 들어, N = 1041이 주어지면 함수는 5를 반환해야 합니다. N은 이진 표현이 10000010001 이고 가장 긴 이진 간격은 길이가 5이기 때문입니다. N = 32가 주어지면 함수는 0을 반환해야 합니다. N은 이진 표현이 '100000'이고 바이너리 갭이 없습니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 2,147,483,647 ] 범위의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/training8XQBN2-CBQ/
 */
public class BinaryGap {

    public int solution(int N) {
        // write your code in Java SE 8
        String binaryString = Integer.toBinaryString(N);

        int maxZeroCount = 0;
        int zeroCount = 0;
        boolean existsFirstZero = false;

        char[] binaryChars = binaryString.toCharArray();
        for (int i = 0; i < binaryChars.length; i++) {
            if (existsFirstZero == false) {
                if (binaryChars[i] == '1') {
                    existsFirstZero = true;
                }
            } else  {
                if (binaryChars[i] == '1') {
                    if (maxZeroCount < zeroCount) {
                        maxZeroCount = zeroCount;
                    }
                    zeroCount = 0;
                } else {
                    zeroCount++;
                }
            }
        }

        return maxZeroCount;

    }

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(0 ));

    }
}
