#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main()
{
	int a;
	printf("enter a number: \n");
	scanf("%d", &a);
	printf("%c\n", foo(a) + 'a');
}

int foo(int a) {
	int total = 0;
	for (int i = 1; i < a; i++) {
		if (a % i == 0) {
			total += i;
		}
	}
	return total;
}