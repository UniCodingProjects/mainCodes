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

pass
