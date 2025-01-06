import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            String command = br.readLine();
            int arraySize = Integer.parseInt(br.readLine());
            boolean reverse = false;
            String str = br.readLine();
            List<String> arr = new ArrayList<>(Arrays.stream(str.substring(1, str.length() - 1).split(","))
                    .collect(Collectors.toList()));

            for (int i = 0; i < command.length(); i++) {
                if(arraySize < 0)
                    break;
                switch (command.charAt(i)){
                    case 'R':
                        reverse = !reverse;
                        break;
                    case 'D':
                        arraySize--;
                        if(arraySize < 0){
                            break;
                        }
                        String noUsed = reverse ? arr.remove(arr.size() - 1) : arr.remove(0);
                        break;
                }
            }
            if (arraySize < 0) {
                sb.append("error\n");
                continue;
            }
            int startIdx = reverse ? arraySize - 1 : 0;
            int endIdx = reverse ? 0 : arraySize - 1;
            sb.append("[");
            if(reverse){
                for (int i = startIdx; i > endIdx - 1; i--) {
                    sb.append(arr.get(i));
                    if(i != 0){
                        sb.append(",");
                    }
                }
            }else{
                for (int i = startIdx; i < endIdx + 1; i++) {
                    sb.append(arr.get(i));
                    if(i != endIdx){
                        sb.append(",");
                    }
                }
            }
            sb.append("]\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
