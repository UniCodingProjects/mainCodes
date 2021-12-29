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
	printf("The the word %s appears %d times in the sentence\n",word, countWordIFExists(sent,word));
}

int countWordIFExists(char* sent, char* word) {
	char* pointWord = word;
	char* pointSent;
	int flag=0;
	for (pointSent = sent; pointSent < sent + strlen(sent); pointSent++) {
		if (*pointSent == *pointWord) {
			for (int i = 1; i < strlen(word); i++) {
				if ((i == strlen(word) - 1)) flag++;
				else if (*(pointSent + i) != *(pointWord + i)) break;
			}
		}
	}
	return flag;
}