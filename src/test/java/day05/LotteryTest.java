package day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LotteryTest {

    @Test
    void listOfNumbersTest() {
        Lottery lottery = new Lottery(5, 90);
        List<Integer> numbers = lottery.startLottery();
        int maxNumber = getMaxNumber(numbers);
        assertTrue(maxNumber <= 90);
        assertTrue(maxNumber >= 1);
        assertFalse(isThereEquals(numbers));
    }

    private int getMaxNumber(List<Integer> numbers) {
        int max = 0;
        for (int actual : numbers) {
            if (actual > max) {
                max = actual;
            }
        }
        return max;
    }

    private int getMinNumber(List<Integer> numbers) {
        int min = Integer.MAX_VALUE;
        for (int actual : numbers) {
            if (actual < min) {
                min = actual;
            }
        }
        return min;
    }

    private boolean isThereEquals(List<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) == numbers.get(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}