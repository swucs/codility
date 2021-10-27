/**
https://app.codility.com/demo/results/trainingTPK7U9-JKQ/
*/
// you can also use imports, for example:
import java.util.*;
import java.util.stream.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class NumberOfDiscIntersections2 {
    public int solution(int[] A) {

        if (A.length < 2) {
            return 0;
        }

        // write your code in Java SE 8
        List<long[]> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(new long[] {i - (long)A[i], i + (long)A[i]});
        }

        //시작값으로 정렬한다.
        List<long[]> newList = list.stream()
            .sorted(Comparator.comparingLong(a -> a[0]))
            .collect(Collectors.toList());
        
        int result = 0;
        for (int i = 1; i < newList.size(); i++) {
            
            long base = newList.get(i)[0];
            for (int j = 0; j < i; j++) {
                if (newList.get(j)[0] <= base && base <= newList.get(j)[1]) {
                    //기준점이 다른 원에 교체되어 있다면
                    result++;
                }
            }

        }

        if (result > 10000000) {
            return -1;
        }

        return result;

    }
}
