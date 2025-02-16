class Solution {
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n / 2; i++)
            answer.append("수박");
        if (n % 2 != 0)
            answer.append("수");
        return answer.toString();
    }
}
