# moving-average-stream

## Task Overview

A trading dashboard plots the moving average of the most recent K trade prices, updating once per incoming trade. You are given a class `MovingAverage` whose constructor receives a positive integer `K` representing the window size. The class exposes a single method `next(value)` that accepts the next numeric price and returns the mean of the most recent **up-to-K** values seen so far as a floating-point number.

If fewer than K values have arrived, compute the average over however many have been submitted — do **not** divide by K until the window is full. Values may be negative or fractional. The constructor argument K is guaranteed to be at least 1 and does not require validation.

Implement the `MovingAverage` class with its `next` method in your chosen language.

## Examples

**Example 1:** Constructed with K = 3, five calls made.

**Input:** next(1), next(10), next(3), next(5), next(5)

**Output:** 1.0, 5.5, 4.6667, 6.0, 4.3333

**Explanation:** The window slides forward on each call. After next(5) the window holds [10, 3, 5] (the 1 was evicted), giving average 18/3 = 6.0. On the next next(5) the window becomes [3, 5, 5] and the average is 13/3 ≈ 4.3333.

**Example 2:** Constructed with K = 1, two calls made.

**Input:** next(7), next(42)

**Output:** 7.0, 42.0

**Explanation:** A window of size 1 always holds exactly one value, so each call immediately evicts the previous entry and returns the new value.

**Example 3:** Constructed with K = 5, only two calls made.

**Input:** next(4), next(6)

**Output:** 4.0, 5.0

**Explanation:** The window is not yet full, so divide by the number of values received so far, not by K. After two calls the average is (4 + 6) / 2 = 5.0.

## Constraints

- `1 <= K <= 10,000`
- Up to `10,000` calls to `next()` per test run.
- Each value passed to `next()` fits in a 64-bit float; values may be negative or fractional.
- While the window is not yet full (fewer than K values received), divide by the count of values received so far.
- Once the window is full, divide by K and evict the oldest value on every subsequent call.
- Return type is a float (or double) — the very first call returns the first value cast to float.
- Target complexity: **O(1)** per call to `next()`; **O(K)** total memory.

## How to Verify

- Open the `solution.*` file inside your chosen language folder and implement the `MovingAverage` class with its `next` method.
- Run the tests for your chosen language:
  - Python → `pytest` (inside the `python/` folder)
  - JavaScript → `npm test` (inside the `javascript/` folder)
  - TypeScript → `npm test` (inside the `typescript/` folder)
  - Java → `mvn test` (inside the `java/` folder)
  - C++ → `make test` (inside the `cpp/` folder)
- All committed tests in your chosen folder must pass before you submit.
- Use only the standard library and built-in primitives — no third-party DSA libraries.
