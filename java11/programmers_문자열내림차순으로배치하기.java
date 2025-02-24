import java.util.*;

class Solution {
    public String solution(String s) {
        int length = s.length();
        char[] chr = new char[length];
        for(int i = 0; i < length; i++){
            chr[i] = s.charAt(i);
        }
        Arrays.sort(chr);
        StringBuilder sb = new StringBuilder(new String(chr));
        return sb.reverse().toString();
    }
}
