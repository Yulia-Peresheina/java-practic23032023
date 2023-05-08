package exeptions.les3;

import java.io.IOException;

public class Les3 {
    public static void main(String[] args) {
/*        try{
            doSomething();
        }catch (IOException e){
            e.printStackTrace();
        }*/
//        --------------------------------------------------------------
        /*try (Counter counter = new Counter()){
            counter.add();
            counter.add();
            System.out.println("count: "+ counter.getCount());
            counter.close();
            counter.add();
            System.out.println("count: "+ counter.getCount());


        }catch (IOException e){
            System.out.println(e);
        }*/
//        ----------------------------------------------------------
        int a = 10;
        int b = 0;
        try{
            int c = a/b;
        }catch (ArithmeticException e){
            throw new DivideByZeroExeption();
        }



    }
//    public void rwLine(Path pathRead, Path pathWrite)throws IOException {
//        try (BufferedReader in = Files.newBufferedReader(pathRead);
//             BufferedWriter out = Files.newBufferedWriter(pathWrite);){
//            out.write(in.readLine());
//        }
//    }

    public static void doSomething() throws IOException{

    }
}
