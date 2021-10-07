package lesson7;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * N개의 문자로 구성된 문자열 S 는 다음 조건 중 하나라도 참인 경우 적절하게 중첩된 것으로 간주됩니다 .
 *
 * S는 비어 있습니다.
 * S는 " (U) " 또는 " [U] " 또는 " {U} " 형식을 갖습니다. 여기서 U는 적절하게 중첩된 문자열입니다.
 * S는 V와 W가 적절하게 중첩된 문자열인 " VW " 형식을 갖습니다 .
 * 예를 들어, " {[()()]} " 문자열 은 적절하게 중첩되지만 " ([)()] "는 중첩 되지 않습니다.
 *
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int 솔루션(문자열 S); }
 *
 * N개의 문자로 구성된 문자열 S가 주어지면 S가 적절하게 중첩되면 1을 반환하고 그렇지 않으면 0을 반환합니다.
 *
 * 예를 들어, S = " {[()()]} "가 주어지면 함수는 1을 반환해야 하고 S = " ([)()] "가 주어지면 위에서 설명한 것처럼 함수는 0을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 0 .. 200,000 ] 범위 내의 정수입니다 .
 * 문자열 S는 " ( ", " { ", " [ ", " ] ", " } " 및/또는 " ) " 문자로만 구성됩니다 .
 */

/**
 * )( 이 경우도 테스트에 포함되어야 함. => if (stack.isEmpty()) 추가
 * {{{(((, [()()], 테스트 필요
 * https://app.codility.com/demo/results/training9UBC7A-3PQ/    => 62%      => 정합성이 안맞음.
 * https://app.codility.com/demo/results/trainingV2XSCB-G5G/    => 100%     O(N)
 */
public class Brackets {

    public int solution(String S) {
        // write your code in Java SE 8

        char[] chars = S.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {


            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else if (chars[i] == ')' || chars[i] == '}' || chars[i] == ']') {

                if (stack.isEmpty()) {
                    return 0;
                }

                char chr = stack.pop();
                char closedChr;
                if (chr == '(') {
                    closedChr = ')';
                } else if (chr == '{') {
                    closedChr = '}';
                } else {
                    closedChr = ']';
                }

                if (chars[i] != closedChr) {
                    return 0;
                }

            }
        }

        if (!stack.isEmpty()) {
            return 0;
        }

        return 1;

    }

}
