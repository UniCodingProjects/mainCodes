# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'a.ui'
#
# Created by: PyQt5 UI code generator 5.15.4
#
# WARNING: Any manual changes made to this file will be lost when pyuic5 is
# run again.  Do not edit this file unless you know what you are doing.


from PyQt5 import QtCore, QtGui, QtWidgets


class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(800, 534)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        MainWindow.setCentralWidget(self.centralwidget)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)
        self.menuBar = QtWidgets.QMenuBar(MainWindow)
        self.menuBar.setGeometry(QtCore.QRect(0, 0, 800, 18))
        self.menuBar.setObjectName("menuBar")
        self.menuMain = QtWidgets.QMenu(self.menuBar)
        self.menuMain.setObjectName("menuMain")
        MainWindow.setMenuBar(self.menuBar)
        self.toolBar = QtWidgets.QToolBar(MainWindow)
        self.toolBar.setObjectName("toolBar")
        MainWindow.addToolBar(QtCore.Qt.TopToolBarArea, self.toolBar)
        self.actionOpen_folder = QtWidgets.QAction(MainWindow)
        icon = QtGui.QIcon()
        icon.addPixmap(QtGui.QPixmap(":/wowss/D:/World of Warcraft/Screenshots/WoWScrnShot_090417_234435.jpg"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.actionOpen_folder.setIcon(icon)
        self.actionOpen_folder.setObjectName("actionOpen_folder")
        self.actioncloseWin = QtWidgets.QAction(MainWindow)
        icon1 = QtGui.QIcon()
        icon1.addPixmap(QtGui.QPixmap(":/wowss/D:/World of Warcraft/Screenshots/WoWScrnShot_090417_235148.jpg"), QtGui.QIcon.Normal, QtGui.QIcon.Off)
        self.actioncloseWin.setIcon(icon1)
        self.actioncloseWin.setObjectName("actioncloseWin")
        self.actionabout = QtWidgets.QAction(MainWindow)
        self.actionabout.setObjectName("actionabout")
        self.menuMain.addAction(self.actionOpen_folder)
        self.menuMain.addSeparator()
        self.menuMain.addAction(self.actionabout)
        self.menuBar.addAction(self.menuMain.menuAction())
        self.toolBar.addAction(self.actionOpen_folder)
        self.toolBar.addAction(self.actioncloseWin)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))
        self.menuMain.setTitle(_translate("MainWindow", "Main"))
        self.toolBar.setWindowTitle(_translate("MainWindow", "toolBar"))
        self.actionOpen_folder.setText(_translate("MainWindow", "Open folder"))
        self.actionOpen_folder.setToolTip(_translate("MainWindow", "Open folder"))
        self.actioncloseWin.setText(_translate("MainWindow", "closeWin"))
        self.actioncloseWin.setToolTip(_translate("MainWindow", "closeWin"))
        self.actionabout.setText(_translate("MainWindow", "about"))
