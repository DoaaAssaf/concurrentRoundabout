public class Main {

    public static void main(String[] args) {
        Roundabout roundabout=new Roundabout();
        TrafficLight trafficlight = new TrafficLight(10000);
        TrafficLight trafficlight2 = new TrafficLight(13000);

        Thread moveCars = new Thread(roundabout);
        moveCars.start();
        new StreetQueue(1,roundabout,trafficlight);
        new OutStreetQueue(2,roundabout,trafficlight);
        new StreetQueue(3,roundabout,trafficlight2);
        new OutStreetQueue(4,roundabout,trafficlight2);
        new StreetQueue(5,roundabout,trafficlight);
        new OutStreetQueue(6,roundabout,trafficlight);
        new StreetQueue(7,roundabout,trafficlight2);
        new OutStreetQueue(8,roundabout,trafficlight2);
        Thread trafficLight =new Thread(trafficlight);
        trafficLight.start();
        Thread trafficLight2 =new Thread(trafficlight2);
        trafficLight2.start();
    }

}


