package com.wipro.days5.projects;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

public class FractionalPartFixed {
    public static void main(String[] args) {
        Function<Double, Double> fractionalPart = num -> {
            double frac = num - Math.floor(num);
            BigDecimal rounded = new BigDecimal(frac).setScale(2, RoundingMode.HALF_UP);
            return rounded.doubleValue();
        };

        double input = 123.45;
        double result = fractionalPart.apply(input);
        System.out.println("Fractional part: " + result);  // Output: 0.45
    }
}
