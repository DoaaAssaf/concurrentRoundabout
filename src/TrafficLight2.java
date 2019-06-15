public class TrafficLight2 implements Runnable{
    public String color="green";
    TrafficLight2(){
    }
    @Override
    public void run() {
        try {
            while (true) {
                this.color="green";
                System.out.println("the traffic lights in streets 2 and 4 changed to GREEN");
                Thread.currentThread().sleep(12000);
                this.color="amber";
                System.out.println("the traffic lights in streets 2 and 4  changed to AMBER");

                Thread.currentThread().sleep(12000);
                this.color="red";
                System.out.println("the traffic lights in streets 2 and 4 changed to RED");
                Thread.currentThread().sleep(12000);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
