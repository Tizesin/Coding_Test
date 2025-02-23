#include <iostream>
#include <vector>
#include <cstring>  // memset

using namespace std;

const int MAX = 10001;
vector<pair<int, int>> tree[MAX]; // 트리 구조 (연결 노드, 가중치)
bool visited[MAX];
int maxDist = 0;
int farthestNode = 0;

// DFS 탐색
void dfs(int node, int dist) {
    if (visited[node]) return;

    visited[node] = true;

    if (dist > maxDist) {
        maxDist = dist;
        farthestNode = node; // 가장 먼 노드 갱신
    }

    for (auto& next : tree[node]) {
        int nextNode = next.first;
        int weight = next.second;
        dfs(nextNode, dist + weight);
    }
}

int main() {
    int n;
    cin >> n;

    if (n == 1) {  // 노드가 1개이면 지름은 0
        cout << 0 << endl;
        return 0;
    }

    for (int i = 1; i < n; i++) {
        int parent, child, weight;
        cin >> parent >> child >> weight;
        tree[parent].push_back({child, weight});
        tree[child].push_back({parent, weight});
    }

    // 1. 임의의 노드 (1번)에서 가장 먼 노드 찾기
    memset(visited, false, sizeof(visited));
    dfs(1, 0);

    // 2. 찾은 노드에서 가장 먼 노드 찾기
    memset(visited, false, sizeof(visited));
    maxDist = 0;
    dfs(farthestNode, 0);

    cout << maxDist << endl;
    return 0;
}
