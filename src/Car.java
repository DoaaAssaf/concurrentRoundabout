public class Car {
    String model;
    int number;
    String dest;

    Car(String model, int number,String dest){
        this.model=model;
        this.number=number;
        this.dest=dest;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDest() {
        return dest;
    }

    public int getNumber() {
        return number;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public String getModel() {
        return model;
    }
}
