#include <iostream>
#include <algorithm>
using namespace std;

int main() 
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
	int num, DP[1000000] = {0,};
	cin >> num;

	for (int i = 2; i <= num; i++) {
		DP[i] = DP[i - 1] + 1;

		if (i % 2 == 0) 
			DP[i] = min(DP[i], DP[i / 2] + 1);
		if (i % 3 == 0) 
			DP[i] = min(DP[i], DP[i / 3] + 1);
	}
	std::cout << DP[num];
	return 0;
}