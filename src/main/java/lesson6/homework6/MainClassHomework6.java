package lesson6.homework6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClassHomework6 {
    public static void main(String[] args) {
        Laptop laptop1 = new Laptop(1, "huawei", 16,
                2.8, 80000, "Intel", 16, "booked" );
        Laptop laptop2 = new Laptop(2, "hp", 15,
                3, 67000, "AMD", 16, "sale");
        Laptop laptop3 = new Laptop(1, "lenovo", 16,
                2.45,132000, "AMD", 16 , "sale");
        Laptop laptop4 = new Laptop(1, "dell", 15,
                2.34, 90000, "Intel", 8 , "sale");
        Laptop laptop5 = new Laptop(1, "acer", 15,
                2.3 , 100000, "AMD", 16, "booked" );
        Laptop laptop6 = new Laptop(1, "asus", 14,
                1.4, 160000, "Intel", 16, "purchased" );



        List<List<String>> laptopList = new ArrayList<>();
        laptopList.add(laptop1.allCharacteristics());
        laptopList.add(laptop2.allCharacteristics());
        laptopList.add(laptop3.allCharacteristics());
        laptopList.add(laptop4.allCharacteristics());
        laptopList.add(laptop5.allCharacteristics());
        laptopList.add(laptop6.allCharacteristics());


        chooseMinimumWeight(laptopList);
        chooseMinimumRAM(laptopList);
        chooseBrand(laptopList);
        printAllLaptops(laptopList);
    }

    private static void printAllLaptops(List<List<String>> laptopList) {

        for (List<String> laptop : laptopList) {
            System.out.println(laptop.toString());

        }
    }

    private static void chooseBrand(List<List<String>> laptopList) {
        System.out.println("Which laptop brand do you want? ");
        String brandWanted = askQuestion().toLowerCase();
        for (List<String> laptop : laptopList) {
            if (laptop.get(1).equals(brandWanted)){
                System.out.println(laptop);
            }
        }
    }

    private static String askQuestion() {
        Scanner scanner = new Scanner(System.in);
        String answer1 = scanner.nextLine();
        scanner.close();
        return answer1;
    }

    private static void chooseMinimumWeight(List<List<String>> laptopList) {
        System.out.println("Enter maximum weight you want: ");
        double maxWeight = Double.parseDouble(askQuestion());
        for (List<String> laptop : laptopList) {
            if (Double.parseDouble(laptop.get(3)) <= maxWeight){
                System.out.println(laptop);
            }


        }
    }
    private static void chooseMinimumRAM(List<List<String>> laptopList) {
        System.out.println("Enter minimum RAM you want: ");
        int minimumRam = Integer.parseInt(askQuestion());
        for (List<String> laptop : laptopList) {
            if (Integer.parseInt(laptop.get(6)) >= minimumRam){
                System.out.println(laptop);
            }
        }
    }
}
