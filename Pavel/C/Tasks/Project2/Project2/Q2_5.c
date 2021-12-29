#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	int num1,num2,carry1,carry2,carry3,carry4,carry5,binarySum,base=2; //define integers to be used in the code

	printf("Please enter two base numbers: "); //prompt the user to enter two numbers
	scanf("%5d %5d", &num1, &num2); //receive input from the user 

	carry1 = ((num1%10) + (num2%10)) / base * 10; //calculate the first digit to be carried over after addition
	carry2 = ((num1%100/10) + (num2%100/10) + (carry1/10)) / base *100; //calculate the second digit to be carried over after addition
	carry3 = ((num1%1000/100) + (num2%1000/100) + (carry2/100)) / base * 1000; //calculate the third digit to be carried over after addition
	carry4 = ((num1%10000/1000) + (num2%10000/1000) + (carry3/1000)) / base * 10000; //calculate the fourth digit to be carried over after addition
	carry5 = ((num1%100000/10000) + (num2%100000/10000) + (carry4/10000)) / base * 100000; //calculate the fifth digit to be carried over after addition
	binarySum = (((num1%10%base) + (num2%10%base)) % base) + (((((num1%100/10%base) + (num2%100/10%base)) + carry1/10) % base) * 10) + (((((num1%1000/100%base) + (num2%1000/100%base)) + carry2/100) % base) * 100) + (((((num1%10000/1000%base) + (num2%10000/1000%base)) + carry3/1000) % base) * 1000) + (((((num1%100000/10000%base) + (num2%100000/10000%base)) + carry4/10000) % base) * 10000) + carry5; //calculate the sum of the numbers received from the user input

	printf("(%d)%d + (%d)%d = (%d)%d", num1, base, num2, base, binarySum, base); //display the addition and sum of the numbers

}