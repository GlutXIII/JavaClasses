package DataGenerator;

import POJO.Account;
import POJO.Customer;
import Services.AccountHistoryService;
import Services.BankAccountOperationService;

import java.util.Date;

public class Generator {
    public void createSampleData(){
        BankAccountOperationService bankAccountOperationService = new BankAccountOperationService();
        AccountHistoryService accountHistoryService = new AccountHistoryService();

        Customer customer = new Customer();
        customer.setName("Piotr");
        customer.setID("2");
        customer.setLastName("Cos");
        customer.setDateOfBirth(new Date());
        /*try{*/
            bankAccountOperationService.createAccountForCustomer(customer,"123123123123124444");
/*        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }*/

      //  bankAccountOperationService.removeAccount("123123123123123128");
        bankAccountOperationService.deposit("123123123123121218",100);
    bankAccountOperationService.withdraw("123123123123121218",50);
    bankAccountOperationService.deposit("123123123123121218",400);
   bankAccountOperationService.transfer("123123123123121218",100, "123123123123121219");


    }

}
