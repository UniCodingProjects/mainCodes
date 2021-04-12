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



C = myClass()
print(repr(C))
C.print()
C.X = 2
C.print()
