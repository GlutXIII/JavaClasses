package pl.lodz.uni.math.factory;

import org.junit.Test;
import pl.lodz.uni.math.factory.enums.FactoryEnum;
import pl.lodz.uni.math.factory.factoryImpl.CSVFactory;
import pl.lodz.uni.math.factory.factoryImpl.DBFactory;
import pl.lodz.uni.math.factory.factoryImpl.WSFactory;
import pl.lodz.uni.math.factory.factoryImpl.XMLFactory;
import pl.lodz.uni.math.factory.Provider.DaoFactoryProvider;

import static junit.framework.Assert.assertTrue;

public class DaoFactoryProviderTest {

    @Test
    public void setSourceOfData() {

        DaoFactoryProvider.INSTANCE.setSourceOfData(FactoryEnum.CSV);
        assertTrue( DaoFactoryProvider.INSTANCE.getService() instanceof CSVFactory);
        DaoFactoryProvider.INSTANCE.setSourceOfData(FactoryEnum.WSF);
        assertTrue( DaoFactoryProvider.INSTANCE.getService() instanceof WSFactory);
        DaoFactoryProvider.INSTANCE.setSourceOfData(FactoryEnum.DBF);
        assertTrue( DaoFactoryProvider.INSTANCE.getService() instanceof DBFactory);
        DaoFactoryProvider.INSTANCE.setSourceOfData(FactoryEnum.XML);
        assertTrue( DaoFactoryProvider.INSTANCE.getService() instanceof XMLFactory);
    }

}
