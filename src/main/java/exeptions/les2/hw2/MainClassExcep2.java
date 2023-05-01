package exeptions.les2.hw2;

import java.util.Scanner;

//Задание 1.Реализуйте метод, который запрашивает у пользователя ввод
// дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.
//Задание 2. Исправить код.
//Задание 3. Исправить код.
public class MainClassExcep2 {
    public static void main(String[] args) {
//        inputFloat(); //Задача1
//        correctCode();  //Задача2
//        correctCode2();  //Задача3
        throwExeptionEmptyString();

    }

    private static void throwExeptionEmptyString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите любые данные");
        String input = scanner.nextLine();
        if (!input.isEmpty()){
            System.out.println("Супер!");
        } else {
            throw new RuntimeException("Пустые строки вводить нельзя!"); //задание было выбросить исключение.
                                                                         // А то можно было и через flag
        }

    }

    //------------------------------------------------------------------------------------------------
    private static void correctCode2() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(14, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;

        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!"); // Используется, если указать null в printSum
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так...");
        }
    }
    public static void printSum(Integer a, Integer b) {     //Удалила FileNotFoundException
        System.out.println(a + b);
    }
//------------------------------------------------------------------------------------------------------


    private static void correctCode() {
        int[] intArray = new int[10];
        int d = 0;
        try {
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Catching exception 2: " + e);
        }
    }
//----------------------------------------------------------------------------------------------
        private static void inputFloat () {
            Scanner scanner = new Scanner(System.in);
            boolean flag = false;
            while (!flag) {
                System.out.println("Введите дробное число: ");
                String input = scanner.nextLine();
                try {
                    float number = Float.parseFloat(input);
                    if (number % 1 != 0) {
                        System.out.println(number);
                        flag = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введено неверное значение.");
                }
            }
        }
//-------------------------------------------------------------------------------------------------------
    }
