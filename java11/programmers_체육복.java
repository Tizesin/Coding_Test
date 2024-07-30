import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        //out of boundary 방지 + 학생 시작번호 1번과 idx 일치 시키기 위함 -> n + 2
        int[] totalStudent = new int[n + 2];
        Arrays.fill(totalStudent,1);
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        //잃어버린 사람 확인
        for(int idx : lost)
            totalStudent[idx]--;
        for(int idx : reserve)
            totalStudent[idx]++;

        for(int idx : lost){
            if(totalStudent[idx] == 1){
                answer++;
            }
            else if(totalStudent[idx-1]==2){
                totalStudent[idx-1]--;
                totalStudent[idx]++;
                answer++;
            }else if(totalStudent[idx+1]==2){
                totalStudent[idx+1]--;
                totalStudent[idx]++;
                answer++;
            }
        }
        return answer;
    }
}
