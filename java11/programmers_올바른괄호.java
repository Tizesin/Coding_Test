class Solution {
    boolean solution(String s) {
        int validation = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(')
                validation++;
            else
                validation--;
            
            if(validation < 0)
                return false;
        }
        if(validation == 0)
            return true;
        return false;
    }
}
