import time
import pyfirmata
import numpy as np
import pkg_resources
import sys
import subprocess

from serial.serialutil import SerialException
from serial import Serial
from pyfirmata import INPUT, OUTPUT, PWM, util, STRING_DATA


def initArduino():
    return Arduino()


class Arduino:
    def __init__(self, address="COM3"):
        if 'pyfirmata' not in pkg_resources.working_set.by_key:
            subprocess.check_call([sys.executable, "-m", "pip", "install", 'pyfirmata'])
        self.arduino = self._connect(address)
        self.input = INPUT
        self.output = OUTPUT
        self.pwm = PWM
        self.util = util
        self.general = ArduinoFuncs(self)

    def __del__(self):
        if self.connected:
            self.arduino.exit()

    def _connect(self, address):
        self.connected = False
        try:
            # self.serialGate = Serial(address, 9600)
            ard = pyfirmata.Arduino(address)
            ard.auto_setup()
            # it = util.Iterator(ard)
            # it.start()
        except SerialException:
            raise SerialException(f"Cannot connect to Arduino through port: {address}, check port / connectivity")
        self.connected = True
        return ard

    def sendToLcd(self, data: str):
        self.arduino.send_sysex(STRING_DATA, self.util.str_to_two_byte_iter(data))

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


class ArduinoFuncs():
    def __init__(self, arduino):
        self.arduino = arduino
        self._stopLeds = False

    def dancingLeds(self):
        led = self.arduino.arduino.digital[10]
        led.mode = PWM
        up = np.arange(0, 1, 0.01)
        down = list(np.arange(0, 1, 0.01))
        down.reverse()
        while True:
            if self._stopLeds:
                return
            for j in up:
                led.write(j)
                time.sleep(0.01)
            for k in down:
                led.write(k)
                time.sleep(0.01)
