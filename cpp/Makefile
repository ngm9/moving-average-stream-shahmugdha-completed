CXX      = g++
CXXFLAGS = -std=c++17 -Wall -Wextra -o moving_average_test

.PHONY: test clean

test: solution.cpp test_solution.cpp solution.h
	$(CXX) $(CXXFLAGS) solution.cpp test_solution.cpp
	./moving_average_test

clean:
	rm -f moving_average_test
