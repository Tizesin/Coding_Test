#include <stdio.h>
#include <iostream>

using namespace std;

int main(void)
{
    int test_case;
    cin >> test_case;
    for(int a = 0; a < test_case; a++){
        int EAST_pin, WEST_pin;
        unsigned long result = 1;
        cin >> WEST_pin >> EAST_pin;
        
        int c = 1;
        for(int i = EAST_pin; i > EAST_pin-WEST_pin; i--){
            result = result * i;
            result = result / c;
            c++;
        }
        cout << result << endl;
    }
    
}