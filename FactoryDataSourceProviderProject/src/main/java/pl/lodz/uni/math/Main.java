package pl.lodz.uni.math;

import pl.lodz.uni.math.POJO.Person;
import pl.lodz.uni.math.factory.DAOFactoryProvider;
import pl.lodz.uni.math.factory.enums.FactoryEnum;
import pl.lodz.uni.math.factory.transformer.FactoryDataToUserTransformer;


import static pl.lodz.uni.math.factory.enums.FactoryEnum.getFactory;

public class Main {

    public static void main(String[] args) {
        DAOFactoryProvider daoFactoryProvider = new DAOFactoryProvider();
        daoFactoryProvider.setInstance(getFactory(FactoryEnum.CSV));
        System.out.println(daoFactoryProvider.getName());
        daoFactoryProvider.setInstance(getFactory(FactoryEnum.WSF));
        System.out.println(daoFactoryProvider.getName());
        FactoryDataToUserTransformer factoryDataToUserTransformer = new FactoryDataToUserTransformer();
        Person person = factoryDataToUserTransformer.populate(daoFactoryProvider);
        System.out.println("Imie: " + person.getName() + " Wiek: "+ person.getAge());
    }
}
