from dataclasses import *
from typing import Mapping

# import os
# import sys
# sys.path.insert(0, f"{os.getcwd()}")

from Roman.devEnv.infra.git import GitInfra




@dataclass
class Order:
    name: str
    side: str = field(repr=False)
    comment: str
    cash: float = field(repr=True)
    main: str = field(default="Pizza", repr=False)



if __name__ == "__main__":
   import sys
   for i in sys.path:
       if i == r"C:\temp\GIT\mainCodes":
           print("====" * 10)