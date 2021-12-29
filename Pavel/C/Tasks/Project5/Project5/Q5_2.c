#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int find_power(int num);
int merge_numbers(int n, int m);

void main() {
	int num, num2;
	printf("Enter a number\n");
	scanf("%d%d", &num, &num2);
	printf("The merged number is %d\n", merge_numbers(num, num2));
}

int find_power(int num) {
	int counter = 0;
	for (int i = 1; i <= num; i * 10) {
		if (num > 0 && num % 10 >= 0)
			counter++;
		num = num / 10;
	}
	return counter;
}

int merge_numbers(int n, int m) {
	int res,digits = find_power(n);
	for (int j = 1; j <= digits ; j++) {
		n = n * 10;
	}
	return res = n + m;
}