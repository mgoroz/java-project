package ee.taltech.calculator.controller;

import ee.taltech.calculator.calculation.Calculation1;
import ee.taltech.calculator.calculation.Calculation2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("calculator")
public class Calculator {

    @GetMapping("calculate1")
    public Calculation1 calculate1(@RequestParam List<Integer> input) { return new Calculation1(input); }

    @GetMapping("calculate2")
    public Calculation2 calculate2(@RequestParam List<Integer> input) { return new Calculation2(input); }
}

