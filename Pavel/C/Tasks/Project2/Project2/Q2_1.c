#include <stdio.h>

void main() {
	int number = 239, digitSum = (number / 100) + (number / 10 % 10) + (number % 10);
	double averageOfSum = digitSum/3.0;

	printf("The number is %d, the sum of his digits is %d and the average is %.2f\n", number, digitSum, averageOfSum);

}