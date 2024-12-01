import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = list.stream()
                .distinct()
                .mapToInt(e->e)
                .sorted()
                .toArray();
        return answer;
    }
}
