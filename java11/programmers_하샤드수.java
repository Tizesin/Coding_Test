class Solution {
    public boolean solution(int x) {
        int totalNumSum = 0;
        int Num = x;
        
        while(Num > 0){
            totalNumSum += Num % 10;
            Num /= 10;
        }
        
        if( x % totalNumSum == 0)
            return true;
        return false;
    }
}
