package lesson5;

/**
 * DNA 서열은 A , C , G 및 T 문자로 구성된 문자열로 나타낼 수 있으며 , 이는 서열의 연속적인 뉴클레오티드 유형에 해당합니다.
 * 각 뉴클레오티드에는 정수인 영향 계수 가 있습니다. A , C , G 및 T 유형 의 뉴클레오티드는 각각 1, 2, 3 및 4의 영향 계수를 갖습니다.
 * 다음과 같은 형식의 몇 가지 질문에 답할 것입니다. 주어진 DNA 서열의 특정 부분에 포함된 뉴클레오티드의 최소 영향 인자는 무엇입니까?
 *
 * DNA 시퀀스는 N개의 문자로 구성된 비어 있지 않은 문자열 S = S[0]S[1]...S[N-1] 로 제공됩니다.
 * 비어 있지 않은 배열 P 및 Q에 제공되는 M 쿼리가 있으며 각각 M 정수로 구성되어 있습니다.
 * K 번째 쿼리(0 ≤ K < M)에서는 위치 P[K]와 Q[K](포함) 사이의 DNA 시퀀스에 포함된 뉴클레오티드의 최소 영향 계수를 찾아야 합니다.
 *
 * 예를 들어, 다음 과 같은 문자열 S = CAGCCTA 와 배열 P, Q를 고려하십시오.
 *
 *     P[0] = 2 Q[0] = 4
 *     P[1] = 5 Q[1] = 5
 *     P[2] = 0 Q[2] = 6
 * 이러한 M = 3 쿼리에 대한 답변은 다음과 같습니다.
 *
 * 위치 2와 4 사이의 DNA 부분에는 뉴클레오타이드 G 와 C (2회) 가 포함되어 있으며 , 이들의 임팩트 팩터는 각각 3과 2이므로 답은 2입니다.
 * 위치 5와 5 사이의 부분에는 단일 뉴클레오티드 T 가 포함되어 있으며 , 그 영향 계수는 4이므로 답은 4입니다.
 * 위치 0과 6 사이의 부분(전체 문자열)은 모든 뉴클레오티드, 특히 영향 계수가 1인 뉴클레오티드 A 를 포함하므로 답은 1입니다.
 * 함수 작성:
 *
 * 클래스 솔루션 { 공개 int[] 솔루션(문자열 S, int[] P, int[] Q); }
 *
 * N개의 문자로 구성된 비어 있지 않은 문자열 S와 M개의 정수로 구성된 두 개의 비어 있지 않은 배열
 * P 및 Q가 주어지면 모든 쿼리에 대한 연속적인 답변을 지정하는 M개의 정수로 구성된 배열을 반환합니다.
 *
 * 결과 배열은 정수 배열로 반환되어야 합니다.
 *
 * 예를 들어, 문자열 S = CAGCCTA 와 배열 P, Q가 다음과 같은 경우:
 *
 *     P[0] = 2 Q[0] = 4
 *     P[1] = 5 Q[1] = 5
 *     P[2] = 0 Q[2] = 6
 * 함수는 위에서 설명한 대로 값 [2, 4, 1]을 반환해야 합니다.
 *
 * 다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .
 *
 * N은 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
 * M은 [ 1 .. 50,000 ] 범위 내의 정수입니다 .
 * 배열 P, Q의 각 요소는 [ 0 .. N − 1 ] 범위 내의 정수입니다 .
 * P[K] ≤ Q[K], 여기서 0 ≤ K < M;
 * 문자열 S는 대문자 A, C, G, T 로만 구성됩니다 .
 */

/**
 * https://app.codility.com/demo/results/training7FWT7V-QGD/    => 62%, O(N * M)
 * https://app.codility.com/demo/results/trainingEYGP2N-8NA/    => 100% O(N + M)
 */
public class GenomicRangeQuery {

    public static void main(String[] args) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        System.out.println(genomicRangeQuery.solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6}));
    }

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        int[] result = new int[P.length];
        char[] chars = S.toCharArray();
        int[][] array = new int[3][S.length() + 1];

        for (int i = 0; i < chars.length; i++) {

            if (i == 0) {
                if (chars[i] == 'A') {
                    array[0][1] = 1;
                } else if (chars[i] == 'C') {
                    array[1][1] = 1;
                } else if (chars[i] == 'G') {
                    array[2][1] = 1;
                }
            } else {
                if (chars[i] == 'A') {
                    array[0][i+1] = array[0][i] + 1;
                    array[1][i+1] = array[1][i];
                    array[2][i+1] = array[2][i];
                } else if (chars[i] == 'C') {
                    array[0][i+1] = array[0][i];
                    array[1][i+1] = array[1][i] + 1;
                    array[2][i+1] = array[2][i];
                } else if (chars[i] == 'G') {
                    array[0][i+1] = array[0][i];
                    array[1][i+1] = array[1][i];
                    array[2][i+1] = array[2][i] + 1;
                } else {
                    array[0][i+1] = array[0][i];
                    array[1][i+1] = array[1][i];
                    array[2][i+1] = array[2][i];
                }
            }
        }

        for (int i = 0; i < P.length; i++) {
            int startpos = P[i];
            int endpos = Q[i] + 1;

            if (array[0][endpos] - array[0][startpos] > 0) {
                result[i] = 1;
            } else  if (array[1][endpos] - array[1][startpos] > 0) {
                result[i] = 2;
            } else  if (array[2][endpos] - array[2][startpos] > 0) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;


    }
}
