class Solution {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        return sqrt == (long) sqrt ? (long) Math.pow(sqrt+1,2) : -1;
    }
}
