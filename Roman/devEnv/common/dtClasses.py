from dataclasses import *


@dataclass
class Order:
    name: str
    side: str = field(repr=False)
    comment: str
    cash: float = field(repr=True)
    main: str = field(default="Pizza", repr=False)
