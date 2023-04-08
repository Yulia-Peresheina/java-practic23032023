package lesson5;
//Задача 0. Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
//123456 Иванов
//321456 Васильев
//234561 Петрова
//234432 Иванов
//654321 Петрова
//345678 Иванов
//Вывести данные по сотрудникам с фамилией Иванов.

// Задача 2. Написать метод, который переведет число из римского формата записи в арабский.
//Например, MMXXII = 2022

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClassLesson5 {
    public static void main(String[] args) {
//        ex0();
        convertLatinNumInArabic();
    }

    private static void convertLatinNumInArabic() {
        Map<String, Integer> converterLatinTOArabic = new HashMap<>();
        converterLatinTOArabic.put("I", 1);
        converterLatinTOArabic.put("V", 5);
        converterLatinTOArabic.put("X", 10);
        converterLatinTOArabic.put("L", 50);
        converterLatinTOArabic.put("C", 100);
        converterLatinTOArabic.put("D", 500);
        converterLatinTOArabic.put("M", 1000);
        System.out.println(converterLatinTOArabic);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Latin number: ");
        String inputLatin = scanner.nextLine();
        
        int result = 0;
        String [] keyArray = inputLatin.split("");

        if (keyArray.length == 1) {
            result = converterLatinTOArabic.get(keyArray[0]);
        }
        else {
            for (int i = keyArray.length - 1; i > 0; i--) {
                int number = converterLatinTOArabic.get(keyArray[i]);
                if (converterLatinTOArabic.get(keyArray[i]) > converterLatinTOArabic.get(keyArray[i - 1])){
                        number -= converterLatinTOArabic.get(keyArray[i - 1]);
                        i--;
                }
                result += number;
            }
            if (converterLatinTOArabic.get(keyArray[0]) >= converterLatinTOArabic.get(keyArray[1])) {
                result += converterLatinTOArabic.get(keyArray[0]);
            }
        }
        System.out.println(result);

    }




    private static void ex0() {
        Map<String, String> passportBook = new HashMap<>();
        passportBook.put("123456", "Ivanov");
        passportBook.put("232323", "Vasiliev");
        passportBook.put("987654", "Petrov");
        passportBook.put("463802", "Ivanov");
        passportBook.put("783890", "Petrov");
        passportBook.put("111111", "Ivanov");
        System.out.println(passportBook);
        for (var item : passportBook.entrySet()) {
            if (item.getValue().equals("Ivanov")){
                System.out.println(item);
            }
        }
//        System.out.println(passportBook.get("Ivanov"));
    }
}
