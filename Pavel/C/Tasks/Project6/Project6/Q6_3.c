#define _CRT_NO_SECURE_WARNINGS
#include <stdio.h>
#define SIZE 10

void main() {
	int arr[] = { 1, 3, 5, 7, 9, 1, 3, 5, 8, 9, 1, 3, 5, 8, 9 };
	int arr2[SIZE] = { 0 };

	for (int i = 0; i < (sizeof(arr) / 4); i++) {
		arr2[arr[i]] += 1;
	}
	for (int j = 0; j < (sizeof(arr2) / 4); j++) {
		printf("%d appears  %d times\n", j , arr2[j]);
	}
}