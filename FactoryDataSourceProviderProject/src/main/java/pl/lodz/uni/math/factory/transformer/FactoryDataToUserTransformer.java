package pl.lodz.uni.math.factory.transformer;

import pl.lodz.uni.math.POJO.Person;
import pl.lodz.uni.math.factory.DAOFactoryProvider;

public class FactoryDataToUserTransformer {

    public Person populate(DAOFactoryProvider input){
        Person output = new Person();
        output.setAge(input.getAge());
        output.setName(input.getName());
        return output;
    }
}
