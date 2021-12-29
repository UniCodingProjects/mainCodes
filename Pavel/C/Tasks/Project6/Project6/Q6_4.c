#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define SIZE 10

void main() {
	int arr[SIZE];
	int arrNew[SIZE] = { 0 };
	int counter = 0;
	printf("Please enter 10 numbers: ");
	for (int i = 0; i < SIZE; i++) {
		scanf("%d", &arr[i]);
		if (arr[i] >= 0) {
			arrNew[counter] = arr[i]; // add all positive numbers to temporary array
			counter++;
		}
	}

	for (int j = 0; j < SIZE; j++) { // add negative numbers to temporary array
		if (arr[j] < 0) {
			arrNew[counter] = arr[j];
			counter++;
		}
	}

	for (int k = 0; k < SIZE; k++) {
		arr[k] = arrNew[k]; // change original array back
		printf("%d\t", arr[k]);
	}
}