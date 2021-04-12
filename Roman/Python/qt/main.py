import sys

from PyQt5.QtWidgets import (
    QApplication, QDialog, QMainWindow, QMessageBox
)
from PyQt5.uic import loadUi

from output import Ui_MainWindow


class Window(QMainWindow, Ui_MainWindow):
    def __init__(self, parent=None):
        super().__init__(parent)
        self.setupUi(self)
        self.connectSignalsSlots()

    def connectSignalsSlots(self):
        # self.action_Exit.triggered.connect(self.close)
        # self.action_Find_Replace.triggered.connect(self.findAndReplace)
        self.actionabout.triggered.connect(self.about)
        self.actioncloseWin.triggered.connect(self.closeAllWin)
        self.actionOpen_folder.triggered.connect(self.showImage)

    def about(self):
        QMessageBox.information(
            self,
            "About Sample Editor",
            "<p>A sample text editor app built with:</p>"
            "<p>- PyQt</p>"
            "<p>- Qt Designer</p>"
            "<p>- Python</p>",
        )

    def closeAllWin(self):
        self.close()

    def showImage(self):
        from PIL import Image, ImageShow
        with Image.open(r"C:\Users\cryos\Documents\Screenshot 2020-12-04 195747.jpg") as imag:
            ImageShow.show(imag)
            # imag.resize((640, 480))
            # imag.show()



if __name__ == "__main__":
    app = QApplication(sys.argv)
    win = Window()
    win.show()
    sys.exit(app.exec())
