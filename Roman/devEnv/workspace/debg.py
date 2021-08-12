class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        self.random = None

    def getData(self):
        return self.data

    def setNext(self, node):
        self.next = node

    def setRand(self, node):
        self.random = node

    def getRand(self):
        return self.random

    def getNext(self):
        return self.next


class LinkedList:
    def __init__(self, head):
        self.head = head

    def getHead(self):
        return self.head

    def toPrint(self):
        temp = self.head
        while temp is not None:
            print(temp.getData(), end=", ")
            temp = temp.getNext()
        print(" ")


def deepCopy(head: Node):
    newH = Node(head.getData())
    temp = newH
    tempH = head
    newL = LinkedList(newH)
    while tempH.getNext() is not None:
        temp.setNext(Node(tempH.getNext().getData()))
        temp = temp.getNext()
        tempH = tempH.getNext()

    tempH = head
    temp = newH
    while tempH is not None:
        if tempH.getRand() is not None:
            runningTemp = newH
            while runningTemp is not None:
                if runningTemp.getData() == tempH.getRand().getData():
                    temp.setRand(runningTemp)
                    temp = temp.getNext()
                    tempH = tempH.getNext()
                    break
                else:
                    runningTemp = runningTemp.getNext()
        else:
            tempH = tempH.getNext()
            temp = temp.getNext()

    return newL


def assertDeepCopy():
    n1 = Node(1)
    n2 = Node(2)
    n3 = Node(3)
    n4 = Node(4)
    n5 = Node(5)

    n1.setNext(n2)
    n2.setNext(n3)
    n3.setNext(n4)
    n4.setNext(n5)

    n1.setRand(n3)
    n3.setRand(n5)
    n5.setRand(n2)

    l1 = LinkedList(n1)
    l2 = deepCopy(n1)

    l1.toPrint()
    l2.toPrint()

    assert l1 != l2
    temp = l1.getHead()
    temp2 = l2.getHead()
    while temp is not None:
        print(f"l1: {temp.getData()}", end=", ")
        print(f"l2: {temp2.getData()}")
        assert temp != temp2
        temp = temp.getNext()
        temp2 = temp2.getNext()

    temp = l1.getHead()
    temp2 = l2.getHead()
    while temp is not None:
        if temp.getRand() is not None:
            print(f"l1: {temp.getRand().getData()}")
            print(f"l2: {temp2.getRand().getData()}")
            assert temp.getRand() != temp2.getRand()
        temp = temp.getNext()
        temp2 = temp2.getNext()


class Solution:
    def reverseWithString(self, x: int) -> int:
        y = abs(x)
        charArr = list(str(y))
        i, j = 0, len(charArr) - 1
        while i < j:
            charArr[i], charArr[j] = charArr[j], charArr[i]
            i += 1
            j -= 1
        if abs(int("".join(charArr))).bit_length() >= 32:
            return 0
        if x < 0:
            return int("".join(charArr)) * -1
        return int("".join(charArr))

    @staticmethod
    def reverse(x: int) -> int:
        def findLen(y):
            counter = 1
            while y >= 1:
                y = y / 10
                counter *= 10
            return counter

        def checkBit(newX, x):
            lowLimit = pow(-2, 31)
            highLimit = pow(2, 31) - 1
            if x > 0 and newX > highLimit:
                return 0
            elif x < 0 and (newX * - 1) < lowLimit:
                return 0

        y = abs(x)
        newX = 0
        length = findLen(y)
        while length != 1:
            newX += y.__mod__(10) * length
            y = y // 10
            length //= 10
        newX = newX // 10
        if checkBit(newX, x) == 0:
            return 0
        if x < 0:
            return newX * -1
        return newX

"aabccaabbbbbbbaaaaz"
"abc"
"aabaab"

from Roman.devEnv.workspace.debug import Stack



def firstUniqChar(s: str) -> int:
    d = dict()
    for char in s:
        if d.get(char, None) is None:
            d[char] = 1
        else:
            d[char] += 1
    for k, v in d.items():
        if v == 1:
            return s.index(k)
    return -1


def firstuniqeWithEnumeration(s: str) -> int:
    d = dict()
    for char in s:
        if d.get(char, None) is None:
            d[char] = 1
        else:
            d[char] += 1

    enumerated = enumerate(s)
    for idx, char in enumerated:
        if d[char] == 1:
            return idx
    return -1


def firstUniqueWithCounterAndEnum(s: str) -> int:
    from collections import Counter

    counterDict = Counter(s)
    enumerated = enumerate(s)

    for idx, char in enumerated:
        if counterDict[char] == 1:
            return idx
    return -1


def isAnagram(s, t):
    if len(s) != len(t):
        return False
    d = dict()
    for char in s:
        if d.get(char, None) is None:
            d[char] = 1
        else:
            d[char] += 1
    for char in t:
        try:
            d[char] -= 1
        except KeyError:
            return False
    for k, v in d.items():
        if v != 0:
            return False
    return True

