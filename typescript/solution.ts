export class MovingAverage {
  private k: number;

  constructor(k: number) {
    this.k = k;
  }

  next(value: number): number {
    return 0;
  }
}
