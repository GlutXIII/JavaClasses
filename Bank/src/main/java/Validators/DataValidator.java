package Validators;

import POJO.Account;
import POJO.Customer;
import Services.AccountHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.List;

import static java.lang.Character.isDigit;

public class DataValidator {

    private final Logger LOG = LoggerFactory.getLogger(DataValidator.class);

    private AccountHistoryService accountHistoryService = new AccountHistoryService();

    public boolean validateCustomer(Customer customer){
        Boolean result = true;
        if(customer.getID() == null){
            result = false;
            LOG.error("Customer Id cannot be null");
        }
        if(customer.getDateOfBirth() == null){
            result = false;
            LOG.error("Customer date of birth cannot be null");
        }
        if(customer.getName() == null){
            result = false;
            LOG.error("Customer name cannot be null");
        }
        if(customer.getLastName() == null){
            result = false;
            LOG.error("Customer last name cannot be null");
        }
        return result;
    }
    public boolean validateNewAccount(Account accountIn){
        Boolean result = true;
        List<Account> accountList = accountHistoryService.getAllAccounts();
        if(StringUtils.isEmpty(accountIn.getAccountNumber())){
            result = false;
            LOG.error("Account number must be set");
            return result;
        }
        for (Account account: accountList
             ) {
            if(account.getAccountNumber().equals(accountIn.getAccountNumber())){
                result = false;
                LOG.error("Account with number {} already exists!", accountIn.getAccountNumber());
            }
        }
        if(accountIn.getAccountNumber().length()!=18){
            LOG.error("Account number have not appropriate length, {}", accountIn.getAccountNumber().length());
            return false;
        }
        for (int i=0;i<18;i++) {
          if( !isDigit( accountIn.getAccountNumber().charAt(i))){
              result = false;
              LOG.error("Account number must have only digits!");
            }
        }
        return result;
    }
}
