import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

// the producer puts strings on the queue
class CarProducer implements Runnable {
    int carsNumber;
    ConcurrentLinkedQueue<Car> queue;
    String streetname;
    String[] exits={"ex1","ex2","ex3","ex4"};
    String[] models={"toyota","audi","BMW","KIA","mercides","ford","hunda"};

    CarProducer(ConcurrentLinkedQueue<Car> queue,int carsNumber,String streetname){
        this.queue = queue;
        this.carsNumber=carsNumber;
        this.streetname= streetname;
    }
    public void run() {
        System.out.println("car Producer Started on the road ("+streetname+")");
        try {
            for (int i = 1; i < carsNumber; i++) {
                Car car=new Car(this.getRandom(models),ThreadLocalRandom.current().nextInt(10000, 32000 + 1), this.getRandom(exits));
                queue.add(car);

                System.out.println("new car arrived to the road("+streetname+"): number" + car.getNumber()+" dest is "+car.getDest());
                Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(200, 10000 + 1));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


}