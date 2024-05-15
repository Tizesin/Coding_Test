#include <iostream>
#include <string>

int main(void)
{
    std::string str;

    std::cin >> str;

    // 1) 입력받은 문자열에서 XXXX를 찾아 AAAA로 변경
    while(str.find("XXXX") != std::string::npos)
        str.replace(str.find("XXXX"),4,"AAAA");

    // 2) 1)진행 후 남은 문자열에서 XX를 찾아 BB로 변경
    while(str.find("XX") != std::string::npos)
        str.replace(str.find("XX"),2,"BB");

    // 3) 1,2번 진행 후 남은 문자열에 X가 있다면..?
    if(str.find("X") != std::string::npos)
        str = "-1";

    std::cout << str << std::endl;
    return 0;
}