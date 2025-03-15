#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> getMaxNumbers(int a, int b, int c) {
    int maxVal = max({a, b, c});
    vector<int> result;

    if (a == maxVal) result.push_back(1);
    if (b == maxVal) result.push_back(2);
    if (c == maxVal) result.push_back(3);

    return result;
}

vector<int> solution(vector<int> answers) {
    int person_1[5] = {1,2,3,4,5};
    int person_2[8] = {2,1,2,3,2,4,2,5};
    int person_3[10] = {3,3,1,1,2,2,4,4,5,5};
    int score_1 = 0, score_2 = 0, score_3 = 0;
    for(int i = 0; i < answers.size(); i++){
        int answer = answers[i];
        if(person_1[i%5] == answer)
            score_1++;
        if(person_2[i%8] == answer)
            score_2++;
        if(person_3[i%10] == answer)
            score_3++;
    }
    return getMaxNumbers(score_1,score_2,score_3);
}
