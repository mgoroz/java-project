package ee.taltech.calculator.calculation;

import ee.taltech.calculator.Operations;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class Calculation1 {
    private Optional<Integer> minOdd;
    private Integer sumOfEven;
    private List<Integer> odds;

    public Calculation1(List<Integer> numbers) {
        this.minOdd = Operations.minOdd(numbers);
        this.sumOfEven = Operations.sumOfEven(numbers);
        this.odds = Operations.odds(numbers);
    }
}
