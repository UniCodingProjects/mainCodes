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

    def __str__(self):
        temp = self.head
        while temp is not None:
            print(temp.getData(), end=", ")


def deepCopy(head: Node):
    newH = Node(head.getData())
    temp = newH
    tempH = head
    newL = LinkedList(newH)
    while tempH is not None:
        temp.setNext(Node(tempH.getNext().getData()))
        temp = temp.getNext()
        tempH = tempH.getNext()

    tempH = head
    temp = newH
    while tempH is not None:
        if tempH.getRand() is not None:
            runningTemp = temp
            while runningTemp is not None:
                if runningTemp.getData() == tempH.getRand().getData():
                    temp.setRand(runningTemp)
                    tempH = tempH.getNext()
                    break
                else:
                    runningTemp = runningTemp.getNext()

    return newL


n1 = Node(1)
n2 = Node(2)
n3 = Node(3)

n1.setNext(n2)
n2.setNext(3)
n1.setRand(n3)

l1 = LinkedList(n1)
l2 = deepCopy(n1)