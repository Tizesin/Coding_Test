class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[][] buttonPosition = {
                {0,1}, // 0
                {3,0}, // 1
                {3,1}, // 2
                {3,2}, // 3
                {2,0}, // 4
                {2,1}, // 5
                {2,2}, // 6
                {1,0}, // 7
                {1,1}, // 8
                {1,2}  // 9
        };
        int[] rightHandPosition = {0,2};
        int[] leftHandPosition = {0,0};
        for(int idx = 0; idx < numbers.length; idx++){
            int[] needPushButton = buttonPosition[numbers[idx]];
            String calResult;
            switch (numbers[idx]){
                case 1:
                case 4:
                case 7:
                    leftHandPosition = needPushButton;
                    calResult = "L";
                    break;
                case 3:
                case 6:
                case 9:
                    rightHandPosition = needPushButton;
                    calResult = "R";
                    break;
                default:
                    calResult = shortestDistance(rightHandPosition,leftHandPosition,
                            needPushButton,hand);
                    if(calResult.equals("L"))
                        leftHandPosition = needPushButton;
                    else
                        rightHandPosition = needPushButton;
            }
            answer += calResult;
            // System.out.print("L : "+leftHandPosition[0] + " : " + leftHandPosition[1]);
            // System.out.println(" | R : "+rightHandPosition[0] + " : " + rightHandPosition[1]);
        }
        return answer;
    }
    public String shortestDistance(int[] R, int[] L, int[] destination,String hand) {
        int leftDistance = Math.abs(L[0]-destination[0])+Math.abs(L[1]-destination[1]);
        int rightDistance = Math.abs(R[0]-destination[0])+Math.abs(R[1]-destination[1]);
        if(leftDistance==rightDistance) {
            return hand.equals("right") ? "R" : "L";
        }
        return leftDistance > rightDistance ? "R" : "L";
    }
}
