#define _CRT_NO_SECURE_WARNINGS
#include <stdio.h>

void main() {
	int arr1[] = { 12,15,5,88,234,1,18,115,14,6 };
	int arr2[] = { 234,4,567,5,88,6,45,113,1,72 };
	int flag = 0;

	printf("The following numbers were found in both arrays: \n");
	for (int i = 0; i < (sizeof(arr1) / 4); i++) {
		for (int j = 0; j < (sizeof(arr2) / 4); j++) {
			if (arr1[i] == arr2[j]) {
				printf("%d\n", arr1[i]);
			}
			else flag++;
		}
	}
	if (flag == (sizeof(arr1)/4)*(sizeof(arr2)/4)) printf("No numbers were found in both arrays\n");
}