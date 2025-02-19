import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0};
        int cycle = 0;
        char firstChar = '0';
        char lastChar = '0';
        List<String> wordList = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            firstChar = words[i].charAt(0);
            if(wordList.contains(words[i]) || (firstChar != lastChar && lastChar != '0')){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
            lastChar = words[i].charAt(words[i].length() -1);
            wordList.add(words[i]);
            
        }

        return answer;
    }
}
