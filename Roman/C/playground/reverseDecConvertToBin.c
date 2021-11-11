/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>
#include <stdbool.h>

void reverse(bool arr[], int l);
void printy(bool[], int);
void toDec(bool[], int);



int poW(int n, int i){
    int p;
    int res = 1;
    for (p = 1; p <= i; p++){
        res *= 2;
    }
    return res;
}

int getLength(int num){
    int i = 1;
    bool t = true;
    while (t){
        if (poW(2, i) > num){
            return i;
        }
        i++;
    }
    return -1;
}


void printy(bool arr[], int l){
    int j;
    printf("the binary repr = ");
    for (j=0;j<l;j++){
        printf("%d", arr[l-j-1]);
    }
    printf("\n");
}

bool convertToBin(int num){
    int l = getLength(num);
    // printf("length = %d\n", l);
    bool arr[l];
    int res = poW(2, l-1);
    int i = 0;

    int j;
    for (j=0;j<l;j++){
        arr[j] = false;
    }
    arr[l-1] = true;
    while (true){
        if (res >= num){
            break;
        }
        else{
            if (poW(2, i) + res > num){
                arr[i-1] = true;
                res += poW(2, i-1);
                i=0;
            }
            else if (arr[i+1] == true && i+1 != l-1){
                arr[i] = true;
                res += poW(2, i);
                i=0;
            }
            else{
                i++;
                if (i == l){
                    i = 0;
                }
            }
        }
    }
    printy(arr, l);
    reverse(arr, l);
}

void reverse(bool arr[], int l){
    int i = 0;
    bool temp;
    int j = l-1;
    while (i < j){
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
    }
    printy(arr, l);
    toDec(arr, l);
}


void toDec(bool arr[], int l){
    int res;
    int i;
    for (i=0;i<l;i++){
        if (arr[i]){
            int p = poW(2, i);
            // printf("the P is= %d\n", p);
            res += p;
        }
    }
    printf("the reversed num as dec repr: %d", res);
}

void clear(){
    printf("\e[1;1H\e[2J");
}

void main()
{
    int num;
    printf("Enter a num: ");
    scanf("%d", &num);
    clear();
    printf("Entered num: %d \n", num);
    convertToBin(num);
}
