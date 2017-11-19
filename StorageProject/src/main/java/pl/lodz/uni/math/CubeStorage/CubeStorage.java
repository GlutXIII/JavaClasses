package pl.lodz.uni.math.CubeStorage;

import pl.lodz.uni.math.Packages.Package;
import pl.lodz.uni.math.Packages.PackageEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CubeStorage {

    private static int ID = 0;

    private static final Integer size = 5;

    public static final List<Package>[][] storage = new List[size][size];

    public void generateRandomStorage(int howMany) {
        fillStorageWithLists();
        for (int i = 0; i < howMany; i++) {
            Package pack = generatePackage(){
            getRandomPlace().add();
            
        }

    }

    private void fillStorageWithLists() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                storage[i][j] = new ArrayList<Package>();
            }
        }
    }

    private void addRandomPackages() {

        getRandomPlace().add(generatePackage());
    }

    private List<Package> getRandomPlace() {
        Random generator = new Random();
        return storage[generator.nextInt(size)][generator.nextInt(size)];
    }

    private Package generatePackage() {
        Random generator = new Random();
        Package pack = PackageEnum.getPackage(generator.nextInt(2));
        pack.fillWithData(ID,generator.nextInt(5));
        ID++;
        return pack;
    }

    public void showStorage() {
        StringBuilder stringBuilder = new StringBuilder();
        String packageName = "0";
        for (int g = 0; g < size; g++) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (g < storage[i][j].size()) {
                        packageName = storage[i][j].get(g).getName();
                    } else {
                        packageName = "0";
                    }
                    stringBuilder.append(packageName + " ");

                }
                stringBuilder.append("\n");
            }
            stringBuilder.append("\n\n");
        }
        System.out.println(stringBuilder);

    }
}
