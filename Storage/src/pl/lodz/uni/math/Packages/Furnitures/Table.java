package pl.lodz.uni.math.Packages.Furnitures;

import pl.lodz.uni.math.Packages.Data;
import pl.lodz.uni.math.Packages.Package;

public class Table extends Data implements Package  {

    @Override
    public String getName() {
        return "Table_" + getID();
    }

    @Override
    public void fillWithData(Integer ID, Integer priority) {
        this.setID(ID);
        this.setPriority(priority);
    }


}
