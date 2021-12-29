#include <stdio.h>

void main() {
	const int ONE = 1;
	float pi=4,odd=0,even=0;
	for (int i = 1 ; i < 1000 ; i++) {
		if (i % 2) {
			even = (float) even + ((float)ONE / (ONE + (i * 2)));
		}
		else {
			odd = (float) odd + ((float) ONE / (ONE + (i * 2)));
		}
	}
	pi = (float)pi * (ONE + odd - even);
	printf("Pi is approximately %.4f\n", pi);
}