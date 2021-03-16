import os
import pytest


@pytest.mark.CI
def test_CI():
    ROOT_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..\\"))
    BASE_FOLDERS = ["Alexandrax", "Roman", "Pavel", ".git", ".idea", "CI"]

    folders = os.scandir(ROOT_DIR)
    for folder in folders:
        if os.path.isdir(folder.path):
            if folder.name not in ["__pycache__", '.pytest_cache']:
                print(f"testing: {folder.name}")
                assert folder.name in BASE_FOLDERS


class Point:
    def __init__(self, x, y):
        self._x = x
        self._y = y

    def __del__(self):
        print("fuck you")

    def __str__(self):
        return f"({self._x},{self._y})"

    def getX(self):
        return self._x

    def getY(self):
        return self._y

    def setX(self, x):
        self._x = x

    def setY(self, y):
        self._y = y

    def comparePoint(self, point):
        if self._x == point.getX() and self._y == point.getY():
            return True
        return False


if __name__ == '__main__':
    myPoint1 = Point(1.0, 2.0)
    myPoint2 = Point(1.0, 2.0)
    print(myPoint1.comparePoint(myPoint2))
