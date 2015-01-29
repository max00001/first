package mw.p10.main;

public class Main {
    /* 
     * to try a bad example from Andrey
     * 
     */
    public static void main(String[] args) {
        ThreadB b = new ThreadB();
        b.start();

        synchronized (b) {
            try {
                System.out.println("Waiting for b to complete... "
                        + System.nanoTime());
                b.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Total is: " + b.total);
            System.out.println(System.nanoTime());
        }
    }
}
