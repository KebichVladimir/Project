package by.itacademy.elements;

public class Cars {
    private String carName;

    public Cars(String carName) {
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    @Override
    public String toString() {
        return carName;
    }
}