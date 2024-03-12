#include <iostream>

int main(void)
{
    std::string str;

    std::cin >> str;

    while(str.find("XXXX") != std::string::npos)
        str.replace(str.find("XXXX"),4,"AAAA");
    while(str.find("XX") != std::string::npos)
        str.replace(str.find("XX"),2,"BB");
    if(str.find("X") != std::string::npos)
        str = "-1";

    std::cout << str << std::endl;
    return 0;
}