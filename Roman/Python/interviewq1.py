from algorithms import time_it

import time

a = [1, 2]


def func(i):
    print(i)


def func1(func, i):
    func(i)


f = lambda x: list(map(func, a))

with time_it("lambdatest"):
    func1(func, 1)
