public class MyClass2 {

    public static void main(String[] args) {
        if (args.length>0) {
            System.out.printf("Hello %s!\n", args[0]);
        }
        else {
            System.out.println("Hello world! (no new word is provided)");
        }
    }

}