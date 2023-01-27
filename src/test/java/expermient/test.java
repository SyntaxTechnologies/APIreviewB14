package expermient;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class test {

    public static void main(String[] args) throws IOException {
        System.out.println(readPayloadFile("payload.txt"));

    }


    public static String readPayloadFile(String filePath) throws IOException {
        String data = "";
        data = new String(Files.readAllBytes(Paths.get(filePath)));
        return data;
    }
}
