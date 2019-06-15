import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

// the producer puts strings on the queue
class CarProducer implements Runnable {
    int carsNumber;
    ConcurrentLinkedQueue<Car> queue;
    int streetname;
    int[] exits={2,4,6,8};
    String[] models={"toyota","audi","BMW","KIA","mercedes","ford","CHEVROLET","FERRARI","MAZDA",
    "NISSAN","SEAT","VOLVO","LAND ROVER","JEEP","LAMBORGHINI","BENTLEY","PORSCHE"};
    String[] size={"mini","small","medium","large","truck"};
    TrafficLight trafficlight;


    CarProducer(ConcurrentLinkedQueue<Car> queue,int carsNumber,int streetname,TrafficLight trafficlight){
        this.queue = queue;
        this.carsNumber=carsNumber;
        this.streetname= streetname;
        this.trafficlight=trafficlight;


    }
    public void run() {
        int entranceNumber=streetname/2+1;
        System.out.println("street ("+entranceNumber+") entrance is initialized successfully ...");
        try {

            while(true) {
                if (queue.size() >= 5) {
                    Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(10000, 20000 + 1));
                    continue;
                }
                if (!trafficlight.color.equals("red")) {
                    Car car = new Car(this.getRandom(models), ThreadLocalRandom.current().nextInt(10000, 32000 + 1), this.getRandomDestination(exits), this.getRandom(size));
                    queue.add(car);
                    System.out.println("new car " + queue.size() + " arrived to the road(" + entranceNumber + "): number " + car.getNumber() + " Model " + car.model + " Size " + car.size + " destination is ex" + car.getDest() / 2);
                    Thread.currentThread().sleep(ThreadLocalRandom.current().nextInt(10000, 20000 + 1));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }



    public String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    
    public int getRandomDestination(int[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }


}