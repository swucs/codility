package lesson8;

/**
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
 *
 * 이 배열 의 리더 는 A 요소의 절반 이상에서 발생하는 값입니다.
 *
 * 동등 리더 인덱스가 S이고 예컨대 0 ≤ S <N이 - 1 개의 서열 A [0], A [1], ..., A [S] 및 [S + 1], A [S + 2 ], ..., A[N − 1]은 같은 값의 지시선을 가집니다.
 *
 * 예를 들어, 주어진 배열 A는 다음과 같습니다.
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * 우리는 두 개의 동등한 지도자를 찾을 수 있습니다.
 *
 * 시퀀스: (4)와 (3, 4, 4, 4, 2)는 값이 4인 동일한 리더를 갖기 때문에 0입니다.
 * 2, 시퀀스: (4, 3, 4) 및 (4, 4, 2)의 값이 4인 동일한 리더가 있기 때문입니다.
 * 목표는 동등한 지도자의 수를 계산하는 것입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] A); }
 *
 * N개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 등가 리더의 수를 반환합니다.
 *
 * 예를 들면 다음과 같습니다.
 *
 *     A[0] = 4
 *     A[1] = 3
 *     A[2] = 4
 *     A[3] = 4
 *     A[4] = 4
 *     A[5] = 2
 * 함수는 위에서 설명한 대로 2를 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 A의 각 요소는 [ −1,000,000,000 .. 1,000,000,000 ] 범위 내의 정수 입니다.
 */

import java.util.*;

/**
 * 전체 리더값이 결국 배열을 2개로 쪼개진 곳의 리더값이 된다.
 * https://app.codility.com/demo/results/trainingEF3A96-R3M/    => 88% O(N)
 */
public class EquiLeader {
    public int solution(int[] A) {
        // write your code in Java SE 8

        int result = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            List<Integer> list = map.getOrDefault(A[i], new ArrayList());
            list.add(i);
            map.put(A[i], list);
        }

        final int half = A.length / 2;

        Integer leader = null;
        int totalLeaderCount = 0;
        Iterator<Map.Entry<Integer, List<Integer>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, List<Integer>> entry = iterator.next();
            List<Integer> list = entry.getValue();

            if (list != null && list.size() > half) {
                leader = entry.getKey();
                totalLeaderCount = list.size();
                break;
            }
        }

        if (leader == null) {
            return 0;
        }

        int leftLeaderCount = 0;
        int leftCount = 0;
        int rightLeaderCount = totalLeaderCount;
        int rightCount = A.length;
        for (int i = 0; i < A.length; i++) {
            leftCount++;
            rightCount--;

            if (A[i] == leader) {
                leftLeaderCount++;
                rightLeaderCount--;
            }

            if(leftLeaderCount > (leftCount / 2) && rightLeaderCount > (rightCount / 2)) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        EquiLeader test = new EquiLeader();
        System.out.println(test.solution(new int[] {4, 3, 4, 4, 4, 2}));
    }
}
