from contextlib import contextmanager

"""Merge sort algorithm"""


def merge_sort(arr, start, end):
    if start == end:
        return arr
    if start < end:
        mid = (start + end) // 2
        merge_sort(arr, start, mid)
        merge_sort(arr, mid + 1, end)

        return merge(arr, start, mid, end)


def merge(arr, start, mid, end):
    left_arr = create_temp_arr(arr, start, 0, list(), mid - start + 1)
    right_arr = create_temp_arr(arr, mid + 1, 0, list(), end - mid)

    return sort(arr, left_arr, right_arr, start, end, 0, 0)


def create_temp_arr(arr, idx, i, temp_arr, length):
    if i < length and idx < len(arr):
        temp_arr.append(arr[idx])
        return create_temp_arr(arr, idx + 1, i + 1, temp_arr, length)
    return temp_arr


def sort(arr, left_arr, right_arr, start, end, i, j):
    if start < end and i < len(left_arr) and j < len(right_arr):
        if left_arr[i] <= right_arr[j]:
            arr[start] = left_arr[i]
            arr[start + 1] = right_arr[j]
            return sort(arr, left_arr, right_arr, start + 1, end, i + 1, j)
        else:
            arr[start] = right_arr[j]
            arr[start + 1] = left_arr[i]
            return sort(arr, left_arr, right_arr, start + 1, end, i, j + 1)
    else:
        arr = fill_remaining(arr, left_arr, start + 1, i + 1) if j == len(right_arr) else fill_remaining(arr, right_arr,
                                                                                                         start + 1,
                                                                                                         j + 1)
        return arr


def fill_remaining(arr, temp_arr, idx, i):
    if i < len(temp_arr) and idx < len(arr):
        arr[idx] = temp_arr[i]
        return fill_remaining(arr, temp_arr, idx + 1, i + 1)
    return arr


###############################################################################################################

"""insertion sort algorithm"""


def insertion_sort(arr):
    for i in range(len(arr)):
        temp = arr[i]
        j = i - 1
        while j >= 0 and arr[j] > temp:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = temp
    return arr


##############################################################################################################

@contextmanager
def time_it(name):
    import time
    s = time.time()
    try:
        yield
    finally:
        print(f"time to execute func: {name}: {time.time() - s} seconds")


if __name__ == '__main__':
    a = [1, 1, 2, 0, 10, 16, 1, 1, 1, 4, 5, 6, 7, 9, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 258] * 1000


    with time_it("sorted func "):
        sorted(a)

    with time_it("insertion sort"):
        insertion_sort(a)

    with time_it("merge sort"):
        merge_sort(a, 0, len(a) - 1)
