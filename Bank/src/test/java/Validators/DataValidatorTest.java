package Validators;

import POJO.Account;
import POJO.Customer;
import Services.AccountHistoryService;
import Services.BankAccountOperationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class DataValidatorTest{

    @Mock
    private AccountHistoryService accountHistoryService = new AccountHistoryService();

    private DataValidator dataValidator = new DataValidator();
    @Before
    public void setUp(){
        initMocks(this);
        List<Account> accountList = new ArrayList<Account>();
        Account account = new Account();
        account.setAccountBalance(0);
        account.setAccountNumber("123123123123123123");
        accountList.add(account);
        when(accountHistoryService.getAllAccounts()).thenReturn(accountList);
    }

    @Test
    public void validateCustomerTest(){
        Customer customer = new Customer();
        customer.setDateOfBirth(new Date());
        assertFalse(dataValidator.validateCustomer(customer));
        customer.setLastName("asd");
        assertFalse(dataValidator.validateCustomer(customer));
        customer.setName("asd1");
        assertFalse(dataValidator.validateCustomer(customer));
        customer.setID("1");
        assertTrue(dataValidator.validateCustomer(customer));
    }
    @Test
    public void validateNewAccountTest(){
        Account account = new Account();
        assertFalse(dataValidator.validateNewAccount(account));
        assertFalse(dataValidator.validateNewAccount(account));
        account.setAccountNumber("123");
        assertFalse(dataValidator.validateNewAccount(account));
        account.setAccountNumber("12312312312312312d");
        assertFalse(dataValidator.validateNewAccount(account));
        account.setAccountNumber("999111999111999111");
        assertTrue(dataValidator.validateNewAccount(account));

    }
}
