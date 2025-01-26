import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        String firstLine = br.readLine();
        String secondLine = br.readLine();
        int[][] dpArray = new int[firstLine.length()][secondLine.length()];
        int max = 0;
        for (int i = 0; i < firstLine.length(); i++) {
            int stack = 0;
            for (int j = 0; j < secondLine.length(); j++) {
                if(i > 0 && stack < dpArray[i-1][j]){
                    stack = dpArray[i-1][j];
                }
                if(firstLine.charAt(i) == secondLine.charAt(j)){
                    if(i > 0 && j > 0) {
                        dpArray[i][j] = dpArray[i - 1][j - 1] + 1;
                        stack = dpArray[i][j];
                    }else{
                        stack = dpArray[i][j] + 1;
                    }
                }
                dpArray[i][j] = stack;
                max = Math.max(max, stack);
//                System.out.print(dpArray[i][j] + " ");
            }
//            System.out.println();
        }
        sb.append(max);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
