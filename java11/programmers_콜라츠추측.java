class Solution {
    public int solution(int num) {
        long cal = num;
        int answer = 0;
        while(answer < 500) {
            if(cal == 1L)
                return answer;
            if(cal % 2 == 1)
                cal = cal * 3 + 1;
            else   
                cal /= 2;
            answer++;
        }
        return -1;
    }
}
