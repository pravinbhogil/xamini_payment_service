package com.cognizant.payments.payments;

import com.cognizant.payments.payments.publisher.CustomerNotificationService;
import com.cognizant.payments.payments.publisher.PaymentNotificationService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class PaymentServiceImplTest {

    @Mock
    private CustomerNotificationService customerNotificationService;

    @Mock
    private PaymentNotificationService paymentNotificationService;
    @InjectMocks
    private PaymentServiceImpl paymentService = new PaymentServiceImpl(customerNotificationService, paymentNotificationService);

    private Customer firstDigital = new Customer(101, "First Digital");
    private Customer janeLuna = new Customer(101, "First Digital");

    private Account GOLD_ACCOUNT = new Account(1001, "Premier Track", firstDigital, 500_000, Membership.GOLD);
    private Account GOLD_TO_SILVER_ACCOUNT = new Account(1001, "Premier Track", firstDigital, 250_000, Membership.GOLD);
    private Account BRONZE_ACCOUNT = new Account(1005, "Russet", new Customer(101, "Cast Cooper"), 40_000, Membership.BRONZE);
    private Account SILVER_TO_BRONZE_ACCOUNT = new Account(1005, "Tinsel", janeLuna, 150_000.00, Membership.SILVER);
    private Account SILVER_TO_BRONZE_ACCOUNT_2 = new Account(1005, "Tinsel", janeLuna, 52_000.00, Membership.SILVER);


    private static final double fourHundredNinetyNine = 499.99;
    private static final double twoHundredNinetyNine = 299.99;

    private static final double oneHundredNinetyNine = 199.99;
    private static final int hundredSalesUnits = 100;
    private static final int fiftySalesUnits = 50;
    private static final int twentyFiveSalesUnits = 25;

    private static  Account actualAccount=null;



    @Test
    @Order(1)
    void processPayment_for_GOLD_ACCOUNT_Test() {
        Account expectedAccount = new Account(1001, "Premier Track", firstDigital, 454_975.90, Membership.GOLD);
        var expectedPayment = CommonUtils.round(GOLD_ACCOUNT.getBalance() - expectedAccount.getBalance());
        verifyAndAssertExpectedAccountAndPayment(GOLD_ACCOUNT, fourHundredNinetyNine, hundredSalesUnits, expectedPayment, expectedAccount);
        actualAccount=expectedAccount;
    }

    @Test
    @Order(2)
    void processPayment_for_ACCOUNT_2_Test() {
        Account expectedAccount = new Account(1001, "Premier Track", firstDigital, 431_213.88, Membership.GOLD);
        var expectedPayment = CommonUtils.round(actualAccount.getBalance() - expectedAccount.getBalance());
        verifyAndAssertExpectedAccountAndPayment(actualAccount, fourHundredNinetyNine, fiftySalesUnits, expectedPayment, expectedAccount);
        actualAccount=expectedAccount;
    }

    @Test
    @Order(3)
    void processPayment_for_ACCOUNT_3_Test() {
        Account expectedAccount = new Account(1001, "Premier Track", firstDigital, 418_714.13, Membership.GOLD);
        var expectedPayment = CommonUtils.round(actualAccount.getBalance() - expectedAccount.getBalance());
        verifyAndAssertExpectedAccountAndPayment(actualAccount, fourHundredNinetyNine, twentyFiveSalesUnits, expectedPayment, expectedAccount);

    }

    @Test
    @Order(4)
    void processPayment_for_SILVER_TO_BRONZE_ACCOUNT_Test() {
        Account expectedAccount = new Account(1005, "Tinsel", new Customer(101, "Jane Luna"), 122_985.90, Membership.SILVER);
        var expectedPayment = CommonUtils.round(SILVER_TO_BRONZE_ACCOUNT.getBalance() - expectedAccount.getBalance());
        verifyAndAssertExpectedAccountAndPayment(SILVER_TO_BRONZE_ACCOUNT, twoHundredNinetyNine, hundredSalesUnits, expectedPayment, expectedAccount);
    }

    @Test
    @Order(5)
    void processPayment_for_BRONZE_ACCOUNT_Test() {
        Account expectedAccount = new Account(1005, "Russet", new Customer(101, "Cast Cooper"), 30_495.48, Membership.BRONZE);
        var expectedPayment = CommonUtils.round(BRONZE_ACCOUNT.getBalance() - expectedAccount.getBalance());
        verifyAndAssertExpectedAccountAndPayment(BRONZE_ACCOUNT, oneHundredNinetyNine, fiftySalesUnits, expectedPayment, expectedAccount);
    }

    @Test
    @Order(5)
    void processPayment_for_GOLD_TO_SILVER_ACCOUNT_Test() {
        Account expectedAccount = new Account(1001, "Premier Track", firstDigital, 235_742.98, Membership.GOLD);
        var expectedPayment = CommonUtils.round(GOLD_TO_SILVER_ACCOUNT.getBalance() - expectedAccount.getBalance());
        verifyAndAssertExpectedAccountAndPayment(GOLD_TO_SILVER_ACCOUNT, twoHundredNinetyNine, fiftySalesUnits, expectedPayment, expectedAccount);
        verifyAndAssertExpectedAccountTypeChange(GOLD_TO_SILVER_ACCOUNT,Membership.SILVER,firstDigital);
    }

    @Test
    @Order(5)
    void processPayment_for_SILVER_TO_BRONZE_ACCOUNT_Test_2() {
        Account expectedAccount = new Account(1005, "Tinsel", janeLuna, 47_000.25, Membership.SILVER);
        var expectedPayment = CommonUtils.round(SILVER_TO_BRONZE_ACCOUNT_2.getBalance() - expectedAccount.getBalance());
        verifyAndAssertExpectedAccountAndPayment(SILVER_TO_BRONZE_ACCOUNT_2, oneHundredNinetyNine, twentyFiveSalesUnits, expectedPayment, expectedAccount);
        verifyAndAssertExpectedAccountTypeChange(SILVER_TO_BRONZE_ACCOUNT_2,Membership.BRONZE,janeLuna);
    }



    void verifyAndAssertExpectedAccountAndPayment(Account actualAccount, double actualAmount, int salesUnits, double expectedPayment, Account expectedAccount) {

        paymentService.processPayment(actualAccount, actualAmount, salesUnits);
        verify(paymentNotificationService).pay(expectedAccount, expectedPayment);

    }

    void verifyAndAssertExpectedAccountTypeChange(Account actualAccount, Membership expectedMemberShip, Customer expectedCustomer) {

        verify(customerNotificationService).membershipChange(expectedCustomer,actualAccount.getMembership(), expectedMemberShip);

    }


}