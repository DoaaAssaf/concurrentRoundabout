import sun.security.jca.GetInstance;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

class CarStreetConsumer implements Runnable {
    int carsNumber;
    Car car;
    ConcurrentLinkedQueue<Car> queue;
    int streetname;
    Roundabout roundabout;

    CarStreetConsumer(ConcurrentLinkedQueue<Car> queue, int carsNumber,int streetname,Roundabout roundabout){
        this.queue = queue;
        this.carsNumber =carsNumber;
        this.streetname= streetname;
        this.roundabout=roundabout;

    }
    public void run() {
        int entranceNumber= streetname/2+1;

        System.out.println("car Consumer Started on the road ("+entranceNumber+")");
        for (int x = 0; x < carsNumber; x++) {
            while (!queue.isEmpty()) {
                if (roundabout.roundarray[streetname-1] == null){
                    System.out.println("car number ("+ queue.peek().getNumber()+") from entrance ("+entranceNumber+") is rounding in the roundabout"  );
                    roundabout.roundarray[streetname-1]=queue.peek();
                    queue.poll();
                }
            }
            try {
                Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(200, 10000 + 1));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
