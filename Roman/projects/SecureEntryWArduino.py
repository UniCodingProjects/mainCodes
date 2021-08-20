import time
import threading
import numpy as np

from Roman.devEnv.infra.Arduino.arduino1 import initArduino


class rfidProject:
    def __init__(self):
        self.ardo = initArduino()
        self.masterCode = [1, 2, 3, 4]
        self.acceptedCodes = [self.masterCode]
        self.wrongCounter = 0
        self._pressedKeys = []

        self.startMode()
        self.threadsFlags()
        self._terminate = False

        self.initThreads()

    def __del__(self):
        self._terminate = True

    def initThreads(self):
        self._keyStatus = threading.Thread(target=self.getKeysStatus)
        self._alarmLeds = threading.Thread(target=self._alarmLedsFunc)
        self._cleanPressedKeys = threading.Thread(target=self.cleanPressedKeys)

        self._keyStatus.start()
        self._alarmLeds.start()
        self._cleanPressedKeys.start()

    def threadsFlags(self):
        self._stopAlarmLeds = True

    def cleanPressedKeys(self):
        while True:
            if len(self._pressedKeys) > 5:
                self._pressedKeys.clear()

    def startMode(self):
        time.sleep(0.5)
        red = self.ardo.arduino.digital[9]
        blue = self.ardo.arduino.digital[10]
        time.sleep(0.5)
        red.mode = self.ardo.output
        time.sleep(0.5)
        red.write(0)
        blue.mode = self.ardo.output
        blue.write(1)

    def getKeysStatus(self):
        gotKey = self.ardo.arduino
        if gotKey is not None:
            self._pressedKeys.append(gotKey)
            if self._pressedKeys[:-1] == "A" and len(self._pressedKeys) > 4 and self._checkCode(
                    self._pressedKeys[-4:-1]):
                self.openDoor()
            elif self._pressedKeys[:-1] == "B" and len(self._pressedKeys) > 4 and self._assertCode(
                    self._pressedKeys[-4:-1]):
                self.stopAlarm()
            elif self._pressedKeys[:-1] == "C" and len(self._pressedKeys) > 4 and self._assertCode(
                    self._pressedKeys[-4:-1]):
                print("FUCK OFF")

        # check keys or key status from keyboard

    def _assertCode(self, code: list):
        try:
            assert code == self.masterCode
            self.wrongCounter = 0
        except AssertionError:
            self.wrongCounter += 1
            if self.wrongCounter >= 3:
                self.alarm()

    def _checkCode(self, code: list):
        if code in self.acceptedCodes:
            self.wrongCounter = 0
            return True
        self.wrongCounter += 1
        if self.wrongCounter >= 3:
            self.alarm()
        return False

    def alarm(self):
        self.ardo  # play alarm
        self._stopAlarmLeds = False

    def giveKeys(self):
        self._pressedKeys = [1, 2, 3, 4, "A"]

    def openDoor(self):
        if self._checkCode(self._pressedKeys[-5:-1]):
            self._pressedKeys.clear()
            self.ardo  # ping to open door
            red = self.ardo.arduino.digital[9]
            blue = self.ardo.arduino.digital[10]
            green = self.ardo.arduino.digital[11]
            red.write(0)
            blue.write(0)
            green.mode = self.ardo.output
            green.write(1)
            time.sleep(5)
            blue.write(1)
            green.write(0)
        else:
            print(f"wrong code: attempts left: {3 - self.wrongCounter}")

    def stopAlarm(self):
        self._pressedKeys = [1, 2, 3, 4]

        self._assertCode(self._pressedKeys[-4:-1])
        self._stopAlarmLeds = True
        self.startMode()

    def _alarmLedsFunc(self):
        while True:
            if self._terminate:
                return
            if self._stopAlarmLeds:
                time.sleep(1)
            else:
                time.sleep(0.1)
                blue = self.ardo.arduino.digital[10]
                led = self.ardo.arduino.digital[9]
                led.mode = self.ardo.pwm
                up = np.arange(0, 1, 0.1)
                down = list(np.arange(0, 1, 0.1))
                down.reverse()
                time.sleep(0.05)
                blue.write(0)
                for j in up:
                    led.write(j)
                    time.sleep(0.005)
                for k in down:
                    led.write(k)
                    time.sleep(0.01)

    # def _setCode(self):
    #     self.masterCode  # write new code to aruino
    #
    # def _addCode(self, code: list):
    #     self._assertCode(self._pressedKeys[-4:])
    #     self.acceptedCodes.append(code)
    # def getLedStatus(self):
    #     return self.ardo.arduino.digital[13]
    #
    # def changeCode(self, masterCode: list, changedCode: list):
    #     self._assertCode(masterCode)
    #     self.masterCode = changedCode
    #     self._setCode()


proj = rfidProject()
proj.ardo.sendToLcd("aaaa")
inP = proj.ardo.getALlAnalogPorts()[1]
inP.enable_reporting()
while True:
    time.sleep(1)
    print(inP.read())
# while True:
#     print("start")
#     time.sleep(3)
#     print("alarm")
#     # proj.getKeysStatus()
#     proj.alarm()
#     time.sleep(4)
#     print("stop alarm")
#     proj.stopAlarm()
#     time.sleep(1)
