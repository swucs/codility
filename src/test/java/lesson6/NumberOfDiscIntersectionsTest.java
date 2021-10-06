package lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
class NumberOfDiscIntersectionsTest {


    @ParameterizedTest()
    @MethodSource(value="params")
    public void test(int[] A, int expeted) {
        NumberOfDiscIntersections test = new NumberOfDiscIntersections();
        int result = test.solution(A);

        System.out.println(result);
        Assertions.assertEquals(result, expeted);
    }


    private static Object[] params() {
        return new Object[] {
                new Object[] {new int[] {1, 5, 2, 1, 4, 0}, 11}
                , new Object[] {new int[] {1, 2147483647, 0}, 2}
        };
    }

}