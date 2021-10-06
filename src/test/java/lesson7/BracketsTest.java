package lesson7;

import lesson6.NumberOfDiscIntersections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

class BracketsTest {

    @ParameterizedTest()
    @MethodSource(value="params")
    public void test(String S, int expeted) {
        Brackets test = new Brackets();
        int result = test.solution(S);

        System.out.println(result);
        Assertions.assertEquals(result, expeted);
    }


    private static Object[] params() {
        return new Object[] {
                new Object[] {"{[()()]}", 1}
                , new Object[] {"([)()]", 0}
                , new Object[] {" [((SS)(EE))dddd][test]", 1}
                , new Object[] {")(", 0}
                , new Object[] {"[]}{", 0}
                , new Object[] {"{([", 0}
        };
    }
}