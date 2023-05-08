package exeptions.les3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lecture3 {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("file.txt");
            FileWriter writer = new FileWriter("file2.txt")
        ){while (reader.ready()){
                writer.write(reader.read());
            }
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
