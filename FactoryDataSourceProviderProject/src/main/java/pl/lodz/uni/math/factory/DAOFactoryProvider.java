package pl.lodz.uni.math.factory;

import java.util.HashMap;
import java.util.Map;

public class DAOFactoryProvider implements Factory {

    Factory instance = null;

  //  Map<FactoryEnum,Factory> factoryEnumToFactoryMap = new HashMap<>();

    public void setInstance(Factory factoryEnum){
        instance = factoryEnum;
    }

    @Override
    public String getName() {
       return instance.getName();
    }

    @Override
    public Integer getAge() {
      return instance.getAge();
    }

    @Override
    public void setName(String name) {
        instance.setName(name);
    }

    @Override
    public void setAge(Integer age) {
        instance.getAge();
    }
}
