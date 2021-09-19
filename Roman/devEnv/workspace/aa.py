a = 5
b = 8
c = "i love ice cream"

l = [a, b, c]


def printy(string):
    print(string)
    return string


def run():
    for i in range(3):
        yield printy(l[i])
