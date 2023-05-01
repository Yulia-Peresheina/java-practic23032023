package exeptions.les2;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClassLes2 {
    public static void main(String[] args) {
//        firstTry();
//        String [][] array = new String[3][3];
//        array[1][0] = "3";
//        array[1][1] = "g";
//        array[2][2] = "1";
//        System.out.println(secondEx(array));
        ThirdEx("file.txt"); //метод создает файл со строками,
                                      // считывавет и записывает эти строки в хэшмап,
                                      // изменяет и перезаписывает в тот же файл
    }

    private static void ThirdEx(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, false)){
            fileWriter.write("Анна=4\n");
            fileWriter.write("Елена=5\n");
            fileWriter.write("Марина=6\n");
            fileWriter.write("Владимир=?\n");
            fileWriter.write("Константин=?\n");
            fileWriter.write("Иван=k\n");

        } catch (IOException e) {
            System.out.println("путь к файлу не существует");
        }
        System.out.println(1);
        HashMap<String,String> person = readTOHashMap("file.txt");
        System.out.println(2);
        modifyHashMap(person);
        rewriteFile(fileName, person);

    }

    private static void rewriteFile(String file, HashMap<String,String>newInfo) {
        try (FileWriter fileWriter = new FileWriter(file, false)){
            for (Map.Entry<String, String> entry : newInfo.entrySet()) {
                fileWriter.write(entry.getKey()+"="+entry.getValue()+"\n");
            }
        } catch(IOException e){
            System.out.println("Файла не существует"+e);
        }
    }

    private static void modifyHashMap(HashMap<String, String> lines) {
        for (Map.Entry<String, String> entry : lines.entrySet()) {
            if (entry.getValue().equals("?")){
                lines.replace(entry.getKey(), String.valueOf(entry.getKey().length()));
            }
            try{
                Integer.parseInt(entry.getValue());
            } catch (NumberFormatException  e){
                System.out.println("не соответствующий символ: "+ entry.getValue());
            }
            System.out.println(entry);
        }

    }

    private static HashMap<String,String> readTOHashMap(String file) {
        HashMap<String, String> person = new HashMap<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null){
                String [] lineArray = line.split("=");
                person.put(lineArray[0], lineArray[1]);
            }
        }  catch ( IOException e){
            System.out.println("Файла не существует" + e);
        }
        return person;
    }

    private static int secondEx(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == null){
                    arr[i][j] = "0";
                }
                try {
                    int val = Integer.parseInt(arr[i][j]);
                    sum += val;
                } catch (NumberFormatException e){
                    System.out.println("элемент не является числом");
                } finally {
                    sum += 0;
                }
            }
        }
        return sum;
    }


    private static void firstTry() {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        System.out.println("На какой индекс в массиве вы хотите записать значение 1? ");
        try {
            int index = Integer.parseInt(scanner.nextLine());
            while (index < 0 || index > 9){
                System.out.println("Введенный индекс не соответствует ддлине массива. Повторите попытку: ");
                index = Integer.parseInt(scanner.nextLine());
            }
        } catch (NumberFormatException e){
            System.out.println("Не верный формат");
        }
    }
}
