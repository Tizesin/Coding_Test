import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length; i++){
            int iSentenceLength = phone_book[i].length();
            char iSentenceFirstChar = phone_book[i].charAt(0);
            char iSentenceLastChar = phone_book[i].charAt(iSentenceLength-1);
            for(int j = i+1; j < phone_book.length; j++){
                if(iSentenceLength <= phone_book[j].length()){
                    if(iSentenceFirstChar != phone_book[j].charAt(0) || 
                      iSentenceLastChar != phone_book[j].charAt(iSentenceLength-1))
                       break;
                    if(phone_book[j].substring(0,iSentenceLength).equals(phone_book[i]))
                        return false;
                }
            }
        }
        return true;
    }
}
