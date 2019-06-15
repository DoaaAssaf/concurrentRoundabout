import java.util.concurrent.ThreadLocalRandom;


public class TrafficLight implements Runnable{
    public String color="green";
    int sleepingTime;
    TrafficLight(int sleepingTime){
        this.sleepingTime=sleepingTime;
    }
    @Override
    public void run() {
        try {
            while (true) {
                if (sleepingTime == 10000) {
                    this.color = "green";
                    System.out.println("the traffic lights in streets 1 and 3  is now GREEN");
                    Thread.currentThread().sleep(sleepingTime);
                    this.color = "amber";
                    System.out.println("the traffic lights in streets 1 and 3  is now AMBER");

                    Thread.currentThread().sleep(sleepingTime);
                    this.color = "red";
                    System.out.println("the traffic lights in streets 1 and 3 is now RED");
                    Thread.currentThread().sleep(sleepingTime);
                }
                else{
                    this.color = "green";
                    System.out.println("the traffic lights in streets 2 and 4  is now GREEN");
                    Thread.currentThread().sleep(sleepingTime);
                    this.color = "amber";
                    System.out.println("the traffic lights in streets 2 and 4  is now AMBER");

                    Thread.currentThread().sleep(sleepingTime);
                    this.color = "red";
                    System.out.println("the traffic lights in streets 2 and 4 is now RED");
                    Thread.currentThread().sleep(sleepingTime);

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
