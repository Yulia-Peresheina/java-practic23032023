package exeptions.les3;

public class MyArrayDataException extends RuntimeException{
public int col;
public int raw;
public MyArrayDataException(int col, int raw){
    super(String.format("В ячейке [ %d ][ %d ] лежат неверные данные. ", col, raw));
}
}
