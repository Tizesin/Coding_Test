import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        String answer = "";
        int ret = Arrays.asList(seoul).indexOf("Kim");
        return "김서방은 " + ret + "에 있다";
    }
}
