import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> table = new HashMap<>();
        for(int i = 0; i < name.length; i++){           table.put(name[i],yearning[i]);
        }
        int[] answer = new int[photo.length];
        for(int i = 0; i < photo.length; i++){
            int score = 0;
            for(int j = 0; j < photo[i].length; j++){
                String chkyearningName = photo[i][j];
                if(table.containsKey(chkyearningName)){
                score += table.get(chkyearningName);
                }
            }
            answer[i] = score;
        }
        return answer;
    }
}
