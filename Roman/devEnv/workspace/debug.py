import time
import os
import sys
import collections
import itertools
import numpy as np
import matplotlib.pyplot as plt

# from infra.Arduino.arduino1 import initArduino


# arduino:
def playMap():
    a = map(lambda x, y: x if x == y else None, [0, 1, 2], [0, 1, 3])
    c = list(a)
    b = map(lambda x: x, [i for i in c if i is not None])

    while True:
        try:
            d = next(b)
            print(d)
        except StopIteration:
            break


class Stack:
    def __init__(self):
        self.stack = list()
        self.idx = 0
        self.len = 0

    def push(self, num):
        self.len += 1
        self.stack.insert(self.idx, num)

    def pop(self):
        self.len -= 1
        num = self.stack[self.idx]
        self.idx += 1
        return num

    def peek(self):
        if self.len > 0:
            num = self.pop()
            self.push(num)
            return num


s = ["f", "a", 'g']


def reverseWithStack(s):
    st = Stack()

    for char in s:
        st.push(char)

    i = 0
    while st.len > 0:
        s[i] = st.pop()
        i += 1
    print(s)


def rev2Prec(s, i, j):
    if i < j:
        s[i], s[j] = s[j], s[i]
        return rev2Prec(s, i + 1, j - 1)
    return s


def reverseString2Pointers(s):
    i = 0
    j = len(s) - 1
    while i < j:
        s[i], s[j] = s[j], s[i]
        i += 1
        j -= 1
    print(s)


# print(rev2Prec(s, 0, len(s) - 1))
# print(rev2Prec(s, 0, len(s) - 1))
# reverseString2Pointers(s)


class node:
    def __init__(self, num, next=None):
        self._num = num
        self._next = next

    def getNum(self):
        return self._num

    def getNext(self):
        return self._next

    def setNext(self, next):
        self._next = next


class linkedShit:
    from collections.abc import Generator

    def __init__(self, head=None):
        self._head = head

    def assignHead(self, n):
        self._head = n

    def addToLinkedList(self, Node):
        if self._head is None:
            self.assignHead(Node)
            return
        temp = self._head
        while True:
            if temp.getNext() is None:
                temp.setNext(Node)
                break
            else:
                temp = temp.getNext()

    def addListToLinkedList(self, nodes: Generator):
        for Node in nodes:
            self.addToLinkedList(Node)

    def reverseOrder(self):
        newH = None
        temp = self._head
        while True:
            if temp.getNext().getNext() is not None:
                temp = temp.getNext()
            else:
                if not newH:
                    newH = temp.getNext()
                temp.getNext().setNext(temp)
                temp.setNext(None)
                temp = self._head
            if temp.getNext() is None:
                self._head = newH
                break

    def reverse(self):
        temp = self._head
        while temp.getNext() is not None:
            next = temp.getNext().getNext()
            temp.getNext().setNext(temp)
            temp = next
            if temp is None:
                break

    def reverseWithStack(self):
        self.stack = Stack()
        temp = self._head
        while temp is not None:
            self.stack.push(temp)
            temp = temp.getNext()

        self._head = self.stack.pop()
        temp = self._head
        while self.stack.len > 0:
            temp.setNext(self.stack.pop())
            temp = temp.getNext()
        temp.setNext(None)

    def printY(self):
        temp = self._head
        while temp is not None:
            print(temp.getNum())
            temp = temp.getNext()

    @staticmethod
    def generateSequence(amount):
        for i in range(amount):
            yield node(i)

    def timeIt(self):
        pass


#
# ll = linkedShit()
#
# ll.addListToLinkedList(ll.generateSequence(10))
#
# ll.printY()
# ll.reverseWithStack()
# print(" ")
# ll.printY()
# pass


def interSection(arr1: list, arr2: list):
    arr1.sort()
    arr2.sort()
    tempArr = list()
    i = 0
    j = 0
    while i < len(arr1) and j < len(arr2):
        if arr1[i] == arr2[j]:
            tempArr.append(arr1[i])
            if i + 1 < len(arr1):
                if arr1[i] == arr1[i + 1]:
                    i += 1
                    continue
            if j + 1 < len(arr2):
                if arr2[j] == arr2[j + 1]:
                    j += 1
                    continue
            i += 1
            j += 1
            continue
        if i + 1 == len(arr1):
            j += 1
            continue
        if j + 1 == len(arr2):
            i += 1
            continue
    return tempArr


def interS(arr1: list, arr2: list):
    tempDict = dict()
    tempArr = list()
    for i in range(len(arr1)):
        tempDict[arr1[i]] = arr1[i]
    for i in range(len(arr2)):
        if tempDict.get(arr2[i]) is not None:
            tempArr.append(tempDict.pop(arr2[i]))
    return tempArr


# from Roman.Python.algorithms import time_it
#
# arr1 = list(range(1, 20, 3))
# arr2 = list(range(1, 20, 2))
# print(arr1)
# print(arr2)
#
# with time_it("interS"):
#     print(interS(arr1, arr2))
#
#
# with time_it("set"):
#     print(sorted(list(set(arr1).intersection(set(arr2)))))

def runIspermutItertools():
    print(" --------------------------- ")

    from itertools import permutations

    s = "abccbaabcabadd"
    t = "abc"

    a = permutations(t)
    while True:
        try:
            t = "".join(a.__next__())
            if t in s:
                print(t)
        except StopIteration:
            break

    print(" --------------------------- ")


# runIspermutItertools()


def permutats(t):
    new = list(t)
    permuts = dict()
    i = 0
    j = 0

    while i < len(t):
        new[i], new[j] = new[j], new[i]
        if j + 1 == len(t):
            i += 1
            j = 0
        j += 1
        # yield t
        print(new)
        permuts["".join(new)] = "".join(new)
        i
        new = list(t)
    return permuts


#
# s = "abccbaabcabadd"
# t = "abc"
#
# a = permutats(t)
# for i in range(len(a)):
#     if a[i] in s:
#         print(a[i])
#
# print(" --------------------------- ")


def isPermutation(s, t):
    d = dict()
    i = 0
    while i < len(s):
        if d.get(s[i]) is None:
            d[s[i]] = s[i]
        i += 1
    i = 0
    while i < len(t):
        if d.get(t[i]) is not None:
            d.pop(t[i])
        else:
            d[t[i]] = t[i]
        i += 1

    return len(d.keys()) == 0


def permute1(s, answer):
    if (len(s) == 0):
        print(answer)
        return

    for i in range(len(s)):
        ch = s[i]
        left_substr = s[0:i]
        right_substr = s[i + 1:]
        rest = left_substr + right_substr
        permute(rest, answer + ch)


def permute(string, toPrint):
    if len(string) > 0:
        for i in range(len(string)):
            permute(string[0:i] + string[i + 1:], toPrint + string[i])
    else:
<<<<<<< HEAD
        print(toPrint)


def isPalindrome(s: str) -> bool:
    from collections import deque
    st = deque()
    for i in s:
        if i.isalnum():
            st.append(i.casefold())
    for i in range(len(s)):
        if not s[i].isalnum():
            continue
        if s[i].casefold() == st.pop():
            continue
        else:
            return False
    return True


def isPalindrome2(s: str) -> bool:
    newS = ""
    for i in s:
        if i.isalnum():
            newS += i.casefold()
    k = 0
    j = len(newS) - 1
    while k < j:
        if newS[k] == newS[j]:
            k += 1
            j -= 1
        else:
            return False
    return True


def myAtoi(s: str) -> int:
    if len(s) == 0:
        return 0
    t = ""
    sign = 1
    singed = False
    if not s[0].isdigit() and s[0] != ' ' and s[0] != "+" and s[0] != '-':
        return 0
    idx = 0
    for i in s:
        if i.isdigit() is False:
            if len(t) > 0:
                break
            if len(t) == 0:
                if i == "+":
                    if idx > 0 and len(t) > 0:
                        return 0
                    if len(t) > 0:
                        return 0
                    if singed:
                        return 0
                    sign = sign * 1
                    singed = True
                    idx += 1
                    continue
                elif i == "-":
                    if idx > 0 and len(t) > 0:
                        return 0
                    if len(t) > 0:
                        return 0
                    if singed:
                        return 0
                    sign = sign * -1
                    singed = True
                    idx += 1
                    continue
                elif i == ' ' and singed or i.isalnum() and idx > 0 and len(t) == 0:
                    return 0
                idx += 1
                continue
        if i.isdigit():
            t += i
            idx += 1
            continue
        idx += 1
    if len(t) == 0:
        return 0
    integer = int(t) * sign
    if integer > pow(2, 31) -1:
        return pow(2, 31) -1
    elif integer < pow(-2, 31):
        return pow(-2, 31)
    return integer
