class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int emptybottle = n;
        int pullbottle = 0;
        
        while(emptybottle > a-1){
            pullbottle = emptybottle/a*b;
            emptybottle = emptybottle%a;
            answer += pullbottle;
            emptybottle += pullbottle;
        }
        return answer;
    }
}
