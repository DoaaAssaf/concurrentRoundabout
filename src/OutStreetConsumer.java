import sun.security.jca.GetInstance;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

class OutStreetConsumer implements Runnable {
    int carsNumber;
    Car car;
    ConcurrentLinkedQueue<Car> queue;
    int streetname;
    Roundabout roundabout;
    TrafficLight trafficLight;

    OutStreetConsumer(ConcurrentLinkedQueue<Car> queue, int streetname,Roundabout roundabout,TrafficLight trafficLight){
        this.queue = queue;
        this.carsNumber =carsNumber;
        this.streetname= streetname;
        this.roundabout=roundabout;
        this.trafficLight=trafficLight;
    }
    public void run() {
        System.out.println("street exit ("+streetname/2+") exit is initialized successfully... ");
            while (true) {
                try {
                    Thread.currentThread().sleep(2000);
                    if (roundabout.roundarray[streetname-1] != null) {
                        if ((roundabout.roundarray[streetname - 1].getDest() == streetname)&&(queue.size()<=5)) {
                            System.out.println("car number (" + roundabout.roundarray[streetname - 1].getNumber() + ") reached its destination on the ex" + streetname/2 );
                            queue.add(roundabout.roundarray[streetname - 1]);
                            roundabout.roundarray[streetname - 1] = null;
                        }
                    }
                    if(!trafficLight.color.equals("red")){
                        queue.poll();
                    }
                    } catch(Exception ex){
                        ex.printStackTrace();
                    }
                }
            }
        }