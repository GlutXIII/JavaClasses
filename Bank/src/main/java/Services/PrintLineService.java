package Services;

import POJO.Account;
import POJO.TransactionHistory;

public class PrintLineService {
    private AccountHistoryService accountHistoryService = new AccountHistoryService();

    public void printAllAccounts() {
        for (Account account : accountHistoryService.getAllAccounts()) {
            System.out.println("Account number: " + account.getAccountNumber() + " , account owner id: " + account.getOwner().getID() + ", account balance: "+ account.getAccountBalance() + " zl");
        }
    }
    public void printHistoryOfBank(){
        for(TransactionHistory transactionHistory : accountHistoryService.getHistory()) {
            System.out.println(transactionHistory.toString());
        }
    }
    public void printHistoryOfCustomer(String id){
        for(TransactionHistory transactionHistory : accountHistoryService.getHistory()) {
            if(id.equals(transactionHistory.getOwnerId())) {
                System.out.println(transactionHistory.toString());
            }
        }
    }
    public void printHistoryOfAccount(String account){
        for(TransactionHistory transactionHistory : accountHistoryService.getHistory()){
            if(account.equals(transactionHistory.getAccountNumber()))
                System.out.println(transactionHistory.toString());
        }
    }

}
