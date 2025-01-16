import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int meetingCount = Integer.parseInt(br.readLine());
        int[][] meetingTime = new int[meetingCount][2];

        for (int i = 0; i < meetingCount; i++) {
            String[] line = br.readLine().split(" ");
            meetingTime[i][0] =  Integer.parseInt(line[0]);
            meetingTime[i][1] =  Integer.parseInt(line[1]);
        }

        Arrays.sort(meetingTime, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int meetingEndTime = 0;

        for (int[] time : meetingTime) {
            if(time[0] >= meetingEndTime ){
                meetingEndTime = time[1];
                result++;
            }
        }
        sb.append(result);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
