#include <iostream>
#include <bits/stdc++.h>
using namespace std;

vector<int> max_array(vector<int> & max_arr, const vector<int>& nums);

int difference(const vector<int>& max_arr, int l, int r , int key, int & diff);

int max_difference(const  vector<int>& nums);

int main() {
    vector<int> nums1 = {34, 8, 10, 3, 2, 80, 30, 33, 1};
    cout<<max_difference(nums1)<<endl;
    vector<int> nums2 = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
    cout<<max_difference(nums2)<<endl;
    vector<int> nums3 = {1, 2, 3, 4, 5, 6};
    cout<<max_difference(nums3)<<endl;
    vector<int> nums4 = {6, 5, 4, 3, 2, 1};
    cout<<max_difference(nums4)<<endl;

    return 0;
}

vector<int> max_array(vector<int>& max_arr, const vector<int>& nums){
    int n = nums.size();
    max_arr.resize(n + 1, INT_MIN);
    for(int i=n-1; i>=0; i--){
        max_arr[i] = max(max_arr[i+1], nums[i]);
    }
    return max_arr;
}

int difference(const vector<int>& max_arr, int l , int r, int key, int & diff){
    if( l >  r){
        return diff;
    }
    int mid = (l + r)/2;
    if(max_arr[mid] > key){
        diff = mid;
        return difference(max_arr, mid + 1, r, key, diff);
    }
    else{
        return difference(max_arr, l, mid - 1, key, diff);
    }
}

int max_difference(const vector<int>& nums){
    int diff = -1;
    int n = nums.size();
    vector<int>max_vec;
    max_array(max_vec, nums);
    for(int i=0; i < n; i++){
        int local_diff = -1;
        difference(max_vec,i, n-1, nums[i], local_diff);
        local_diff-= i;
        diff = max(diff , local_diff);
    }
    return diff;
}