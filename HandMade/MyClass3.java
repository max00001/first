import java.io.IOException;


public class MyClass3 {

    public static void main(String[] args) throws IOException {
        StringBuilder inputData = new StringBuilder();
        int someByte;
        System.out.println("What is your name?");
        while ((someByte=System.in.read())!='\r') {
            inputData.append((char)someByte);
        }
        System.out.printf("Hello %s!\n", inputData.toString());
    }

}