//#include<stdio.h>
//int convertToBinary(int n);
//int convertToDecimal(int n);
//int main()
//{
//    int num, binary, decimal;
//
//    printf("Enter Decimal Number: ");
//    scanf("%d",&num);
//
//    binary = convertToBinary(num);
//
//    printf("Binary Value= %d\n",binary);
//
//    decimal = convertToDecimal(binary);
//
//    printf("\nDecimal of Given Number is= %d",decimal);
//
//    return 0;
//
//}
//
//int convertToBinary(int n)
//{
//    int num, bin=0, i=1, arr[10], j=0;
//
//    while(n!=0)
//    {
//        num= n%2;
//        bin += (num*i);
//        arr[j] = num;
//        j++;
//        n /= 2;
//        i *= 10;
//    }
//    for(int i= 0; i<j; i++){
//        printf("The reverse of array is %d\n: ",arr[i]);
//    }
//
//    return bin;
//}
//
//int convertToDecimal(int binary)
//{
//    int decimal = 0, base = 1, num;
//
//    printf("Enter the Binary Number = ");
//    scanf("%d", &binary);
//
//    while(binary > 0)
//    {
//        num = binary % 10;
//        decimal = decimal + num * base;
//        binary = binary / 10;
//        base = base * 2;
//    }
//
//    printf("The Decimal Value = %d\n", decimal);
//
//    return decimal;
//}
//
