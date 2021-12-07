//#include <stdio.h>
//
//void  printDigit(int N){
//
//    int r,j;
//    int arr[9] = {};
//    int i = 0;
//
//    while (N !=0){
//        r = N % 10;
//        arr[i] = r;
//        i++;
//        N = N / 10;
//    }
//    for( j = i-1;j > -1; j--){
//        printf("The digxit num  is[%d] =  %d\n", j,arr[j]);
//    }
//}
//int main()
//{
//    int N;
//     printf("Please enter you ID number: ");
//     scanf("%d",&N);
//     if (N /10 >=1000000000 || N <= 99999999){
//         printf("ERROR!!!!!!! ");
//     }
//     else{
//         printDigit(N);
//     }
//    return 0;
//}