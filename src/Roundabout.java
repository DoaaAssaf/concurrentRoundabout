import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Roundabout  implements Runnable {
 public Car[] roundarray = new Car[8];
    Lock lock = new ReentrantLock();
    Roundabout(){

    }
    public void setRoundarray(Car[] roundarray) {
        this.roundarray = roundarray;
    }

    public Car[] getRoundarray() {
        return roundarray;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void run() {
        while (true) {
            Car temp;
            int n;
            try {
                Thread.currentThread().sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            try {
                temp = roundarray[7];
                for (int i = 7; i > 0; i--) {
                    roundarray[i] = roundarray[i - 1];
                }
                roundarray[0] = temp;
            } finally {
                for (int i = 0; i < roundarray.length; i++) {
                    int j=i+1;
                    if (roundarray[i] != null)
                      System.out.println("roundabout: in the position["+j+"]"+" car number "+roundarray[i].getNumber()+" destination ex" + roundarray[i].getDest()/2);
                    else
                        System.out.println("roundabout: the position ["+j+"] is available" );

                }
                lock.unlock();
            }
        }
    }
}
