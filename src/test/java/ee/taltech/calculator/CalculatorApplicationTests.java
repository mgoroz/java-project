package ee.taltech.calculator;
import ee.taltech.calculator.calculation.Calculation1;
import ee.taltech.calculator.calculation.Calculation2;
import ee.taltech.calculator.controller.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class CalculatorApplicationTests {

	//Operations Tests

	@Test
	void minOddNormal() {
		List<Integer> all = List.of (1,2,3,5,8);
		assertEquals(Optional.of(1), Operations.minOdd(all));
	}

	@Test
	void minOddNull() {
		List<Integer> all = List.of (2, 8);
		assertEquals(Optional.empty(), Operations.minOdd(all));
	}

	@Test
	void sumOfEvenNormal() {
		List<Integer> all = List.of (1,2,3,5,8);
		assertEquals(10, Operations.sumOfEven(all));
	}

	@Test
	void sumOfEvenNull() {
		List<Integer> all = List.of (1,3,5);
		assertEquals(null, Operations.sumOfEven(all));
	}

	@Test
	void oddsNormal() {
		List<Integer> all = List.of (1,2,3,5,8);
		assertEquals(List.of(1, 3, 5), Operations.odds(all));
	}

	@Test
	void oddsNull() {
		List<Integer> all = List.of (2,8);
		assertEquals(null, Operations.odds(all));
	}

	@Test
	void squaredNormal() {
		List<Integer> all = List.of (1, 2, 3);
		assertEquals(List.of (1, 4, 9), Operations.squared(all));
	}

	@Test
	void squaredNegative() {
		List<Integer> all = List.of (-1, 2, -3);
		assertEquals(List.of (1, 4 ,9), Operations.squared(all));
	}

	@Test
	void averageOfPositivesNormal() {
		List<Integer> all = List.of (1, 2, 15);
		BigDecimal a = new BigDecimal(6).setScale(2, RoundingMode.HALF_UP);
		assertEquals(a, Operations.averageOfPositives(all));
	}

	@Test
	void averageOfPositivesNegatives() {
		List<Integer> all = List.of (-1, 2, -3);
		BigDecimal a = new BigDecimal(2).setScale(2, RoundingMode.HALF_UP);
		assertEquals(a, Operations.averageOfPositives(all));
	}

	@Test
	void averageOfPositivesNull() {
		List<Integer> all = List.of (-1, -2, -3);
		assertEquals(null, Operations.averageOfPositives(all));
	}

	//Calculation1 Tests

	@Test
	void Calculation1Normal() {
		List<Integer> all = List.of (1, 2, 3);
		assertEquals(Optional.of(1), new Calculation1(all).getMinOdd());
		assertEquals(2, new Calculation1(all).getSumOfEven());
		assertEquals(List.of(1,3), new Calculation1(all).getOdds());
	}

	@Test
	void Calculation1NoOdds() {
		List<Integer> all = List.of (2, 8);
		assertEquals(Optional.empty(), new Calculation1(all).getMinOdd());
		assertEquals(10, new Calculation1(all).getSumOfEven());
		assertEquals(null, new Calculation1(all).getOdds());
	}

	@Test
	void Calculation1NoEvens() {
		List<Integer> all = List.of (1, 5);
		assertEquals(Optional.of(1), new Calculation1(all).getMinOdd());
		assertEquals(null, new Calculation1(all).getSumOfEven());
		assertEquals(List.of(1,5), new Calculation1(all).getOdds());
	}

	@Test
	void Calculation1Empty() {
		List<Integer> all = List.of ();
		assertEquals(Optional.empty(), new Calculation1(all).getMinOdd());
		assertEquals(null, new Calculation1(all).getSumOfEven());
		assertEquals(null, new Calculation1(all).getOdds());
	}

	//Calculation2 Tests

	@Test
	void Calculation2Normal() {
		List<Integer> all = List.of (1, 2, 3);
		assertEquals(List.of(1, 4 ,9), new Calculation2(all).getSquared());
		assertEquals(2, new Calculation2(all).getSumOfEven());
		assertEquals(new BigDecimal(2).setScale(2, RoundingMode.HALF_UP), new Calculation2(all).getAverageOfPositives());
	}

	@Test
	void Calculation2NoPositives() {
		List<Integer> all = List.of (-1, -2, -3);
		assertEquals(List.of(1, 4 ,9), new Calculation2(all).getSquared());
		assertEquals(-2, new Calculation2(all).getSumOfEven());
		assertEquals(null, new Calculation2(all).getAverageOfPositives());
	}

	@Test
	void Calculation2Empty() {
		List<Integer> all = List.of ();
		assertEquals(List.of(), new Calculation2(all).getSquared());
		assertEquals(null, new Calculation2(all).getSumOfEven());
		assertEquals(null, new Calculation2(all).getAverageOfPositives());
	}
}


