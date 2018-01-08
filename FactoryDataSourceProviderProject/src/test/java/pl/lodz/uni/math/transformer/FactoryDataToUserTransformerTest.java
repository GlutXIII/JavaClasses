package pl.lodz.uni.math.transformer;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import pl.lodz.uni.math.POJO.Person;
import pl.lodz.uni.math.factory.factoryImpl.CSVFactory;
import pl.lodz.uni.math.factory.transformer.FactoryDataToUserTransformer;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class FactoryDataToUserTransformerTest {

    @InjectMocks
    FactoryDataToUserTransformer factoryDataToUserTransformer = new FactoryDataToUserTransformer();

    @Mock
    CSVFactory csvFactory;

    @Before
    public void setUp(){
    initMocks(this);
    when(csvFactory.getAge()).thenReturn(4);
    when(csvFactory.getName()).thenReturn("Name");
    }

    @Test
    public void populateTest(){
        Person person = factoryDataToUserTransformer.populate(csvFactory);
        assertEquals(Integer.valueOf(4),person.getAge());
        assertEquals("Name",person.getName());
    }
}
