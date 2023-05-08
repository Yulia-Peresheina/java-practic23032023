package exeptions.les3.hw3;
//Напишите приложение, которое будет запрашивать у пользователя следующие
//данные в произвольном порядке, разделенные пробелом:
//Фамилия Имя Отчество датарождения номертелефона пол. Форматы данных:
//фамилия, имя, отчество - строки.
//дата_рождения - строка формата dd.mm.yyyy
//номер_телефона - целое беззнаковое число без форматирования
//пол - символ латиницей f или m.
//Приложение должно проверить введенные данные по количеству.
//Если количество не совпадает с требуемым, вернуть код ошибки,
//обработать его и показать пользователю сообщение,
//что он ввел меньше и больше данных, чем требуется.
// Приложение должно попытаться распарсить полученные значения и выделить
//из них требуемые параметры. Если форматы данных не совпадают, нужно
//бросить исключение, соответствующее типу проблемы. Можно использовать
//встроенные типы java и создать свои. Исключение должно быть корректно
//обработано, пользователю выведено сообщение с информацией, что именно неверно.
//Если всё введено и обработано верно, должен создаться файл с названием,
//равным фамилии, в него в одну строку должны записаться полученные данные, вида
//<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
//Не забудьте закрыть соединение с файлом.
//При возникновении проблемы с чтением-записью в файл, исключение должно быть
//корректно обработано, пользователь должен увидеть стектрейс ошибки.

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MainClassExcep3 {
    public static void main(String[] args) {
        System.out.println("Введите, разделенные пробелом в произвольном порядке:\n" +
                " - фамилию, имя, отчество,\n" +
                " - дату рождения (формат dd.mm.yyyy),\n" +
                " - номер телефона,\n" +
                " - пол (латиницей f или m):");
        int correctNumberData = 6;
        String inputPersonalData = inputData();
        String [] arrayWithPersonalData = splitStringToArray(inputPersonalData);
        String codeError = checkingQuantityData(arrayWithPersonalData, correctNumberData);
        if (!codeError.equals("correct")){
            return;
        }

        HashMap<String, String> readyPersonalData = parseAllData(arrayWithPersonalData);
        System.out.println(readyPersonalData);
        boolean allDataValid = false;
        try {
            allDataValid = checkingValidData(readyPersonalData);
        }catch (RuntimeException e){
            System.out.println("Данные не обработаны:");
            System.out.println(e.getMessage());
        }
        if (allDataValid){
            try{
                writeDataToFile(readyPersonalData);
                System.out.println("Запись данных пользователя произведена успешно.");
            }catch (IOException e){
                System.out.println("Проблема с зарписью в файл.\n Запись данных пользователя невозможна.");
                e.printStackTrace();
            }
        }
    }

    public static String inputData(){
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        scanner.close();
        return data;
    }

    public static String [] splitStringToArray(String data){
        String [] arrayData = data.split(" ");
        return arrayData;
    }
    
    public static String checkingQuantityData(String [] arrayWithData, int correctNumber){
        if (arrayWithData.length < correctNumber){
            System.out.println("Количество введенных данных недостаточно.");
            return "not_enough";
        } else if (arrayWithData.length > correctNumber ) {
            System.out.println("Количество введенных данных превышает допустимое.");
            return "overly";
        }
        return "correct";
    }

    public static boolean isThisName(String word){
        if (word.length() == 1){
            return false;
        }
        char [] Chars = word.toCharArray();
        for (char c : Chars) {
            if(!Character.isLetter(c)){
                return false;
            }
        }
        return true;
    }
    public static boolean isThisTelephone(String word){
        if (word.length() != 10){
            return false;
        }
        char[] Chars = word.toCharArray();
        for (char c : Chars) {
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
    public static boolean isThisGender(String word){
        if (Objects.equals(word, "m")){
            return true;
        } else return word.equals("f");


    }
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);
        try {
            dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    public static HashMap <String, String> parseAllData(String[] arrayData){
        HashMap <String, String> parsedData = new HashMap<>();
        parsedData.put("Фамилия", null);
        parsedData.put("Имя", null);
        parsedData.put("Отчество", null);
        parsedData.put("Номер телефона", null);
        parsedData.put("Дата рождения", null);
        parsedData.put("Пол", null);
        for (String item : arrayData) {
            if (isThisGender(item)){
                parsedData.put("Пол", item);
            } else if (isThisName(item)){
                if (parsedData.get("Фамилия") == null){
                    parsedData.put("Фамилия", item);
                } else if (parsedData.get("Имя") == null) {
                    parsedData.put("Имя", item);
                } else if (parsedData.get("Отчество") == null){
                    parsedData.putIfAbsent("Отчество", item);
                }
            } else if (isThisTelephone(item)){
                parsedData.putIfAbsent("Номер телефона", item);
            } else if (isValidDate(item)) {
                parsedData.putIfAbsent("Дата рождения", item);
            }
        }
        return parsedData;
    }

    public static boolean checkingValidData(HashMap<String, String> data) throws RuntimeException{
        if (data.get("Фамилия") == null ||
            data.get("Имя") == null ||
            data.get("Отчество") == null){
            throw new RuntimeException("Неправильно введено ФИО");
        } else if (data.get("Номер телефона") == null) {
            throw new RuntimeException("Неправильно введен номер телефона");
        } else if (data.get("Дата рождения") == null) {
            throw new RuntimeException("Неправильно введена дата рождения");
        } else if (data.get("Пол") == null) {
            throw new RuntimeException("Неправильно введен пол");
        }
        return true;

    }

    public static void writeDataToFile(HashMap<String, String> data) throws IOException {
        String fileName = data.get("Фамилия");

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write(data.get("Фамилия") + " ");
            fileWriter.write(data.get("Имя") + " ");
            fileWriter.write(data.get("Отчество") + " ");
            fileWriter.write(data.get("Дата рождения") + " ");
            fileWriter.write(data.get("Номер телефона") + " ");
            fileWriter.write(data.get("Пол") + " \n");
        }
    }
}


