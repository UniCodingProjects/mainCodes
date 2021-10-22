#include <stdio.h>

int poW(int num, int p){
    int res = 1;
    while (p > 0){
        res *= num;
        p--;
    }
    return res;
}

int len(int num, int l){
    int p = 2;
    while (p < l){
        if (poW(l, p) < num){
            p++;
        }
        else{
            if (p != l-1){
                return -1;
            }
            return p;
        }
    }
}

int getDivisor(int l){
    int divisor = 1;
    while (l > 1){
        divisor *= 10;
        l--;
    }
    return divisor;
}

void func(int num, int l){
    int arr[l];
    int i;
    int divisor = getDivisor(l);
    if (len(num, l+1) != -1){
        for (i=0; i<l; i++){
            arr[i] = num / divisor;
            num = num % divisor;
            divisor = divisor / 10;
        }
        for (i=0;i<l;i++){
            printf("num at idx %d is: %d\n", i, arr[i]);
        }
    }
    else{
        printf("error");
    }
}

void main()
{
    int l = 9; // expected len
    printf("Enter a num with %d digits: ", l);
    int num;
    scanf("%d", &num);
    func(num, l);
    }
