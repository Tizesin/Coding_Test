import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String[] line = br.readLine().split(" ");
        int noHeardCount = Integer.parseInt(line[0]); // 듣도 못한 사람 수
        int noSeeCount = Integer.parseInt(line[1]); // 보도 못한 사람 수
        String[] noHeard = new String[noHeardCount];
        String[] noSee = new String[noSeeCount];
        int resultCount = 0;

        for(int i = 0; i < noHeardCount; i++)
            noHeard[i] = br.readLine();
        for(int i = 0; i < noSeeCount; i++)
            noSee[i] = br.readLine();

        Arrays.sort(noHeard);
        Arrays.sort(noSee);

        int seeIdx = 0;
        int heardIdx = 0;
        sb.append("\n");
        while(seeIdx < noSeeCount && heardIdx < noHeardCount){
            int ret = noSee[seeIdx].compareTo(noHeard[heardIdx]);
            if(ret == 0){
                sb.append(noSee[seeIdx] + "\n");
                resultCount++;
                seeIdx++;
            }else if(ret > 0){
                heardIdx++;
            }else{
                seeIdx++;
            }
        }

        bw.write(String.valueOf(resultCount));
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
