class Solution {
    public double solution(int[] arr) {
        double total = 0;
        for(int i = 0; i < arr.length; i++)
            total += (double)arr[i];
        double answer = total/arr.length;
        return answer;
    }
}
