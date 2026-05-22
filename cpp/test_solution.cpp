#include <cassert>
#include <cmath>
#include <cstdio>
#include "solution.h"

static bool approx(double a, double b, double eps = 1e-9) {
    return std::fabs(a - b) < eps;
}

int main() {
    {
        MovingAverage ma(3);
        assert(approx(ma.next(1),  1.0));
        assert(approx(ma.next(10), 5.5));
        assert(approx(ma.next(3),  14.0 / 3));
        assert(approx(ma.next(5),  6.0));
        assert(approx(ma.next(5),  13.0 / 3));
    }

    {
        MovingAverage ma(1);
        assert(approx(ma.next(7),  7.0));
        assert(approx(ma.next(42), 42.0));
    }

    {
        MovingAverage ma(5);
        assert(approx(ma.next(4), 4.0));
        assert(approx(ma.next(6), 5.0));
    }

    {
        MovingAverage ma(2);
        assert(approx(ma.next(-4.0), -4.0));
        assert(approx(ma.next(2.0),  -1.0));
        assert(approx(ma.next(3.0),   2.5));
    }

    std::printf("All tests passed\n");
    return 0;
}
