package com.productdock.exercise_3;

import java.util.List;

public class ShoppingCart {

  private PaymentService paymentService;
  private ShippingService shippingService;
  private NotificationService notificationService;
  private DeliveryService deliveryService;

  public void checkout(List items, double totalPrice,
                       String emailAddress, String fullName,
                       String deliveryCountry, String deliveryAddress, String deliveryCity,
                       String cardNumber, String expiryDate, String cvv) {
    deliveryService.reserveStocks(items);
    shippingService.scheduleShipping(fullName, deliveryCountry, deliveryCity, deliveryAddress);
    notificationService.sendNotificationTo(emailAddress, items, totalPrice);
    paymentService.makePayment(totalPrice, cardNumber, expiryDate, cvv);
  }

}
