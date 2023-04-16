package lesson6.homework6;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class Laptop {
    private int id;
    private String brand;
    private int inch;
    private double weight;
    private int price;
    private String processor;
    private int ram;
    private String status;





    public Laptop(int id, String brand,
                  int inch, double weight, int price,
                  String processor, int ram, String status) {
        this.id = id;
        this.brand = brand;
        this.inch = inch;
        this.weight = weight;
        this.price = price;
        this.processor = processor;
        this.ram = ram;
        this.status = status;
    }


    @Override
    public String toString() {
        return "Laptop "  +
                "id=" + id + '\n' +
                " manufacturer=" + brand +
                ", inch=" + inch +
                ", weight=" + weight +
                ", price=" + price +
                ", processor=" + processor +
                ", ram=" + ram +
                ", status=" + status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return id == laptop.id && inch == laptop.inch
                && Double.compare(laptop.weight, weight) == 0
                && price == laptop.price && ram == laptop.ram
                && Objects.equals(brand, laptop.brand)
                && Objects.equals(processor, laptop.processor)
                && Objects.equals(status, laptop.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, inch, weight, price, processor, ram, status);
    }

    public List<String> allCharacteristics(){
        List<String> laptopCharacteristics = new ArrayList<>();
        laptopCharacteristics.add(Integer.toString(this.id));
        laptopCharacteristics.add(this.brand);
        laptopCharacteristics.add(Integer.toString(this.inch));
        laptopCharacteristics.add(Double.toString(this.weight));
        laptopCharacteristics.add(Integer.toString(this.price));
        laptopCharacteristics.add(this.processor);
        laptopCharacteristics.add(Integer.toString(this.ram));
        laptopCharacteristics.add(this.status);

        return laptopCharacteristics;
    }
}
