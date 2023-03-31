package Lesson3;
//Даны следующие строки, cравнить их с помощью == и метода equals() класса Object
//String s1 = "hello";
//String s2 = "hello";
//String s3 = s1;
//String s4 = "h" + "e" + "l" + "l" + "o";
//String s5 = new String("hello");
//String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});


//Задача 2. Заполнить список десятью случайными числами.
//Отсортировать список методом sort() и вывести его на экран.

// Задача 3. Заполнить список названиями планет Солнечной системы
// в произвольном порядке с повторениями.
//Вывести название каждой планеты и количество его повторений в списке.

import java.sql.Array;
import java.util.*;


public class MainClassLessonThree {
    public static void main(String[] args) {
//        equalsOfString();
//        fillListRandomNumbsSortAndPrint();
//        fillListRandomPlanetsAndSortWithRepetition();
        fillListRandomPlanetsAndSortWithRepetitionVar2();
    }

    private static void fillListRandomPlanetsAndSortWithRepetitionVar2() {
            String[] arrPlanet = {"Mercury", "Venus", "Earth", "Mars",
                    "Jupiter", "Saturn", "Uranus", "Neptun", "Pluto"};
            Random random = new Random();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < 30; i++) {
                list.add(arrPlanet[random.nextInt(9)]);
            }
            System.out.println(list);

            list.sort(Comparator.naturalOrder());
            StringBuilder sb = new StringBuilder();
            System.out.println(list);
            int count = 1;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).equals(list.get(i+1))) {
                    count++;
                }else{
                    sb.append(list.get(i))
                            .append(": ")
                            .append(count)
                            .append("; ");
                    count = 1;
                }
            }
            sb.append((list.get(list.size() - 1) + ": ")).append(count).append(".");
            System.out.println(sb);
    }

    private static void fillListRandomPlanetsAndSortWithRepetition() {
        String [] arrayPlanets = new String[]{"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto"};
        int length = arrayPlanets.length;
        List <String> planetList = new ArrayList<>(30);
        Random randomPlanet = new Random();
        for (int i = 0; i < 30; i++) {
            planetList.add(arrayPlanets[randomPlanet.nextInt(length)]);
        }
        System.out.println(planetList);
        for (int i = 0; i < length; i++) {
            int count = Collections.frequency(planetList, arrayPlanets[i]);
            System.out.println(arrayPlanets[i] + ": "+ count);
        }
    }


    private static void fillListRandomNumbsSortAndPrint() {
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            Random random = new Random();

            list.add(random.nextInt(100));
        }
//        Collections.sort(list);

        list.sort(null);
        System.out.println(list);

    }

    private static void equalsOfString() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = s1;
        String s4 = "h" + "e" + "l" + "l" + "o";
        String s5 = new String("hello");
        String s6 = new String(new char[]{'h', 'e', 'l', 'l', 'o'});
        System.out.println(s1.equals(s5));
        System.out.println(s1 == s5);
    }
}
