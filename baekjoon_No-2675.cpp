#include <iostream>
#include <vector>

using namespace std;

int main()
{
    int Test_case, Repeat;
    string enter_Sentence;
    cin >> Test_case;

    while(Test_case--)
    {
        cin >> Repeat >> enter_Sentence;
        for(int i = 0; i < enter_Sentence.length(); i++)
            for(int j = 0; j < Repeat; j++)
                cout << enter_Sentence[i];
        cout << endl;
    }
}