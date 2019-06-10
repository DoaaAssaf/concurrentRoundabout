import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;


public class StreetQueue {
    private final int streetname;
    private Roundabout roundabout;
    StreetQueue( int streetname,Roundabout roundabout){
        this.streetname=streetname;
        ConcurrentLinkedQueue<Car> queue = new ConcurrentLinkedQueue<Car>();
        this.roundabout=roundabout;
        int randomCarsNumber = ThreadLocalRandom.current().nextInt(200, 10000 + 1);
        Thread carProducer = new Thread(new CarProducer(queue,randomCarsNumber,this.getStreetname()));
        Thread carStreetConsumer = new Thread(new CarStreetConsumer(queue,randomCarsNumber,this.getStreetname(),roundabout));
        carProducer.start();
        carStreetConsumer.start();
    }

    public int getStreetname() {
        return streetname;
    }
}
