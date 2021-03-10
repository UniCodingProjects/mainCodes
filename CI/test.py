import os

ROOT_DIR = os.path.abspath(os.path.join(os.path.dirname(__file__), "..\\"))
BASE_FOLDERS = ["Alexandrax", "Roman", "Pavel", ".git", ".idea", "CI"]

folders = os.scandir(ROOT_DIR)
for folder in folders:
    if os.path.isdir(folder.path):
        print(f"testing: {folder.name}")
        assert folder.name in BASE_FOLDERS
