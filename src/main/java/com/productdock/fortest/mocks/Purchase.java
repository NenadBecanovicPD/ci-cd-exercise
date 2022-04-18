package com.productdock.fortest.mocks;

public class Purchase {

  private double sum;
  private boolean hasAwards;

  public Purchase() {
  }

  public Purchase(double sum, boolean hasAwards) {
    this.sum = sum;
    this.hasAwards = hasAwards;
  }

  public boolean containsAwards() {
    return this.hasAwards;
  }

  public double getSum() {
    return this.sum;
  }
}
