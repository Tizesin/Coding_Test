class Solution {
    int[] result = new int[15];
    
    public int solution(int n) {
        
        result[0] = 1;
        result[1] = 1;
        
        for(int i = 2; i<n+1; i++){
            for(int j = i; j>0; j--){
                result[i] += (result[j-1] * result[i-j]);
            }
        }
        return result[n];
    }
}
