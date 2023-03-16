#include <iostream>
#include <bits/stdc++.h>
using namespace std;
 
int main()
{
    int n;
    cin >>n;
    vector<int> vec(n);
    for(int &i : vec){
        cin >> i;
    }
    vector<int>inc;
    vector<int>dec;
    std::sort(vec.begin(), vec.end());
    bool flag = true;
    for(int i=0; i<vec.size(); i++){
        int cnt = 1;
        inc.push_back(vec[i]);
        while(i+1 < n && vec[i+1] == vec[i]){
            dec.push_back(vec[i]);
            cnt++;
            i++;
        }
        if(cnt > 2){
            flag = false;
            cout<<"NO";
            break;
        }
        
    }
    if(flag){
        cout<<"YES"<<endl;
        cout<<inc.size()<<endl;
        for(int i : inc)cout<<i << " ";
        cout<<endl;
        cout<<dec.size()<<endl;
        for(int i= dec.size()-1; i >= 0; i--){
            cout<<dec[i]<<" ";
        }
        cout<<endl;
    }
 
    return 0;
}