class Solution {
    public String solution(String phone_number) {
        int length = phone_number.length();
        String answer = "*".repeat(length - 4) + phone_number.substring(length - 4);
        return answer;
    }
}
