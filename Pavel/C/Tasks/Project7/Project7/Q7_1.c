#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#define SIZE 5

int kFour(int arr[SIZE][SIZE]);

void main(){
	int arr[SIZE][SIZE];
	printf("Please enter 25 positive numbers: \n");
	for (int i = 0; i < SIZE ; i++) {
		for (int j = 0; j < SIZE ; j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] < 0) {
				printf("Entered a negative number please enter a positive number: \n");
				j--;
			}
		}
	}
	if (kFour(arr) != -1) printf("Exists in the array four %d", kFour(arr));
	else printf("Doesnt exists in the four K array");
}

int kFour(int arr[SIZE][SIZE]) {
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			if (arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 1][j + 1] && arr[i][j] == arr[i][j + 1]) return arr[i][j];
		}
	}
	return -1;
}