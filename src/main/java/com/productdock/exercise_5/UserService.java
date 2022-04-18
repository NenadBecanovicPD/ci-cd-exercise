package com.productdock.exercise_5;

import java.util.Date;

public class UserService {

  private UserRepository userRepository;
  private NotificationService notificationService;

  public User getUser(String username) {
    User user = userRepository.getByUsername(username);

    if (user.isCustomer()) {
      appendCustomerRelevantInformation(user);
    } else if (user.isEmployee()) {
      appendEmployeeRelevantInformation(user);
    }

    String password = "...";
    if (user.setOneTimePassword(password)) {
      user.setPasswordExpiryDate();
    }

    if (user.isFirstTimeVisiting()) {
      notificationService.sendOnboardingMail();
    }

    return user;
  }

  private void appendEmployeeRelevantInformation(User user) {
  }

  private void appendCustomerRelevantInformation(User user) {
  }

  public boolean set(String attribute, String value) {
    return false;
  }

}
