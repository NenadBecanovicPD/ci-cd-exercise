package com.productdock.exercise_2;

public class Order {

    private int orderId;
    private int userId;
    private String status;

    public void process(int userId) {
        if (this.userId != userId) {
            throw new ForbiddenException();
        }
        if (("DELETED").equals(this.status)) {
            throw new BadRequestException();
        }
        this.update();
    }

    private void update() {
    }

}
