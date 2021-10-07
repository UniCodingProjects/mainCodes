from collections import deque
import heapq

class Queue:
    def __init__(self):
        self.items = deque()

    def enqueue(self, coords):
        self.items.append(coords)

    def deque(self):
        return self.items.pop()

    def peek(self):
        return self.items[0]

    def size(self):
        return len(self.items)

    def is_empty(self):
        return self.size() == 0


maze = [(1, 2, 3, 7, 6),
        (4, 4, 5, 2, 4),
        (7, 3, 9, 8, 9),
        (7, 3, 9, 8, 9),
        (7, 3, 9, "H", 9)]


def checkMove(maze, x, y):
    if 0 <= x < len(maze) and 0 <= y < len(maze[0]):
        return True


def checkAndEqueue(maze, x, y):
    if checkMove(maze, x - 1, y):
        q.enqueue(maze[x - 1][y])
    if checkMove(maze, x + 1, y):
        q.enqueue(maze[x + 1][y])
    if checkMove(maze, x, y - 1):
        q.enqueue(maze[x][y - 1])
    if checkMove(maze, x, y + 1):
        q.enqueue(maze[x][y + 1])
    return q


if __name__ == '__main__':
    goal = "H"
    path = ""
    q = Queue()
    x, y, = 0, 0
    start = maze[x][y]
    q.enqueue(start)
    path += (x, y) + "_ "
    predecessors = {start: None}

    while q.is_empty() is False:
        curr = q.deque()
        if curr == goal:
            print(path)
            break

        q = checkAndEqueue(maze, x, y)
