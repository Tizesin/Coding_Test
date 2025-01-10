import java.io.*;
import java.util.*;

public class Main {
    static Map<String, List<String>> map = new HashMap<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int computerCount = Integer.parseInt(br.readLine());
        int lineCount = Integer.parseInt(br.readLine());
        visited = new boolean[computerCount+1];
        for (int i = 1; i <= computerCount; i++) {
            List<String> list = new ArrayList<>();
            map.put(Integer.toString(i),list);
        }

        for (int i = 0; i < lineCount; i++) {
            String[] line = br.readLine().split(" ");
            map.get(line[0]).add(line[1]);
            map.get(line[1]).add(line[0]);
        }

        sb.append(dfs());

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static int dfs(){
        int totalResult = 0;
        Queue<String> que = new LinkedList<>();
        que.offer("1");
        while (!que.isEmpty()) {
            String target = que.poll();
            List<String> targets = map.get(target);
            for (int i = 0; i < targets.size(); i++) {
                if(!visited[Integer.parseInt(targets.get(i))] && !(targets.get(i).equals("1"))) {
                    que.offer(targets.get(i));
                    visited[Integer.parseInt(targets.get(i))] = true;
                    totalResult++;
//                    System.out.println(targets.get(i) + " : "+ visited[Integer.parseInt(targets.get(i))]);
                }
            }
        }
        return totalResult;
    }
}
