class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        Long a = Long.parseLong(p);
        
        for(int i=0;i<t.length()-len+1;i++){
            Long diff = Long.parseLong(t.substring(i,i+len));
            
            if(diff<= a){
                answer++;
            }
        }
        
        return answer;
    }
}
