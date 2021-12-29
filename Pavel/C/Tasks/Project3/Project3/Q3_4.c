#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	int num;
	printf("Please enter a 4 digit number ");
	scanf("%d", &num);
	if (num > 9999 || num < -9999 || num < 1000 && num > -1000)
		printf("Invalid number");
	else if ((num % 10 == num / 1000) && (num / 100 % 10 == num % 100 / 10)) 
		printf("The number is a palindrom");
	else
		printf("The number is a not palindrom");
}