package pl.lodz.uni.math;

import pl.lodz.uni.math.factory.Factory;
import pl.lodz.uni.math.factory.Provider.DaoFactoryProvider;
import pl.lodz.uni.math.factory.enums.FactoryEnum;

public class Main {

    public static void main(String[] args) {
        DaoFactoryProvider.INSTANCE.setSourceOfData(FactoryEnum.CSV);

         System.out.println(DaoFactoryProvider.INSTANCE.getService().getName());
        DaoFactoryProvider.INSTANCE.setSourceOfData(FactoryEnum.DBF);
      System.out.println(DaoFactoryProvider.INSTANCE.getService().getName());
      /*  FactoryDataToUserTransformer factoryDataToUserTransformer = new FactoryDataToUserTransformer();
        Person person = factoryDataToUserTransformer.populate(daoFactoryProvider);
        System.out.println("Imie: " + person.getName() + " Wiek: "+ person.getAge());*/
    }
}
