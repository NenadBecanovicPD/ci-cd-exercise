package com.productdock.exercise_1;

public class Monitor {

    private int coffeeCount;
    private int coffeeLimit;
    private String serviceCompany;

    public Monitor(int coffeeLimit) {
        this.coffeeLimit = coffeeLimit;
    }

    public int getCoffeeCount() {
        return coffeeCount;
    }

    public void setCoffeeCount(int coffeeCount) {
        this.coffeeCount = coffeeCount;
    }

    public int getCoffeeLimit() {
        return coffeeLimit;
    }

    public void setCoffeeLimit(int coffeeLimit) {
        this.coffeeLimit = coffeeLimit;
    }

    public String getServiceCompany() {
        return serviceCompany;
    }

    public void setServiceCompany(String serviceCompany) {
        this.serviceCompany = serviceCompany;
    }
}
