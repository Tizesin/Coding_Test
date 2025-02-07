import java.util.*;
class Solution {
    public long solution(long n) {
        String[] array = String.valueOf(n).split("");
        Arrays.sort(array);
        String newstr = "";
        for(int i = array.length-1; i>=0; i--)
            newstr+=array[i];
        
        return Long.parseLong(newstr);
    }
}
