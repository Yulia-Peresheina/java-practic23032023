package lesson4.homework4;

import java.util.*;

//1. Реализовать консольное приложение, которое:
//Принимает от пользователя и “запоминает” строки.
//Если введено print, выводит строки так, чтобы последняя
// введенная была первой в списке, а первая - последней.
//Если введено revert, удаляет предыдущую введенную строку из памяти.

// 2. Пусть дан LinkedList с несколькими элементами.
// Реализуйте метод, который вернет “перевернутый” список.

public class MainClassHomeworkFour {
    public static void main(String[] args) {
        readPrintStack();         //Задача 1
        printReverseLinkedList(); //Задача 2
    }

    private static void printReverseLinkedList() {
        List<String> listWithElements = new LinkedList<>();
        Collections.addAll(listWithElements, "one", "two", "three", "four", "five", "six");
        System.out.println("LinkedList contains: "+listWithElements);
        String temp = "";
        for (int i = 0; i < listWithElements.size() / 2; i++) {
            temp = listWithElements.get(i);
            listWithElements.set(i, listWithElements.get(listWithElements.size()-(1+i)));
            listWithElements.set(listWithElements.size()-(1+i), temp);
        }

        System.out.printf("Reversed LinkedList contains: %s\n", listWithElements);
        Collections.reverse(listWithElements); //другой способ, работает быстрее, проверила
        System.out.println("Double-reversed listWithElements:"+ listWithElements);
    }

    private static void readPrintStack() {
        Stack<String> stringStack = new Stack<>();
        Collections.addAll(stringStack, "green", "orange", "grey", "red", "blue");
        boolean flag = true;

        while (flag) {
            System.out.println("Введите:\n" +
                                "строку для внесения в стэк\n"+
                                "print - для вывода верхнего элемента стэка\n"+
                                "printAll - для вывода всех элементов стэка\n"+
                                "revert - для удаления предыдущего элемента\n"+
                                "end - для завершения работы программы\n");
            Scanner scanner = new Scanner(System.in);
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("end")){
                System.out.println("Программа завершена");
                return;
            }
            if (inputString.trim().isEmpty()){
                System.out.println("Строка не должна быть пустой");
                continue;
            }
            if (inputString.equalsIgnoreCase("print")){
                if (stringStack.isEmpty()){
                    System.out.println("Нет элементов для вывода.");
                    continue;
                }
                System.out.printf("Верхний элемент стэка: %s\n", stringStack.peek());
                continue;
            }
            if (inputString.equalsIgnoreCase("printall")){
                printAllElements(stringStack);
                continue;
            }
            if (inputString.equalsIgnoreCase("revert")){
                if (stringStack.isEmpty()){
                    System.out.println("Нет элементов для удаления. Стэк пуст.");
                    continue;
                }
                String deletedElement = stringStack.pop();
                System.out.printf("Эелемент %s удален из стэка\n", deletedElement);
                continue;
            }
            stringStack.push(inputString);
            System.out.printf("Элемент %s добавлен в стэк\n", inputString);

        }


    }

    private static void printAllElements(Stack<String> stringStack) {
        if (stringStack.isEmpty()) {
            System.out.println("Нет элементов для вывода.");
            return;
        }
        for (int i = stringStack.size() - 1; i >= 0 ; i--) {
            System.out.println(stringStack.get(i));
            }
    }
}

