import DataGenerator.Generator;
import Services.PrintLineService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {


    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        PrintLineService printLineService = new PrintLineService();
        Generator generator = new Generator();
        generator.createSampleData();
        printLineService.printAllAccounts();
      //  printLineService.printHistoryOfAccount("123123123123123127");
        printLineService.printHistoryOfBank();
       // printLineService.printHistoryOfCustomer("2");

    }
}
