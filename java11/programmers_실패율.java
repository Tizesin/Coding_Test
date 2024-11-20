import java.util.*;

class Pair{
    Integer first;
    Double second;
    public Pair(Integer first, Double b) {
        this.first = first;
        this.second = b;
    }
    public Integer getFirst() {
        return first;
    }
    public Double getSecond() {
        return second;
    }
}
class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지 실패율
        double[] stageFailPer = new double[N+2];
        // 스테이지 실패한 유저 수
        int[] stageFailUserCnt = new int[N+2];
        int[] answer = new int[N];
        for(int stage : stages){
            stageFailUserCnt[stage]++;
        }
        int userCnt = stages.length;
        for(int i = 1; i < N+1; i++) {
            if(userCnt == 0){
                stageFailPer[i] = 0.0;
                continue;
            }
            stageFailPer[i] = (double) stageFailUserCnt[i]/userCnt;
            userCnt -= stageFailUserCnt[i];
            System.out.println(i + "stage : " + stageFailUserCnt[i] + "/" + userCnt);
        }
        List<Pair> list = new ArrayList<>();
        for(int idx = 1; idx < stageFailPer.length-1; idx++) {
           Pair pair = new Pair(idx,stageFailPer[idx]);
           list.add(pair);
        }
        list.sort(Comparator.comparing(Pair::getSecond).reversed());
        int answerIdx = 0;
        for(Pair pair : list){
            System.out.println(pair.first + " | " + pair.second);
            answer[answerIdx++] = pair.first;
        }
        return answer;
    }
}
