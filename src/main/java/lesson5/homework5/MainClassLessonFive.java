package lesson5.homework5;

import java.util.*;



//Задача 1. Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.
//2. Пусть дан список сотрудников:
// ....
//Написать программу, которая найдёт и выведет повторяющиеся 
// имена с количеством повторений. Отсортировать по убыванию популярности.
//.
public class MainClassLessonFive {
    public static void main(String[] args) {
        phoneBookByHashMap(); // Задача 1
        FindSortPrintRepeated(); //Задача 2
        converterFromArabicToRomain(); //Задача 3
        
    }

    private static void converterFromArabicToRomain() {
        Map<Integer, String> symbolMeaning = new HashMap<>();
        symbolMeaning.put(1, "I");
        symbolMeaning.put(5, "V");
        symbolMeaning.put(10, "X");
        symbolMeaning.put(50, "L");
        symbolMeaning.put(100, "C");
        symbolMeaning.put(500, "D");
        symbolMeaning.put(1000, "M");
        StringBuilder romainNumber = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter arabic number from 1 to 3999: ");
        int arabicNumber = scanner.nextInt();
        scanner.close();
        if (arabicNumber <= 0 || arabicNumber > 3999){
            System.out.println("Your number is out of bounds!");
            return;
        }
        if (arabicNumber > 999){
            for (int i = 0; i < arabicNumber/1000; i++) {
                romainNumber.append(symbolMeaning.get(1000));
            }
            arabicNumber = arabicNumber % 1000;
        }
        if (arabicNumber > 99 & arabicNumber <= 999) {
            if (arabicNumber > 99 & arabicNumber < 400){
                for (int i = 0; i < arabicNumber / 100; i++) {
                    romainNumber.append(symbolMeaning.get(100));
                }
            } else if (arabicNumber >=400 & arabicNumber < 500) {
                romainNumber.append(symbolMeaning.get(100)).append(symbolMeaning.get(500));
            } else if (arabicNumber >= 500 & arabicNumber < 900) {
                romainNumber.append(symbolMeaning.get(500));
                for (int i = 5; i < arabicNumber / 100 ; i++) {
                    romainNumber.append(symbolMeaning.get(100));
                }
            } else {
                romainNumber.append(symbolMeaning.get(100)).append(symbolMeaning.get(1000));
            }
            arabicNumber = arabicNumber % 100;
        }

        if (arabicNumber > 9 & arabicNumber <= 99) {
            if (arabicNumber > 9 & arabicNumber <= 39) {
                for (int i = 0; i < arabicNumber / 10; i++) {
                    romainNumber.append(symbolMeaning.get(10));
                }
            } else if (arabicNumber > 39 & arabicNumber <= 49) {
                romainNumber.append(symbolMeaning.get(10)).append(symbolMeaning.get(50));
            } else if (arabicNumber > 49 & arabicNumber <= 89) {
                romainNumber.append(symbolMeaning.get(50));
                for (int i = 5; i < arabicNumber / 10; i++) {
                    romainNumber.append(symbolMeaning.get(10));
                }
            } else {
                romainNumber.append(symbolMeaning.get(10)).append(symbolMeaning.get(100));
            }
            arabicNumber = arabicNumber % 10;
        }

        if (arabicNumber > 0 & arabicNumber <= 9) {
            if (arabicNumber > 0 & arabicNumber <= 3){
                for (int i = 0; i < arabicNumber; i++) {
                    romainNumber.append(symbolMeaning.get(1));
                }
            } else if (arabicNumber == 4) {
                romainNumber.append(symbolMeaning.get(1)).append(symbolMeaning.get(5));
            } else if (arabicNumber > 4 & arabicNumber <= 8) {
                romainNumber.append(symbolMeaning.get(5));
                for (int i = 5; i < arabicNumber; i++) {
                    romainNumber.append(symbolMeaning.get(1));
                }
            } else {
                romainNumber.append(symbolMeaning.get(1)).append(symbolMeaning.get(10));
            }
        }
        System.out.println(romainNumber);
    }



    private static void FindSortPrintRepeated() {
        Map<String, String> nameSurname = new HashMap<>();
        nameSurname.put("Иванов", "Иван");
        nameSurname.put("Петрова", "Светлана");
        nameSurname.put("Белова", "Кристина");
        nameSurname.put("Мусина", "Анна");
        nameSurname.put("Крутова", "Анна");
        nameSurname.put("Лыков", "Петр");
        nameSurname.put("Чернов", "Павел");
        nameSurname.put("Чернышов", "Петр");
        nameSurname.put("Федорова", "Мария");
        nameSurname.put("Светлова", "Марина");
        nameSurname.put("Савина", "Мария");
        nameSurname.put("Рыкова", "Мария");
        nameSurname.put("Лугова", "Марина");
        nameSurname.put("Владимирова", "Анна");
        nameSurname.put("Мечников", "Иван");
        nameSurname.put("Петин", "Петр");
        nameSurname.put("Ежов", "Иван");

        List<String> nameList = new ArrayList<>(nameSurname.values());
        Map<String, Integer> nameFrequency = new HashMap<>();
        for (String s : nameList) {
            if (!nameFrequency.containsKey(s)) {
                nameFrequency.put(s, Collections.frequency(nameList, s)); //Создали HashMap имя - частота
            }
        }

        //Создаем лист из пар HashMap (имя - частота):
        List<Map.Entry<String, Integer>> sortedNameFrequancyList = new ArrayList<>(nameFrequency.entrySet());

        //Используя метод Collections.sort создаем свой метод Comparator, где сравниваем два значения из пар
        Collections.sort(sortedNameFrequancyList, new Comparator<Map.Entry<String , Integer>>() {
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });
//
        // Перебираем отсортированный массив для вывода на печать:
        for (Map.Entry<String, Integer> item : sortedNameFrequancyList) {
            System.out.println("Количество повторений имени "+  item.getKey() + ": " + item.getValue());

        }
    }

    private static void phoneBookByHashMap() {
        Map<String, String [] > phoneSurname = new HashMap<>();
        phoneSurname.put("Ivanov", new String[]{"123456", "666666"});
        phoneSurname.put("Petrov", new String[]{"111111", "222222"});
        phoneSurname.put("Andreev", new String[]{"232323", "456654", "565656"});
        phoneSurname.put("Nikolaev", new String[]{"100000"});
        phoneSurname.put("Maximov", new String[]{"336677", "999999", "789678"});
        for (Map.Entry<String, String[]> stringEntry : phoneSurname.entrySet()) {
            String surname = stringEntry.getKey();
            String phones = Arrays.toString(stringEntry.getValue());
            System.out.printf("Surname: %s\n  --> phones: %s\n\n",
                    surname, phones.replaceAll("\\[|\\]", ""));
        }
    }
}

