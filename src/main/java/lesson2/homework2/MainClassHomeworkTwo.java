package lesson2.homework2;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// Задача 1. Напишите метод, который принимает
// на вход строку (String) и определяет является 
// ли строка палиндромом (возвращает boolean значение).

// Задача 2. Напишите метод, который составит строку,
// состоящую из 100 повторений слова TEST и метод,
//который запишет эту строку в простой текстовый файл,
// обработайте исключения.

// .Напишите метод, который определит тип (расширение)
// файлов из текущей папки и выведет в консоль результат вида:
//        1 Расширение файла: txt
//        2 Расширение файла: pdf
//        3 Расширение файла:
//        4 Расширение файла: jpg

public class MainClassHomeworkTwo {
    public static void main(String[] args) {
        System.out.println("This is palindrome: " + stringIsPalindromeOrNot(inputString())); // Задача 1.

        printTextToFile(createText()); // Задача 2.

        typesOfFilesInDir("C:\\Users\\HUAWEI"); // Задача 3.


    }

    private static void typesOfFilesInDir(String pathDir) {
        File file = new File(pathDir);
        if (! file.isDirectory()){
            System.out.println("Not a directory!");
            return;
        }
        String [] dirListFile = file.list();
        for (String fileName : dirListFile) {
            String [] fileExpansion = fileName.split("\\.");
            System.out.println("Expansion of file: " + (fileExpansion.length == 2 ? fileExpansion[1] : ""));
        }
    }


    private static void printTextToFile(StringBuilder text) {
        try (PrintWriter pw = new PrintWriter("C:\\Users\\HUAWEI\\java-practic23032023\\src\\main\\java\\lesson2\\homework2\\FileForHw2.txt");) {
            pw.print(text);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static StringBuilder createText() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            sb.append("TEST ");
        }
        return sb;

    }

    private static StringBuilder inputString() {
        System.out.println("Enter something: ");
        Scanner sc = new Scanner(System.in);
        StringBuilder str = new StringBuilder(sc.nextLine());
        return str;
    }

    private static boolean stringIsPalindromeOrNot(StringBuilder checkPalindrome) {
        int strLength = checkPalindrome.length();
        for (int i = 0; i < strLength / 2; i++) {
            if (checkPalindrome.charAt(i) != checkPalindrome.charAt(strLength - 1 - i)) {
                return false;
                }
            }
        return true;
    }
}
