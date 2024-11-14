import java.util.*;

class Solution {
    int[] dx = {0, 1, -1, 0};
    int[] dy = {1, 0, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        int[][] visited = new int[maps.length][maps[0].length];
        bfs(maps, visited);
        answer = visited[maps.length - 1][maps[0].length - 1];
        if (answer == 0)
            answer = -1;
        return answer;
    }
    
    public void bfs(int[][] maps, int[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = 1;
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int X = current[0];
            int Y = current[1];
            for (int i = 0; i < 4; i++) {
                int nX = X + dx[i];
                int nY = Y + dy[i];
                if (nX < 0 || nX > maps.length - 1 || nY < 0 || nY > maps[0].length - 1) 
                    continue;

                if (visited[nX][nY] == 0 && maps[nX][nY] == 1) {
                    visited[nX][nY] = visited[X][Y] + 1;
                    q.add(new int[]{nX, nY});
                }
            }
        }
    }
}
