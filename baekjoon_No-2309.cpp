#include <iostream>
#include <algorithm>

int main()
{
    int person[9];
    int total_tall = 0;
    
    for(int i = 0; i < 9; i++){
        std::cin >> person[i];
        total_tall += person[i];
    }

    std::sort(person,person+9);

	for (int i = 0; i < 8; i++) {
		for (int j = 1; j < 9; j++) {
			if (total_tall - person[i] - person[j] == 100) {

				for (int a = 0; a < 9; a++) {
					if (a == i || a == j) 
                        continue;
					std::cout << person[a] << std::endl;
				}
				return 0;
			}
		}
	}
}