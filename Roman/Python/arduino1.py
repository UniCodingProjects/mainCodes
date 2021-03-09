import pyfirmata
import time
# from pyfirmata import INPUT, OUTPUT, PWM
# import numpy as np
# import adafruit_dht
# from board import pin


# ard = pyfirmata.Arduino("COM3")
a = input("fuck off: ")

# it = pyfirmata.util.Iterator(ard)
# it.start()
iter = 1
nano = {
    'digital' : tuple(x for x in range(14)),
    'analog' : tuple(x for x in range(8)),
    'pwm' : (3, 5, 6, 9, 10, 11),
    'use_ports' : True,
    'disabled' : (0, 1) # Rx, Tx, Crystal
    }
# ard.setup_layout(nano)
# led = ard.digital[7]

# it = pyfirmata.util.Iterator(ard)
# it.start()
# ard.digital[13].write(1)
# digital_input = ard.get_pin('a:3:i')
dht_device = adafruit_dht.DHT11(pin)


led.mode = PWM
up = np.arange(0, 1, 0.01)
down = list(np.arange(0, 1, 0.01))
down.reverse()
speak = ard.digital[13]
speak.write(1)
while True:
    iter += 1
    for i in up:
        led.write(i)
        time.sleep(0.01)
    for i in down:
        led.write(i)
        time.sleep(0.01)
    if iter == 10:
        break
