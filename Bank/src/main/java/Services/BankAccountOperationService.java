package Services;

import POJO.Account;
import POJO.Customer;
import Enums.OperationType;
import Validators.DataValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class BankAccountOperationService {
    private final Logger LOG = LoggerFactory.getLogger(BankAccountOperationService.class);

    private static final String ACCOUNTS_PATH = "accounts.txt";

    private AccountHistoryService accountHistoryService = new AccountHistoryService();
    private DataValidator validator = new DataValidator();

    public void createAccountForCustomer(Customer customer, String number) throws IllegalArgumentException {
        Account account = new Account();
        account.setAccountNumber(number);
        account.setOwner(customer);
        account.setAccountBalance(0);

        if (!validator.validateNewAccount(account) || !validator.validateCustomer(customer)) {
            throw new IllegalArgumentException();
        }
      /*  accountHistoryService.saveNewCustomer(customer);*/
        accountHistoryService.saveNewAccount(account);
    }

    public void withdraw(String accountNumber, Integer amount) {
        List<Account> accountListOut = accountHistoryService.getAllAccounts();
        List<Account> accountListIn = new ArrayList<Account>();
        for (Account account :
                accountListOut) {
            if (account.getAccountNumber().equals(accountNumber)) {
                if (account.getAccountBalance() >= amount) {
                    account.setAccountBalance(account.getAccountBalance() - amount);
                    accountHistoryService.saveHistoryOfOperation(OperationType.WITHDRAW, amount.toString(), account);
                } else {
                    LOG.error("Not enought money on account");
                    break;
                }
            }
            accountListIn.add(account);
        }

        accountHistoryService.saveAllChanges(accountListIn);
    }

    public void deposit(String accountNumber, Integer amount) {
        List<Account> accountListOut = accountHistoryService.getAllAccounts();
        List<Account> accountListIn = new ArrayList<Account>();
        for (Account account :
                accountListOut) {
            if (account.getAccountNumber().equals(accountNumber)) {
                account.setAccountBalance(account.getAccountBalance() + amount);
                accountHistoryService.saveHistoryOfOperation(OperationType.DEPOSIT, amount.toString(), account);
            }
            accountListIn.add(account);
        }
        accountHistoryService.saveAllChanges(accountListIn);
    }

    public void transfer(String accountNumber, Integer amount, String reciver) {
        if (!accountNumber.equals(reciver)) {
            List<Account> accountListOut = accountHistoryService.getAllAccounts();
            List<Account> accountListIn = new ArrayList<Account>();
            for (Account account :
                    accountListOut) {
                if (account.getAccountNumber().equals(accountNumber)) {
                    if (account.getAccountNumber().equals(reciver)) {
                        account.setAccountBalance(account.getAccountBalance() + amount);
                    }
                    if (account.getAccountBalance() > amount) {
                        account.setAccountBalance(account.getAccountBalance() - amount);
                        accountHistoryService.saveHistoryOfOperation(OperationType.TRANSFER, amount.toString(), account);
                    } else {
                        LOG.error("Not enought money on account to transfer");
                        break;
                    }
                }
                accountListIn.add(account);
            }
            accountHistoryService.saveAllChanges(accountListIn);
        }
    }

    public void removeAccount(String accountNumber) {
        List<Account> accountListOut = accountHistoryService.getAllAccounts();
        List<Account> accountListIn = new ArrayList<Account>();
        for (Account account :
                accountListOut) {
            if (!account.getAccountNumber().equals(accountNumber)) {
                accountListIn.add(account);
            }
            accountHistoryService.saveAllChanges(accountListIn);
        }
    }
}
