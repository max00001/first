package mw.p10.main;

public class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            System.out.println("Run " + System.nanoTime());
            for (int i = 0; i < 100000; i++) {
                total += i;
            }
            notify();
        }
    }
}
