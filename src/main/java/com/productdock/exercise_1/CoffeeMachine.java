package com.productdock.exercise_1;

public class CoffeeMachine {

  private Display display;
  private Monitor monitor = new Monitor(1000);

  public void makeCoffee() {
    if (monitor.getCoffeeCount() >= monitor.getCoffeeLimit()) {
      display.show("Time for service. Call " + monitor.getServiceCompany());
      return;
    }
    monitor.setCoffeeCount(monitor.getCoffeeCount() + 1);
  }
}
