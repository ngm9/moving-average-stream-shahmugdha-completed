#pragma once

class MovingAverage {
public:
    explicit MovingAverage(int k);
    double next(double value);

private:
    int k_;
};
