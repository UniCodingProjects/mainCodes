import os

from git import cmd, repo
from git import *


def initGit():
    return GitHub()


class GitHub:
    def __init__(self):
        self.repo = Repo(os.path.join(__file__, "..\\" * 5))
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
        fetchData = self.cmd.fetch()
        if len(str(fetchData)) > 0:
            return self.cmd.pull()

    def gitAddAll(self):
        return self.cmd.add(".")

    def gitAddSpecific(self, *args):
        for arg in args:
            print(self.cmd.add(arg))

    def gitCommitAll(self, message):
        try:
            return self.cmd.commit(f"-m", message)
        except GitCommandError as ex:
            print(ex)

    def gitPush(self):
        if self.commitsDiff():
            try:
                return self.cmd.push()
            except GitCommandError as ex:
                print(f"Cant push: {ex}")
                if str(ex.args[2]).split("\\n")[0].__contains__("no upstream"):
                    return self.cmd.push(f"--set-upstream", self.repo.remote(), self.repo.active_branch.name)
                raise ex
        else:
            print("Fetch, Rebase, and Push again")
            raise RepositoryDirtyError(self.repo.active_branch.name, "Fetch, Rebase, and Push again")

    def commitsDiff(self):
        commits = list()
        branch = self.repo.active_branch.name
        commitsBehind = Github.repo.iter_commits(f'{branch}..origin/master')
        for comm in commitsBehind:
            commits.append(comm)
        print(f"Commits behind: {len(commits)}")
        if len(commits) > 0:
            return False
        else:
            return True


if __name__ == '__main__':
    Github = GitHub()
    print(Github.gitStatus())
    print(Github.getActiveBranch())
    Github.gitAddSpecific(["Roman"])
    Github.gitCommitAll("update roman fold")
    Github.gitPull()
    Github.gitPush()
    # print(Github.gitStatus())
    # print(Github.commitsDiff())
