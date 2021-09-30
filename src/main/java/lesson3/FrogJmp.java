package lesson3;

/**
 * https://app.codility.com/demo/results/trainingPD3EJC-YKW/
 */
public class FrogJmp {

    public int solution(int x, int y, int d) {
        if (x > y) {
            return -1;
        }

        if (x == y) {
            return 0;
        }
        return (int) Math.ceil((y - x) / (double)d);

    }

    public static void main(String[] args) {

        FrogJmp test = new FrogJmp();
        System.out.println(test.solution(5, 105, 3));
    }
}
