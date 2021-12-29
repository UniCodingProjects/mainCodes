#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>
#define SIZE 50
#define SIZEWORD 10

int countWordIFExists(char* sent, char* word);

void main() {
	char word[SIZEWORD], sent[SIZE];
	printf("Please enter a sentence: ");
	gets(sent);
	printf("Please enter a word: ");
	gets(word);
	printf("The the word %s appears %d times in the sentence\n", word, countWordIFExists(sent, word));
}

int countWordIFExists(char* str, char* word) {
	char* pointWord=word;
	char* pointSent;
	int temp=0,count=0;
	while (*str) {
		if (*pointWord != *str) str++;
		else if (*pointWord == *str) {
			pointWord++;
			str++;
			count++;
			if (count == strlen(word)) {
				temp++;
				count = 0;
				pointWord = word;
			}
		}
	}
	return temp;
}