from Roman.devEnv.infra.git.GitInfra import initGit

import pickle


class GitGui:
    def __init__(self):
        self.git = initGit()










if __name__ == '__main__':
    a = GitGui()
    b = open("text.txt", "w")
    # pickle.dump(a, b)
    p = pickle.Pickler(b)
    p.dump([1, 2])
    pass