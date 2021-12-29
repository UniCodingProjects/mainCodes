#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	int num1, num2, num3;
	printf("Enter the first number:\n");
	scanf("%d", &num1);
	printf("Enter the second number:\n");
	scanf("%d", &num2);
	printf("Enter the third number:\n");
	scanf("%d", &num3);
	printf("The largest number = %d", (num1 >= num2) && (num1 >= num3) ? num1 : (num2 >= num3) ? num2 : num3);
}