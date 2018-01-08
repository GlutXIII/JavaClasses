package pl.lodz.uni.math.factory.transformer;

import pl.lodz.uni.math.POJO.Person;
import pl.lodz.uni.math.factory.Factory;

public class FactoryDataToUserTransformer {

    public Person populate(Factory input){
        Person output = new Person();
        output.setAge(input.getAge());
        output.setName(input.getName());
        return output;
    }
}
