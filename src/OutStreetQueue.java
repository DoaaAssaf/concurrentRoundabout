import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;


public class OutStreetQueue {
    private final int streetname;
    private Roundabout roundabout;
    OutStreetQueue( int streetname,Roundabout roundabout){
        this.streetname=streetname;
        ConcurrentLinkedQueue<Car> queue = new ConcurrentLinkedQueue<Car>();
        this.roundabout=roundabout;
        Thread outStreetConsumer = new Thread(new OutStreetConsumer(queue,this.getStreetname(),roundabout));
        outStreetConsumer.start();
    }

    public int getStreetname() {
        return streetname;
    }
}