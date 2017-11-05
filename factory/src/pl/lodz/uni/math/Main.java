package pl.lodz.uni.math;

import pl.lodz.uni.math.factory.DAOFactoryProvider;
import pl.lodz.uni.math.factory.FactoryEnum;


import static pl.lodz.uni.math.factory.FactoryEnum.getFactory;

public class Main {

    public static void main(String[] args) {
        DAOFactoryProvider daoFactoryProvider = new DAOFactoryProvider();
        daoFactoryProvider.setInstance(getFactory(FactoryEnum.CSV));
        System.out.println(daoFactoryProvider.getName());
        daoFactoryProvider.setInstance(getFactory(FactoryEnum.WSF));
        System.out.println(daoFactoryProvider.getName());
    }
}
