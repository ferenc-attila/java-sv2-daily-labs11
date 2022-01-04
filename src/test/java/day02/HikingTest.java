package day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HikingTest {

    @Test
    void getPlusElevationTest() {
        Coordinate first = new Coordinate(0.0, 1.0, 10);
        Coordinate second = new Coordinate(0.0, 1.0, 20);
        Coordinate third = new Coordinate(0.0, 1.0, 15);
        Coordinate fourth = new Coordinate(0.0, 1.0, 18);

        Hiking hiking = new Hiking(Arrays.asList(first, second, third, fourth));

        assertEquals(13.0, hiking.getPlusElevation(), 1);
    }
}