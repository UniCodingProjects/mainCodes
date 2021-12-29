#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void armstrong(int num);
int digits(int num);
int pow(int num, int exponent);
int digitCalculation(int num);

void main() {
	int num;
	printf("Enter a number\n");
	scanf("%d", &num);
	armstrong(num);
}

void armstrong(int max) {
	int res=0;
	for (int i = 1; i <= max; i++) {
		res = digitCalculation(i);
		if (i == res) {
			printf("The number %d is an Armstrong number\n", i);
		}
	}
}

int digits(int num) {
	int counter = 0;
	for (int i = 1; i <= num; i * 10) {
		if (num > 0 && num % 10 >= 0)
			counter++;
		num = num / 10;
	}
	return counter;
}

int pow(int num, int exponent) {
	int res = 1;
	for (int j = 1; j <= exponent; j++) {
		res = res * num;
	}
	return res;
}

int digitCalculation(int num) {
	int res = 0;
	for (int i = 0; i < digits(num); i++) {
		res += pow(num / pow(10, i) % 10,digits(num)) ;
	}
	return res;
}
