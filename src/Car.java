public class Car {
    String model;
    int number;
    int dest;
    String size;

    Car(String model, int number,int dest,String size){
        this.model=model;
        this.number=number;
        this.dest=dest;
        this.size=size;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getDest() {
        return dest;
    }

    public int getNumber() {
        return number;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getModel() {
        return model;
    }
}
