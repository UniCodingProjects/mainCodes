#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	int base;
	printf("Enter base size: ");
	scanf("%d", &base);

	if (base % 2 == 0) { // even base
		for (int i = 1; i < base / 2; i++) {

			for (int j = 1; j <= i; j++) {
				printf("*");
			}
			for (int k = 1; k < base + 1 - i; k++) {
				printf("#");
			}
			printf("\n");
		}
		for (int i = (base / 2)-1; i > 1; i--) {

			for (int j = 1; j < i; j++) {
				printf("*");
			}
			for (int k = 1; k < base + 2 - i; k++) {
				printf("#");
			}
			printf("\n");
		}
	}
	else if (base % 2 == 1) { // odd base
		for (int i = 1; i <= base / 2; i++) {

			for (int j = 1; j <= i; j++) {
				printf("*");
			}
			for (int k = 1; k < base + 1 - i; k++) {
				printf("#");
			}
			printf("\n");
		}
		for (int i = (base / 2); i > 1; i--) {

			for (int j = 1; j < i; j++) {
				printf("*");
			}
			for (int k = 1; k < base + 2 - i; k++) {
				printf("#");
			}
			printf("\n");
		}
	}
}