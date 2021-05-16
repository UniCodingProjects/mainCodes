a = [1, 2]


def func(i):
    print(i)


def func1(func, i):
    func(i)


f = lambda x: list(map(func, a))

func1(func, 1)
