# # from threading import Thread
# # import time
# #
# #
# # # class Threader:
# # #     def __init__(self):
# # #         self.killMe = False
# # #         self._myThread = None
# # #
# # #     def _pinger(self):
# # #         print("starting pinger\n")
# # #         nowTime = time.time()
# # #         while True:
# # #             if time.time() - nowTime > 5:
# # #                 print(time.ctime())
# # #                 nowTime = time.time()
# # #             if self.killMe:
# # #                 print("closing pinger")
# # #                 break
# # #
# # #     def startThread(self):
# # #         self._myThread = Thread(target=self._pinger, args=[])
# # #         self._myThread.start()
# # #
# # #     def killThread(self):
# # #         self.killMe = True
# # #         self._myThread.join(timeout=2)
# # #
# # #
# # # def myFunc(killPinger=None):
# # #     inty = 0
# # #     while inty < 50:
# # #         print(inty)
# # #         inty += 1
# # #         time.sleep(0.4)
# # #         if inty == 20:
# # #             killPinger()
# # #
# # #
# # # T = Threader()
# # # T.startThread()
# # # myFunc(T.killThread)
# #
# #
# # class MyClass:
# #     def __init__(self):
# #         print("initialize")
# #
# #     def __del__(self):
# #         print("destroying")
# #
# #     def __bool__(self):
# #         print("bool")
# #
# #
# # clas = MyClass()
# #
# import smtplib
# import socks
#
# socks.get_default_proxy()
#
# socks.setdefaultproxy(socks.PROXY_TYPE_SOCKS4, proxy_host, proxy_port)
# socks.wrapmodule(smtplib)
# smtp = smtplib.SMTP()
#
# server = smtplib.SMTP_SSL("smtp.gmail.com", 465)
# server.login('cryos10@gmail.com', "45810145")
# froM = 'cryos10@gmail.com'
# to = 'predetor1@hotmail.com'
# msg = "test"
# server.sendmail(from_addr=froM, to_addrs=to, msg=msg)
# server.quit()
# socks.socksocket.close()
