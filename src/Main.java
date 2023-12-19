/* Creating threads by extending Thread class and by implementing Runnable interface */
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

class Nonte implements Runnable{
    public void run(){
        for (int i = 1; i<=5; i++)
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

class Fonte implements Runnable{
    public void run(){
        for (int i = 1; i<=5; i++)
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

        Runnable n = new Nonte();
        Runnable n = new Runnable() {
            public void run(){
                for (int i = 1; i<=5; i++)
                {
                    System.out.println("Thread");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

/* Converting anonymous class into lambda expression */
        Runnable n = () ->                            // Using lambda expression
        {
                for (int i = 1; i<=5; i++)
                {
                    System.out.println("Thread");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        };


        Runnable f = new Fonte();

        Thread t1 = new Thread(n);
        Thread t2 = new Thread(f);

        /* Priority set for various threads */
        System.out.println(n.getPriority());
        f.setPriority(10);
        f.setPriority(Thread.NORM_PRIORITY);
        n.setPriority(Thread.MIN_PRIORITY);
        n.setPriority(Thread.MAX_PRIORITY);

        n.start();   // start method coming from thread class
        try {
            Thread.sleep(2);     // two start method will be executed with a gap of 2 mili second
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        f.start();

        t1.start();
        t2.start();

    }

}