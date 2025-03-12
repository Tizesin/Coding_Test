class Solution {
    int answer = 0;
    public int solution(int[] number) {
        boolean[] visited = new boolean[number.length];
        combination(number,visited,0,number.length,3); 
        return answer;
    }

    public void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    sum += arr[i];
                }
            }
            if(sum == 0 ) answer++;
            return;
        } 

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i+1, n, r-1); 
            visited[i] = false;
        }
    }
}
