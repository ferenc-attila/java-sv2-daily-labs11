package day05;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lottery {

    private int amountOfNumbers;
    private int bound;
    Random random = new Random();

    public Lottery(int amountOfNumbers, int bound) {
        this.amountOfNumbers = amountOfNumbers;
        this.bound = bound;
    }

    public List<Integer> startLottery() {
        List<Integer> numbers = new ArrayList<>();
        int count = 0;
        int number;
        while (count <= amountOfNumbers) {
            number = random.nextInt(bound + 1);
            if (!numbers.contains(number)) {
                numbers.add(number);
                count++;
            }
        }
        return numbers;
    }
}
