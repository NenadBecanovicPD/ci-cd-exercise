package com.productdock.fortest.mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class LoyaltyServiceShould {

    @InjectMocks
    private LoyaltyService loyaltyService;
    @Mock
    private CustomerRepository customerRepository;
    @Mock
    private PurchaseHistoryRepository purchaseHistoryRepository;
    @Mock
    private CustomerMailingService customerMailingService;
    @Mock
    private BonusVoucherService bonusVoucherService;

    @Test
    void awardLoyaltyWithBonusVoucher() {
        Customer customer = Mockito.mock(Customer.class);
        PurchaseHistory purchaseHistory = Mockito.mock(PurchaseHistory.class);
        given(customerRepository.getById(1L)).willReturn(customer);
        given(purchaseHistoryRepository.getByCustomer(customer)).willReturn(purchaseHistory);
        given(purchaseHistory.getTotal()).willReturn(4000.0);
        given(purchaseHistory.isAlreadyDiscounted()).willReturn(false);

        loyaltyService.awardLoyalty(1L);

        verify(bonusVoucherService).grantBonusTo(0,customer);
    }

    @Test
    void throwIllegalException_whenCustomerHistoryIsNull() {
        Customer customer = Mockito.mock(Customer.class);
        given(customerRepository.getById(1L)).willReturn(customer);
        given(purchaseHistoryRepository.getByCustomer(customer)).willReturn(null);

        assertThatThrownBy(() -> loyaltyService.awardLoyalty(1L)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void sendNextGoal_whenPurchaseHistoryIsLessThanGoal() {
        Customer customer = Mockito.mock(Customer.class);
        PurchaseHistory purchaseHistory = Mockito.mock(PurchaseHistory.class);
        given(customerRepository.getById(1L)).willReturn(customer);
        given(purchaseHistoryRepository.getByCustomer(customer)).willReturn(purchaseHistory);
        given(purchaseHistory.getTotal()).willReturn(2000.0);

        loyaltyService.awardLoyalty(1L);

        verify(customerMailingService).sendNextGoal(customer);
    }

    @Test
    void sendNextGoal_whenPurchaseHistoryIsAlreadyDiscounted() {
        Customer customer = Mockito.mock(Customer.class);
        PurchaseHistory purchaseHistory = Mockito.mock(PurchaseHistory.class);
        given(customerRepository.getById(1L)).willReturn(customer);
        given(purchaseHistoryRepository.getByCustomer(customer)).willReturn(purchaseHistory);
        given(purchaseHistory.getTotal()).willReturn(4000.0);
        given(purchaseHistory.isAlreadyDiscounted()).willReturn(true);

        loyaltyService.awardLoyalty(1L);

        verify(customerMailingService).sendNextGoal(customer);
    }
}