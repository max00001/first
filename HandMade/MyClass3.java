import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.nio.charset.Charset;


public class MyClass3 {

    public static void main(String[] args) throws IOException {
        int someByte;
        System.out.println("What is your name?");

        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in, Charset.forName(System.getProperty("sun.stdout.encoding"))));

        String inputData = buffReader.readLine();

        System.out.printf("Hello %s!\n", inputData);
    }

}