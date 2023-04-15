package lesson6;

public class MainClassLesson6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat(1);
        cat1.age = 3;
        cat1.name = "Васька";
        cat1.color = "red";
        cat1.weight = 4;
        cat1.owner = "Петров";

        Cat cat2 = new Cat(2);
        cat2.age = 2;
        cat2.name = "Мурка";
        cat2.color = "grey";
        cat2.weight = 3;
        cat2.owner = "Васильева";


        Cat cat3 = new Cat(3, "Борька", "black", 1, "Попова", "male", 8);
        System.out.println(cat3.getId());
        System.out.println(cat3);
        cat2.changeAge();
        cat2.changeOwner("Матвеева");
        System.out.println(cat2);
        System.out.println(cat3.);


    }

}
