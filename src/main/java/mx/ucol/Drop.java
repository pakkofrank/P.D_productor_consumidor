package mx.ucol;

public class Drop {
    private String message []  = new String[10];
    private boolean empty = true;
    private boolean fully = false;
    private int pos = 0;

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Someone interrupted this thread." + e);
            }
        }

        String res = this.message[this.pos - 1];
        --this.pos;
        if (this.pos == 0) {
            this.empty = true;
        }

        this.fully = false;
        this.notifyAll();
        return res;

    }

    public synchronized void put(String message) {
        while (this.fully) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }

        this.message[this.pos] = message;
        ++this.pos;
        if (this.pos == 9) {
            this.fully = true;
        }

        empty = false;
        notifyAll();
    }
}
