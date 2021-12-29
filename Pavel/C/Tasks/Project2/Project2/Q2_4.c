#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	int num1, num2, num3, num4;
	printf("Please enter 4 numbers\n");
	scanf("%d %d %d %d", &num1, &num2, &num3, &num4);
	printf("The amount of odd numbers is %d", num1 % 2 + num2 % 2 + num3 % 2 + num4 % 2);

}