import sun.security.jca.GetInstance;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

class CarStreetConsumer implements Runnable {
    int carsNumber;
    Car car;
    ConcurrentLinkedQueue<Car> queue;
    String streetname;


    CarStreetConsumer(ConcurrentLinkedQueue<Car> queue, int carsNumber,String streetname){
        this.queue = queue;
        this.carsNumber =carsNumber;
        this.streetname= streetname;
    }
    public void run() {
        System.out.println("car Consumer Started on the road ("+streetname+")");
        for (int x = 0; x < carsNumber; x++) {
            while (!queue.isEmpty()) {
                System.out.println("car number ("+ queue.peek().getNumber()+") left the road ("+streetname+")" );
                queue.poll();
            }
            try {
                Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(200, 10000 + 1));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
