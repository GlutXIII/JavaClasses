package pl.lodz.uni.math.Packages.Toys;

import pl.lodz.uni.math.Packages.Data;
import pl.lodz.uni.math.Packages.Package;

public class Car extends Data implements Package {
    @Override
    public String getName() {
        return "Car_"+ID;
    }

    @Override
    public void fillWithData(Integer ID, Integer priority) {
        this.setID(ID);
        this.setPriority(priority);
    }


}
