package day02;

import java.util.List;

public class Hiking {

    private List<Coordinate> tracklog;

    public Hiking(List<Coordinate> tracklog) {
        this.tracklog = tracklog;
    }

    public double getPlusElevation() {
        double plusElevation = 0;
        for (int i = 1; i < tracklog.size(); i++) {
            double difference = (tracklog.get(i).getzCoordinate() - tracklog.get(i - 1).getzCoordinate());
            if (difference > 0) {
                plusElevation += difference;
            }
        }
        return plusElevation;
    }
}
