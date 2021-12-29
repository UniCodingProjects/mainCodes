#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define SIZE 10
#define SIZE2 19

void createString(char str[], char str2[], char str3[]);

void main() {
	char str[SIZE], str2[SIZE], str3[SIZE2];
	printf("Insert first string:\n");
	scanf(" %s", str);
	printf("Insert second string:\n");
	scanf(" %s", str2);
	createString(str, str2, str3);
	printf("New string is: %s\n", str3);
}

void createString(char str[], char str2[], char str3[]) {
	int i=strlen(str),j=strlen(str2),k=0;
	do
	{
		if (str[i - 1] > str2[j - 1] && str3[k] != str[i - 1]) {
			if (k > 0 && str3[k - 1] == str[i - 1]) {
				i--;
				continue;
			}
			str3[k] = str[i - 1];
			i--;
			k++;
		}
		else if (str[i - 1] < str2[j - 1] && str3[k] != str2[j - 1]) {
			if (k > 0 && str3[k - 1] == str2[j - 1]) {
				j--;
				continue;
			}
			str3[k] = str2[j - 1];
			j--;
			k++;
		}
		else if (str[i - 1] == str2[j - 1] && str3[k] != str2[j-1]) {
			if (k > 0 && str3[k - 1] == str2[j - 1]) {
				i--;
				j--;
				continue;
			}
			str3[k] = str2[j - 1];
			i--;
			j--;
			k++;
		}
	} while (i>0 || j> 0);
	str3[k] = '\0';
}