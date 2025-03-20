class Solution {
    public int solution(int n) {
        String str = "";

        while (n != 0) {
            str += n % 3;
            n /= 3;
        }
        
        return Integer.parseInt(str, 3);
    }
}
출처: https://ittrue.tistory.com/335 [IT is True:티스토리]
