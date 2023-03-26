#include <iostream>
#include "bits/stdc++.h"
using namespace std;

int num_of_diff(string str);
int main() {
	int q;
	cin >> q;
	while (q--) {
		int n, k;
		cin >> n >> k;
		string subs;
		cin >> subs;
		int cntDifference = 10e9;
		for (int i = 0; i < n-k+1; i++) {
			string str = subs.substr(i, k);
			cntDifference = min(cntDifference, num_of_diff(str));
		}
		cout << cntDifference << endl;
	}
}

int num_of_diff(string str) {
	vector<string>vec = { "RGB", "BRG", "GBR" };
	int cnt = 10e9;
	for (string ss : vec) {
		int lcnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str[i] != ss[i % 3]) {
				lcnt++;
			}
		}
		cnt = min(lcnt, cnt);
	}
	return cnt;
}