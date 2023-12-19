
class Nonte extends Thread{
    public void run(){
        for (int i = 1; i<=50; i++)
        {
            System.out.println("Thread");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Fonte extends Thread{
    public void run(){
        for (int i = 1; i<=50; i++)
        {
            System.out.println("Completable Future");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Nonte n = new Nonte();
        Fonte f = new Fonte();

        /* Priority set for various threads */
        //System.out.println(n.getPriority());
       // f.setPriority(10);
        f.setPriority(Thread.NORM_PRIORITY);
        n.setPriority(Thread.MIN_PRIORITY);
        n.setPriority(Thread.MAX_PRIORITY);

        n.start();
        try {
            Thread.sleep(2);     // two start method will be executed with a gap of 2 mili second
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        f.start();

    }

}