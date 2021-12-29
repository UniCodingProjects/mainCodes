#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	int number,firstPair,secondPair;
	printf("Please enter a 4 digit number ");
	scanf("%d", &number);
	firstPair = (number / 100 % 10 * 10) + (number / 1000);
	secondPair = (number % 10 * 10) + (number / 10 % 10);

	printf("The original number is %d - after mixing digit pairs %d%d\n", number,firstPair,secondPair);

}