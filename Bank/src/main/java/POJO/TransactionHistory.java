package POJO;

import Enums.OperationType;

public class TransactionHistory {
    private OperationType operationType;
    private String accountNumber;
    private String accountBalanceAfterTransaction;
    private String amountOfMoneyTransfered;
    private String OwnerId;

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountBalanceAfterTransaction() {
        return accountBalanceAfterTransaction;
    }

    public void setAccountBalanceAfterTransaction(String accountBalanceAfterTransaction) {
        this.accountBalanceAfterTransaction = accountBalanceAfterTransaction;
    }

    public String getAmountOfMoneyTransfered() {
        return amountOfMoneyTransfered;
    }

    public void setAmountOfMoneyTransfered(String amountOfMoneyTransfered) {
        this.amountOfMoneyTransfered = amountOfMoneyTransfered;
    }

    public String getOwnerId() {
        return OwnerId;
    }

    public void setOwnerId(String ownerId) {
        OwnerId = ownerId;
    }

    @Override
    public String toString() {
        return "TransactionHistory{" +
                "operationType=" + operationType +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountBalanceAfterTransaction='" + accountBalanceAfterTransaction + '\'' +
                ", amountOfMoneyTransfered='" + amountOfMoneyTransfered + '\'' +
                ", OwnerId='" + OwnerId + '\'' +
                '}';
    }
}
