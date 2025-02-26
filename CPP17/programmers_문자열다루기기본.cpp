#include <string>
#include <vector>

using namespace std;

bool solution(string s) {
    bool answer = true;
    for(int i = 0; i < s.length(); i++){
        char ch = s[i];
        if( ch < '0' || ch > '9')
            return false;
    }
    if(s.length() != 4 && s.length() != 6)
        return false;
    return answer;
}
