import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            Queue<Integer> que = new LinkedList<>();
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            Arrays.fill(command, "");
            Arrays.fill(visited, false);

            String[] line = br.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int goal = Integer.parseInt(line[1]);
            que.add(start);
            visited[start] = true;

            sb.append(bfs(que, visited, command, goal));
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static String bfs(Queue<Integer> que, boolean[] visited, String[] command, int goal) {
        while (!que.isEmpty() && !visited[goal]) {
            int current = que.poll();
            for (String cmd : List.of("D", "S", "L", "R")) {
                int idx = 0;
                switch (cmd) {
                    case "D": idx = (2 * current) % 10000; break;
                    case "S": idx = current == 0 ? 9999 : current - 1; break;
                    case "L": idx = (current % 1000) * 10 + current / 1000; break;
                    case "R": idx = (current % 10) * 1000 + current / 10; break;
                }
                if (!visited[idx]) {
                    visited[idx] = true;
                    que.offer(idx);
                    command[idx] = command[current] + cmd;
                }
            }
        }
        return command[goal];
    }
}
