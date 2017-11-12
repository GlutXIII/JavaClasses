package pl.lodz.uni.math.Packages;

import pl.lodz.uni.math.Packages.Furnitures.Table;
import pl.lodz.uni.math.Packages.Toys.Car;

public enum PackageEnum {
    TableType,
    CarType;
    public static Package getPackage(int packageEnum){
        switch (packageEnum) {
            case 0:
                return new Table();
            case 1:
                return new Car();
        }
        return null;
    }
    public static int size = 2;
}
