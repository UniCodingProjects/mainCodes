from git import *
from git import Repo, cmd

import os


class GitHub:
    def __init__(self):
        self.repo = Repo(os.path.join(__file__, "..\\" * 4))
        self.cmd = cmd.Git(self.repo.working_dir)
        self.dirty = self.repo.is_dirty()
        self.lastCCommitterName = self.repo.commit().author.name
        self.lastCommitterEmail = self.repo.commit().author.email

    def __str__(self):
        return self.repo.working_tree_dir

    def gitStatus(self):
        return self.cmd.status()

    def getBranches(self):
        return self.repo.branches

    def getActiveBranch(self):
        return self.repo.active_branch

    def gitRebase(self):
        self.cmd.fetch()
        return self.cmd.rebase()

    def gitPull(self):
        self.cmd.fetch()
        return self.cmd.pull()

    def gitAddAll(self):
        return self.cmd.add(".")

    def gitAddSpecific(self, *args):
        for arg in args:
            print(self.cmd.add(arg))

    def gitCommitAll(self, message):
        return self.cmd.commit(f"-m {message}")

    def gitPush(self):
        return self.cmd.push()

    def commitsDiff(self):
        branch = self.repo.active_branch
        commsDiff = self.repo.git.rev_list('--left-right', '--count', f'{branch}...origin/master@{{u}}')
        ahead, behind = commsDiff.split('\t')
        print(ahead, "__fag__", behind)


Github = GitHub()
print(Github.gitStatus())
Github.gitAddSpecific(["Roman/Python/git/GitInfra.py"])
Github.gitCommitAll("-m git actions repo")
Github.gitPush()
print(Github.gitStatus())
print(Github.commitsDiff())
pass
