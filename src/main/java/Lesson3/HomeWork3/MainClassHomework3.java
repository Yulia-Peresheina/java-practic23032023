package Lesson3.HomeWork3;
//1. Пусть дан произвольный список целых чисел,
// удалить из него четные числа (в языке уже есть что-то готовое для этого)

//2. Задан целочисленный список ArrayList. Найти минимальное,
// максимальное и среднее арифметическое из этого списка.

//3. Доделать начатое на семинаре. Пройтись по списку из задания 2
// и удалить повторяющиеся элементы.

//4*. Создать список типа ArrayList<String>. Поместить в него как
// строки, так и целые числа. Пройти по списку, найти и удалить целые числа.

import java.util.*;




public class MainClassHomework3 {
    public static void main(String[] args) {
        findMinMaxAverageOfList(15); // Задача 2
        deleteEvenInList(15);  //Задача 1
        fillArrayListAndRemoveIntegers();  //Задача 4*
        deleteRepetitionInList();    //Задача 3

    }

    private static void deleteRepetitionInList() {
        String[] arrPlanet = {"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto"};
        Random random = new Random();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(arrPlanet[random.nextInt(9)]);
        }
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals(list.get(i+1))) {
                list.remove(i + 1);
                i--;
            }
        }
                System.out.println(list);
    }

    private static void fillArrayListAndRemoveIntegers() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 155; i++) {
            int number = getRandomWithExeptions();
            char c = (char) number;
            list.add(Character.toString(c));
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            try {
                Integer.parseInt(list.get(i));
                list.remove(i);
                i--;
            } catch (NumberFormatException ignored){
            }
        }
          System.out.println(list);
    }
    private static int getRandomWithExeptions() {
        Random random = new Random();
        int a = random.nextInt(48, 123);
        while (a < 65 && a > 57 || a > 90 && a < 97){
            a = random.nextInt(48, 123);
        }
        return a;
    }

    private static void deleteEvenInList(int sizeOfList) {
        List <Integer> randomList = new ArrayList<>(sizeOfList);
        Random random = new Random();
        for (int i = 0; i < sizeOfList; i++) {
            randomList.add(random.nextInt(100));
        }
        System.out.println(randomList);
        randomList.removeIf(integer -> integer % 2 == 0);
//        Iterator<Integer> iterator = randomList.iterator(); // Это альтернативный метод
//        while (iterator.hasNext()){
//            if (iterator.next() % 2 == 0){
//                iterator.remove();
//            }
//        }
        System.out.println(randomList);
    }

    private static void findMinMaxAverageOfList(int sizeOfList) {
        List <Integer> list = new ArrayList<>(sizeOfList);
        Random random = new Random();
        for (int i = 0; i < sizeOfList; i++) {
            list.add(random.nextInt());
        }
        int sum = 0;
        for (Integer num : list) {
            sum += num;
        }
        double average = sum / (double)list.size();

        System.out.println(list);
        System.out.printf("Максимальное значение: %s\n", Collections.max(list));
        System.out.printf("Минимальное значение: %s\n", Collections.min(list));
        System.out.printf("Среднее арифметичесоке значение: %.2f", average );
    }
}
