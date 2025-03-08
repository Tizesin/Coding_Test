class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n < m) {
            int temp = n;
            n = m;
            m = temp;
        }
        
        answer[0] = cal(n, m);
        answer[1] = n * m / answer[0];
        return answer;
    }
    
    int cal(int n, int m) {
        int r;
        while(m > 0) {
            r = n % m;
            n = m;
            m = r;
        }
        return n;
    }
}
