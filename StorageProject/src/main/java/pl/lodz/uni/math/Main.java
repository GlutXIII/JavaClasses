package pl.lodz.uni.math;

import pl.lodz.uni.math.CubeStorage.CubeStorage;
import pl.lodz.uni.math.Packages.Toys.Car;

import java.util.ArrayList;
import java.util.List;

import static pl.lodz.uni.math.CubeStorage.CubeStorage.storage;

public class Main {

    public static void main(String[] args) {
        CubeStorage cubeStorage = new CubeStorage();
        cubeStorage.generateRandomStorage(30);
        cubeStorage.showStorage();
    }
}
