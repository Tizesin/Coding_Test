import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int jemma = Integer.parseInt(arr[0]);
        int fNum = 0;
        for(int i = 2; i < arr.length; i+=2){
            if(arr[i-1].equals("-")){
                fNum = checkAbsMaxValue(Arrays.copyOfRange(arr,i+1,arr.length));
                if(fNum < 0)
                    jemma = jemma + (( fNum + Integer.parseInt(arr[i]) ) * -1);
                else
                    jemma = jemma + fNum - Integer.parseInt(arr[i]);
                break;
            }else{
                jemma += Integer.parseInt(arr[i]);
            }
        }
        
        return jemma;
    }
    
    public int checkAbsMaxValue(String arr[]){
        int MaxValue = getMaxValue(arr);
        int MinValue = getMinValue(arr);
        
        if(Math.abs(MaxValue) > Math.abs(MinValue)){
            return MaxValue;
        }
        return MinValue;
    }
    
    public int getMinValue(String arr[]){
        int result = 0;
        boolean minusflag = false;
        for(int i = 1; i < arr.length; i += 2){
            if(!minusflag) {
                if(arr[i-1].equals("-")) {
                    minusflag = true;
                    result -= Integer.parseInt(arr[i]);
                }else{
                    result += Integer.parseInt(arr[i]);
                }
            }else{
                result -= Integer.parseInt(arr[i]);
            }
        }
        return result;
    }
    
    public int getMaxValue(String arr[]) {
        int result = 0;
        int zNum = 0;
        
        //endPoint
        if(arr.length == 2){
            if(arr[0].equals("-")){
                result -= Integer.parseInt(arr[1]);
            }else{
                result += Integer.parseInt(arr[1]);
            }
        }
        
        
        for(int i = 1; i < arr.length; i += 2){
            if(arr[i-1].equals("-")){
                zNum = checkAbsMaxValue(Arrays.copyOfRange(arr,i+1,arr.length));
                if(zNum < 0)
                    result = result + (( zNum + Integer.parseInt(arr[i]) ) * -1);
                else
                    result = result + zNum - Integer.parseInt(arr[i]);
                break;
            }else{
                result += Integer.parseInt(arr[i]);
            }
        }
        return result;
    }
}
