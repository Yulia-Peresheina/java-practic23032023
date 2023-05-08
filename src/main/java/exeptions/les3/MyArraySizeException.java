package exeptions.les3;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException(){
        super("Размер матрицы должен быть 4*4");
    }

}
