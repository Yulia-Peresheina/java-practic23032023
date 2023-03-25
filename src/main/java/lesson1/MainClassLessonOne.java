package lesson1;
//1. Написать программу, которая запросит пользователя ввести <Имя> в консоли.
// Получит введенную строку и выведет в консоль сообщение “Привет, <Имя>!”

//2. Дан массив двоичных чисел, например [1,1,0,1,1,1],
//вывести максимальное количество подряд идущих 1.
import java.util.Scanner;
public class MainClassLessonOne {
    public static void main(String[] args) {
//        exOne();
        exTwo2();
    }

    private static void exTwo2() {
        int[] arr = new int[]{1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1};
        int count = 0;
        int temp = 0;
        for (int a = 0; a < arr.length; a++) {
            if (arr[a] == 1){
                count++;
            }
            else{
                if (temp < count){
                    temp = count;
                }
                count = 0;
            }
        }
        System.out.println(Math.max(temp, count));
    }




    private static void exOne() {
        Scanner helloScanner = new Scanner(System.in);
        System.out.println("What is your name?\n");
        String name = helloScanner.nextLine();
        System.out.println(name+", hello!");
        helloScanner.close();
    }


}
