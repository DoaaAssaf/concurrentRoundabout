import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;


public class StreetQueue {
    private final String streetname;
    StreetQueue( String streetname){
        this.streetname=streetname;
        ConcurrentLinkedQueue<Car> queue = new ConcurrentLinkedQueue<Car>();
        int randomCarsNumber = ThreadLocalRandom.current().nextInt(200, 10000 + 1);
        Thread carProducer = new Thread(new CarProducer(queue,randomCarsNumber,this.getStreetname()));
        Thread carStreetConsumer = new Thread(new CarStreetConsumer(queue,randomCarsNumber,this.getStreetname()));
        carProducer.start();
        carStreetConsumer.start();
    }

    public String getStreetname() {
        return streetname;
    }
}
