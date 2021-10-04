import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        List<Integer> answerList = new ArrayList<>();
        int prevWorkDay = -1;
        int deployDay = 0;
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int workDay = (int)Math.ceil(remain / (double)speeds[i]);


            if (prevWorkDay == -1) {
                deployDay++;
                prevWorkDay = workDay;
            } else {
                if (prevWorkDay >= workDay) {
                    deployDay++;
                    prevWorkDay = workDay;
                } else {
                    answerList.add(deployDay);
                    prevWorkDay = workDay;
                    deployDay = 1;
                }
            }

        }
        answerList.add(deployDay);

        return answerList.stream().mapToInt(x -> x).toArray();
    }
}
