package com.productdock.fortest.mocks;

import java.util.List;

public class LoyaltyService {

  private CustomerRepository customerRepository;
  private PurchaseHistoryRepository purchaseHistoryRepository;
  private CustomerMailingService customerMailingService;
  private BonusVoucherService bonusVoucherService;

  public void awardLoyalty(Long customerId) {
    Customer customer = customerRepository.getById(customerId);

    if (!isApplyingTo(customer)) {
      customerMailingService.sendNextGoal(customer);
      return;
    }

    createBonusVoucher(customer);
  }

  private boolean isApplyingTo(Customer customer) {
    PurchaseHistory history = purchaseHistoryRepository.getByCustomer(customer);
    if (history == null) {
      throw new IllegalStateException();
    }
    return history.getTotal() > 3000 && !history.isAlreadyDiscounted();
  }

  private void createBonusVoucher(Customer customer) {
    double total = 0.0d;
    List<Purchase> purchases = purchaseHistoryRepository.getAllPurchases();
    for (Purchase p : purchases) {
      if (p.containsAwards()) {
        total += p.getSum();
      }
    }
    bonusVoucherService.grantBonusTo(total, customer);
  }
}
