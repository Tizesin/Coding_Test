import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int video_len_int = cal(video_len);
        int pos_int = cal(pos);
        int op_start_int = cal(op_start);
        int op_end_int = cal(op_end);
        for(int i = 0; i < commands.length; i++){
            String command = commands[i];
            if(op_start_int <= pos_int && op_end_int > pos_int)
                pos_int = op_end_int;
            switch(commands[i]){
                case "next":
                    pos_int += 10;
                    if(pos_int > video_len_int)
                        pos_int = video_len_int;
                    break;
                case "prev":
                    pos_int -= 10;
                    if(pos_int < 0)
                        pos_int = 0;
                    break;
            }
            if(op_start_int <= pos_int && op_end_int > pos_int)
                pos_int = op_end_int;
        }
        System.out.println(pos_int);
        String result = String.format("%02d",pos_int/60) + ":" + String.format("%02d",pos_int%60);
        return result;
    }
    public int cal(String value){
        String[] time = value.split(":");
        return Integer.parseInt(time[0])*60 + Integer.parseInt(time[1]);
    }
}
