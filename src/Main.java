public class Main {

    public static void main(String[] args) {
        Roundabout roundabout=new Roundabout();
        Thread moveCars;
        moveCars = new Thread(roundabout);
        moveCars.start();
        new StreetQueue(1,roundabout);
        new OutStreetQueue(2,roundabout);
        new StreetQueue(3,roundabout);
        new OutStreetQueue(4,roundabout);
        new StreetQueue(5,roundabout);
        new OutStreetQueue(6,roundabout);
        new StreetQueue(7,roundabout);
        new OutStreetQueue(8,roundabout);
    }

}


