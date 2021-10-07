import os
import pytest


@pytest.mark.CI
def test_CI():
    ROOT_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..\\"))
    BASE_FOLDERS = ["Alexandrax", "Roman", "Pavel", ".git", ".idea", "CI"]

    folders = os.scandir(ROOT_DIR)
    for folder in folders:
        if folder.name == ".vscode":
            continue
        if os.path.isdir(folder.path):
            if folder.name not in ["__pycache__", '.pytest_cache']:
                print(f"testing: {folder.name}")
                assert folder.name in BASE_FOLDERS

@pytest.mark.CI
def test_CI2():
    print("\ntest")