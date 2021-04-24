import time
import pyfirmata
import numpy as np
import pkg_resources
import sys
import subprocess

from pyfirmata import INPUT, OUTPUT, PWM


class Arduino:
    def __init__(self, address="COM3"):
        if 'pyfirmata' not in pkg_resources.working_set.by_key:
            subprocess.check_call([sys.executable, "-m", "pip", "install", 'pyfirmata'])
        self.arduino = pyfirmata.Arduino(address)

    def __del__(self):
        print("closing session w/ arduino")
        self.arduino.exit()

    def setPinModeOutput(self, PIN):
        pin = self.arduino.digital[PIN]
        pin.mode = OUTPUT
        return pin

    def setPinModeInput(self, PIN):
        pin = self.arduino.digital[PIN]
        pin.mode = INPUT
        return pin

    def getAllDigitalPorts(self):
        return self.arduino.digital

    def getALlAnalogPorts(self):
        return self.arduino.analog

    def dancingLeds(self):
        led = self.arduino.get_pin(6)
        led.mode = PWM
        up = np.arange(0, 1, 0.01)
        down = list(np.arange(0, 1, 0.01))
        down.reverse()
        i = 0
        while True:
            i += 1
            for j in up:
                led.write(j)
                time.sleep(0.01)
            for k in down:
                led.write(k)
                time.sleep(0.01)
            if i == 10:
                break


if __name__ == '__main__':
    arduino = Arduino()
    print(f"Arduino: {arduino.arduino.name}")
