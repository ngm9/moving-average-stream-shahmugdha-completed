from collections import deque


class MovingAverage:
    def __init__(self, k: int) -> None:
        self.k = k
        self._window: deque = deque()
        self._total: float = 0.0

    def next(self, value: float) -> float:
        return 0.0
