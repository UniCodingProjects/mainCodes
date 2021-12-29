#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	int arr[5] = { 0 };
	int min, max=0,sum=0;
	float avg = 0;
	printf("Enter 5 numbers:\n");
	scanf("%d%d%d%d%d", &arr[0], &arr[1], &arr[2], &arr[3], &arr[4]);
	min = arr[0];
	max = arr[0];
	for (int i = 0; i < (sizeof(arr) / 4); i++) {
		if (arr[i] > max) {
			max = arr[i];
		}
		if (arr[i] < min) {
			min = arr[i];
		}
		sum = sum + arr[i];
	}
	avg = sum / (float)(sizeof(arr) / 4);
	printf("Min value is: %d\n", min);
	printf("Max value is: %d\n", max);
	printf("The sum of all numbers is: %d\n", sum);
	printf("The average of all numbers is: %f\n", avg);
}