#include <stdio.h>

int poW(int num, int p){
    int res = 1;
    while (p > 0){
        res *= num;
        p--;
    }
    return res;
}

int len(int num){
    int p = 2;
    while (p < 10){
        if (poW(10, p) < num){
            p++;
        }
        else{
            if (p != 9){
                return -1;
            }
            return p;
        }
    }
}

void func(int num){
    int arr[9];
    int i;
    int divisor = 100000000;
    if (len(num) != -1){
        for (i=0; i<9; i++){
            arr[i] = num / divisor;
            num = num % divisor;
            divisor = divisor / 10;
        }
        for (i=0;i<9;i++){
            printf("num at idx %d is: %d\n", i, arr[i]);
        }
    }
    else{
        printf("error");
    }
}

void main()
{
    printf("Enter a num with 9 digits: ");
    int num;
    scanf("%d", &num);
    func(num);
}
