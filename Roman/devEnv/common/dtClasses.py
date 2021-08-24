from dataclasses import *


@dataclass
class Order:
    name: str
    main: str
    side: str
    comment: str
    cash: float


print(is_dataclass(Order))