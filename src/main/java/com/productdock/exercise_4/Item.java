package com.productdock.exercise_4;

public class Item {

  private double quantity;
  private double itemPrice;

  public double finalPrice() {
    double basePrice = this.quantity * this.itemPrice;

    return this.discountedPrice(basePrice);
  }

  private double discountedPrice(double basePrice) {
    switch (this.getDiscountLevel()) {
      case 1: return basePrice * 0.95;
      case 2: return basePrice * 0.9;
      default: return basePrice;
    }
  }

  private int getDiscountLevel() {
    if (this.quantity > 100) {
      return 2;
    } else {
      return 1;
    }
  }

}
