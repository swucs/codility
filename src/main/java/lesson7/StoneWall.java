package lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 돌담을 쌓게 됩니다. 벽은 직선이어야 하고 길이는 N미터여야 하며 두께는 일정해야 합니다.
 * 그러나 다른 위치에서 다른 높이를 가져야 합니다. 벽의 높이는 N개의 양의 정수 배열 H로 지정됩니다.
 * H[I]는 I에서 왼쪽 끝의 오른쪽으로 I+1미터까지의 벽 높이입니다. 특히, H[0]은 벽의 왼쪽 끝의 높이이고 H[N-1]은 벽의 오른쪽 끝의 높이입니다.
 *
 * 벽은 직육면체 석재 블록으로 지어야 합니다(즉, 이러한 블록의 모든면이 직사각형).
 * 당신의 임무는 벽을 만드는 데 필요한 최소 블록 수를 계산하는 것입니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(int[] H); }
 *
 * 벽의 높이를 지정하는 N개의 양의 정수로 구성된 배열 H가 주어지면 벽을 만드는 데 필요한 최소 블록 수를 반환합니다.
 *
 * 예를 들어, N = 9개의 정수를 포함하는 배열 H가 주어졌을 때:
 *
 *   H[0] = 8 H[1] = 8 H[2] = 5
 *   H[3] = 7 H[4] = 9 H[5] = 8
 *   H[6] = 7 H[7] = 4 H[8] = 8
 * 함수는 7을 반환해야 합니다. 그림은 7개 블록의 가능한 배열을 보여줍니다.
 *
 *
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * 배열 H의 각 요소는 [ 1 .. 1,000,000,000 ] 범위 내의 정수 입니다.
 */

/**
 * 첫 숫자는 벽돌을 만들어야 하므로 count 증가 후 stack에 넣는다.
 * 요소가 stack 값 보다 크다는 것은 높이 쌓아야 하므로 새로운 벽돌이 필요함을 의미 하므로 count 증가후 stack에 넣는다.
 * 요소가 stack 값 보다 작다는 것은 stack의 벽돌은 끝내야 함을 의미하므로 stack에서 계속 지우다가 
   모든 stack이 비었다는 것은 지금까지 중 가장 낮은 높이이므로 
   기존 벽돌을 마무리해야 함을 뜻하므로 count++ 한 후 stack에 넣는다.
   요소가 stack값과 같다는 것은 기존 벽돌 높이와 같으므로 벽돌을 더 만들 필요가 없으므로 아무런 작업을 하지 않는다.
 * https://app.codility.com/demo/results/trainingQJ3KVA-CGZ/    => 100%
 *
 */
public class StoneWall {

    public int solution(int[] H) {
        // write your code in Java SE 8

        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < H.length; i++) {
            while (true) {
                if (!stack.isEmpty()) {
                    if (stack.peek() < H[i]) {
                        //스택보다 크면 스택에 넣고 카운트 증가하고 끝
                        stack.push(H[i]);
                        count++;
                        break;
                    } else if (stack.peek() > H[i]) {
                        //스택보다 작다는 것은 스택의 블럭은 끝이므로 스택에서 제거
                        //스택보다 작으면 pop하고 진행
                        stack.pop();
                    } else if (stack.peek() == H[i]) {
                        //스택과 같으면 끝
                        break;
                    }
                } else {
                    //스택이 비어있는 경우 카운트 증가하고 스택 넣고 끝
                    count++;
                    stack.push(H[i]);
                    break;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        StoneWall test = new StoneWall();
        System.out.println(test.solution(new int[] {4, 8, 8, 5, 7, 9, 8, 7, 4, 8}));
        System.out.println(test.solution(new int[] {5, 7, 9, 8, 7}));
        System.out.println(test.solution(new int[] {2, 4, 3, 2}));
    }
}
