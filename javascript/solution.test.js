'use strict';

const { MovingAverage } = require('./solution');

test('window fills then evicts', () => {
  const ma = new MovingAverage(3);
  expect(ma.next(1)).toBeCloseTo(1.0);
  expect(ma.next(10)).toBeCloseTo(5.5);
  expect(ma.next(3)).toBeCloseTo(14 / 3);
  expect(ma.next(5)).toBeCloseTo(6.0);
  expect(ma.next(5)).toBeCloseTo(13 / 3);
});

test('window size one', () => {
  const ma = new MovingAverage(1);
  expect(ma.next(7)).toBeCloseTo(7.0);
  expect(ma.next(42)).toBeCloseTo(42.0);
});

test('window not yet full', () => {
  const ma = new MovingAverage(5);
  expect(ma.next(4)).toBeCloseTo(4.0);
  expect(ma.next(6)).toBeCloseTo(5.0);
});

test('negative and fractional values', () => {
  const ma = new MovingAverage(2);
  expect(ma.next(-4.0)).toBeCloseTo(-4.0);
  expect(ma.next(2.0)).toBeCloseTo(-1.0);
  expect(ma.next(3.0)).toBeCloseTo(2.5);
});
