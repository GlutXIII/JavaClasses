package Services;

import POJO.Account;

import POJO.Customer;
import Enums.OperationType;
import POJO.TransactionHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AccountHistoryService {

    private static final String ACCOUNTS_PATH = "accounts.txt";
    private static final String OPERATION_HISTORY_PATH = "operationHistory.txt";
    private static final String CUSTOMER_PATH = "customers.txt";
    private final Logger LOG = LoggerFactory.getLogger(AccountHistoryService.class);

    public void saveNewAccount(Account account) {
        writeToFile(account.getAccountNumber() + " " + account.getOwner().getID() + " " + account.getAccountBalance() + " ", ACCOUNTS_PATH);
    }

    public List<Account> getAllAccounts() {
        List<Account> accountList = new ArrayList<Account>();
        File file = new File(ACCOUNTS_PATH);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            LOG.error("Cannot find file {}" + ACCOUNTS_PATH);
        }
        if (sc != null) {
            while (sc.hasNext()) {
                Account account = new Account();
                account.setAccountNumber(sc.next());
                Customer customer = new Customer();
                customer.setID(sc.next());
                account.setOwner(customer);
                account.setAccountBalance(Integer.valueOf(sc.next()));
                accountList.add(account);
            }
        }
        return accountList;
    }

    public List<TransactionHistory> getHistory() {
        List<TransactionHistory> transactionHistoryList = new ArrayList<TransactionHistory>();
        File file = new File(OPERATION_HISTORY_PATH);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            LOG.error("Cannot find file {}" + OPERATION_HISTORY_PATH);
        }
        if (sc != null) {
            while (sc.hasNext()) {
                TransactionHistory transactionHistory = new TransactionHistory();
                transactionHistory.setOperationType(OperationType.valueOf(sc.next()));
                transactionHistory.setAccountNumber(sc.next());
                transactionHistory.setAccountBalanceAfterTransaction(sc.next());
                transactionHistory.setAmountOfMoneyTransfered(sc.next());
                transactionHistory.setOwnerId(sc.next());
                transactionHistoryList.add(transactionHistory);
            }
        }
        return transactionHistoryList;

    }


    private void writeToFile(String data, String filePath) {
        File file = new File(filePath);

        try {
            if (!file.exists()) {
                LOG.debug("File does not exist");
            }

            FileWriter fileWriter = new FileWriter(file, true);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();

            LOG.debug("Done");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveAllChanges(List<Account> accountList) {
        cleanFile(ACCOUNTS_PATH);
        for (Account account : accountList
                ) {
            writeToFile(account.getAccountNumber() + " " + account.getOwner().getID() + " " + account.getAccountBalance() + " ", ACCOUNTS_PATH);
        }
    }

    public void saveHistoryOfOperation(OperationType operationType, String amount, Account account) {
        writeToFile(operationType.toString() + " " + account.getAccountNumber() + " " + account.getAccountBalance() + " " + amount + " " + account.getOwner().getID() + " ", OPERATION_HISTORY_PATH);
    }

    private void cleanFile(String pathToFile) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(pathToFile);
            writer.print("");
        } catch (FileNotFoundException e) {
            LOG.error(e.getMessage());
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

  /*  private List<Customer> getAllCustomers() {
        List<Customer> customerList = new ArrayList<Customer>();
        File file = new File(CUSTOMER_PATH);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            LOG.error("Cannot find file {}" + CUSTOMER_PATH);
        }
        if (sc != null) {
            while (sc.hasNext()) {
                Customer customer = new Customer();
                customer.setID(sc.next());
                customer.setName(sc.next());
                customer.setLastName(sc.next());
                customerList.add(customer);
            }
        }
        return customerList;

    }*/

 /*   public void changeCustomerData(Customer customer) {
        List<Customer> customerListOut = getAllCustomers();
        List<Customer> customerListIn = new ArrayList<Customer>();
        for (Customer customerFromFile :
                customerListOut) {
            if (customer.getID().equals(customerFromFile.getID())) {
                customerListIn.add(customer);
            } else {
                customerListIn.add(customerFromFile);
            }
            saveAllCustomerChanges(customerListIn,CUSTOMER_PATH);
        }
    }
    private void saveAllCustomerChanges(List<Customer> customerList,String path) {
        cleanFile(path);
        for (Customer customer : customerList
                ) {
            writeToFile(customer.getID() + " " + customer.getName() + " " + customer.getLastName() , path);
        }
    }
    public void saveNewCustomer(Customer customer) {
        writeToFile(customer.getID() + " " + customer.getName() + " " + customer.getLastName() , CUSTOMER_PATH);
    }*/
}
