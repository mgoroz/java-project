package ee.taltech.calculator.calculation;

import ee.taltech.calculator.Operations;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Calculation2 {
    private List<Integer> squared;
    private Integer sumOfEven;
    private BigDecimal averageOfPositives;

    public Calculation2(List<Integer> numbers) {
        this.squared = Operations.squared(numbers);
        this.sumOfEven = Operations.sumOfEven(numbers);
        this.averageOfPositives = Operations.averageOfPositives(numbers);
    }
}
