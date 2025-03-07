#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

int cityCount, busCount;
int node[2]; // 0: 출발 노드, 1: 도착 노드

vector<vector<pair<int, int>>> graph; // 인접 리스트 (도시 → {연결된 도시, 비용})
vector<int> dist; // 최단 거리 저장

void dijkstra(int startNode) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, startNode}); // {현재까지 거리, 현재 노드}
    dist[startNode] = 0;

    while (!pq.empty()) {
        int currentDist = pq.top().first;
        int currentNode = pq.top().second;
        pq.pop();

        if (currentDist > dist[currentNode]) continue; // 기존 거리보다 크면 무시

        for (auto& edge : graph[currentNode]) {
            int nextNode = edge.first;
            int weight = edge.second;

            if (dist[nextNode] > currentDist + weight) { // 최단 거리 갱신
                dist[nextNode] = currentDist + weight;
                pq.push({dist[nextNode], nextNode});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> cityCount >> busCount;
    graph.resize(cityCount + 1);
    dist.assign(cityCount + 1, numeric_limits<int>::max());

    for (int i = 0; i < busCount; i++) {
        int from, to, cost;
        cin >> from >> to >> cost;
        graph[from].push_back({to, cost});
    }

    cin >> node[0] >> node[1];

    dijkstra(node[0]);

    cout << dist[node[1]] << endl; // 출발 노드에서 도착 노드까지의 최단 거리 출력
    return 0;
}
