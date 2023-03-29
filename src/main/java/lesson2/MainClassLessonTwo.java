package lesson2;
// Задача 1. Дано число N > 0 и два симовла с1 и с2.
//Написать метод, который вернет строку длины N,
// где чередуются симоволы с1 и с2

// задача 2. Напишите метод, который сжимает строку.
// получили aaaabbbcdd отдали a4b3cd2

import java.util.Arrays;

public class MainClassLessonTwo {
    public static void main(String[] args) {
//        showStringBuilderWorks();
//        stringAlternationOfSymbols(6, "la", "fi");

        stringCompression("aaaabbbcdd");
    }

    private static void stringCompression(String fullString) {
        char[] fullArray = fullString.toCharArray();
        StringBuilder strCompres = new StringBuilder();
        char temp = fullArray[0];
        int count = 1;
        for (int i = 1; i < fullArray.length; i++) {
            if (temp == fullArray[i]){
                count +=1;
            }
            else {
                strCompres.append(temp).append( count == 1 ? "" : count);
                count = 1;
                temp = fullArray[i];
            }
            if (i == fullArray.length - 1) {
                strCompres.append(temp).append( count == 1 ? "" : count);
            }
        }
        System.out.println(strCompres);
    }




    private static void stringAlternationOfSymbols(int num, String a, String b) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            if (i % 2 != 0) {
                sb.append(b);
            }
            else {
                sb.append(a);
            }
        }
        long finish = System.nanoTime();
        System.out.println(finish - start);
        System.out.println(sb);
    }

    private static void showStringBuilderWorks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append("i: ").append(i).append((char)i).append(System.lineSeparator());

        }
        System.out.println(sb);
    }
}
