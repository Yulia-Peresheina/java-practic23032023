package lesson1.homework;
//Задача 1. Задать одномерный массив и найти в нем
// минимальный и максимальный элементы
//-------------------------------------------------
//Задача 2. Дан массив nums = [3,2,2,3] и число val = 3.
//Если в массиве есть числа, равные заданному, нужно
//перенести эти элементы в конец массива. Таким образом,
//первые несколько (или все) элементов массива должны
// быть отличны от заданного, а остальные - равны ему.
//--------------------------------------------------
// Задача  3. В консоли запросить имя пользователя.
// В зависимости от текущего времени, вывести приветствие вида:
//"Доброе утро, <Имя>!", если время от 05:00 до 11:59
//"Добрый день, <Имя>!", если время от 12:00 до 17:59;
//"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
//"Доброй ночи, <Имя>!", если время от 23:00 до 4:59


import java.util.*;

public class MainClassHomeworkOne {
    public static void main(String[] args) {
        getRandomArrayFindMaxMin(8);  // Задача 1
        moveValueToEndOfArray(new int[]{3, 2, 2, 3}, 3);  // Задача 2
        inputNameAndHelloWithDayTime(); // Задача 3
    }

    private static void inputNameAndHelloWithDayTime() {
        System.out.println("Как ваше имя? ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        scanner.close();
        Calendar date = Calendar.getInstance();
        int hourNow = date.get(Calendar.HOUR_OF_DAY);
        if (hourNow <= 11 && hourNow >= 5){
            System.out.printf("Доброе утро, %s!", name);
        }
        else if (hourNow <= 17 && hourNow >= 12) {
            System.out.printf("Добрый день, %s!", name);
        }
        else if (hourNow <= 22 && hourNow >= 18) {
            System.out.printf("Добрый вечер, %s!", name);
        }
        else{
            System.out.printf("Доброй ночи, %s!", name);
        }
    }

    private static void moveValueToEndOfArray(int [] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                for (int j = array.length - 1; j > i; j--) {
                    if (array[j] != value){
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    private static void getRandomArrayFindMaxMin(int size) {
        Random randomForArray = new Random();
        int [] array = new int [size];
        for (int i = 0; i < array.length; i++) {
            array[i] = randomForArray.nextInt();
        }
        System.out.println(Arrays.toString(array));
        int maxOfArray = array[0];
        int minOfArray = array[0];
        for (int item : array) {
            if (minOfArray < item){
                minOfArray = item;
            }
            else if (maxOfArray > item) {
                maxOfArray = item;
            }
        }
        System.out.printf("Max in array is %s, Min in array is %s\n", minOfArray, maxOfArray);
    }
}
