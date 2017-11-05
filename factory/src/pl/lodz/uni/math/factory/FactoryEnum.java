package pl.lodz.uni.math.factory;

import pl.lodz.uni.math.factory.factoryImpl.CSVFactory;
import pl.lodz.uni.math.factory.factoryImpl.DBFactory;
import pl.lodz.uni.math.factory.factoryImpl.WSFactory;
import pl.lodz.uni.math.factory.factoryImpl.XMLFactory;

public enum FactoryEnum {
    XML,
    DBF,
    WSF,
    CSV;

    public static Factory getFactory(FactoryEnum factory){
        switch (factory) {

            case XML:
                return new XMLFactory();
            case DBF:
                return  new DBFactory();
            case WSF:
                return new WSFactory();
            case CSV:
                return new CSVFactory();
        }
        return null;
    }
}
