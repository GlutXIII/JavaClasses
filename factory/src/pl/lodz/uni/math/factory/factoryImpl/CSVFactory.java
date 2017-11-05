package pl.lodz.uni.math.factory.factoryImpl;

import pl.lodz.uni.math.POJO.Person;
import pl.lodz.uni.math.factory.Factory;

public class CSVFactory implements Factory {
    @Override
    public String getName() {
        return "CSV";
    }

    @Override
    public Integer getAge() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setAge(Integer age) {

    }


}
