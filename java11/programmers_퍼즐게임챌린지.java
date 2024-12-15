import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int level = 0;
        int beforelevel = -1;
        int time_prev = 0;
        int mindiff = 1;
        int maxdiff = 100000;
        int result_h = -1;
        boolean escape = false;
        int test = 0;
        while(!escape){
            test++;
            if(test > 10000){
                break;
            }
            long totalSolvedTime = 0;
            
            //난이도의 최댓값과 최솟값을 기준으로 중간 값(limit 체크를 진행할 기준 값) 구함. 소숫점 버립니다.
            if(maxdiff == mindiff){
                return maxdiff;
            }
            level = ((maxdiff-mindiff) / 2) + mindiff;
            if(beforelevel == level){
                level += 1;
            }
            beforelevel = level;
            // System.out.println(level);
            
            //중간값 기준으로 문제를 limit 안에 풀 수 있는지 체크를 함.
            for(int i = 0; i < diffs.length; i++){
                int diff = diffs[i] - level;
                if(diff <= 0){
                    //숙련도가 난이도 보다 높음. 즉 문제풀이 걸리는 시간만 총 걸리는 시간에 더함.
                    totalSolvedTime += times[i];
                }
                else{
                    //숙련도가 난이도 보다 낮음. (현재 문제 걸리는 시간 + 이전 문제 걸리는 시간)*차이나는 레벨
                    totalSolvedTime += (times[i] + time_prev)*diff + times[i];
                }
                time_prev = times[i];
                //limit 시간내에 풀지 못했을 경우.
            }
            if(totalSolvedTime > limit){
                if(result_h != -1 && Math.abs(result_h - level) == 1){
                    level = result_h;
                    escape = true;
                }
                mindiff = level;
            }else if(totalSolvedTime == limit){//limit 시간 내에 풀었을 경우.
                return level; 
            }else if(totalSolvedTime < limit){//limit 시간 내에 풀었을 경우.
                result_h = level;
                maxdiff = level;
            }
        }
        // System.out.println(maxdiff);
        // System.out.println(mindiff);
        // System.out.println(result);
        return level;
    }
}
