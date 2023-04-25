package exeptions.les1.hw1;
//Задача1. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//и возвращающий новый массив, каждый элемент которого равен разности элементов
//двух входящих массивов в той же ячейке. Если длины массивов не равны,
// необходимо как-то оповестить пользователя.
//--------------------------------------------------------------------------------------
//Задача2. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//и возвращающий новый массив, каждый элемент которого равен частному элементов двух
//входящих массивов в той же ячейке. Если длины массивов не равны, необходимо как-то
//оповестить пользователя. Важно: При выполнении метода единственное исключение, которое
//пользователь может увидеть - RuntimeException, т.е. ваше.
//----------------------------------------------------------------------------------------
//Задача3. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и
//возвращающий новый массив, каждый элемент которого равен сумме элементов двух входящих
//массивов в той же ячейке. Если длины массивов не равны, необходимо как-то оповестить
//пользователя.
//----------------------------------------------------------------------------------------
//Задача4.Реализуйте метод, принимающий в качестве аргументов двумерный массив.
//Метод должен проверить что длина строк и столбцов с одинаковым индексом одинакова,
//детализировать какие строки со столбцами не требуется.
//Как бы вы реализовали подобный метод?

import java.util.Arrays;
import java.util.Scanner;

public class MainClassExcep1 {
    public static void main(String[] args) {
        int[] firstArray = fillArray();
        int[] secondArray = fillArray();
        int[][] twoDimensionalArray = fillMatrix();
        differenceOfArrays(firstArray, secondArray);   //Задача 1.
        divisionOfArrays(firstArray, secondArray);     //Задача2.
        sumOfArrays(firstArray,secondArray);           //Задача3.
        checkRowColLength(twoDimensionalArray);        // Задача4.


    }

    private static int[][] fillMatrix() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество строк матрицы: ");
        int row = scanner.nextInt();
        System.out.println("Введите количество столбцов матрицы: ");
        int col = scanner.nextInt();
        int [][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.printf("Введите %d элемент %d строки: \n", j + 1, i + 1);
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    private static void checkRowColLength(int[][] array) {
        System.out.println(array[0].length == array.length ? "True" : "False");
    }

    private static void sumOfArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length){
            throw new RuntimeException("Длины массивов не равны");
        }
        int[] arraySummary = new int[array1.length];
        for (int i = 0; i < arraySummary.length; i++) {
            if ((long) array1[i] + (long) array2[i] > 2_147_483_647 ||
                    (long) array1[i] + (long) array2[i] < -2_147_483_648){
                throw new RuntimeException("Значение вышло за пределы допустимых");
            }
            arraySummary[i] = array1[i]+array2[i];
        }
        System.out.printf("При сложении первого массива %s\n" +
                        "и второго массива %s \n" +
                        "получается третий массив: %s\n",
                Arrays.toString(array1), Arrays.toString(array2), Arrays.toString(arraySummary));
    }

    private static void divisionOfArrays(int[] array1, int[] array2) {
        if (array1.length != array2.length){
            throw new RuntimeException("Длины массивов не равны");
        }
        int[] arrayQuotient = new int[array1.length];
        for (int i = 0; i < arrayQuotient.length; i++) {
            if (array2[i] == 0){
                throw new RuntimeException("Деление на 0 невозможно.");
            }
            arrayQuotient[i] = array1[i]/array2[i];
        }
        System.out.printf("При делении первого массива %s\n" +
                        "на второй массив %s \n" +
                        "получается третий массив с частными: %s\n",
                Arrays.toString(array1), Arrays.toString(array2), Arrays.toString(arrayQuotient));
    }

    private static int[] fillArray() {
        System.out.println("Введите размер массива: ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size ; i++) {
            System.out.printf("ведите %d элемент массива:  ", i + 1);
            array[i] = scanner.nextInt();
        }
        return array;
    }

    private static void differenceOfArrays(int [] array1, int [] array2) {
        if (array1.length != array2.length){
            throw new RuntimeException("Длины массивов не равны");
        }
        int[] arraySubtraction = new int[array1.length];
        for (int i = 0; i < arraySubtraction.length; i++) {
            if ((long) array1[i] - (long) array2[i] < -2_147_483_648 ||
                    (long) array1[i] + (long) array2[i] > 2_147_483_647 ||
                    (long) array1[i] - (long) array2[i] > 2_147_483_647){
                throw new RuntimeException("Значение вышло за пределы допустимых");
            }
            arraySubtraction[i] = array1[i] - array2[i];
        }
        System.out.printf("Разность первого массива %s\n" +
                "и второго массива %s \n" +
                "составляет третий массив %s\n",
                Arrays.toString(array1), Arrays.toString(array2), Arrays.toString(arraySubtraction));
    }
}
