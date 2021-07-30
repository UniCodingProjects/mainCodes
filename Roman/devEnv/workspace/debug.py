import time
import os
import sys
import collections
import numpy as np
import matplotlib

from infra.Arduino.arduino1 import initArduino


# arduino:




if __name__ == '__main__':
    arduino = initArduino()
    print(f"Arduino: {arduino.arduino.name}")

