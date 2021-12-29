#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void triangle(int base);

void main() {
	int base;
	do
	{
		printf("Enter an odd number larger than 1 \n");
		scanf("%d", &base);
		if (base == 1 || base % 2 == 0) printf("This is not an odd number larger than 1, try again\n");
	} while (base == 1 || base % 2 == 0);
	triangle(base);
}

void triangle(int base) {
	for (int i = 1; i <= base/2; i++) {
		for (int j = 0 ; j <= base/2 - i ; j++) printf(" ");
		printf("*");
		if (i > 1) {
			for (int k = 1 ; k < (i-1)*2 ; k++) printf(" ");
			printf("*");
		}
		printf("\n");
	}
	for (int k = 1; k <= base; k++) printf("*");
}