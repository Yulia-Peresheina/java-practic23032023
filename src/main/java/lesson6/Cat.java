package lesson6;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
@Getter //Прописывая это, мы автоматически создаем возможность вывода через get всех параметров
@Setter //Прописывая это, мы автоматически создаем возможность изменения через set всех параметров
public class Cat {
    private int id;  //из-за того, что id private - его нельзя изменить после создания. и увидеть тоже.
    // Для этого нужно создать специальный setter (для изменения) и getter (для просмотра),
    // вызвав меню generate
    String name;
    String color;
    Integer age;
    String owner;
    String sex;
    int weight;

    public Cat(int id) {
        //создали конструктор через ПКМ -> constructor в который внесли только 1 параметр - id.
        // теперь создать экземляр класса Cat можно указав только его id  и всё
        this.id = id;
    }

    public Cat(int id, String name, String color, Integer age, String owner, String sex, int weight) {
        //создали конструктор через ПКМ -> constructor в который внеслы все параметры.
        // Можно создать экземпляр класса Cat, прописав сразу все параметры)
        this.id = id;
        this.name = name;
        this.color = color;
        this.age = age;
        this.owner = owner;
        this.sex = sex;
        this.weight = weight;
    }


    @Override
    public String toString(){
        return String.format("Кличка: %s\n Пол: %s\n Окрас: %s\n" +
                " Возраст: %d\n Вес: %d\n Хозяин: %s\n",
                name, sex, color, age, weight, owner);
    }
    public void changeAge(){
        age += 1;
    }
    public void changeOwner(String newOwner){
        owner = newOwner;
    }


    public int getId() {    // вызывается нажатием ПКМ -> generate -> выбираем getter и отмечаем нужные параметры
        //только так можно увидеть id кота после создания.
        return id;
    }

    @Override //ссылка на переопределение метода в методах Object
    public boolean equals(Object o) {    //вызывается нажатием ПКМ -> generate -> выбираем equals и hash
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return id == cat.id && weight == cat.weight && Objects.equals(name, cat.name) && Objects.equals(color, cat.color) && Objects.equals(age, cat.age) && Objects.equals(owner, cat.owner) && Objects.equals(sex, cat.sex);
    }

    @Override
    public int hashCode() {    //вызывается нажатием ПКМ -> generate -> выбираем equals и hash
        return Objects.hash(id, name, color, age, owner, sex, weight);
    }
}