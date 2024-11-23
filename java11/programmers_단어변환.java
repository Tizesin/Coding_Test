import java.util.*;

class Solution {
    HashMap<String,Integer> visited = new HashMap<>();
    HashMap<String,List<String>> map = new HashMap<>();
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int wordLen = words[0].length();
        int wordCnt = words.length;
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        wordList.add(begin);
        for(int i = 0; i < wordCnt+1; i++){
            List<String> list = new ArrayList<>();
            for(int j = 0; j < wordCnt+1; j++){
                int diffCharCnt = 0;
                for(int k = 0; k < wordLen; k++){
                    if(wordList.get(i).charAt(k) != wordList.get(j).charAt(k))
                        diffCharCnt++;
                    if(diffCharCnt>1)
                        break;
                }
                if(diffCharCnt==1)
                    list.add(wordList.get(j));
            }
            visited.put(wordList.get(i),0);
            map.put(wordList.get(i),list);
        }

        BFS(begin, target);
        answer = (visited.get(target) == null ? 0 : visited.get(target));
        
//         for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//             System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//         }
        
//         for (Map.Entry<String, Integer> entry : visited.entrySet()) {
//             System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//         }
        return answer;
    }
    
    public void BFS(String begin, String target) {
        Queue<String> queue = new LinkedList<>();
        visited.put(begin,0);
        queue.offer(begin);
        int step = 0;
        
        while(!queue.isEmpty()){
            String que = queue.poll();
            step = visited.get(que);
            for(String str : map.get(que)){
                if(visited.get(str) == 0){
                    queue.offer(str);
                    visited.put(str,step+1);
                    if(str.equals(target))
                        return;
                }
            }
        }
        
    }
}
