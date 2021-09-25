def printBin(num):
    print(bin(num)[2:])


def reverseAndPrintBin(num):
    for i in list(bin(num))[2:].__reversed__():
        print(i, end="")
    print("")


def reversedToDec(num):
    n = 0
    idx = 1
    for i in list(bin(num))[2:]:
        if i == '1':
            n += int(i) * idx
        idx *= 2
    print(n)


if __name__ == '__main__':
    num = int(input("Enter a num: "))
    if num < 0:
        exit(0)
    printBin(num)
    reverseAndPrintBin(num)
    reversedToDec(num)
