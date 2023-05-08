package exeptions.les3;

public class NullElement extends RuntimeException {
    public int illegalIndex;

    public int getIllegalIndex(){
        return illegalIndex;
    }
    public NullElement(int illegalIndex){
        super(String.format("Во входном массиве на позиции %d находится пустой ээлемент", illegalIndex));
        this.illegalIndex = illegalIndex;

    }
}
