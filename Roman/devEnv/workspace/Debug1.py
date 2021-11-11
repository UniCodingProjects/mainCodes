def swap(arr, i, j):
    temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
    return arr


def removeDuplicates(nums):
    i = 0
    while i < len(nums):
        popped = False
        if i >= len(nums):
            break
        for j in range(len(nums)):
            if j >= len(nums):
                break
            if nums[i] == nums[j] and i != j:
                nums.pop(i)
                popped = True
        if popped is False:
            i += 1

    print(nums)
    return len(nums)


def removeDups(nums):
    i = 0
    while i < len(nums):
        if i + 1 >= len(nums):
            break
        if nums[i] == nums[i + 1]:
            nums.pop(i)
            if i != 0:
                i -= 1
        else:
            i += 1

    print(f"len: {len(nums)}, nums: {nums}")
    return len(nums)


def rotate(arr, k):
    for i in range(k):
        arr.insert(0, arr.pop(len(arr) - 1))
    return arr


def containsDuplicate(nums):
    i = 0
    j = 1
    while i < len(nums):
        if j >= len(nums) or i >= len(nums):
            return False
        if nums[i] == nums[j]:
            return True
        j += 1
        if j >= len(nums):
            i += 1
            j = i + 1


def containsD(nums):
    nums.sort()
    for i in range(len(nums)):
        if i + 1 >= len(nums):
            return False
        if nums[i] == nums[i + 1]:
            return True
    return False


def containsDWithDict(nums):
    d = dict()
    f = False
    for i in range(len(nums)):
        if d.get(str(nums[i])) is not None:
            f = True
        else:
            d[str(nums[i])] = nums[i]
    return f


def findSingle(nums):
    d = dict()
    for i in range(len(nums)):
        if d.get(str(nums[i])) is None:
            d[str(nums[i])] = nums[i]
        else:
            d.pop(str(nums[i]))
    return d[list(d.keys())[0]]


def findSingleXor(nums):
    single = 0
    for i in range(len(nums)):
        single ^= nums[i]
    return single


def findSingleInSortedArr(nums):
    start = 0
    end = len(nums)
    mid = int((start + end) / 2) + 1
    while start < end:
        if mid + 1 >= len(nums):
            if nums[mid] != nums[mid - 1]:
                return nums[mid]
        elif mid - 1 < 0:
            if nums[mid] != nums[mid + 1]:
                return nums[mid]
        if nums[mid] != nums[mid - 1] and nums[mid] != nums[mid + 1]:
            return nums[mid]
        if (end - mid) % 2 == 0:
            start = mid
            mid = int((start + end) / 2) + 1
        else:
            end = mid
            mid = int((start + end) / 2) - 1
    return -1


def bubbleSortFlag(nums):
    swapped = False
    i = 0
    while i + 1 < len(nums):
        if nums[i] > nums[i + 1]:
            temp = nums[i]
            nums[i] = nums[i + 1]
            nums[i + 1] = temp
            swapped = True
        i += 1
        if i + 1 >= len(nums) and swapped:
            i = 0
            swapped = False
    return nums


def bubbleSortFor(nums):
    for i in range(len(nums)):
        for j in range(len(nums) - 1):
            if nums[j] > nums[j + 1]:
                temp = nums[j]
                nums[j] = nums[j + 1]
                nums[j + 1] = temp

    return nums


def GCD(a, b):
    r = a % b
    if r == 0:
        return b
    return GCD(b, r)


def selectionSort(nums):
    def swaP(nums, num1, num2):
        temp = nums[num1]
        nums[num1] = nums[num2]
        nums[num2] = temp
        return nums

    i = 1
    minIdx = 0
    swapIdx = -1
    minimum = nums[0]
    while i < len(nums):
        if nums[i] < minimum:
            minimum = nums[i]
            swapIdx = i
        i += 1
        if i == len(nums):
            if swapIdx != -1:
                nums = swaP(nums, minIdx, swapIdx)
                swapIdx = -1
            minIdx += 1
            if minIdx == len(nums):
                break
            i = minIdx
            minimum = nums[minIdx]
    return nums


from threading import Thread
import time

f = {"stat": False}


class fg:
    def __init__(self):
        self.kill = False

    def __del__(self):
        pass

    def num1(self):
        zman = time.time()
        print("started")
        while time.time() - zman < 300:
            if self.kill:
                print("kijlled mme")
                break
            time.sleep(1)
            print(time.time())
        print(" ")
        f["stat"] = True

    def num2(self):
        time.sleep(5)
        self.kill = True
        print("here")

    def func(self):
        t1 = Thread(target=self.num1, args=())
        t2 = Thread(target=self.num2, args=())

        t1.start()
        t2.start()
        # t1.join()
        # while f["stat"] is False:
        #     time.sleep(1)
        # else:
        #     t2.start()


if __name__ == '__main__':
    file = r"C:\Users\cryos\Documents\Screenshot 2021-05-17 005012.png"
    with open(file, "rb") as fp:
        buffer = fp.read()

    with open("bin.bin", "wb+") as fp2:
        fp2.write(buffer)

    with open("bin.bin", "rb") as biN:
        buffer2 = biN.read()

    with open("test.png", "wb+") as fp3:
        fp3.write(buffer2)
    pass
