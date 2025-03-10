package lab5.data;

import lab5.tools.Validatable;

public class Coordinates implements Validatable {
    private double x; //Значение поля должно быть больше -771
    private long y;

    public Coordinates(double x, long y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + ";" + y;
    }

    @Override
    public boolean validate() {
       if( x<=-771) return false;
       return true;
    }
}