#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int find_roots(int a, int b, int c);

void main() {
	int num1, num2, num3;
	printf("Enter 3 numbers\n");
	scanf("%d%d%d", &num1, &num2, &num3);
	printf("The number of roots is %d\n", find_roots(num1, num2, num3));
}

int find_roots(int a, int b, int c) {
	if ((b * b) - 4 * (a * c) < 0) return 0;
	else if ((b * b) - 4 * (a * c) == 0) return 1;
	else return 2;
}