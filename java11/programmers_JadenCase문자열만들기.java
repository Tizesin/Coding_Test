import static java.lang.Character.toUpperCase;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        arr[0] = toUpperCase(arr[0]);
        boolean needUpper = false;
        for(int i = 0; i<arr.length-1; i++){
            if(arr[i] == ' ')
                arr[i+1] = toUpperCase(arr[i+1]);
        }
        String str = String.valueOf(arr);
        return str;
    }
}
