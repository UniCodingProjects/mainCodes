import os
import pytest


@pytest.mark.CI
def test_CI():
    ROOT_DIR = os.path.abspath(os.path.dirname(__file__) + f"{os.sep}..")
    BASE_FOLDERS = ["Alexandrax", "Roman", "Pavel", ".git", ".idea", "CI", "MichaelCodes"]


    for folder in BASE_FOLDERS:
        folders = os.listdir(ROOT_DIR)
        print(f"testing: {folder}")
        assert folder in folders

@pytest.mark.CI
def test_CI2():
    os.chdir("CI")
    
    print("\nJAVA test")
    os.system("java test" )
    print("=== java test passed ===")

    os.chdir("..")
    print(f"curr working dir: {os.getcwd()}")