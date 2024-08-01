class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    public int dfs(int[] numbers, int target, int sum, int idx){
        //탈출 조건
        if(idx == numbers.length)
            return sum == target ? 1 : 0;
        
        //재귀 호출
        return dfs(numbers, target, sum + numbers[idx], idx + 1) +
            dfs(numbers, target , sum - numbers[idx], idx + 1);
    }
}