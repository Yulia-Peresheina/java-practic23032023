package exeptions.les1;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainClassLes1 {
    public static void main(String[] args) {
//        ArrayList <Integer> userArr = fillArrList(); //Пользователь заполняет массив
//        ArrayList<Integer> arrayForCheck = new ArrayList<>();
//        Collections.addAll(arrayForCheck, 1,2, 223, 5, 4, 6 ); //самостоятельно заполняем

        int num = 6;
//        System.out.println(createErrorsCodes(userArr, num)); //Задача 1 выводит код ошибки
        checkExeptions();
    }

    private static void checkExeptions() {
        int[][] twoDimensialArr =  createArr();
        printarr(twoDimensialArr);
        try {
            checkArr(twoDimensialArr);
        } catch (Exception e){
            throw e;
        }
        int sum = 0;
        for (int i = 0; i < twoDimensialArr.length; i++) {
            for (int j = 0; j < twoDimensialArr[i].length; j++) {
                sum += twoDimensialArr[i][j];
            }
        }
        System.out.println("Сумма элементов массива: " + sum);
    }
    private static void checkArr(int[][]arr) {
        if (arr.length == 0){
            throw new RuntimeException("Массив пустой");
        }
        if (arr.length != arr[0].length){
            throw new RuntimeException("Двумерный массив не квадратный");
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1) {
                    throw new RuntimeException("Значения должны быть 1 или 0");
                }
            }
        }
    }

    private static void printarr(int [][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
    }

    private static int [][] createArr() {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число столбцов: ");
        int col = scanner.nextInt();
        System.out.println("Введите число рядов: ");
        int raw = scanner.nextInt();
        int [][] arr = new int[raw][col];
        for (int i = 0; i < raw; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("\nВведите %d элемент %d строки: ", i + 1, j + 1);
                arr[i][j] = scanner.nextInt();
            }
        }
        return arr;
    }

    private static ArrayList<Integer> fillArrList() {
        ArrayList<Integer> createdArr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число элементов массива: ");
        int size = scanner.nextInt();
        System.out.println("Готово");
        for (int i = 0; i < size; i++) {
            System.out.println("Введите элемент массива: ");
            createdArr.add(scanner.nextInt());
        }
        System.out.println("Массив заполнен");
        return createdArr;
    }

    private static int createErrorsCodes(ArrayList<Integer> exArr, int number) {
        if (exArr.size() == 0){
            return -3;
        }
        if (exArr.size() < 5) {
            return -1;
        }
        for (Integer integer : exArr) {
            if (integer == number){
                return exArr.indexOf(integer);
            }
        }
        return -2;
    }
}

