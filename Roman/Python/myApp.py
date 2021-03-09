import subprocess
import sys
import pkg_resources
import json
import time

from playsound import playsound
import multiprocessing

if 'kivy' not in pkg_resources.working_set.by_key:
    subprocess.check_call([sys.executable, "-m", "pip", "install", 'kivy'])

from kivy.app import App
from kivy.uix.button import Button
from kivy.uix.label import Label
from kivy.uix.gridlayout import GridLayout
from kivy.uix.textinput import TextInput


class funcs:
    def __init__(self):
        self.dictionary = {}

    def saveDictToJson(self):
        with open('orders.json', "a") as fp:
            json.dump(self.dictionary, fp=fp, indent=0)


class grid(GridLayout):
    def __init__(self, **kwargs):
        super(grid, self).__init__(**kwargs)

        self.p = multiprocessing.Process(target=playsound, args=(r"D:\Music\flight\Maria Takeuchi - Plastic Love.mp3",))
        self.supportAll = True

        self.cols = 1

        self.top_grid = GridLayout()
        self.top_grid.cols = 2
        self.top_grid.rows = 4

        self.funcs = funcs()
        self.top_grid.add_widget(Label(text="Name: "))
        self.name = TextInput(multiline=False)
        self.top_grid.add_widget(self.name)

        self.top_grid.add_widget(Label(text="Main order: "))
        self.Main_Order = TextInput(multiline=False)
        self.top_grid.add_widget(self.Main_Order)

        self.top_grid.add_widget(Label(text="Side order: "))
        self.Side_Order = TextInput(multiline=False)
        self.top_grid.add_widget(self.Side_Order)

        self.top_grid.add_widget(Label(text="Payment: "))
        self.payment = TextInput(multiline=False)
        self.top_grid.add_widget(self.payment)

        self.add_widget(self.top_grid)

        self.buttonFinish = Button(text='Gather order')
        self.buttonFinish.background_color = 'blue'
        self.buttonFinish.bind(on_press=self.getOrder)
        self.add_widget(self.buttonFinish)

        self.closeApp = Button(text='Close')
        self.closeApp.bind(on_press=self.closeAppZ)
        self.closeApp.background_color = 'red'
        self.add_widget(self.closeApp)

        self.textsList = [self.name, self.Main_Order, self.Side_Order, self.payment]
        self.error = Label(text="enter everything properly you fuck")
        self.pavelError = Label(text="Woke mansplainers are not supported in this app")
        self.sashaError = Label(text='овцы не поддержаюца')
        self.mihaelError = Label(text='ani ani ani ani talinn estonia')
        self.playMyShit()

    def closeAppZ(self, instance):
        self.p.terminate()
        App.get_running_app().stop()

    def playMyShit(self):
        self.p.start()

    def getOrder(self, instance):
        error = False
        for text in self.textsList:
            if not text.text:
                error = True
        if not error:
            self.removeErrors()
            Name = self.name.text.capitalize()
            if self.checkName(Name):
                Main_Order = self.Main_Order.text
                Side_Order = self.Side_Order.text
                payment = self.payment.text
                self.funcs.dictionary.clear()
                self.funcs.dictionary[Name] = {'Main_Order': Main_Order, "Side_Order": Side_Order, 'Payment': payment,
                                               "date": time.ctime()}
                self.funcs.saveDictToJson()
                # noinspection PyAttributeOutsideInit
                self.orderLabel = Label(text=json.dumps(self.funcs.dictionary, indent=0))
                for textBox in self.textsList:
                    textBox.text = ""
                self.add_widget(self.orderLabel)
        else:
            self.remove_widget(self.error)
            self.add_widget(self.error)
            for textBox in self.textsList:
                textBox.text = ""

    def checkName(self, name):
        if not self.supportAll:
            if name.casefold() in ['pavel', 'pazel', 'pasha', 'pash', 'alcatraz']:
                self.remove_widget(self.pavelError)
                self.add_widget(self.pavelError)
                return False
            if name.casefold() in ['sasha', 'alex', 'alexandra', 'shurik', 'sash', 'ovza']:
                self.remove_widget(self.sashaError)
                self.add_widget(self.sashaError)
                return False
            if name.casefold() in ['mik', 'mihael', 'michael', 'mikmik133', 'mikmik', 'misha']:
                self.remove_widget(self.mihaelError)
                self.add_widget(self.mihaelError)
                return False
        return True

    def removeErrors(self):
        self.remove_widget(self.error)
        self.remove_widget(self.pavelError)
        self.remove_widget(self.sashaError)
        self.remove_widget(self.mihaelError)


class Orders(App):
    def build(self):
        return grid()


if __name__ == '__main__':
    Orders().run()
