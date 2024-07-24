class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            long sumMap = arr1[i]|arr2[i];
            answer[i] = String.format("%0"+n+"d",Long.parseLong(Long.toBinaryString(sumMap)));
            answer[i] = answer[i].replaceAll("0"," ");
            answer[i] = answer[i].replaceAll("1","#");
        }
        return answer;
    }
}
