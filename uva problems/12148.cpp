#include <iostream>
#include "bits/stdc++.h"
#define FASTIO ios_base::sync_with_stdio(0),cin.tie(0),cout.tie(0);

using namespace std;
struct date {
	int day;
	int month;
	int year;
	int consumption;
};
int modD(date d) {
	int y = d.month;
	int x = d.day;
	int w = d.year;
	if ( y == 4 || y == 6 || y == 11 || y==9) {
		x %= 30;
	}
	else if(y == 2){
		if (!(w % 4) ) {
			if (!(w % 100)) {
				if (!(w % 400)) {
					x %= 29;
				}
			}
			else {
				x %= 29;
			}
		}
		else {
			x %= 28;
		}
	}
	else {
		x %= 31;
	}
	return x;
}
int main() {
	FASTIO;
	int n;
	while (cin >> n && n) {
		date* test = new date[n];
		for (int i = 0; i < n; i++) {
			date d;
			int x, y, w, z;cin >> x >> y >> w >> z;
			d.day = x;
			d.month = y;
			d.year = w;
			d.consumption = z;
			test[i] = d;
		}
		int cnt = 0;
		int cons = 0;
		for (int i = 1; i < n; i++) {
			date d1 = test[i - 1];
			date d2 = test[i];
			int x1 = d1.day + d1.month + d1.year;
			int x2 = d2.day + d2.month + d2.year;
			if (d1.year == d2.year) {
				if (d1.month == d2.month) {
					if (d2.day - d1.day == 1) {
						++cnt;
						cons += (d2.consumption - d1.consumption);
					}
				}
				else if(d2.month - d1.month == 1){
					if (d2.day == 1 && modD(d1) == 0) {
						++cnt;
						cons += (d2.consumption - d1.consumption);
					}
				}
			}
			else if (d2.year - d1.year == 1) {
				if (d2.month == 1 && d1.month == 12) {
					if (d2.day == 1 && modD(d1) == 0) {
						++cnt;
						cons += (d2.consumption - d1.consumption);
					}
				}
			}
			
		}
		cout << cnt << " " << cons << endl;
	}

}

