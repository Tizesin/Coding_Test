#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

struct party_info
{
    bool know_true = false;
    vector<int> party_member;
};
struct people_info
{
    bool know_true = false;
    vector<int> join_party;
};

int main() 
{
    int people, party_cnt;
    int know_people_cnt, mknow_people, mparty_size, mparty_member;
    
    cin >> people >> party_cnt;
    people_info m_people_info[people];
    party_info m_party_info[party_cnt];
    int can_talk_false = party_cnt;

    cin >> know_people_cnt;
    for(int j = 0; j < know_people_cnt; j++)
    {
        cin >> mknow_people;
        m_people_info[mknow_people].know_true = true;
    }
    for(int i = 0; i < party_cnt; i++){
        cout << party_cnt << "|" << i << endl;
        cin >> mparty_size;
        for(int j = 0; j < mparty_size; j++)
        {
            cin >> mparty_member;
            m_party_info[i].party_member.push_back(mparty_member);
            m_people_info[mparty_member].join_party.push_back(i);
            if(m_people_info[mparty_member].know_true == true){
                m_party_info[i].know_true = true;
            }
        }
    }
    for(int A = 0; A < party_cnt; A++){
        bool need_while_restart = false;
        if(m_party_info[A].know_true == true){
            for(int i = 0; i < m_party_info[A].party_member.size(); i++){
                if(m_people_info[i].know_true == false){
                    need_while_restart = true;
                    for(int j = 0; j < m_people_info[i].join_party.size(); j++){
                        m_party_info[j].know_true = true;
                    }
                }
                m_people_info[i].know_true = true;
                if(need_while_restart){
                    A = 0;
                    continue;
                }
            }
        }
    }
    for(int i = 0; i < party_cnt; i++){
        if(m_party_info[i].know_true == true)
            can_talk_false--;
    }
    cout << can_talk_false;
}