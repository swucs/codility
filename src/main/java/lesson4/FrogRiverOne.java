package lesson4;

/**
 * 작은 개구리는 강 건너편으로 가고 싶어합니다. 개구리는 처음에 강의 한쪽 강둑(위치 0)에 있으며 반대쪽 강둑(위치 X+1)으로 이동하려고 합니다. 나뭇잎은 나무에서 강 표면으로 떨어집니다.
 *
 * 떨어지는 잎을 나타내는 N개의 정수로 구성된 배열 A가 주어집니다. A[K]는 초 단위로 측정된 시간 K에서 한 잎이 떨어지는 위치를 나타냅니다.
 *
 * 목표는 개구리가 강의 반대편으로 점프할 수 있는 가장 빠른 시간을 찾는 것입니다. 개구리는 강을 가로질러 1부터 X까지의 모든 위치에 나뭇잎이 나타날 때만 횡단할 수 있습니다(즉, 1에서 X까지의 모든 위치가 나뭇잎으로 덮인 가장 빠른 순간을 찾고 싶습니다). 강의 흐름 속도는 무시할 수 있을 정도로 작다고 가정할 수 있습니다. 즉, 잎이 강에 떨어지면 위치가 바뀌지 않습니다.
 *
 * 예를 들어, 정수 X = 5와 배열 A가 다음과 같이 주어집니다.
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * 두 번째 6에서 잎은 위치 5에 떨어집니다. 이것은 잎이 강 건너 모든 위치에 나타나는 가장 빠른 시간입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int X, int[] A); }
 *
 * N개의 정수와 정수 X로 구성된 비어 있지 않은 배열 A가 주어지면 개구리가 강의 반대편으로 점프할 수 있는 가장 빠른 시간을 반환합니다.
 *
 * 개구리가 강의 반대편으로 점프할 수 없는 경우 함수는 -1을 반환해야 합니다.
 *
 * 예를 들어, 주어진 X = 5 및 배열 A는 다음과 같습니다.
 *
 *   A[0] = 1
 *   A[1] = 3
 *   A[2] = 1
 *   A[3] = 4
 *   A[4] = 2
 *   A[5] = 3
 *   A[6] = 5
 *   A[7] = 4
 * 함수는 위에서 설명한 대로 6을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N 및 X는 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ 1 .. X ] 범위 내의 정수 입니다.
 */

/**
 * https://app.codility.com/demo/results/training6XRM99-T3Y/    => 100%
 */
public class FrogRiverOne {

    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        System.out.println(frogRiverOne.solution(7, new int[] {5, 1, 2, 3, 4, 7, 8, 9, 6}));
    }


    public int solution(int X, int[] A) {

        int[] leaves = new int[X];

        int leafCount = 0;
        for (int i = 0; i < A.length; i++) {

            if (A[i] > X) {
                continue;
            }

            if (leaves[A[i] - 1] == 0) {
                leaves[A[i] - 1] = 1;
                leafCount++;
            }

            if (leafCount == X) {
                return i;
            }
        }

        return -1;

    }
}
