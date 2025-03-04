import java.util.*;

class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            sb.append(pushingWord(ch,n));
        }
        return sb.toString();
    }
    
    public char pushingWord(char ch, int count){
        if(ch < 'A' || ch > 'z')
            return ch;
        boolean isUpperWord = false;
        if(ch < 'a')
            isUpperWord = true;
        ch += count;
        if(isUpperWord && ch > 'Z'){
            ch -= 26;
        }else if(!isUpperWord && ch > 'z'){
            ch -= 26;
        }
        return ch;
    }
}
