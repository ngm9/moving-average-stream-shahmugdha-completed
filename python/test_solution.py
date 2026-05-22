import pytest
from solution import MovingAverage


def test_window_fills_then_evicts():
    ma = MovingAverage(3)
    assert ma.next(1) == pytest.approx(1.0)
    assert ma.next(10) == pytest.approx(5.5)
    assert ma.next(3) == pytest.approx(14 / 3)
    assert ma.next(5) == pytest.approx(6.0)
    assert ma.next(5) == pytest.approx(13 / 3)


def test_window_size_one():
    ma = MovingAverage(1)
    assert ma.next(7) == pytest.approx(7.0)
    assert ma.next(42) == pytest.approx(42.0)


def test_window_not_yet_full():
    ma = MovingAverage(5)
    assert ma.next(4) == pytest.approx(4.0)
    assert ma.next(6) == pytest.approx(5.0)


def test_negative_and_fractional_values():
    ma = MovingAverage(2)
    assert ma.next(-4.0) == pytest.approx(-4.0)
    assert ma.next(2.0) == pytest.approx(-1.0)
    assert ma.next(3.0) == pytest.approx(2.5)
