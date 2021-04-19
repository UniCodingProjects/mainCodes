class myClass:
    def __init__(self):
        self._x = None

    def __del__(self):
        self._x = None

    def __repr__(self):
        return "myClass trying"

    def __str__(self):
        return "myClass trying2"

    @property
    def X(self):
        return self._x

    @X.setter
    def X(self, x):
        print(f"setting X to: {x}, from: {self.X}")
        self._x = x

    @X.deleter
    def X(self):
        del self._x

    def print(self):
        print(self.X)


class A:
    def __init__(self, word):
        self.word = word
        print(word)

    def __repr__(self):
        return self.word

    def getName(self):
        return self.word


class B:
    def __init__(self, name):
        super(B, self).__init__(word="gay")
        print(name)
        self.name = name

    def getName2(self):
        return self.name


class C(B, A):
    def __init__(self):
        super(C, self).__init__(name="fag")
        print("C")

    def __repr__(self):
        return "wtf"

    def getNames(self):
        return self.getName() + self.getName2()

    def getNameFromB(self):
        return getattr(self, "getName2")()


c = C()
print(c.getNames())
print(c.getNameFromB())
