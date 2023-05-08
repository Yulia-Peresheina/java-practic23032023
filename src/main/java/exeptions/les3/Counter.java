package exeptions.les3;

import java.io.IOException;

public class Counter implements AutoCloseable {
    private int a;
    private boolean closed;

    public Counter(){
        this.a = 0;
        this.closed = false;
    }

    @Override
    public void close() throws IOException {
        System.out.println("closing counter resource...");
        this.closed=true;
    }

    public void add() throws IOException{
        if(this.closed){
            throw new IOException("closed");
        }
        this.a += 1;
    }
     @Override
    public String toString(){
         return String.valueOf(a);
    }

    public int getCount(){
        return this.a;
    }
}
