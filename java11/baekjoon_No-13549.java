import java.io.*;
import java.util.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        String[] position = br.readLine().split(" ");
        int N = Integer.parseInt(position[0]);
        int M = Integer.parseInt(position[1]);

        sb.append(bfs(N, M));
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    
    public static int bfs(int start, int target) {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[100001];
        deque.offer(new int[]{start, 0});

        while (!deque.isEmpty()) {
            int[] current = deque.poll();
            int pos = current[0];
            int time = current[1];

            if (pos == target) return time;
            if (pos < 0 || pos > 100000 || visited[pos]) continue;

            visited[pos] = true;

            // 0초 걸리는 이동을 먼저 처리
            if (pos * 2 <= 100000 && !visited[pos * 2])
                deque.addFirst(new int[]{pos * 2, time});
            
            if (pos - 1 >= 0 && !visited[pos - 1])
                deque.addLast(new int[]{pos - 1, time + 1});
            
            if (pos + 1 <= 100000 && !visited[pos + 1])
                deque.addLast(new int[]{pos + 1, time + 1});
        }
        return -1;
    }
}
