#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max(); // 무한대 값 설정

// 정점 개수 V, 간선 개수 E
int V, E, K;
vector<vector<pair<int, int>>> graph; // 인접 리스트 (정점, 가중치)
vector<int> dist; // 최단 거리 배열

void dijkstra(int start) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq; // 최소 힙 (거리, 정점)
    dist[start] = 0; // 시작점 거리 0
    pq.push({0, start}); // (거리, 정점)

    while (!pq.empty()) {
        int cost = pq.top().first; // 현재 정점까지의 거리
        int u = pq.top().second;   // 현재 정점
        pq.pop();

        // 이미 처리된 거리보다 크면 무시
        if (cost > dist[u]) continue;

        // 현재 정점에서 갈 수 있는 모든 정점 탐색
        for (auto &edge : graph[u]) {
            int v = edge.first;  // 다음 정점
            int weight = edge.second; // 가중치

            // 더 짧은 거리로 업데이트 가능하면 갱신
            if (dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                pq.push({dist[v], v});
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> V >> E >> K;
    graph.resize(V + 1);
    dist.assign(V + 1, INF);

    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({v, w}); // 방향 그래프
    }

    dijkstra(K);

    // 결과 출력
    for (int i = 1; i <= V; i++) {
        if (dist[i] == INF) cout << "INF\n";
        else cout << dist[i] << "\n";
    }

    return 0;
}
