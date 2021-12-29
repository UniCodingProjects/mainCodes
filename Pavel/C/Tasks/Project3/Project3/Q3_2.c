#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

void main() {
	float convert;
	char temp;
	printf("Enter C to convert to Celcius or F to convert to Fahrenheit\nEnter your choice (C/F):");
	scanf(" %c", &temp);

	switch (temp) {
	case 'c':
	case 'C':
		printf("Enter temperature in Fahrenheit: ");
		scanf("%f", &convert);
		convert = (convert - 32) * 5 / 9;
		printf("The temperature in Celcius is: %.2f", convert);
		break;
	case 'f':
	case 'F':
		printf("Enter temperature in Celcius: ");
		scanf("%f", &convert);
		convert = (convert * 9 / 5) + 32;
		printf("The temperature in Fahrenheit is: %.2f", convert);
		break;
	default:
		printf("Invalid choice");
		break;
	}
}