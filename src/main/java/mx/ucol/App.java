package mx.ucol;

public class App {
    public static void main(String[] args) {
        Drop drop = new Drop();

        new Thread(new Producer(drop)).start();
        new Thread(new Producer(drop)).start();
        new Thread(new Producer(drop)).start();
        new Thread(new Producer(drop)).start();
        new Thread(new Producer(drop)).start();

        new Thread(new Consumer(drop)).start();
        new Thread(new Consumer(drop)).start();
        new Thread(new Consumer(drop)).start();
        new Thread(new Consumer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
