import java.util.Arrays;

class Solution {
    public String solution(String s) {
        String[] stringArr = s.split(" ");
        int arrLen = stringArr.length;
        int[] intArr = new int[arrLen];
        int i = 0;
        for(String str : stringArr)
            intArr[i++] = Integer.parseInt(str);
        Arrays.sort(intArr);
        String answer = intArr[0] + " " + intArr[arrLen-1];
        return answer;
    }
}
