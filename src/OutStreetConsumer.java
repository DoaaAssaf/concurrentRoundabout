import sun.security.jca.GetInstance;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

class OutStreetConsumer implements Runnable {
    int carsNumber;
    Car car;
    ConcurrentLinkedQueue<Car> queue;
    int streetname;
    Roundabout roundabout;

    OutStreetConsumer(ConcurrentLinkedQueue<Car> queue, int streetname,Roundabout roundabout){
        this.queue = queue;
        this.carsNumber =carsNumber;
        this.streetname= streetname;
        this.roundabout=roundabout;

    }
    public void run() {
        System.out.println("street exit ("+streetname/2+") exit is initialized successfully... ");
            while (true) {
                try {
                    Thread.currentThread().sleep(2000);
                    if (roundabout.roundarray[streetname-1] != null) {
                        if (roundabout.roundarray[streetname - 1].getDest() == streetname) {
                            System.out.println("car number (" + roundabout.roundarray[streetname - 1].getNumber() + ") reached its destination on the ex" + streetname/2 );
                            queue.add(roundabout.roundarray[streetname - 1]);
                            roundabout.roundarray[streetname - 1] = null;
                        }
                    }
                    } catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        }