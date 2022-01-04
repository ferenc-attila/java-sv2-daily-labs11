package day02;

public class Coordinate {

    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public Coordinate(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public double getxCoordinate() {
        return xCoordinate;
    }

    public double getyCoordinate() {
        return yCoordinate;
    }

    public double getzCoordinate() {
        return zCoordinate;
    }
}
