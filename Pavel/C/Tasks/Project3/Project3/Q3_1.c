#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	int num;
	printf("Please enter a number: \n");
	scanf("%d", &num);
	if(num>0)printf("The number is positive");
	else if(num<0) printf("The number is negative");
	else printf("The number is zero");
}