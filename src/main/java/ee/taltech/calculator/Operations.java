package ee.taltech.calculator;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class Operations {

    private static Stream<Integer> getEvenStream(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0);
    }

    private static Stream<Integer> getPositivesStream(List<Integer> numbers) {
        return numbers.stream().filter(x -> x >= 0);
    }

    public static Optional<Integer> minOdd(List<Integer> input) {
        return input.stream().filter(x -> x % 2 != 0).min(Integer::compare);
    }

    public static Integer sumOfEven(List<Integer> input) {
        if (getEvenStream(input).collect(Collectors.toList()).isEmpty()) { return null; }
        return getEvenStream(input).mapToInt(Integer::intValue).sum();
    }

    public static List<Integer> odds(List<Integer> input) {
        List<Integer> output = input.stream().filter(x -> x % 2 != 0).collect(Collectors.toList());
        if (output.isEmpty()) { return null; }
        return output;
    }

    public static List<Integer> squared(List<Integer> input) {
        return input.stream().map(x -> x * x).collect(Collectors.toList());
    }

    public static BigDecimal averageOfPositives(List<Integer> input) {
        if (getPositivesStream(input).collect(Collectors.toList()).isEmpty()) { return null; }
        double avg = getPositivesStream(input).mapToDouble(x -> (double) x).average().orElse(0.0);
        return new BigDecimal(avg).setScale(2, RoundingMode.HALF_UP);
    }
}
