import java.util.*;

class Solution {
        public static int[] solution(int[] numbers) {
            int[] answer = new int[numbers.length];
            Arrays.fill(answer,-1);
            int cnt = 0, idx = 1;
            Stack<Integer> stack = new Stack<>();
            
            for(int i = 0; i<numbers.length; i++){
                while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                    answer[stack.pop()] = numbers[i];
                }
                stack.push(i);
        }
        return answer;
    }
}
