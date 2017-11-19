package pl.lodz.uni.math.factory;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.lodz.uni.math.factory.enums.FactoryEnum;
import pl.lodz.uni.math.factory.factoryImpl.CSVFactory;
import pl.lodz.uni.math.factory.factoryImpl.DBFactory;
import pl.lodz.uni.math.factory.factoryImpl.WSFactory;
import pl.lodz.uni.math.factory.factoryImpl.XMLFactory;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static pl.lodz.uni.math.factory.enums.FactoryEnum.getFactory;


public class DAOFactoryProviderTest {
    @InjectMocks
    private  DAOFactoryProvider daoFactoryProvider = new DAOFactoryProvider();
    @Mock
    private CSVFactory csvFactory;
    @Mock
    private DBFactory dbFactory;
    @Mock
    private WSFactory wsFactory;
    @Mock
    private XMLFactory xmlFactory;

   @Before
    public void setUp(){

       initMocks(this);
       when(csvFactory.getName()).thenReturn("csvFactoryData");
       when(wsFactory.getName()).thenReturn("wsFactoryData");
       when(dbFactory.getName()).thenReturn("dbFactoryData");
       when(xmlFactory.getName()).thenReturn("dbFactoryData");
    }

    @Test
    public void setInstanceTest(){

        daoFactoryProvider.setInstance(getFactory(FactoryEnum.CSV));
        if(daoFactoryProvider.instance instanceof  CSVFactory) {
            assertEquals("csvFactoryData", csvFactory.getName());
        }
        daoFactoryProvider.setInstance(getFactory(FactoryEnum.WSF));
        if(daoFactoryProvider.instance instanceof  CSVFactory) {
            assertEquals("wsFactoryData", wsFactory.getName());
        }
        daoFactoryProvider.setInstance(getFactory(FactoryEnum.DBF));
        if(daoFactoryProvider.instance instanceof  DBFactory) {
            assertEquals("dbFactoryData", dbFactory.getName());
        }
        daoFactoryProvider.setInstance(getFactory(FactoryEnum.XML));
        if(daoFactoryProvider.instance instanceof  XMLFactory) {
            assertEquals("dbFactoryData", xmlFactory.getName());
        }


    }

}
