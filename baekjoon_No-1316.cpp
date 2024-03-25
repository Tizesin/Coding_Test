#include <iostream>
#include <stdio.h>
#include <cstring>

int main()
{
    int word_input_cnt = 0; 
    int result_val = 0;
    char word[101];
    char alp[1];
    //string alp_t;
    std::string word_str;

    scanf("%d", &word_input_cnt);
    result_val = word_input_cnt;
    while(word_input_cnt){
        scanf("%101s", word);
        word_str = word;
        
        for(int i=0;i<strlen(word);i++){
            std::string alp_t = word_str.substr(i,1);
            if(word[i]!=word[i+1]){
                std::string word_str_remaining = word+i+1;
                //printf("word+i+1 : %s\n",word_str_remaining.c_str());
                //printf("alp_t : %s\n",alp_t.c_str());
                size_t found = word_str_remaining.find(alp_t);
                if(found != std::string::npos){
                    result_val--;
                    break;
                }
            }
        }
        word_input_cnt--;
    }
    printf("%d\n",result_val);
}