package pl.lodz.uni.math.factory.Provider;

import pl.lodz.uni.math.factory.Factory;
import pl.lodz.uni.math.factory.enums.FactoryEnum;
import pl.lodz.uni.math.factory.factoryImpl.CSVFactory;
import pl.lodz.uni.math.factory.factoryImpl.DBFactory;
import pl.lodz.uni.math.factory.factoryImpl.WSFactory;
import pl.lodz.uni.math.factory.factoryImpl.XMLFactory;

import java.util.HashMap;
import java.util.Map;

public enum DaoFactoryProvider{

    INSTANCE;

    private Factory factory;

    private static final Map<FactoryEnum, Factory> factoryEnumToFactoryMap;

    static {
        factoryEnumToFactoryMap = new HashMap<FactoryEnum, Factory>();
        factoryEnumToFactoryMap.put(FactoryEnum.XML, new XMLFactory());
        factoryEnumToFactoryMap.put(FactoryEnum.CSV, new CSVFactory());
        factoryEnumToFactoryMap.put(FactoryEnum.DBF, new DBFactory());
        factoryEnumToFactoryMap.put(FactoryEnum.WSF, new WSFactory());
    }

    public void setSourceOfData(FactoryEnum factoryEnum) {
        factory = factoryEnumToFactoryMap.get(factoryEnum);
    }

    public Factory getService(){
        return factory;
    }
}
